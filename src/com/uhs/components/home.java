package com.uhs.components;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class home implements ActionListener {
    home() {
        JFrame f = new JFrame("Universal Health Care");
        JLabel l4= new JLabel("Welcome");
        JLabel l5 =new JLabel("To");
        JLabel l1 = new JLabel("Universal Health Care System");
        JLabel l2 = new JLabel("Select the type of role");
        l1.setForeground(Color.white);
        l1.setBounds(300,320,800,50);
        l1.setFont(new Font("Verdana", Font.BOLD, 45));
        l4.setForeground(Color.white);
        l4.setBounds(540, 220, 400, 50);
        l4.setFont(new Font("Verdana", Font.BOLD, 45));
        l5.setForeground(Color.white);
        l5.setBounds(620, 270, 80, 50);
        l5.setFont(new Font("Verdana", Font.BOLD, 45));
        l2.setForeground(Color.white);
        l2.setBounds(540, 430, 300, 40);
        l2.setFont(new Font("Verdana", Font.BOLD, 20));
        //f.getContentPane().setBackground(new Color(0, 191, 255));
        f.getContentPane().setBackground(new Color(3, 4,94));
        JLabel l3=new JLabel(new ImageIcon("C:\\Users\\Sumil\\Documents\\GitHub\\uhs\\src\\com\\uhs\\images\\i1.png"));
        l3.setBounds(540,33,231,181);
        JButton b1 = new JButton("Admin");
        JButton b2 = new JButton("Doctor");
        JButton b3 = new JButton("Patient");
        b1.setForeground(new Color(3, 4, 94));
        b1.setBackground(Color.white);
        b1.setBounds(560, 480, 200, 35);
        b1.setFont(new Font("Verdana",Font.BOLD, 14));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b2.setForeground(new Color(3, 4, 94));
        b2.setBackground(Color.white);
        b2.setBounds(560, 535, 200, 35);
        b2.setFont(new Font("Verdana",Font.BOLD, 14));
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b3.setForeground(new Color(3, 4, 94));
        b3.setBackground(Color.white);
        b3.setBounds(560, 590, 200, 35);
        b3.setFont(new Font("Verdana",Font.BOLD, 14));
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l1);
        f.add(l2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        b1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            AdminLogin al1=new AdminLogin();
            f.show();
            f.dispose();
        }});
        b2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            DLoginAndRegister lr1=new DLoginAndRegister();
            f.show();
            f.dispose();
        }});
        b3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            PLoginAndRegister lr1=new PLoginAndRegister();
            f.show();
            f.dispose();
        }});

        f.setSize(1300, 700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


