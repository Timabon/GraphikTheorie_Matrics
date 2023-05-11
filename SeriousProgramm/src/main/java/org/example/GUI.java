package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends Matrix implements ActionListener {

    Matrix mm = new Matrix();

    public GUI() {

        JButton button = new JButton("Create");
        button.addActionListener(this);
        button.setBounds(100, 100, 200, 40);

        JLabel label = new JLabel("Create a Matrix");
        label.setBounds(100, 70, 200, 20);

        JFrame frame = new JFrame();
        //JPanel panel = new JPanel();
        //panel.setBorder(BorderFactory.createEmptyBorder(50, 30, 10, 30));
        //panel.setLayout(new GridLayout(0,1));
        //panel.add(button);
        //panel.add(label);
        frame.add(button);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.add(label);


        //frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       /* try {
            Matrix.main();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }*/

    }
}

