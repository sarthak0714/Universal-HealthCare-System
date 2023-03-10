package com.uhs.components;

import com.uhs.swing.EmailValidator;
import com.uhs.swing.MyPasswordField;
import com.uhs.swing.MyTextField;

import javax.management.Query;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Queue;

public class PatientDashBoard {
    public String p,Dnam, Dupto, comm,descp, Dos;
    public int count=0;
    public PatientDashBoard(){}
    public PatientDashBoard(String sname,String semail){


        JFrame f= new JFrame("Universal Healthcare System");

        JPanel p1=new JPanel();
        p1.setBounds(0,0,240,750);
        p1.setBackground(new Color(3, 4, 94));
        f.add(p1);
        p1.setLayout(null);
        //JLabel l31=new JLabel(new ImageIcon(getClass().getResource("/com/uhs/images/i1.png")));
        //p1.add(l31);
        //l31.setBounds(15,20,50,50);
        JLabel l32=new JLabel("UHS");
        p1.add(l32);
        l32.setBounds(10,10,150,50);
        l32.setFont(new Font("sansserif", Font.BOLD, 36));
        l32.setForeground(Color.white);
        JButton b30=new JButton("   DASHBOARD");
        JButton b31=new JButton("   VIEW DETAILS");
        JButton b32=new JButton("   EDIT DETAILS");
        JButton b33=new JButton("   CHANGE PASSWORD");
        JButton b34=new JButton("   LOG OUT");
        JButton b35=new JButton("   VIEW DOCTORS");
        p1.add(b30);
        p1.add(b31);
        p1.add(b32);
        p1.add(b33);
        p1.add(b35);
        p1.add(b34);

        b30.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            new PatientDashBoard(sname,semail);
            f.show();
            f.dispose();
        }});
        b31.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            NewViewP np1=new NewViewP(semail);

        }});
        b32.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            NewEditP np2=new NewEditP(semail);

        }});
        b33.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            JFrame p8=new JFrame("CHANGE PASSWORD");

            JLabel text1=new JLabel("EMAIL ID:");
            JLabel text2=new JLabel("PASSWORD:");
            JLabel text3=new JLabel("NEW PASSWORD: ");

            MyTextField textEmail = new MyTextField();
            MyPasswordField textPass = new MyPasswordField();
            MyPasswordField textnewpass =new MyPasswordField();

            JButton btnAdd = new JButton("UPDATE");
            JButton btnDelete = new JButton("CLEAR");

            text1.setBounds(20, 20, 100, 40);
            text2.setBounds(20, 70, 500, 40);
            text3.setBounds(20, 120, 500, 40);
            text1.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setFont(new Font("sansserif",Font.BOLD, 14));
            text3.setFont(new Font("sansserif",Font.BOLD, 14));

            textEmail.setBounds(160, 20, 200, 35);
            textPass.setBounds(160, 70, 200, 35);
            textnewpass.setBounds(160, 120, 200, 35);
            text1.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setFont(new Font("sansserif",Font.BOLD, 14));
            text3.setFont(new Font("sansserif",Font.BOLD, 14));
            textEmail.setHint("Enter The Email Id");
            textPass.setHint("Enter Current Password");
            textnewpass.setHint("Enter New Password");
            textPass.setFont(new Font("sansserif",Font.BOLD, 12));
            textEmail.setFont(new Font("sansserif",Font.BOLD, 12));
            textnewpass.setFont(new Font("sansserif",Font.BOLD, 12));

            btnAdd.setFocusPainted(false);
            btnAdd.setBorderPainted(false);
            btnDelete.setFocusPainted(false);
            btnDelete.setBorderPainted(false);

            btnAdd.setBounds(80, 180, 100, 25);
            btnDelete.setBounds(190, 180, 100, 25);

            p8.add(text1);
            p8.add(text2);
            p8.add(text3);
            p8.add(textPass);
            p8.add(textEmail);
            p8.add(textnewpass);
            p8.add(btnAdd);
            p8.add(btnDelete);




            btnAdd.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    String username1 = "";
                    if(semail.equals(textEmail.getText())){
                    username1=textEmail.getText();}
                    String passp1=textPass.getText();
                    String passp2=textnewpass.getText();
                    if(username1.isEmpty()||passp1.isEmpty()||passp2.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter Valid Details");
                    }
                    else{
                        EmailValidator emailValidator = new EmailValidator();
                        if(!emailValidator.validate(textEmail.getText().trim())) {
                            JOptionPane.showMessageDialog(null,"Enter a Valid Email Address");
                            return;
                        }
                        try{
                            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
                            String qu="update patient set passwordp=? where patientid=? and passwordp=?";
                            PreparedStatement ps= c.prepareStatement(qu);
                            ps.setString(1,passp2);
                            ps.setString(2,username1);
                            ps.setString(3,passp1);
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Password Updated Succesfully");
                        }catch(Exception e1){
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null,"Email ID or password does not matches");
                        }
                    }


                }
            });

            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textPass.setText("");
                    textEmail.setText("");
                    textnewpass.setText("");
                }
            });

            p8.setBackground(Color.black);
            p8.setSize(400, 300);
            p8.setLocationRelativeTo(null);
            //p8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            p8.setLayout(null);
            p8.setVisible(true);

        }});
        b34.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            home h3=new home();
            f.show();
            f.dispose();

        }});
        b35.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            JFrame p8=new JFrame("SEARCH DOCTOR");

            JLabel text1=new JLabel("EMAIL ID:");
            JLabel text2=new JLabel();
            JLabel text3=new JLabel();

            MyTextField textEmail = new MyTextField();
            //MyTextField textEmail = new MyTextField();
            //MyTextField textStatus =new MyTextField();

            JButton btnAdd = new JButton("Search");
            JButton btnDelete = new JButton("Clear");

            text1.setBounds(20, 20, 100, 40);
            text2.setBounds(20, 70, 500, 40);
            text3.setBounds(20, 120, 500, 40);
            text1.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setFont(new Font("sansserif",Font.BOLD, 14));
            text3.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setText("Doctor Name:");
            text3.setText("Doctor Contact No:");

            textEmail.setBounds(100, 20, 200, 35);
            //textEmail.setBounds(160, 70, 200, 35);
            //textStatus.setBounds(160, 120, 200, 35);
            text1.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setFont(new Font("sansserif",Font.BOLD, 14));
            text3.setFont(new Font("sansserif",Font.BOLD, 14));
            textEmail.setHint("Enter The Email Id");
            //textEmail.setHint("Enter the Email Id");
            //textStatus.setHint("Enter Contact no");
            //textFname.setFont(new Font("sansserif",Font.BOLD, 12));
            textEmail.setFont(new Font("sansserif",Font.BOLD, 12));
            //textStatus.setFont(new Font("sansserif",Font.BOLD, 12));

            btnAdd.setFocusPainted(false);
            btnAdd.setBorderPainted(false);
            btnDelete.setFocusPainted(false);
            btnDelete.setBorderPainted(false);

            btnAdd.setBounds(80, 180, 100, 25);
            btnDelete.setBounds(190, 180, 100, 25);

            p8.add(text1);
            p8.add(text2);
            p8.add(text3);
            //p8.add(textFname);
            p8.add(textEmail);
            //p8.add(textStatus);
            p8.add(btnAdd);
            p8.add(btnDelete);




            btnAdd.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    String username1=textEmail.getText();

                    try{
                        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
                        String qu="Select * from doctor where doctorID=?";
                        PreparedStatement ps= c.prepareStatement(qu);
                        ps.setString(1,username1);
                        ResultSet rs= ps.executeQuery();

                        if(rs.next()){
                            String fnme=rs.getString("fnamed");
                            String lnme=rs.getString("lnamed");
                            String phne=rs.getString("phoned");
                            text2.setText("Doctor Name: "+String.valueOf(fnme)+" "+String.valueOf(lnme));
                            text3.setText("Doctor Contact No: "+String.valueOf(phne));

                            p8.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Enter Valid Doctor Email Id");
                        }
                    }catch(Exception e1){
                        e1.printStackTrace();
                    }
                }
            });

            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text2.setText("Doctor Name:");
                    textEmail.setText("");
                    text3.setText("Doctor Contact No:");
                }
            });

            p8.setBackground(Color.black);
            p8.setSize(400, 300);
            p8.setLocationRelativeTo(null);
            //p8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            p8.setLayout(null);
            p8.setVisible(true);

        }});

        b30.setBorder(new MatteBorder(1,0,0,0,Color.white));
        b30.setBackground(new Color(3, 4, 94));
        b30.setForeground(Color.white);
        b30.setBounds(0, 80, 250, 40);
        b30.setHorizontalAlignment(JLabel.LEFT);
        b30.setFont(new Font("sansserif",Font.BOLD, 14));
        b30.setFocusPainted(false);
        b30.setBorderPainted(false);
        b31.setBorder(new MatteBorder(1,0,0,0,Color.white));
        b31.setBackground(new Color(3, 4, 94));
        b31.setForeground(Color.white);
        b31.setBounds(0, 120, 250, 40);
        b31.setHorizontalAlignment(JLabel.LEFT);
        b31.setFont(new Font("sansserif",Font.BOLD, 14));
        b31.setBorderPainted(false);
        b31.setFocusPainted(false);
        b32.setBorder(new MatteBorder(1,0,0,0,Color.white));
        b32.setBackground(new Color(3, 4, 94));
        b32.setForeground(Color.white);
        b32.setBounds(0, 160, 250, 40);
        b32.setHorizontalAlignment(JLabel.LEFT);
        b32.setFont(new Font("sansserif",Font.BOLD, 14));
        b32.setFocusPainted(false);
        b32.setBorderPainted(false);
        b33.setBorder(new MatteBorder(1,0,0,0,Color.white));
        b33.setBackground(new Color(3, 4, 94));
        b33.setForeground(Color.white);
        b33.setBounds(0, 200, 250, 40);
        b33.setHorizontalAlignment(JLabel.LEFT);
        b33.setFont(new Font("sansserif",Font.BOLD, 14));
        b33.setFocusPainted(false);
        b33.setBorderPainted(false);
        b35.setBorder(new MatteBorder(1,0,2,0,Color.white));
        b35.setBackground(new Color(3, 4, 94));
        b35.setForeground(Color.white);
        b35.setBounds(0, 240, 250, 40);
        b35.setHorizontalAlignment(JLabel.LEFT);
        b35.setFont(new Font("sansserif",Font.BOLD, 14));
        b35.setFocusPainted(false);
        b35.setBorderPainted(false);
        b34.setBorder(new MatteBorder(1,0,2,0,Color.white));
        b34.setBackground(new Color(3, 4, 94));
        b34.setForeground(Color.white);
        b34.setBounds(0, 280, 250, 40);
        b34.setHorizontalAlignment(JLabel.LEFT);
        b34.setFont(new Font("sansserif",Font.BOLD, 14));
        b34.setFocusPainted(false);
        b34.setBorderPainted(false);

        JPanel p2=new JPanel();
        p2.setBounds(240,0,1060,40);
        p2.setBackground(Color.white);
        f.add(p2);
        p2.setLayout(null);
        JLabel p11=new JLabel(new ImageIcon(getClass().getResource("/com/uhs/images/user.png")));
        p11.setBounds(1000,1,50,40);
        p2.add(p11);

        JPanel p3=new JPanel();
        p3.setBounds(260,70,325,160);
        p3.setBackground(new Color(200,240,247));
        f.add(p3);
        p3.setLayout(null);
        JLabel li1=new JLabel("ABOUT LAST TREATMENT:");
        li1.setForeground(Color.black);
        li1.setBounds(16, 7, 250, 40);
        li1.setHorizontalAlignment(JLabel.LEFT);
        li1.setFont(new Font("sansserif",Font.BOLD, 14));
        p3.add(li1);

        JLabel li2=new JLabel();
        li2.setForeground(Color.black);

        li2.setBounds(16, 44, 400, 40);
        li2.setHorizontalAlignment(JLabel.LEFT);
        li2.setFont(new Font("sansserif",Font.BOLD, 14));
        p3.add(li2);

        JLabel li3=new JLabel();
        li3.setForeground(Color.black);
        li3.setBounds(16, 82, 400, 40);
        li3.setHorizontalAlignment(JLabel.LEFT);
        li3.setFont(new Font("sansserif",Font.BOLD, 14));
        p3.add(li3);


        JLabel li4=new JLabel();
        li4.setForeground(Color.black);
        li4.setBounds(16, 120, 400, 40);
        li4.setHorizontalAlignment(JLabel.LEFT);
        li4.setFont(new Font("sansserif",Font.BOLD, 14));
        p3.add(li4);

        JPanel p4=new JPanel();
        p4.setBounds(600,70,325,160);
        p4.setBackground(new Color(200,240,247));
        f.add(p4);
        p4.setLayout(null);
        JLabel li41=new JLabel("ABOUT PREVIOUS TREATMENT:");
        li41.setForeground(Color.black);
        li41.setBounds(16, 7, 250, 40);
        li41.setHorizontalAlignment(JLabel.LEFT);
        li41.setFont(new Font("sansserif",Font.BOLD, 14));
        p4.add(li41);

        JLabel li42=new JLabel();
        li42.setForeground(Color.black);
        li42.setBounds(16, 44, 400, 40);
        li42.setHorizontalAlignment(JLabel.LEFT);
        li42.setFont(new Font("sansserif",Font.BOLD, 14));
        p4.add(li42);

        JLabel li43=new JLabel();
        li43.setForeground(Color.black);
        li43.setBounds(16, 82, 400, 40);
        li43.setHorizontalAlignment(JLabel.LEFT);
        li43.setFont(new Font("sansserif",Font.BOLD, 14));
        p4.add(li43);

        JLabel li44=new JLabel();
        li44.setForeground(Color.black);
        li44.setBounds(16, 120, 400, 40);
        li44.setHorizontalAlignment(JLabel.LEFT);
        li44.setFont(new Font("sansserif",Font.BOLD, 14));
        p4.add(li44);

        JLabel lName=new JLabel();
        lName.setBounds(900,1,200,40);
        lName.setFont(new Font("sansserif", 3, 18));
        p2.add(lName);
        this.p=sname;
        lName.setText("Hello,"+String.valueOf(p));
        JPanel p5=new JPanel();
        p5.setBounds(940,70,325,160);
        p5.setBackground(new Color(200,240,247));
        f.add(p5);
        p5.setLayout(null);
        JLabel l41=new JLabel("ALERT:");
        l41.setForeground(Color.black);
        l41.setBounds(16, 7, 250, 40);
        l41.setHorizontalAlignment(JLabel.LEFT);
        l41.setFont(new Font("sansserif",Font.BOLD, 14));
        p5.add(l41);

        JLabel l42=new JLabel("Disease: Flu");
        l42.setForeground(Color.black);
        l42.setBounds(16, 44, 250, 40);
        l42.setHorizontalAlignment(JLabel.LEFT);
        l42.setFont(new Font("sansserif",Font.BOLD, 14));
        p5.add(l42);

        JLabel l43=new JLabel("Patient Recorded: 03");
        l43.setForeground(Color.black);
        l43.setBounds(16, 82, 250, 40);
        l43.setHorizontalAlignment(JLabel.LEFT);
        l43.setFont(new Font("sansserif",Font.BOLD, 14));
        p5.add(l43);

        JLabel l44=new JLabel("Location: Mumbai");
        l44.setForeground(Color.black);
        l44.setBounds(16, 120, 250, 40);
        l44.setHorizontalAlignment(JLabel.LEFT);
        l44.setFont(new Font("sansserif",Font.BOLD, 14));
        p5.add(l44);


        JPanel p6=new JPanel();
        p6.setBounds(940,250,325,400);
        p6.setBackground(Color.white);
        f.add(p6);
        p6.setLayout(null);
        JPanel p7=new JPanel();
        p7.setBounds(260,250,665,400);
        p7.setBackground(Color.white);
        p7.setLayout(null);
        f.add(p7);
        JLabel l21=new JLabel("PATIENTS DETAILS:");
        p7.add(l21);
        l21.setForeground(Color.BLACK);
        l21.setBounds(5,0,300,40);
        l21.setFont(new Font("sansserif", Font.BOLD, 20));
        JTable jta1=new JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row,
                                             int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                ((JLabel) comp).setHorizontalAlignment(JLabel.CENTER);
                return comp;
            }
        };
        Object[] columns = {"Report Id","Dooctor Id","diagnosis disease","Visited Date"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        jta1.setModel(model);
        JTableHeader jh1=jta1.getTableHeader();
        jta1.setTableHeader(null);
        p7.add(jh1);
        p7.add(jta1);
        jh1.setBounds(0,40,665,40);


        try{
            Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
            PreparedStatement pss= c1.prepareStatement("Select * from report where patientid in(select patientid from patient where patientid=?) order by reportid desc");
            pss.setString(1,semail);
            ResultSet rss= pss.executeQuery();
            Object[] row = new Object[4];
            while(rss.next()){
                count++;
                row[0]=rss.getString("reportid");
                row[1]=rss.getString("doctorID");
                row[2]=rss.getString("disease");
                row[3]=rss.getString("date_rcd");
                Dupto= rss.getString("date_upto");
                Dnam=rss.getString("Dnamer");
                comm=rss.getString("desc_report");
                descp=rss.getString("medication");
                Dos=rss.getString("Dose");
                model.addRow(row);
            }

        }catch (Exception ee){
            JOptionPane.showMessageDialog(null,"ERROR OCCURED");
        };


       /* try{
            Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
            PreparedStatement pss= c1.prepareStatement("Select * from doctor where doctorID in(select doctorID from report where patientid=?)");
            pss.setString(1,semail);
            ResultSet rss= pss.executeQuery();
            while(rss.next()){

                Dnam= rss.getString("fnamed");

            }

        }catch (Exception ee){
            JOptionPane.showMessageDialog(null,"ERROR OCCURED");
        };*/


        jta1.setRowHeight(50);
        jta1.setGridColor(new Color(230, 230, 230));
        //jtab1.setEnabled(false);
        jta1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jta1.setShowGrid(false);
        jta1.setShowVerticalLines(false);
        //jta1.setShowHorizontalLines(true);
        jta1.setFont(new Font("sansserif", 1, 12));
        jta1.setBorder(new MatteBorder(0,0,0,0,Color.white));
        //jh1.setRowHeight(40);
        //jh1.setShowVerticalLines(false);
        jh1.setBackground(new Color(200,240,247));
        jh1.setFont(new Font("sansserif", 1, 12));
        JScrollPane jsp1=new JScrollPane(jta1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        p7.add(jsp1);
        //jsp1.setBounds(10,10,50,90);
        jsp1.setBounds(3,80,665,320);
        jta1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=jta1.rowAtPoint(e.getPoint());
                String repID=jta1.getValueAt(i,0).toString();
                //String rdocn=jta1.getValueAt(i,1).toString();
                String rdocID=jta1.getValueAt(i,1).toString();
                String rdisease=jta1.getValueAt(i,2).toString();
                String rdrec=jta1.getValueAt(i,3).toString();

                Prescription1 pres=new Prescription1(repID,sname);


                //System.out.println("Name:"+ " " +jta1.getValueAt(row,0).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //next java page object

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        if(count==0)
        {
            li2.setText("REPORT ID: ");

            li3.setText("DIAGNOSIS DISEASE: ");

            li4.setText("TREATMENT DONE BY: ");

            li42.setText("REPORT ID:");

            li43.setText("DIAGNOSIS DISEASE: ");

            li44.setText("TREATMENT DONE BY: ");
        }
        else if(count==1) {
            String tab21=jta1.getValueAt(0,0).toString();
            li2.setText("REPORT ID: "+String.valueOf(tab21));

            String tab22=jta1.getValueAt(0,2).toString();
            li3.setText("DIAGNOSIS DISEASE: "+String.valueOf(tab22));

            String tab23=jta1.getValueAt(0,1).toString();
            li4.setText("TREATMENT DONE BY: "+String.valueOf(tab23));

            li42.setText("REPORT ID:");

            li43.setText("DIAGNOSIS DISEASE: ");

            li44.setText("TREATMENT DONE BY: ");
        }
        else {
            String tab21=jta1.getValueAt(0,0).toString();
            li2.setText("REPORT ID: "+String.valueOf(tab21));

            String tab22=jta1.getValueAt(0,2).toString();
            li3.setText("DIAGNOSIS DISEASE: "+String.valueOf(tab22));

            String tab23=jta1.getValueAt(0,1).toString();
            li4.setText("TREATMENT DONE BY: "+String.valueOf(tab23));

            String tab24=jta1.getValueAt(1,0).toString();
            li42.setText("REPORT ID:"+String.valueOf(tab24));

            String tab25=jta1.getValueAt(1,2).toString();
            li43.setText("DIAGNOSIS DISEASE: "+String.valueOf(tab25));

            String tab26=jta1.getValueAt(1,1).toString();
            li44.setText("TREATMENT DONE BY: "+String.valueOf(tab26));
        }
       /* if((tab21.equals(null)){
            li2.setText("REPORT ID: ");

            String tab22=jta1.getValueAt(0,2).toString();
            li3.setText("DIAGNOSIS DISEASE: ");

            String tab23=jta1.getValueAt(0,1).toString();
            li4.setText("TREATMENT DONE BY: ");

            String tab24=jta1.getValueAt(1,0).toString();
            li42.setText("REPORT ID:");

            String tab25=jta1.getValueAt(1,2).toString();
            li43.setText("DIAGNOSIS DISEASE: ");

            String tab26=jta1.getValueAt(1,1).toString();
            li44.setText("TREATMENT DONE BY: ");
        }

            li2.setText("REPORT ID: "+String.valueOf(tab21));

            String tab22=jta1.getValueAt(0,2).toString();
            li3.setText("DIAGNOSIS DISEASE: "+String.valueOf(tab22));

            String tab23=jta1.getValueAt(0,1).toString();
            li4.setText("TREATMENT DONE BY: "+String.valueOf(tab23));

            String tab24=jta1.getValueAt(1,0).toString();
            li42.setText("REPORT ID:"+String.valueOf(tab24));

            String tab25=jta1.getValueAt(1,2).toString();
            li43.setText("DIAGNOSIS DISEASE: "+String.valueOf(tab25));

            String tab26=jta1.getValueAt(1,1).toString();
            li44.setText("TREATMENT DONE BY: "+String.valueOf(tab26));*/
/*
        b40.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            JFrame p8=new JFrame("ADD PATIENT");

            JLabel text1=new JLabel("FIRST NAME:");
            JLabel text2=new JLabel("EMAIL ID:");
            JLabel text3=new JLabel("PATIENT STATUS:");

            MyTextField textFname = new MyTextField();
            MyTextField textEmail = new MyTextField();
            MyTextField textStatus =new MyTextField();

            JButton btnAdd = new JButton("Add");
            JButton btnDelete = new JButton("Clear");

            text1.setBounds(20, 20, 200, 40);
            text2.setBounds(20, 70, 200, 40);
            text3.setBounds(20, 120, 200, 40);
            text1.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setFont(new Font("sansserif",Font.BOLD, 14));
            text3.setFont(new Font("sansserif",Font.BOLD, 14));

            textFname.setBounds(160, 20, 200, 35);
            textEmail.setBounds(160, 70, 200, 35);
            textStatus.setBounds(160, 120, 200, 35);
            text1.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setFont(new Font("sansserif",Font.BOLD, 14));
            text3.setFont(new Font("sansserif",Font.BOLD, 14));
            textFname.setHint("Enter The Name");
            textEmail.setHint("Enter the Email Id");
            textStatus.setHint("ONGOING/COMPLETED/NEW");
            textFname.setFont(new Font("sansserif",Font.BOLD, 12));
            textEmail.setFont(new Font("sansserif",Font.BOLD, 12));
            textStatus.setFont(new Font("sansserif",Font.BOLD, 12));

            btnAdd.setFocusPainted(false);
            btnAdd.setBorderPainted(false);
            btnDelete.setFocusPainted(false);
            btnDelete.setBorderPainted(false);

            btnAdd.setBounds(80, 180, 100, 25);
            btnDelete.setBounds(190, 180, 100, 25);

            p8.add(text1);
            p8.add(text2);
            p8.add(text3);
            p8.add(textFname);
            p8.add(textEmail);
            p8.add(textStatus);
            p8.add(btnAdd);
            p8.add(btnDelete);

            Object[] row = new Object[3];

            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textFname.setText("");
                    textEmail.setText("");
                    textStatus.setText("");
                }
            });

            btnAdd.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {

                    row[0] = textFname.getText();
                    row[1] = textEmail.getText();
                    row[2] = textStatus.getText();

                    // add row to the model
                    model.addRow(row);
                    p8.setVisible(false);
                    p8.dispose();
                    JOptionPane.showMessageDialog(null,"PATIENT HAVE BEEN ADDED");

                }
            });

            p8.setBackground(Color.black);
            p8.setSize(400, 300);
            p8.setLocationRelativeTo(null);
            //p8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            p8.setLayout(null);
            p8.setVisible(true);

        }});


        String[][] data = {
                { "SHUBHAM", "shubham.yadhav@gmail.com","ongoing" },
                {"SHUBHAM", "shubham.yadhav@gmail.com","ongoing"}
        };
        String[][] data1 = {
                { " NAME", "EMAIL ID","STATUS"}
        };
        String[] columnNames = { " NAME", "EMAIL ID","STATUS" };

        JTable jtab1= new JTable(data,columnNames){
            public boolean isCellEditable(int row,int column){
                return false;
            }
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row,
                                             int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                ((JLabel) comp).setHorizontalAlignment(JLabel.CENTER);
                return comp;
            }
        };
        //JTable jh1=new JTable(data1,columnNames);
        JTableHeader jh1=jtab1.getTableHeader();
        jtab1.setTableHeader(null);
        p7.add(jh1);
        p7.add(jtab1);
        jh1.setBounds(0,40,665,40);
        jtab1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=jtab1.rowAtPoint(e.getPoint());

                int col= jtab1.columnAtPoint(e.getPoint());

                JOptionPane.showMessageDialog(null,"Value in the cell clicked :"+ " " +jtab1.getValueAt(row,col).toString());

                System.out.println("Value in the cell clicked :"+ " " +jtab1.getValueAt(row,col).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                home h123=new home();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        jtab1.setRowHeight(50);
        jtab1.setGridColor(new Color(230, 230, 230));
        //jtab1.setEnabled(false);

        jtab1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jtab1.setShowGrid(false);
        jtab1.setShowVerticalLines(false);
        //jtab1.setShowHorizontalLines(true);
        jtab1.setFont(new Font("sansserif", 1, 12));
        jtab1.setBorder(new MatteBorder(0,0,0,0,Color.white));
        //jh1.setRowHeight(40);
        //jh1.setShowVerticalLines(false);
        jh1.setBackground(Color.gray);
        jh1.setFont(new Font("sansserif", 1, 12));

        JScrollPane jsp1=new JScrollPane(jtab1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p7.add(jsp1);
        //jsp1.setBounds(10,10,50,90);
        jsp1.setBounds(0,80,665,500);
*/
        JTextArea ta2=new JTextArea();
        ta2.setText("  Conjunctivitis, also known as pinkeye, is \n  an inflammation of the conjunctiva. The \n  conjunctiva is the thin clear tissue that lies \n  over the white part of the eye and lines the inside of the \n  eyelid\n -------------------------------------------------------------- \n  Coronavirus disease (COVID-19) is an \n  infectious disease caused by the SARS-\n  CoV-2 virus. " +
                "Most people who fall sick \n  with COVID-19 will experience mild to \n  moderate symptoms and recover without \n  special treatment. However, some will \n  become seriously ill and require medical \n  attention.\n -------------------------------------------------------------- \n  Diabetes is a chronic disease that occurs \n  either when the pancreas not produce\n  enough insulin or when the body cannot \n  effectively use the insulin it produces."+
                "\n  Diabetes can be treated and its consequences \n  avoided or delayed with diet, physical \n  activity, medication and regular screening \n  and treatment for complications.");
        p6.add(ta2);
        ta2.setEditable(false);
        ta2.setFont(new Font("sansserif", Font.BOLD, 14));

        //ta2.setBounds(30,20,105,200);
        //ta2.setBackground(Color.BLACK);
        JScrollPane jsp2=new JScrollPane(ta2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p6.add(jsp2);
        jsp2.setBounds(0,30,326,375);
        jsp2.setForeground(Color.black);
        JLabel l22=new JLabel("NOTICE");
        l22.setForeground(Color.BLACK);
        p6.setBackground(new Color(144,224,239));
        p6.add(l22);
        l22.setBounds(150,0,320,30);







        f.setSize(1300, 700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

    }


    public static void main(String[] args){
        new PatientDashBoard("sujal","sujal@gmail.com");
    }
}
