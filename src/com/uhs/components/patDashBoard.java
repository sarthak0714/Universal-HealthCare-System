package com.uhs.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class patDashBoard {
    public patDashBoard(){
        JFrame f= new JFrame("Universal Healthcare System");

        JPanel p1=new JPanel();
        p1.setBounds(0,0,240,750);
        p1.setBackground(new Color(3, 4, 94));
        f.add(p1);
        JPanel p2=new JPanel();
        p2.setBounds(240,0,1060,40);
        p2.setBackground(Color.white);
        f.add(p2);
        JPanel p3=new JPanel();
        p3.setBounds(260,70,325,160);
        p3.setBackground(Color.red);
        f.add(p3);
        JPanel p4=new JPanel();
        p4.setBounds(600,70,325,160);
        p4.setBackground(Color.white);
        f.add(p4);
        JPanel p5=new JPanel();
        p5.setBounds(940,70,325,160);
        p5.setBackground(Color.white);
        f.add(p5);
        JPanel p6=new JPanel();
        p6.setBounds(940,250,325,400);
        p6.setBackground(Color.white);
        f.add(p6);
        JPanel p7=new JPanel();
        p7.setBounds(260,250,665,400);
        p7.setBackground(Color.white);
        p7.setLayout(null);
        f.add(p7);
        JTable jtab1=new JTable(8,6);
        JTable jh1=new JTable(1,6);
        p7.add(jh1);
        p7.add(jtab1);
        jh1.setBounds(3,40,660,40);
        jtab1.setBounds(3,80,660,320);
        jtab1.setRowHeight(40);
        jtab1.setGridColor(Color.GRAY);
        jtab1.setEnabled(false);
        jtab1.setBackground(Color.cyan);
        jtab1.setShowVerticalLines(false);
        jh1.setRowHeight(40);
        jh1.setShowVerticalLines(false);
        jh1.setBackground(Color.gray);


        jtab1.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));



        f.setSize(1300, 700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args){
        new patDashBoard();
    }
}
