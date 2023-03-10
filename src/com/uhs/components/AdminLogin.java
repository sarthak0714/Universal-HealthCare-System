package com.uhs.components;



import com.uhs.swing.MyPasswordField;
import com.uhs.swing.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin {
    AdminLogin(){
        JFrame f2=new JFrame("Universal Healthcare System");
        JLabel l1 = new JLabel("Sign In");
        l1.setFont(new Font("Vardana", 1, 50));
        l1.setForeground(new Color(3, 4, 94));
        l1.setBounds(540,120,550,70);
        f2.add(l1);
        MyTextField t1=new MyTextField();
        t1.setFont(new Font("Vardana",1,12));
        t1.setBounds(370,230,530,40);
        t1.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/user.png")));
        t1.setHint("Username");
        f2.add(t1);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/mail.png")));
        txtEmail.setHint("Email");
        txtEmail.setFont(new Font("Vardana",1,12));
        txtEmail.setBounds(370,290,530,40);
        f2.add(txtEmail);
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/pass.png")));
        txtPass.setHint("Password");
        txtPass.setFont(new Font("Vardana",1,12));
        txtPass.setBounds(370,350,530,40);
        f2.add(txtPass);
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setBounds(520,400,200,40);
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("Vardana", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdForget.setBorderPainted(false);
        cmdForget.setFocusPainted(false);
        f2.add(cmdForget);
        JButton b1 = new JButton("SIGN IN");
        b1.setBackground(new Color(3, 4, 94));
        b1.setForeground(new Color(250, 250, 250));
        b1.setBounds(485,460,266,40);
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        f2.add(b1);
        /*
        JPanel p1=new JPanel();
        JLabel jl1=new JLabel("hello, Friend!");
        JLabel jl2=new JLabel("Enter your personal details");
        JLabel jl3=new JLabel("and start journey with us");
        jl1.setBounds(930,210,300,40);
        jl1.setFont(new Font("Vardana",1,40));
        jl1.setForeground(Color.white);
        jl2.setBounds(960,280,300,20);
        jl2.setFont(new Font("Vardana",0,14));
        jl2.setForeground(Color.white);
        jl3.setBounds(967,310,300,20);
        jl3.setFont(new Font("Vardana",0,14));
        jl3.setForeground(Color.white);
        JButton jb1=new JButton("SIGN UP");
        jb1.setBackground(new Color(3, 4, 94));
        jb1.setForeground(new Color(250, 250, 250));
        jb1.setBounds(930,365,250,40);
        jb1.setBorderPainted(true);
        jb1.setFocusPainted(false);
        jb1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            //LoginAndRegister lr2=new LoginAndRegister();
            f2.show();
            f2.dispose();
        }});

        f2.add(b1);

        f2.add(jl1);
        f2.add(jl2);
        f2.add(jl3);
        f2.add(jb1);

        p1.setBounds(800,0,500,700);
        p1.setBackground(new Color(3, 4, 94));
        f2.add(p1);

*/
        f2.setSize(1300, 700);
        f2.setLocationRelativeTo(null);
        f2.getContentPane().setBackground(new Color(255,255,255));
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setLayout(null);
        f2.setVisible(true);
    }
    public static void main(String[] args){
        new AdminLogin();
    }
}
