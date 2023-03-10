package com.uhs.components;

import com.uhs.swing.EmailValidator;
import com.uhs.swing.MyPasswordField;
import com.uhs.swing.MyTextArea;
import com.uhs.swing.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class DNewRegister  {
    public DNewRegister(){}
    public DNewRegister(String pnme,String pm){
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
        p.add(t2);
        t2.setText(String.valueOf(pnme));

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
        l5.setBounds(30,90,150,40);
        p.add(l5);
        MyTextArea ta1=new MyTextArea();
        ta1.setBounds(150,90,1050,60);
        ta1.setFont(new Font("Vardana",1,14));
        ta1.setHint("Address");
        p.add(ta1);

        JLabel l6=new JLabel("State:");
        l6.setFont(new Font("Vardana", Font.BOLD, 16));
        l6.setForeground(new Color(3, 4, 94));
        l6.setBounds(30,181,150,40);
        p.add(l6);
        MyTextField t6=new MyTextField();
        t6.setFont(new Font("Vardana",1,14));
        t6.setBounds(150,181,200,40);
        t6.setHint("State");
        p.add(t6);

        JLabel l7=new JLabel("CITY:");
        l7.setFont(new Font("Vardana", 1, 16));
        l7.setForeground(new Color(3, 4, 94));
        l7.setBounds(360,181,150,40);
        p.add(l7);
        MyTextField t7=new MyTextField();
        t7.setFont(new Font("Vardana",1,14));
        t7.setBounds(420,181,200,40);
        t7.setHint("City");
        p.add(t7);

        JLabel l8=new JLabel("PINCODE:");
        l8.setFont(new Font("Vardana", Font.BOLD, 16));
        l8.setForeground(new Color(3, 4, 94));
        l8.setBounds(630,181,150,40);
        p.add(l8);
        MyTextField t8=new MyTextField();
        t8.setFont(new Font("Vardana",1,14));
        t8.setBounds(730,181,200,40);
        t8.setHint("Pincode");
        p.add(t8);

        JLabel l9=new JLabel("BLOOD GROUP:");
        l9.setFont(new Font("Vardana", Font.BOLD, 16));
        l9.setForeground(new Color(3, 4, 94));
        l9.setBounds(950,181,150,40);
        p.add(l9);
//        String bloodgrp[]={"--Select--","A+","A-","B+","B-","AB+","AB-","O+","O-"};
        MyTextField cb=new MyTextField();
        cb.setBounds(1100, 181,90,40);
        cb.setFont(new Font("Vardana",1,14));
        cb.setHint("BG");
        p.add(cb);

        JLabel l10=new JLabel("GENDER: ");
        l10.setFont(new Font("Vardana", Font.BOLD, 16));
        l10.setForeground(new Color(3, 4, 94));
        l10.setBounds(30,255,150,40);
        p.add(l10);
        ButtonGroup bg=new ButtonGroup();
        JRadioButton r1=new JRadioButton("Male");
        JRadioButton r2=new JRadioButton("Female");
        bg.add(r1);bg.add(r2);
        p.add(r1);p.add(r2);
        r1.setBounds(130,248,70,60);
        r1.setFocusPainted(false);
        r1.setBorderPainted(false);
        r1.setBackground(Color.white);
        r1.setForeground(new Color(3, 4, 94));
        r1.setFont(new Font("Vardana", Font.BOLD, 12));
        r2.setBounds(200,248,70,60);
        r2.setFocusPainted(false);
        r2.setBorderPainted(false);
        r2.setBackground(Color.white);
        r2.setForeground(new Color(3, 4, 94));
        r2.setFont(new Font("Vardana", Font.BOLD, 12));

        JLabel l11=new JLabel("CONTACT NO:");
        l11.setFont(new Font("Vardana", Font.BOLD, 16));
        l11.setForeground(new Color(3, 4, 94));
        l11.setBounds(290,255,120,40);
        p.add(l11);
        MyTextField t11=new MyTextField();
        t11.setFont(new Font("Vardana",1,14));
        t11.setBounds(420,255,200,40);
        t11.setHint("Contact No");
        p.add(t11);

        JLabel l12=new JLabel("Email:");
        l12.setFont(new Font("Vardana", Font.BOLD, 16));
        l12.setForeground(new Color(3, 4, 94));
        l12.setBounds(660,255,150,40);
        p.add(l12);
        MyTextField t12=new MyTextField();
        t12.setFont(new Font("Vardana",1,14));
        t12.setBounds(730,255,200,40);
        t12.setHint("Email Address");
        p.add(t12);
        t12.setText(String.valueOf(pm));

        JLabel l13=new JLabel("D.O.B:");
        l13.setFont(new Font("Vardana", Font.BOLD, 16));
        l13.setForeground(new Color(3, 4, 94));
        l13.setBounds(950,255,150,40);
        p.add(l13);
        MyTextField t13=new MyTextField();
        t13.setFont(new Font("Vardana",1,14));
        t13.setBounds(1010,255,190,40);
        t13.setHint(" DD/MM/YYYY");
        p.add(t13);

        JLabel l52=new JLabel("QUALIFICATION:");
        l52.setFont(new Font("Vardana", Font.BOLD, 16));
        l52.setForeground(new Color(3, 4, 94));
        l52.setBounds(30,330,150,40);
        p.add(l52);
        MyTextField t52=new MyTextField();
        t52.setFont(new Font("Vardana",1,14));
        t52.setBounds(180,330,250,40);
        t52.setHint("Last Education degree");
        p.add(t52);
        JLabel l53=new JLabel("SPECIALIZATION:");
        l53.setFont(new Font("Vardana", 1, 16));
        l53.setForeground(new Color(3, 4, 94));
        l53.setBounds(460,330,150,40);
        p.add(l53);
        MyTextField t53=new MyTextField();
        t53.setFont(new Font("Vardana",1,14));
        t53.setBounds(605,330,250,40);
        t53.setHint("Specialize In");
        p.add(t53);
        JLabel l54=new JLabel("D.O.P:");
        l54.setFont(new Font("Vardana", Font.BOLD, 16));
        l54.setForeground(new Color(3, 4, 94));
        l54.setBounds(880,330,150,40);
        p.add(l54);
        MyTextField t54=new MyTextField();
        t54.setFont(new Font("Vardana",1,14));
        t54.setBounds(950,330,250,40);
        t54.setHint(" DD/MM/YYYY");
        p.add(t54);

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

        JLabel l32=new JLabel("CONFIRM PASSWORD:");
        l32.setFont(new Font("Vardana", Font.BOLD, 16));
        l32.setForeground(new Color(3, 4, 94));
        l32.setBounds(750,410,250,40);
        p.add(l32);
        MyPasswordField t32=new MyPasswordField();
        t32.setFont(new Font("Vardana",1,14));
        t32.setBounds(950,410,250,40);
        t32.setHint("Password");
        p.add(t32);
/*
        JLabel l21=new JLabel("EMERGENCY PERSON DETAILS:");
        l21.setFont(new Font("Vardana", Font.BOLD, 16));
        l21.setForeground(new Color(3, 4, 94));
        l21.setBounds(30,320,300,40);
        p.add(l21);
        JLabel l22=new JLabel("RELATION TYPE:");
        l22.setFont(new Font("Vardana", Font.BOLD, 16));
        l22.setForeground(new Color(3, 4, 94));
        l22.setBounds(790,325,150,40);
        p.add(l22);
        MyTextField t22=new MyTextField();
        t22.setFont(new Font("Vardana",1,14));
        t22.setBounds(950,325,250,40);
        t22.setHint("-Relation-Type-");
        p.add(t22);
        JLabel l31=new JLabel("FIRST NAME:");
        l31.setFont(new Font("Vardana", Font.BOLD, 16));
        l31.setForeground(new Color(3, 4, 94));
        l31.setBounds(30,380,150,40);
        p.add(l31);
        MyTextField t31=new MyTextField();
        t31.setFont(new Font("Vardana",1,14));
        t31.setBounds(150,380,250,40);
        t31.setHint("First Name");
        p.add(t31);
        JLabel l32=new JLabel("MIDDLE NAME:");
        l32.setFont(new Font("Vardana", 1, 16));
        l32.setForeground(new Color(3, 4, 94));
        l32.setBounds(420,380,150,40);
        p.add(l32);
        MyTextField t32=new MyTextField();
        t32.setFont(new Font("Vardana",1,14));
        t32.setBounds(555,380,250,40);
        t32.setHint("Middle Name");
        p.add(t32);
        JLabel l33=new JLabel("LAST NAME:");
        l33.setFont(new Font("Vardana", Font.BOLD, 16));
        l33.setForeground(new Color(3, 4, 94));
        l33.setBounds(830,380,150,40);
        p.add(l33);
        MyTextField t33=new MyTextField();
        t33.setFont(new Font("Vardana",1,14));
        t33.setBounds(950,380,250,40);
        t33.setHint("Last Name");
        p.add(t33);
        JLabel l35=new JLabel("GENDER: ");
        l35.setFont(new Font("Vardana", Font.BOLD, 16));
        l35.setForeground(new Color(3, 4, 94));
        l35.setBounds(30,435,150,40);
        p.add(l35);
        ButtonGroup bg1=new ButtonGroup();
        JRadioButton r11=new JRadioButton("Male");
        JRadioButton r22=new JRadioButton("Female");
        bg.add(r11);bg.add(r22);
        p.add(r11);p.add(r22);
        r11.setBounds(130,425,70,60);
        r11.setFocusPainted(false);
        r11.setBorderPainted(false);
        r11.setBackground(Color.white);
        r11.setForeground(new Color(3, 4, 94));
        r11.setFont(new Font("Vardana", Font.BOLD, 12));
        r22.setBounds(200,425,70,60);
        r22.setFocusPainted(false);
        r22.setBorderPainted(false);
        r22.setBackground(Color.white);
        r22.setForeground(new Color(3, 4, 94));
        r22.setFont(new Font("Vardana", Font.BOLD, 12));
        JLabel l36=new JLabel("CONTACT NO:");
        l36.setFont(new Font("Vardana", Font.BOLD, 16));
        l36.setForeground(new Color(3, 4, 94));
        l36.setBounds(290,431,120,40);
        p.add(l36);
        MyTextField t36=new MyTextField();
        t36.setFont(new Font("Vardana",1,14));
        t36.setBounds(420,435,200,40);
        t36.setHint("Contact No");
        p.add(t36);
        JLabel l37=new JLabel("Email:");
        l37.setFont(new Font("Vardana", Font.BOLD, 16));
        l37.setForeground(new Color(3, 4, 94));
        l37.setBounds(660,435,150,40);
        p.add(l37);
        MyTextField t37=new MyTextField();
        t37.setFont(new Font("Vardana",1,14));
        t37.setBounds(730,435,200,40);
        t37.setHint("Email Address");
        p.add(t37);
        JLabel l38=new JLabel("State:");
        l38.setFont(new Font("Vardana", Font.BOLD, 16));
        l38.setForeground(new Color(3, 4, 94));
        l38.setBounds(950,435,150,40);
        p.add(l38);
        MyTextField t38=new MyTextField();
        t38.setFont(new Font("Vardana",1,14));
        t38.setBounds(1010,435,190,40);
        t38.setHint("State");
        p.add(t38);*/

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
            DLoginAndRegister dl=new DLoginAndRegister();
            f.show();
            f.dispose();
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

        b.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            String pass=String.valueOf(t31.getPassword());
            String cpass=String.valueOf(t32.getPassword());
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
                    String fname = t2.getText();
                    String mname =t3.getText();
                    String lname =t4.getText();
                    String phone = t11.getText();
                    String addp = ta1.getText();
                    String statep=t6.getText();
                    String cityp =t7.getText();
                    String pincodep= t8.getText();

                    String gender = "male";
                    if(r1.isSelected()){
                        gender="male";
                    }
                    else if(r2.isSelected()){
                        gender="female";
                    }
                    String bloodgroup = cb.getText();
                    String emaild= t12.getText();
                    String dob1= t13.getText();
                    String quali = t52.getText();
                    String special = t53.getText();
                    String dop1 = t54.getText();
                    String pass2d= t31.getText();
                    String pass1d= t32.getText();
                    try {
                        Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
                        String qu1= "insert into doctor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps2 = c1.prepareStatement(qu1);

                        ps2.setString(1,emaild);
                        ps2.setString(2,fname);
                        ps2.setString(3,mname);
                        ps2.setString(4,lname);
                        ps2.setString(5,special);
                        ps2.setString(6,phone);
                        ps2.setString(7,cityp);
                        ps2.setString(8,addp);
                        ps2.setString(9,statep);
                        ps2.setString(10,pincodep);
                        ps2.setString(11,bloodgroup);
                        ps2.setString(12,gender);
                        ps2.setString(13,dob1);
                        ps2.setString(14,dop1);
                        ps2.setString(15,quali);
                        ps2.setString(16,pass1d);
                        ps2.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Registered Successfully");

                        DLoginAndRegister d1=new DLoginAndRegister();
                        f.show();
                        f.dispose();

                    }catch (Exception e2){
                        e2.printStackTrace();
                    }



            }}
            else {
                JOptionPane.showMessageDialog(null,"Password and Confirm Password not matches");
            }
        }});

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

        t54.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                String value = t54.getText();
                int l = value.length();
                if ((EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' && (l<=9)) || EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                    t54.setEditable(true);
                    /*if(l==2){
                        String d1=t13.getText();
                        t13.setText(d1+"/");
                        if(value.charAt(0)>'3'||value.charAt(1)>'9'){
                            t13.setText("");
                        }
                    }*/
                    if(l==2) {
                        String d1 = t54.getText();
                        if (value.charAt(0) == '3') {
                            if (value.charAt(1) <= '1') {
                                t54.setText(d1 + "/");
                            } else {
                                t54.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '0') {
                            if (value.charAt(1) <= '9') {
                                t54.setText(d1 + "/");
                            } else {
                                t54.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '1') {
                            if (value.charAt(1) <= '9') {
                                t54.setText(d1 + "/");
                            } else {
                                t54.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '2') {
                            if (value.charAt(1) <= '9') {
                                t54.setText(d1 + "/");
                            } else {
                                t54.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else {
                            t54.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                    if(l==5){
                        String d1=t54.getText();
                        if(value.charAt(3)=='1'){
                            if(value.charAt(4)<='2'){
                                t54.setText(d1+"/");
                            }
                            else {
                                t54.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        }
                        else if(value.charAt(3)=='0'){
                            if(value.charAt(4)<='9'){
                                t54.setText(d1+"/");
                            } else {
                                t54.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        }
                        else{
                            t54.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                    if(l==9){
                        String d1=t54.getText();
                        if(value.charAt(6)=='2'){
                            if(value.charAt(7)!='0'){
                                t54.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                            else {
                                t54.setText(String.valueOf(d1));
                            }
                        }
                        else if(value.charAt(6)>'2'){
                            t54.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                }
                else {
                    t54.setEditable(false);
                }
            }
        });

        t54.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                if(EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    t54.setText("");
                }}});


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
        new DNewRegister("sumil","sumil123@gmail.com");
    }
}

