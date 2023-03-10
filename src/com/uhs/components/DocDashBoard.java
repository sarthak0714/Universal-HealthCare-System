package com.uhs.components;



import com.uhs.swing.EmailValidator;
import com.uhs.swing.MyPasswordField;
import com.uhs.swing.MyTextField;

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
import java.util.Objects;

public class DocDashBoard {
    public String dname,demail;
    public DocDashBoard(){}
    public DocDashBoard(String sname,String semail){


        JFrame f= new JFrame("Universal Healthcare System");

        JPanel p1=new JPanel();
        p1.setBounds(0,0,240,750);
        p1.setBackground(new Color(3, 4, 94));
        f.add(p1);
        p1.setLayout(null);
        //JLabel l31=new JLabel(new ImageIcon("C:\\Users\\Sumil\\Download\\i12.png"));
        //p1.add(l31);
        //l31.setBounds(15,20,50,50);
        JLabel l32=new JLabel("UHS");
        p1.add(l32);
        l32.setBounds(10,10,150,50);
        l32.setFont(new Font("sansserif", Font.BOLD, 36));
        l32.setForeground(Color.white);
        JButton b30=new JButton("   DASHBOARD");
        JButton b31=new JButton("   SEARCH DOCTOR");
        JButton b32=new JButton("   CHANGE PASSWORD");
        JButton b33=new JButton("   LOG OUT");
        p1.add(b30);
        p1.add(b31);
        p1.add(b32);
        p1.add(b33);

        b30.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            new DocDashBoard(sname,semail);
            f.show();
            f.dispose();
        }});
        b33.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            home h3=new home();
            f.show();
            f.dispose();

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

        b32.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
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
                            String qu="update doctor set passwordd=? where doctorID=? and passwordd=?";
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
            p8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            p8.setLayout(null);
            p8.setVisible(true);

        }});


        JPanel p2=new JPanel();
        p2.setBounds(240,0,1060,40);
        p2.setBackground(Color.white);
        f.add(p2);
        p2.setLayout(null);
        JLabel p11=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/uhs/images/user.png"))));
        p11.setBounds(1000,1,50,40);
        p2.add(p11);
        JLabel lName=new JLabel();
        lName.setBounds(900,1,200,40);
        lName.setFont(new Font("sansserif", 3, 18));
        p2.add(lName);
        this.demail=semail;
        this.dname=sname;
        lName.setText("Hello, "+String.valueOf(dname));


        JPanel p5=new JPanel();
        p5.setBounds(940,70,325,160);
        p5.setBackground(new Color(200,240,247));
        f.add(p5);
        p5.setLayout(null);
        JLabel l41=new JLabel();
        l41.setText("Doctor Name: "+String.valueOf(sname));
        l41.setForeground(Color.black);
        l41.setBounds(16, 10, 450, 40);
        l41.setHorizontalAlignment(JLabel.LEFT);
        l41.setFont(new Font("sansserif",Font.BOLD, 14));
        p5.add(l41);

        JLabel l42=new JLabel();
        l42.setText("Doctor Email: "+String.valueOf(semail));
        l42.setForeground(Color.black);
        l42.setBounds(16, 50, 450, 40);
        l42.setHorizontalAlignment(JLabel.LEFT);
        l42.setFont(new Font("sansserif",Font.BOLD, 14));
        p5.add(l42);
        JButton b42=new JButton(" ADD PATIENT ");
        p5.add(b42);
        b42.setBorder(new MatteBorder(1,0,0,0,Color.white));
        b42.setBackground(new Color(2,62,138));
        b42.setForeground(Color.white);
        b42.setBounds(16, 100, 293, 35);
        b42.setHorizontalAlignment(JLabel.CENTER);
        b42.setFont(new Font("sansserif",Font.BOLD, 14));
        b42.setBorderPainted(false);
        b42.setFocusPainted(false);

        JPanel p6=new JPanel();
        p6.setBounds(940,250,325,400);
        p6.setBackground(Color.white);
        f.add(p6);
        p6.setLayout(null);
        JPanel p7=new JPanel();
        p7.setBounds(260,70,665,580);
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
        Object[] columns = {"First Name","Email Id","Contact No"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        jta1.setModel(model);
        JTableHeader jh1=jta1.getTableHeader();
        jta1.setTableHeader(null);
        p7.add(jh1);
        p7.add(jta1);
        jh1.setBounds(0,40,665,40);


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
        JScrollPane jsp1=new JScrollPane(jta1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p7.add(jsp1);
        //jsp1.setBounds(10,10,50,90);
        jsp1.setBounds(0,80,665,500);
        jta1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=jta1.rowAtPoint(e.getPoint());

                int col= jta1.columnAtPoint(e.getPoint());
                String pname=jta1.getValueAt(row,0).toString();
                String pmail=jta1.getValueAt(row,1).toString();

                AddReport ad1=new AddReport(pname,pmail,dname,demail);

                //JOptionPane.showMessageDialog(null,"Name:"+ " " +jta1.getValueAt(row,0).toString()+"    Email Id:"+ " " +jta1.getValueAt(row,1).toString());

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

        b42.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            JFrame p8=new JFrame("ADD PATIENT");

            JLabel text1=new JLabel("EMAIL ID:");
            JLabel text2=new JLabel();
            JLabel text3=new JLabel();

            MyTextField textEmail = new MyTextField();
            //MyTextField textEmail = new MyTextField();
            //MyTextField textStatus =new MyTextField();

            JButton btnAdd = new JButton("Add");
            JButton btnDelete = new JButton("Clear");

            text1.setBounds(20, 20, 100, 40);
            text2.setBounds(20, 70, 500, 40);
            text3.setBounds(20, 120, 500, 40);
            text1.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setFont(new Font("sansserif",Font.BOLD, 14));
            text3.setFont(new Font("sansserif",Font.BOLD, 14));
            text2.setText("Patient Name:");
            text3.setText("Patient Contact No:");

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

            Object[] row = new Object[3];



            btnAdd.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    String username=textEmail.getText().trim();

                    try{
                        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
                        String qu="Select * from Patient where patientid=?";
                        PreparedStatement ps= c.prepareStatement(qu);
                        ps.setString(1,username);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next()){
                            String fnme=rs.getString("fnamep");
                            String phne=rs.getString("Phonep");
                            text2.setText("Patient Name: "+String.valueOf(fnme));
                            text3.setText("Patient Contact No: "+String.valueOf(phne));
                            row[0] = fnme;
                            row[1] = username;
                            row[2] = phne;
                            // add row to the model
                            model.addRow(row);
                            p8.setVisible(true);
                            //p8.dispose();
                            JOptionPane.showMessageDialog(null,"PATIENT HAVE BEEN ADDED");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Enter Valid Patient Email Id");
                        }
                    }catch(Exception e1){
                        e1.printStackTrace();
                    }
                }
            });

            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text2.setText("Patient Name:");
                    textEmail.setText("");
                    text3.setText("Patient Contact No:");
                }
            });

            p8.setBackground(Color.black);
            p8.setSize(400, 300);
            p8.setLocationRelativeTo(null);
            //p8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            p8.setLayout(null);
            p8.setVisible(true);

        }});

        b31.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
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

        try{
            Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
            PreparedStatement pss= c1.prepareStatement("Select * from patient where patientid in(select patientid from report where doctorid=?)");
            pss.setString(1,semail);
            ResultSet rss= pss.executeQuery();
            Object[] row = new Object[3];
            while(rss.next()){


                row[0]=rss.getString("fnamep");
                row[1]=rss.getString("patientid");
                row[2]=rss.getString("Phonep");
                model.addRow(row);
            }

        }catch (Exception ee){
            JOptionPane.showMessageDialog(null,"ERROR OCCURED");
        };

        /*
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
        p6.setBackground(new Color(200,240,247));
        p6.add(l22);
        l22.setBounds(150,0,320,30);







        f.setSize(1300, 700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

    }


    public static void main(String[] args){
        new DocDashBoard("ajay","ajay@gmail.com");
    }
}
