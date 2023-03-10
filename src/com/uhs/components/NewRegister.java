package com.uhs.components;

import com.uhs.swing.EmailValidator;
import com.uhs.swing.MyPasswordField;
import com.uhs.swing.MyTextArea;
import com.uhs.swing.MyTextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.border.*;

public class NewRegister  {
    public NewRegister(){}
    public NewRegister(String pnme,String pm){
        JFrame f=new JFrame("Universal Healthcare System");
        JLabel l1=new JLabel("REGISTRATION DETAILS");
        l1.setBounds(500,15,300,30);
        l1.setFont(new Font("Vardana", 1, 20));
        l1.setForeground(Color.white);
        JPanel p=new JPanel();
        p.setLayout(null);
        JLabel l2=new JLabel("FIRST NAME:");
        l2.setFont(new Font("Vardana", Font.BOLD, 16));
        l2.setForeground(new Color(3, 4, 94));
        l2.setBounds(30,20,150,40);
        p.add(l2);
        MyTextField t2=new MyTextField();
        t2.setFont(new Font("Vardana",1,14));
        t2.setBounds(150,20,250,40);
        t2.setHint("First Name");
        String jkl=pnme;
        t2.setText(String.valueOf(jkl));
        p.add(t2);
        JLabel l3=new JLabel("MIDDLE NAME:");
        l3.setFont(new Font("Vardana", 1, 16));
        l3.setForeground(new Color(3, 4, 94));
        l3.setBounds(420,20,150,40);
        p.add(l3);
        MyTextField t3=new MyTextField();
        t3.setFont(new Font("Vardana",1,14));
        t3.setBounds(555,20,250,40);
        t3.setHint("Middle Name");
        p.add(t3);
        JLabel l4=new JLabel("LAST NAME:");
        l4.setFont(new Font("Vardana", Font.BOLD, 16));
        l4.setForeground(new Color(3, 4, 94));
        l4.setBounds(830,20,150,40);
        p.add(l4);
        MyTextField t4=new MyTextField();
        t4.setFont(new Font("Vardana",1,14));
        t4.setBounds(950,20,250,40);
        t4.setHint("Last Name");
        p.add(t4);
        JLabel l5=new JLabel("ADDRESS:");
        l5.setFont(new Font("Vardana", Font.BOLD, 16));
        l5.setForeground(new Color(3, 4, 94));
        l5.setBounds(30,80,150,40);
        p.add(l5);
        MyTextArea ta1=new MyTextArea();
        ta1.setBounds(150,80,1050,60);
        ta1.setFont(new Font("Vardana",1,14));
        ta1.setHint("Address");
        p.add(ta1);
        JLabel l6=new JLabel("State:");
        l6.setFont(new Font("Vardana", Font.BOLD, 16));
        l6.setForeground(new Color(3, 4, 94));
        l6.setBounds(30,161,150,40);
        p.add(l6);
        MyTextField t6=new MyTextField();
        t6.setFont(new Font("Vardana",1,14));
        t6.setBounds(150,161,200,40);
        t6.setHint("State");
        p.add(t6);
        JLabel l7=new JLabel("CITY:");
        l7.setFont(new Font("Vardana", 1, 16));
        l7.setForeground(new Color(3, 4, 94));
        l7.setBounds(360,161,150,40);
        p.add(l7);
        MyTextField t7=new MyTextField();
        t7.setFont(new Font("Vardana",1,14));
        t7.setBounds(420,161,200,40);
        t7.setHint("City");
        p.add(t7);
        JLabel l8=new JLabel("PINCODE:");
        l8.setFont(new Font("Vardana", Font.BOLD, 16));
        l8.setForeground(new Color(3, 4, 94));
        l8.setBounds(630,161,150,40);
        p.add(l8);
        MyTextField t8=new MyTextField();
        t8.setFont(new Font("Vardana",1,14));
        t8.setBounds(730,161,200,40);
        t8.setHint("Pincode");
        p.add(t8);
        JLabel l9=new JLabel("BLOOD GROUP:");
        l9.setFont(new Font("Vardana", Font.BOLD, 16));
        l9.setForeground(new Color(3, 4, 94));
        l9.setBounds(950,161,150,40);
        p.add(l9);
//        String bloodgrp[]={"--Select--","A+","A-","B+","B-","AB+","AB-","O+","O-"};
        MyTextField cb=new MyTextField();
        cb.setBounds(1100, 161,90,40);
        cb.setForeground(new Color(3, 4, 94));
        cb.setFont(new Font("Vardana",1,14));
        cb.setHint("BG");
        p.add(cb);
        JLabel l10=new JLabel("GENDER: ");
        l10.setFont(new Font("Vardana", Font.BOLD, 16));
        l10.setForeground(new Color(3, 4, 94));
        l10.setBounds(30,235,150,40);
        p.add(l10);
        ButtonGroup bg=new ButtonGroup();
        JRadioButton r1=new JRadioButton("Male");
        JRadioButton r2=new JRadioButton("Female");
        bg.add(r1);bg.add(r2);
        p.add(r1);p.add(r2);
        r1.setBounds(130,228,70,60);
        r1.setFocusPainted(false);
        r1.setBorderPainted(false);
        r1.setBackground(Color.white);
        r1.setForeground(new Color(3, 4, 94));
        r1.setFont(new Font("Vardana", Font.BOLD, 12));
        r2.setBounds(200,228,70,60);
        r2.setFocusPainted(false);
        r2.setBorderPainted(false);
        r2.setBackground(Color.white);
        r2.setForeground(new Color(3, 4, 94));
        r2.setFont(new Font("Vardana", Font.BOLD, 12));
        JLabel l11=new JLabel("CONTACT NO:");
        l11.setFont(new Font("Vardana", Font.BOLD, 16));
        l11.setForeground(new Color(3, 4, 94));
        l11.setBounds(290,237,120,40);
        p.add(l11);
        MyTextField t11=new MyTextField();
        t11.setFont(new Font("Vardana",1,14));
        t11.setBounds(420,235,200,40);
        t11.setHint("Contact No");
        p.add(t11);
        JLabel l12=new JLabel("Email:");
        l12.setFont(new Font("Vardana", Font.BOLD, 16));
        l12.setForeground(new Color(3, 4, 94));
        l12.setBounds(660,235,150,40);
        p.add(l12);
        MyTextField t12=new MyTextField();
        t12.setFont(new Font("Vardana",1,14));
        t12.setBounds(730,235,200,40);
        //t12.setHint("Email Address");
        t12.setText(pm);
        p.add(t12);
        JLabel l13=new JLabel("D.O.B:");
        l13.setFont(new Font("Vardana", Font.BOLD, 16));
        l13.setForeground(new Color(3, 4, 94));
        l13.setBounds(950,235,150,40);
        p.add(l13);
        MyTextField t13=new MyTextField();
        t13.setFont(new Font("Vardana",1,14));
        t13.setBounds(1010,235,190,40);
        t13.setHint(" DD/MM/YYYY ");
        p.add(t13);
        JLabel l21=new JLabel("EMERGENCY PERSON DETAILS:");
        l21.setFont(new Font("Vardana", Font.BOLD, 16));
        l21.setForeground(new Color(3, 4, 94));
        l21.setBounds(30,290,300,40);
        p.add(l21);/*
        JLabel l22=new JLabel("RELATION TYPE:");
        l22.setFont(new Font("Vardana", Font.BOLD, 16));
        l22.setForeground(new Color(3, 4, 94));
        l22.setBounds(790,260,150,40);
        p.add(l22);
        MyTextField t22=new MyTextField();
        t22.setFont(new Font("Vardana",1,14));
        t22.setBounds(950,260,250,40);
        t22.setHint("-Relation-Type-");
        p.add(t22);
        JLabel l31=new JLabel("FIRST NAME:");
        l31.setFont(new Font("Vardana", Font.BOLD, 16));
        l31.setForeground(new Color(3, 4, 94));
        l31.setBounds(30,315,150,40);
        p.add(l31);
        MyTextField t31=new MyTextField();
        t31.setFont(new Font("Vardana",1,14));
        t31.setBounds(150,315,175,40);
        t31.setHint("Name");
        p.add(t31);*/
        JLabel l32=new JLabel("RELATIONSHIP TO CONTACT:");
        l32.setFont(new Font("Vardana", 1, 16));
        l32.setForeground(new Color(3, 4, 94));
        l32.setBounds(30,345,250,40);
        p.add(l32);
        MyTextField t32=new MyTextField();
        t32.setFont(new Font("Vardana",1,14));
        t32.setBounds(280,345,210,40);
        t32.setHint("Relation Type");
        p.add(t32);
        JLabel l33=new JLabel("EMAIL:");
        l33.setFont(new Font("Vardana", Font.BOLD, 16));
        l33.setForeground(new Color(3, 4, 94));
        l33.setBounds(895,345,150,40);
        p.add(l33);
        MyTextField t33=new MyTextField();
        t33.setFont(new Font("Vardana",1,14));
        t33.setBounds(970,345,230,40);
        t33.setHint("Emergency Contact Email");
        p.add(t33);
        JLabel l36=new JLabel("ALLERGY:");
        l36.setFont(new Font("Vardana", Font.BOLD, 16));
        l36.setForeground(new Color(3, 4, 94));
        l36.setBounds(510,345,120,40);
        p.add(l36);
        MyTextField t36=new MyTextField();
        t36.setFont(new Font("Vardana",1,14));
        t36.setBounds(650,345,230,40);
        t36.setHint("IF ANY");
        p.add(t36);

        JLabel l31=new JLabel("PASSWORD:");
        l31.setFont(new Font("Vardana", Font.BOLD, 16));
        l31.setForeground(new Color(3, 4, 94));
        l31.setBounds(30,410,150,40);
        p.add(l31);
        MyPasswordField t31=new MyPasswordField();
        t31.setFont(new Font("Vardana",1,14));
        t31.setBounds(150,410,250,40);
        t31.setHint("Password");
        p.add(t31);

        JLabel l52=new JLabel("CONFIRM PASSWORD:");
        l52.setFont(new Font("Vardana", Font.BOLD, 16));
        l52.setForeground(new Color(3, 4, 94));
        l52.setBounds(750,410,250,40);
        p.add(l52);
        MyPasswordField t52=new MyPasswordField();
        t52.setFont(new Font("Vardana",1,14));
        t52.setBounds(950,410,250,40);
        t52.setHint("Password");
        p.add(t52);

        JButton b = new JButton("REGISTER");
        b.setForeground(Color.white);
        b.setBackground(new Color(3, 4,94));
        b.setBounds(400, 520, 200, 35);
        b.setFont(new Font("Verdana",Font.BOLD, 14));
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setEnabled(false);
        p.add(b);

        JButton b3 = new JButton("CLOSE");
        b3.setForeground(Color.white);
        b3.setBackground(new Color(3, 4,94));
        b3.setBounds(630, 520, 200, 35);
        b3.setFont(new Font("Verdana",Font.BOLD, 14));
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        //b3.setEnabled(false);
        p.add(b3);

        b3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            PLoginAndRegister dl=new PLoginAndRegister();
            f.show();
            f.dispose();
        }});

        b.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            String pass=String.valueOf(t31.getPassword());
            String cpass=String.valueOf(t52.getPassword());
            if(pass.equals(cpass)){
                if(t11.getText().isEmpty()||t12.getText().isEmpty()||t8.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"It appears that some information is missing.");
                }
                else if (pass.isEmpty()||cpass.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Password or Confirm Password Has not been entered");
                }
                else {
                    EmailValidator emailValidator = new EmailValidator();
                    if(!emailValidator.validate(t12.getText().trim())) {
                        JOptionPane.showMessageDialog(null,"Enter a Valid Email Address");
                        return;
                    }

                    String fnamepat = t2.getText();
                    String mnamepat =t3.getText();
                    String lnamepat =t4.getText();
                    String phonepat = t11.getText();
                    String addpat = ta1.getText();
                    String statepat=t6.getText();
                    String citypat =t7.getText();
                    String pincodepat= t8.getText();
                    String genderpat = "male";
                    if(r1.isSelected()){
                        genderpat="male";
                    }
                    else if(r2.isSelected()){
                        genderpat="female";
                    }
                    String bloodgroup = cb.getText();
                    String emailpat= t12.getText();
                    String dob1pat= t13.getText();
                    String allergy= t36.getText();
                    String pass2dpat= t31.getText();
                    String pass1dpat= t52.getText();
                    String relid= t33.getText();
                    String reltype=t32.getText();
                    try{
                        Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
                        String qu1= "insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement pst = c1.prepareStatement(qu1);
                        pst.setString(1,emailpat);
                        pst.setString(2,fnamepat);
                        pst.setString(3,mnamepat);
                        pst.setString(4,lnamepat);
                        pst.setString(5,addpat);
                        pst.setString(6,statepat);
                        pst.setString(7,citypat);
                        pst.setString(8,pincodepat);
                        pst.setString(9,phonepat);
                        pst.setString(10,pass2dpat);
                        pst.setString(11,relid);
                        pst.setString(12,allergy);
                        pst.setString(13,bloodgroup);
                        pst.setString(14,genderpat);
                        pst.setString(15,dob1pat);
                        pst.setString(16,reltype);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Registered Successfully");

                        home h1= new home();
                        f.show();
                        f.dispose();

                    }catch (Exception e1){
                        e1.printStackTrace();
                    }

                }}
            else {
                JOptionPane.showMessageDialog(null,"Password and Confirm Password not matches");
            }
        }});

        JCheckBox r31=new JCheckBox("BY CLICKING,YOU ACCEPT THE TERMS AND CONDITIONS");
        p.add(r31);
        r31.setBounds(440,475,1300,40);
        r31.setFocusPainted(false);
        r31.setBorderPainted(false);
        r31.setBackground(Color.white);
        r31.setForeground(new Color(3, 4, 94));
        r31.setFont(new Font("Vardana", Font.BOLD, 12));
        r31.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                if(state==ItemEvent.SELECTED){
                    b.setEnabled(true);
                }
                else {
                    b.setEnabled(false);
                }
            }
        });

        t8.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                String value = t8.getText();
                int l = value.length();
                if ((EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' && (l<=5)) || EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                    t8.setEditable(true);
                }
                else {
                    t8.setEditable(false);
                }
            }
        });
        t13.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                String value = t13.getText();
                int l = value.length();
                if ((EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' && (l<=9)) || EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                    t13.setEditable(true);
                    /*if(l==2){
                        String d1=t13.getText();
                        t13.setText(d1+"/");
                        if(value.charAt(0)>'3'||value.charAt(1)>'9'){
                            t13.setText("");
                        }
                    }*/
                    if(l==2) {
                        String d1 = t13.getText();
                        if (value.charAt(0) == '3') {
                            if (value.charAt(1) <= '1') {
                                t13.setText(d1 + "/");
                            } else {
                                t13.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '0') {
                            if (value.charAt(1) <= '9') {
                                t13.setText(d1 + "/");
                            } else {
                                t13.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '1') {
                            if (value.charAt(1) <= '9') {
                                t13.setText(d1 + "/");
                            } else {
                                t13.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '2') {
                            if (value.charAt(1) <= '9') {
                                t13.setText(d1 + "/");
                            } else {
                                t13.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else {
                            t13.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                    if(l==5){
                        String d1=t13.getText();
                        if(value.charAt(3)=='1'){
                            if(value.charAt(4)<='2'){
                                t13.setText(d1+"/");
                            }
                            else {
                                t13.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        }
                        else if(value.charAt(3)=='0'){
                            if(value.charAt(4)<='9'){
                                t13.setText(d1+"/");
                            } else {
                                t13.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        }
                        else{
                            t13.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                    if(l==9){
                        String d1=t13.getText();
                        if(value.charAt(6)=='2'){
                            if(value.charAt(7)!='0'){
                                t13.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                            else {
                                t13.setText(String.valueOf(d1));
                            }
                        }
                        else if(value.charAt(6)>'2'){
                            t13.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                }
                else {
                    t13.setEditable(false);
                }
            }
        });

        t13.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                if(EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    t13.setText("");
        }}});
        t11.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                String value = t11.getText();
                int l = value.length();
                if ((EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' && (l<=9)) || EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                  t11.setEditable(true);
                }
                else {
                    t11.setEditable(false);
                }
            }
        });



        p.setBackground(Color.white);
        p.setBounds(10,50,1265,600);
        f.add(p);
        f.add(l1);
        f.getContentPane().setBackground(new Color(3, 4,94));
        f.setSize(1300, 700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args){
        new NewRegister("sumil","sumil123@gmail.com");
    }
}
