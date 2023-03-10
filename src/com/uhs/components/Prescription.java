package com.uhs.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Prescription {
    public Prescription(){}
     public Prescription(String patname,String patid,String rID,String Docname,String DocId,String dise,String Drec,String Dupto,String comm,String descp,String Dos){

         JFrame f=new JFrame("Universal Healthcare System");
         JPanel p=new JPanel();
         JLabel l1=new JLabel("Universal Healthcare System");
         JLabel rid=new JLabel();
         JLabel pid=new JLabel();
         JLabel pname=new JLabel();
         JLabel did=new JLabel();
         JLabel dname=new JLabel();
         JLabel disease=new JLabel();
         JLabel dep=new JLabel();
         JLabel Drecor=new JLabel();
         JLabel Duptod=new JLabel();
         JLabel description=new JLabel();
         JLabel doses=new JLabel();
         JLabel gend=new JLabel();
         JLabel pcon=new JLabel();
         JLabel statep=new JLabel();


         rid.setText("Report Id: "+String.valueOf(rID));
         rid.setBounds(20,8,200,40);
         rid.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(rid);

         Drecor.setText("Report Date: "+String.valueOf(Drec));
         Drecor.setBounds(850,8,300,40);
         Drecor.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(Drecor);

         pname.setText("Patient Name: "+String.valueOf(patname));
         pname.setBounds(20,50,600,40);
         pname.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(pname);

         pid.setText("Patient Email Id: "+String.valueOf(patid));
         pid.setBounds(850,50,500,40);
         pid.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(pid);

         dname.setText("Prescribed By Dr."+String.valueOf(Docname));
         dname.setBounds(20,95,300,40);
         dname.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(dname);

         did.setText("Doctor Email Id: "+String.valueOf(DocId));
         did.setBounds(850,95,500,40);
         did.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(did);

         JLabel style=new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
         style.setBounds(20,126,1220,40);
         style.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(style);

         JLabel rx=new JLabel("Rx.");
         rx.setBounds(30,152,1220,40);
         rx.setFont(new Font("Vardana", Font.BOLD, 20));
         p.add(rx);

         disease.setText("Patient Mr/Mrs "+String.valueOf(patname)+" was diagnosed with "+String.valueOf(dise)+".");
         disease.setBounds(30,182,1200,40);
         disease.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(disease);

         dep.setText(String.valueOf(patname)+" was given the aforementioned medication, "+String.valueOf(descp)+" with "+String.valueOf(Dos)+" doses per day based on his/her symptoms.");
         dep.setBounds(30,214,1220,40);
         dep.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(dep);

         description.setText("It is anticipated that they will continue taking this medication until "+String.valueOf(Dupto)+".");
         description.setBounds(30,248,1220,40);
         description.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(description);

         Duptod.setText("Reports Needed: "+String.valueOf(comm));
         Duptod.setBounds(30,320,1220,40);
         Duptod.setFont(new Font("Vardana", Font.BOLD, 18));
         p.add(Duptod);

         JButton repbtn=new JButton("Click here to see report");
         p.add(repbtn);
         repbtn.setBounds(30,360,250,40);
         repbtn.setFont(new Font("Vardana", Font.BOLD, 18));
         repbtn.setFocusPainted(false);
         repbtn.setBorderPainted(false);
         repbtn.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
             if(rID.equals("R00001")){
                 JOptionPane.showMessageDialog(null,"Report found");
                 if (Desktop.isDesktopSupported()) {
                     try {
                         File myFile = new File("C:\\Users\\Sumil\\Documents\\GitHub\\uhs\\src\\com\\uhs\\images\\R00001.pdf");
                         Desktop.getDesktop().open(myFile);
                     } catch (IOException ex) {
                         // no application registered for PDFs
                     }
                 }
             }
             else {
                 JOptionPane.showMessageDialog(null,"No Report Available");
             }
         }});

         JButton clobtn=new JButton("Close The File");
         p.add(clobtn);
         clobtn.setBounds(480,540,250,40);
         clobtn.setFont(new Font("Vardana", Font.BOLD, 18));
         clobtn.setFocusPainted(false);
         clobtn.setBorderPainted(false);
         clobtn.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
             f.show();
             f.dispose();
         }});





         l1.setFont(new Font("Vardana", Font.BOLD, 24));
         l1.setBounds(450,5,500,40);
         l1.setForeground(Color.white);
         f.add(l1);
         p.setBackground(Color.white);
         p.setBounds(10,50,1265,600);
         p.setLayout(null);
         f.add(p);


         f.getContentPane().setBackground(new Color(3, 4,94));
         f.setSize(1300, 700);
         f.setLocationRelativeTo(null);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setLayout(null);
         f.setVisible(true);
     }

     public static void main(String[] args){
         new Prescription();
     }
}
