package com.uhs.components;

import com.uhs.swing.MyTextArea;
import com.uhs.swing.MyTextField;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class AddReport{
    public String[] stringprec;
    AddReport(){}
    AddReport(String pnme,String pmal,String dnam,String dmal){

        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable(){
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
        JTableHeader th=table.getTableHeader();
        th.setPreferredSize(new Dimension(30,40));

        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"Report Id","Disease","Doctor","DEmail Id","Date","Till Date","Description","Prescription","Doses"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        // set the model to the table
        table.setModel(model);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        //table.setBackground(new Color(200,240,247));
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);

        // create JButtons
        JButton btnAdd = new JButton("Add");
        btnAdd.setBorderPainted(false);
        btnAdd.setFocusPainted(false);
        btnAdd.setBackground(new Color(200,240,247));


        // create JScrollPane
        JScrollPane pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setBounds(0, 47, 1020, 200);
        pane.setBackground(new Color(200,240,247));
        table.setRowHeight(30);
        //table.setShowGrid(true);
        TableColumnModel columnModel=table.getColumnModel();
        columnModel.getColumn(3).setPreferredWidth(120);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(30);
        table.setFont(new Font("sansserif", Font.BOLD, 12));
        table.setGridColor(new Color(230, 230, 230));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setShowGrid(false);
        table.setShowVerticalLines(false);
        th.setFont(new Font("sansserif", Font.BOLD, 12));
        th.setBackground(new Color(200,240,247));

        JLabel reporthead=new JLabel("ADD NEW REPORT:");
        JLabel rid=new JLabel("REPORT Id:");
        JLabel pid=new JLabel("PATIENT EMAIL:");
        JLabel pname=new JLabel();
        JLabel did=new JLabel();
        JLabel dname=new JLabel();
        JLabel disease=new JLabel("DISEASE:");
        JLabel descp=new JLabel("PRESCRIPTION:");
        JLabel Drec=new JLabel("REPORT DATE:");
        JLabel Dupto=new JLabel("REPORT UPTO:");
        JLabel description=new JLabel("Report needed:");
        JLabel doses=new JLabel("DOSE:");

        MyTextField trid=new MyTextField();
        MyTextField tdisease=new MyTextField();
        MyTextArea tdescp=new MyTextArea();
        MyTextField tDrec=new MyTextField();
        MyTextField tDupto=new MyTextField();
        MyTextField tdescription=new MyTextField();
        MyTextField tdoses=new MyTextField();

        pname.setBounds(5,5,200,40);
        pname.setText("Patient Name : "+String.valueOf(pnme));
        pname.setFont(new Font("sansserif", Font.BOLD, 16));
        frame.add(pname);
        pid.setBounds(330,5,600,40);
        pid.setText("Patient Email Id : "+String.valueOf(pmal));
        pid.setFont(new Font("sansserif", Font.BOLD, 16));
        frame.add(pid);
        reporthead.setBounds(3,250,300,30);
        reporthead.setFont(new Font("sansserif", Font.BOLD, 18));
        frame.add(reporthead);
        rid.setBounds(5,280,100,40);
        rid.setFont(new Font("sansserif", 2, 16));
        frame.add(rid);
        trid.setBounds(120,280,200,40);
        trid.setFont(new Font("sansserif", 1, 14));
        trid.setHint("Enter report Id");
        frame.add(trid);
        dname.setBounds(5,320,300,40);
        dname.setText("Prescribe By Doctor : "+String.valueOf(dnam));
        dname.setFont(new Font("sansserif", 2, 16));
        frame.add(dname);
        did.setBounds(440,320,360,40);
        did.setText("Doctor Email Id : "+String.valueOf(dmal));
        did.setFont(new Font("sansserif", 2, 16));
        frame.add(did);
        disease.setBounds(5,360,100,40);
        disease.setFont(new Font("sansserif", 2, 16));
        frame.add(disease);
        tdisease.setBounds(120,360,200,40);
        tdisease.setFont(new Font("sansserif", 1, 14));
        tdisease.setHint("Diagnosis disease:");
        frame.add(tdisease);
        descp.setBounds(440,410,150,40);
        descp.setFont(new Font("sansserif", 2, 16));
        frame.add(descp);
        tdescp.setBounds(570,410,200,80);
        tdescp.setFont(new Font("sansserif", 1, 14));
        tdescp.setHint("Medicine Name");
        frame.add(tdescp);
        Drec.setBounds(440,280,180,40);
        Drec.setFont(new Font("sansserif", 2, 16));
        frame.add(Drec);
        tDrec.setBounds(570,280,200,40);
        tDrec.setFont(new Font("sansserif", 1, 14));
        tDrec.setHint(" DD/MM/YYYY");
        frame.add(tDrec);
        Dupto.setBounds(440,360,180,40);
        Dupto.setFont(new Font("sansserif", 2, 16));
        frame.add(Dupto);
        tDupto.setBounds(570,360,200,40);
        tDupto.setFont(new Font("sansserif", 1, 14));
        tDupto.setHint(" DD/MM/YYYY");
        frame.add(tDupto);
        description.setBounds(5,410,120,40);
        description.setFont(new Font("sansserif", 2, 16));
        frame.add(description);
        tdescription.setBounds(120,410,200,40);
        tdescription.setFont(new Font("sansserif", 1, 14));
        tdescription.setHint("Xrays,City scan,etc");
        frame.add(tdescription);
        doses.setBounds(5,460,120,40);
        doses.setFont(new Font("sansserif", 2, 16));
        frame.add(doses);
        tdoses.setBounds(120,460,50,40);
        tdoses.setFont(new Font("sansserif", 1, 14));
        tdoses.setHint("dose");
        JLabel d1=new JLabel("per day");
        frame.add(d1);
        d1.setBounds(180,460,80,40);
        d1.setFont(new Font("sansserif", 2, 16));
        frame.add(tdoses);

        JFileChooser fc1=new JFileChooser();
        frame.add(fc1);
        fc1.setBackground(Color.WHITE);
        fc1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //fc1.setForeground(Color.white);
        fc1.setBounds(10,510,600,40);

        frame.add(btnAdd);
        btnAdd.setBounds(840, 295, 150, 35);
        JButton btnDelete = new JButton("Clear");
        btnDelete.setBounds(840,370,150,35);
        frame.add(btnDelete);
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setBackground(new Color(200,240,247));
        frame.setLayout(null);
        frame.add(pane);
        Object[] row = new Object[9];
        Object[] r00001={"R00001","Flue","Aaron","aaron123@gmail.com","05/01/2021","12/01/2021","Xray of L2","Dolo-350,Crocin","3"};
        model.addRow(r00001);

        tDrec.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                String value = tDrec.getText();
                int l = value.length();
                if ((EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' && (l<=9)) || EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                    tDrec.setEditable(true);
                    /*if(l==2){
                        String d1=t13.getText();
                        t13.setText(d1+"/");
                        if(value.charAt(0)>'3'||value.charAt(1)>'9'){
                            t13.setText("");
                        }
                    }*/
                    if(l==2) {
                        String d1 = tDrec.getText();
                        if (value.charAt(0) == '3') {
                            if (value.charAt(1) <= '1') {
                                tDrec.setText(d1 + "/");
                            } else {
                                tDrec.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '0') {
                            if (value.charAt(1) <= '9') {
                                tDrec.setText(d1 + "/");
                            } else {
                                tDrec.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '1') {
                            if (value.charAt(1) <= '9') {
                                tDrec.setText(d1 + "/");
                            } else {
                                tDrec.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '2') {
                            if (value.charAt(1) <= '9') {
                                tDrec.setText(d1 + "/");
                            } else {
                                tDrec.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else {
                            tDrec.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                    if(l==5){
                        String d1=tDrec.getText();
                        if(value.charAt(3)=='1'){
                            if(value.charAt(4)<='2'){
                                tDrec.setText(d1+"/");
                            }
                            else {
                                tDrec.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        }
                        else if(value.charAt(3)=='0'){
                            if(value.charAt(4)<='9'){
                                tDrec.setText(d1+"/");
                            } else {
                                tDrec.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        }
                        else{
                            tDrec.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                    if(l==9){
                        String d1=tDrec.getText();
                        if(value.charAt(6)=='2'){
                            if(value.charAt(7)!='0'){
                                tDrec.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                            else {
                                tDrec.setText(String.valueOf(d1));
                            }
                        }
                        else if(value.charAt(6)>'2'){
                            tDrec.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                }
                else {
                    tDrec.setEditable(false);
                }
            }
        });

        tDrec.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                if(EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    tDrec.setText("");
                }}});

        tDupto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                String value = tDupto.getText();
                int l = value.length();
                if ((EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' && (l<=9)) || EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                    tDupto.setEditable(true);
                    if(l==2) {
                        String d1 = tDupto.getText();
                        if (value.charAt(0) == '3') {
                            if (value.charAt(1) <= '1') {
                                tDupto.setText(d1 + "/");
                            } else {
                                tDupto.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '0') {
                            if (value.charAt(1) <= '9') {
                                tDupto.setText(d1 + "/");
                            } else {
                                tDupto.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '1') {
                            if (value.charAt(1) <= '9') {
                                tDupto.setText(d1 + "/");
                            } else {
                                tDupto.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else if (value.charAt(0) == '2') {
                            if (value.charAt(1) <= '9') {
                                tDupto.setText(d1 + "/");
                            } else {
                                tDupto.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        } else {
                            tDupto.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                    if(l==5){
                        String d1=tDupto.getText();
                        if(value.charAt(3)=='1'){
                            if(value.charAt(4)<='2'){
                                tDupto.setText(d1+"/");
                            }
                            else {
                                tDupto.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        }
                        else if(value.charAt(3)=='0'){
                            if(value.charAt(4)<='9'){
                                tDupto.setText(d1+"/");
                            } else {
                                tDupto.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                        }
                        else{
                            tDupto.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                    if(l==9){
                        String d1=tDupto.getText();
                        if(value.charAt(6)=='2'){
                            if(value.charAt(7)!='0'){
                                tDupto.setText("");
                                JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                            }
                            else {
                                tDupto.setText(String.valueOf(d1));
                            }
                        }
                        else if(value.charAt(6)>'2'){
                            tDupto.setText("");
                            JOptionPane.showMessageDialog(null,"ENTER A VALID DATE");
                        }
                    }
                }
                else {
                    tDupto.setEditable(false);
                }
            }
        });

        tDupto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                if(EVT.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    tDupto.setText("");
                }}});
        JButton btngen=new JButton("Generate report id");
        btngen.setBounds(840,445,150,35);
        frame.add(btngen);
        btngen.setBorderPainted(false);
        btngen.setFocusPainted(false);
        btngen.setBackground(new Color(200,240,247));
        trid.setEditable(false);
        btngen.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            int record;
            try{
                Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
                String qu="Select count(reportid)+1 from report";
                PreparedStatement ps= c.prepareStatement(qu);
                ResultSet rs= ps.executeQuery();
                if(rs.next()){
                    record =rs.getInt(1);
                    if(record<10){
                        trid.setText("R0000"+String.valueOf(record));
                    }
                    else if((record<100)&&(record>9)){
                        trid.setText("R000"+String.valueOf(record));
                    }
                    else {
                        trid.setText("R000"+String.valueOf(record));
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Some Error occur");
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }});

        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String t1 = pmal;
                String t2 =dmal;
                String t3 =trid.getText();
                String t4 = tdisease.getText();
                String t5 = tdescp.getText();
                String t6=tDrec.getText();
                String t7 =tDupto.getText();
                String t8= tdescription.getText();
                String t9 = tdoses.getText();
                String t10="";
                String t11=dnam;
                if(t4.isEmpty()||t5.isEmpty()||t6.isEmpty()||t7.isEmpty()||t8.isEmpty()||t9.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"It appears that some information is missing.");
                }
                else {
                    try {
                        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs", "root", "Sumil399");
                        String qu1 = "insert into report values(?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement pst = c1.prepareStatement(qu1);
                        pst.setString(1, t1);
                        pst.setString(2, t2);
                        pst.setString(3, t3);
                        pst.setString(4, t4);
                        pst.setString(5, t5);
                        pst.setString(6, t6);
                        pst.setString(7, t7);
                        pst.setString(8, t8);
                        pst.setString(9, t9);
                        pst.setString(10, t10);
                        pst.setString(11, t11);
                        pst.executeUpdate();
                    /*String dnmed="";
                    try {
                        Connection c11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs", "root", "Sumil399");
                        String qu11 = "Select * from doctor where doctorID in(select doctorID from report where reportid=?)";
                        PreparedStatement pst1 = c11.prepareStatement(qu11);
                        pst1.setString(1,t3);
                        ResultSet rs1=pst1.executeQuery();
                        while(rs1.next()){

                            dnmed= rs1.getString("fnamed");

                        }
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }*/
                        row[0] = trid.getText();
                        row[1] = tdisease.getText();
                        row[2] = dnam;
                        row[3] = dmal;
                        row[4] = tDrec.getText();
                        row[5] = tDupto.getText();
                        row[6] = tdescription.getText();
                        row[7] = tdescp.getText();
                        row[8] = tdoses.getText();


                        // add row to the model
                        model.addRow(row);
                        JOptionPane.showMessageDialog(null, "Data Added Successfully");


                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                trid.setText("");
                tdisease.setText("");
                tdescp.setText("");
                tDrec.setText("");
                tDupto.setText("");
                tdescription.setText("");
                tdoses.setText("");
            }
        });
        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){

                // i = the index of the selected row
                int i = table.getSelectedRow();
                String repID=model.getValueAt(i,0).toString();
                String rdisease=model.getValueAt(i,1).toString();
                String rdocn=model.getValueAt(i,2).toString();
                String rdocID=model.getValueAt(i,3).toString();
                String rdrec=model.getValueAt(i,4).toString();
                String rdupto=model.getValueAt(i,5).toString();
                String rcomment=model.getValueAt(i,6).toString();
                String rpres=model.getValueAt(i,7).toString();
                String rdose=model.getValueAt(i,8).toString();

                JOptionPane.showMessageDialog(null,model.getValueAt(i,0));
                Prescription pres=new Prescription(pnme,pmal,repID,rdocn,rdocID,rdisease,rdrec,rdupto,rcomment,rpres,rdose);
/*
                textId.setText(model.getValueAt(i, 0).toString());
                textFname.setText(model.getValueAt(i, 1).toString());
                textLname.setText(model.getValueAt(i, 2).toString());
                textAge.setText(model.getValueAt(i, 3).toString());*/
            }
        });

        try{
            Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/uhs","root","Sumil399");
            PreparedStatement pss= c1.prepareStatement("Select * from report where patientid=? order by reportid asc");
            pss.setString(1,pmal);
            ResultSet rss= pss.executeQuery();
            Object[] row1 = new Object[9];
            while(rss.next()){


                row[0]=rss.getString("reportid");
                row[1]=rss.getString("disease");
                row[2]=rss.getString("Dnamer");
                row[3]=rss.getString("doctorID");
                row[4]=rss.getString("date_rcd");
                row[5]=rss.getString("date_upto");
                row[6]=rss.getString("desc_report");
                row[7]=rss.getString("medication");
                row[8]=rss.getString("Dose");
                model.addRow(row);
            }

        }catch (Exception ee){
            JOptionPane.showMessageDialog(null,"ERROR OCCURED");
        };


        frame.getContentPane().setBackground(Color.white);
        frame.setLocation(370,150);
        frame.setSize(1040,600);
        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        new AddReport("sujal","sujal@gmail.com","user","user@gmail.com");

    }
}

/*
f.setSize(690, 600);
        f.setLocation(370,150);
        //f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        }
public static void main(String[] args){
        new AddReport("Username","user@gmail.com");
        }
*/