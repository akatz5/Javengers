package javengers;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class ModelAdminView extends JFrame {
    private JPanel mainPanel;
    private JPanel adminPanel;
    private JLabel nameLabel;
    DefaultListModel model = new DefaultListModel();
    JList fileList = new JList(model);
    private JLabel statusLabel;
    private JLabel dateLabel;
    private JLabel adminTitle;
    private JButton addFileButton;
    private JButton removeFileButton;
    private JButton updateListButton;


    public ModelAdminView(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
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

        updateListButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                updateListActionPerformed(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new ModelAdminView("Maintenance: Search Engine");
        frame.setVisible(true);
    }
    public void addFileActionPerformed(java.awt.event.ActionEvent e) {
        JFileChooser addFileChooser = new JFileChooser();
        addFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        addFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        addFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text File only", "txt"));
        addFileChooser.setAcceptAllFileFilterUsed(true);
        int res = addFileChooser.showOpenDialog(this);
        if(res == JFileChooser.APPROVE_OPTION) {

            File f = addFileChooser.getSelectedFile();
            String fileInfo = f.getName();
            model.addElement(addFileChooser.getSelectedFile().getName());
            fileList.setModel(model);
        };
    }

    // code for this method written by Kthan Graham
    public void removeFileActionPerformed(java.awt.event.ActionEvent e) {
        var n = fileList.getSelectedIndex();
        fileList.remove(n);
    }

    public void updateListActionPerformed(java.awt.event.ActionEvent e) {
        fileList.setModel(model);
    }

}