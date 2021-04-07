package javengers;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ModelAdminView extends JFrame {
    private JPanel mainPanel;
    private JPanel adminPanel;
    private JLabel adminTitle;
    private JButton addFileButton;
    private JButton removeFileButton;
    private JButton updateListButton;
    private JTable tableShown;
    String n;
    String s;
    static DefaultTableModel model = new DefaultTableModel();

    public ModelAdminView(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        model.setColumnCount(2);
        model.setColumnIdentifiers(new Object[]{"File Name", "File Status"});
        tableShown.setModel(model);


        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFileActionPerformed(e);

            }
        });
        removeFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFileActionPerformed(e);
            }
        });

        updateListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateListActionPerformed(e);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        tableShown.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = model.getRowCount();
                tableShown.addRowSelectionInterval(row, -1);

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new ModelAdminView("Maintenance: Search Engine");
        frame.setVisible(true);
        readDatabase(model);

    }

    public static void readDatabase(DefaultTableModel model) {
        try {
            //the file path
            File database = new File("./database.txt");
            //if the file not exist create one
            if (!database.exists()) {
                database.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addFileActionPerformed(java.awt.event.ActionEvent e) {
        JFileChooser addFileChooser = new JFileChooser();
        addFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        addFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        addFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text File only", "txt"));
        addFileChooser.setAcceptAllFileFilterUsed(true);
        int res = addFileChooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {

            File f = addFileChooser.getSelectedFile();

            n = f.getName();
            s = "In file index";

            model.addRow(new Object[]{n, s});
        }
        ;

    }

    public void removeFileActionPerformed(java.awt.event.ActionEvent e) {
        s = "Removed. Update to refresh";
        int row = tableShown.getSelectedRow();
        n = model.getValueAt(row, 0).toString();
        model.removeRow(row);


    }


    public void updateListActionPerformed(java.awt.event.ActionEvent e) throws IOException {

        File database = new File("./database.txt");
        FileWriter fw = new FileWriter(database.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i = 0; i < model.getRowCount(); i++){
            //loop for jtable column
            for(int j = 0; j < model.getColumnCount(); j++){
                n = (model.getValueAt(i, j)+"\n");
                n = n.replace("In file index", "");
                bw.write(n);
            }
        }
        //close BufferedWriter
        bw.close();
        //close FileWriter
        fw.close();
    }
}



