package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEngine {
    private JPanel panelMain;
    private JTextField txtfieldFile;
    private JButton btnSearch;
    private JRadioButton radiobtnAll;
    private JRadioButton radiobtnAny;
    private JRadioButton radiobtnExact;
    private JButton btnMaintenance;
    private JButton btnAbout;
    private JLabel lblNumFiles;
    private JLabel searchEngineLabel;
    private JLabel searchTermsLabel;
    private JPanel panel2;
    private JPanel panel1;
    private JPanel panel3;

    public SearchEngine() {
        btnAbout.addActionListener (e -> JOptionPane.showMessageDialog(null, "Success!"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Search Engine");
        frame.setContentPane(new SearchEngine().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
