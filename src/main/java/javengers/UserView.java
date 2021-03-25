package javengers;
// @author Ann Katz;
import javax.swing.*;

public class UserView extends JFrame{
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JPanel userViewPanel;
    private JTextField searchTextField;
    private JLabel searchByLabel;
    private JRadioButton andRadioButton;
    private JRadioButton orRadioButton;
    private JRadioButton phraseRadioButton;
    private JButton searchButton;
    private JList filesList;
    private JLabel filesLabel;

    public UserView(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args){
        JFrame frame = new UserView("Index Search Engine");
        frame.setVisible(true);
    }


}
