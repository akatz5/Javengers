package javengers;
// @author Ann Katz;
import javax.swing.*;

public class View extends JFrame{
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JLabel titleLabel;
    private JPanel adminPanel;
    private JPanel userViewPanel;
    private JTextField searchTextField;
    private JLabel searchByLabel;
    private JRadioButton andRadioButton;
    private JRadioButton orRadioButton;
    private JRadioButton phraseRadioButton;
    private JButton searchButton;
    private JList filesList;
    private JLabel filesLabel;
    private JLabel statusLabel;
    private JLabel dateLabel;
    private JLabel nameLabel;
    private JList nameList;
    private JList statusList;
    private JList dateList;
    private JLabel adminTitle;
    private JButton addFileButton;
    private JButton removeFileButton;
    private JButton updateListButton;

    public View(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args){
        JFrame frame = new View("Index Search Engine");
        frame.setVisible(true);
    }


}
