package com.uhs.components;

import com.uhs.swing.EmailValidator;
import com.uhs.swing.MyPasswordField;
import com.uhs.swing.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DLoginAndRegister {
    public DLoginAndRegister(){
        //Register();
        Login();
    }
    public void Register(){
        JFrame f1=new JFrame("Universal Healthcare System");
        JLabel l1 = new JLabel("Create Account");
        l1.setFont(new Font("Vardana", 1, 50));
        l1.setForeground(new Color(3, 4, 94));//2,62,138
        l1.setBounds(200,120,550,50);
        f1.add(l1);
        MyTextField t1=new MyTextField();
        t1.setFont(new Font("Vardana",1,12));
        t1.setBounds(130,230,530,40);
        t1.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/user.png")));
        t1.setHint("Name");
        f1.add(t1);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/mail.png")));
        txtEmail.setHint("Email");
        txtEmail.setFont(new Font("Vardana",1,12));
        txtEmail.setBounds(130,290,530,40);
        f1.add(txtEmail);
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/pass.png")));
        txtPass.setHint("Password");
        txtPass.setFont(new Font("Vardana",1,12));
        txtPass.setBounds(130,350,530,40);
        f1.add(txtPass);
        JButton b1 = new JButton("SIGN UP");
        b1.setBackground(new Color(3, 4, 94));
        b1.setForeground(new Color(250, 250, 250));
        b1.setBounds(250,410,266,40);
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        f1.add(b1);
        b1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            //LoginAndRegister lr2=new LoginAndRegister();
            EmailValidator emailValidator = new EmailValidator();
            if(!emailValidator.validate(txtEmail.getText().trim())) {
                JOptionPane.showMessageDialog(null,"Enter a Valid Email Address");
                return;
            }
            DNewRegister dnr1=new DNewRegister(t1.getText(),txtEmail.getText());
            f1.show();
            f1.dispose();
        }});

        JPanel p1=new JPanel();
        JLabel jl1=new JLabel("Welcome Back!");
        JLabel jl2=new JLabel("To keep connected with us please");
        JLabel jl3=new JLabel("login with your personal info");
        jl1.setBounds(920,210,300,40);
        jl1.setFont(new Font("Vardana",1,40));
        jl1.setForeground(Color.white);
        jl2.setBounds(955,280,300,20);
        jl2.setFont(new Font("Vardana",0,14));
        jl2.setForeground(Color.white);
        jl3.setBounds(970,310,300,20);
        jl3.setFont(new Font("Vardana",0,14));
        jl3.setForeground(Color.white);
        JButton jb1=new JButton("SIGN IN");
        jb1.setBackground(new Color(3, 4, 94));
        jb1.setForeground(new Color(250, 250, 250));
        jb1.setBounds(940,365,250,40);
        jb1.setBorderPainted(true);
        jb1.setFocusPainted(false);
        jb1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            Login();
            f1.show();
            f1.dispose();
        }});

        f1.add(b1);

        f1.add(jl1);
        f1.add(jl2);
        f1.add(jl3);
        f1.add(jb1);

        p1.setBounds(800,0,500,700);
        p1.setBackground(new Color(3, 4, 94));
        f1.add(p1);


        f1.setSize(1300, 700);
        f1.setLocationRelativeTo(null);
        f1.getContentPane().setBackground(new Color(255,255,255));
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(null);
        f1.setVisible(true);
    }
    public void Login(){
        String semail,spass;
        JFrame f2=new JFrame("Universal Healthcare System");
        JLabel l1 = new JLabel("Sign In");
        l1.setFont(new Font("Vardana", 1, 50));
        l1.setForeground(new Color(3, 4, 94));
        l1.setBounds(300,120,550,70);
        f2.add(l1);
        /*MyTextField t1=new MyTextField();
        t1.setFont(new Font("Vardana",1,12));
        t1.setBounds(130,230,530,40);
        t1.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/user.png")));
        t1.setHint("Name");
        f2.add(t1);*/
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/mail.png")));
        txtEmail.setHint("Email");
        txtEmail.setFont(new Font("Vardana",1,12));
        txtEmail.setBounds(130,230,530,40);
        f2.add(txtEmail);
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/uhs/images/pass.png")));
        txtPass.setHint("Password");
        txtPass.setFont(new Font("Vardana",1,12));
        txtPass.setBounds(130,290,530,40);
        f2.add(txtPass);
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setBounds(290,340,200,40);
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
        b1.setBounds(250,400,266,40);
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        f2.add(b1);
        b1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            //LoginAndRegister lr2=new LoginAndRegister();
            String username = txtEmail.getText();
            String password = txtPass.getText();
            if(username.equals("")||password.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Credentials");
            }
            else{
                EmailValidator emailValidator = new EmailValidator();
                if(!emailValidator.validate(txtEmail.getText().trim())) {
                    JOptionPane.showMessageDialog(null,"Enter a Valid Email Address");
                    return;
                }
                try{
                    Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
                    String qu="Select * from doctor where doctorID=? and passwordd=?";
                    PreparedStatement ps= c.prepareStatement(qu);
                    ps.setString(1,username);
                    ps.setString(2,password);
                    ResultSet rs= ps.executeQuery();

                    if(rs.next()){
                        String fnme=rs.getString("fnamed");
                        JOptionPane.showMessageDialog(null,"Login Successful");
                        //TAKE TO DASHBOARD

                        DocDashBoard ddb1=new DocDashBoard(fnme,username);
                        f2.show();
                        f2.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Login UnSuccessful");
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        }});
        JPanel p1=new JPanel();
        JLabel jl1=new JLabel("hello, Doctor!");
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
            Register();
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


        f2.setSize(1300, 700);
        f2.setLocationRelativeTo(null);
        f2.getContentPane().setBackground(new Color(255,255,255));
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setLayout(null);
        f2.setVisible(true);
    }

    public static void main(String[] args)
    {
        new DLoginAndRegister();
    }


}
