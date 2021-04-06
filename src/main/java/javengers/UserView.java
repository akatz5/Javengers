package javengers;
// @author Ann Katz;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class UserView extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JPanel userViewPanel;
    private JTextField searchTextField;
    private JLabel searchByLabel;
    private JRadioButton andRadioButton;
    private JRadioButton orRadioButton;
    private JRadioButton phraseRadioButton;
    private JButton searchButton;
    private JLabel filesLabel;
    private JTable tableShown;
    DefaultTableModel model = (DefaultTableModel) tableShown.getModel();

    public UserView(String title) throws IOException, ClassNotFoundException {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        tableShown.setModel(model);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeModel();
            }
        });
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JFrame frame = new UserView("Index Search Engine");
        frame.setVisible(true);
    }
    private void makeModel() {

        String filePath = "./database.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            DefaultTableModel model = (DefaultTableModel) tableShown.getModel();
            model.setColumnCount(1);
            model.setColumnIdentifiers(new Object[]{"File Name"});


            Object[] tableLines = br.lines().toArray();
            String textSearched = "";
            String search = searchTextField.getText();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString();
                if (line.contains(search)) {
                    Object n = line;
                    model.addRow(new Object[]{n});
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}


