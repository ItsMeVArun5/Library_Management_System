import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BookDetails extends javax.swing.JFrame {

    private final String url = "jdbc:postgresql://localhost/library_management_system";
    private final String user = "varun";
    private final String password = "password";

    Connection con;
    Statement stmt;
    ResultSet rs;
    String query;
    String BId,Bname,Bauthor,strm,cls,avl;
    
    
    public BookDetails() {
        initComponents();
    }

    private void initComponents() {

        b1 = new javax.swing.ButtonGroup();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        c1 = new javax.swing.JComboBox<>();
        c2 = new javax.swing.JComboBox<>();
        txt1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b1.add(r1);
        r1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        r1.setText("Search by Book Name");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        b1.add(r2);
        r2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        r2.setText("Search By Class");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        c1.setForeground(new java.awt.Color(204, 0, 0));
        c1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Stream", "Science", "Commerce", "Arts" }));
        c1.setEnabled(false);
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });

        c2.setForeground(new java.awt.Color(204, 0, 0));
        c2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class" }));
        c2.setEnabled(false);
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });

        txt1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt1.setForeground(new java.awt.Color(204, 0, 0));
        txt1.setEnabled(false);
        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });
        txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt1KeyReleased(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Author", "Sream", "Class", "Available"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(40);
            table.getColumnModel().getColumn(1).setPreferredWidth(210);
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
            table.getColumnModel().getColumn(3).setPreferredWidth(40);
            table.getColumnModel().getColumn(4).setPreferredWidth(40);
            table.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add a  New Book ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Issue Book");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Return Book");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Issued Book Details");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Book Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r2)
                                    .addComponent(r1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jButton4)
                        .addGap(70, 70, 70)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r1)
                            .addComponent(txt1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(r2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(23, 23, 23))
        );

        pack();
    }//end of init

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {
        c1.disable();
	c2.disable();
        txt1.enable();
    }

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) { }

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {
        txt1.disable();
        c1.enable();
    }

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {
        try
        {
           
        connect();
        query="select * from books where stream='"+c1.getSelectedItem()+"' and class='"+c2.getSelectedItem()+"';";
        rs=stmt.executeQuery(query); 
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        while(rs.next())
        {
            BId=rs.getString("Book_ID");
            Bname=rs.getString("Book_Name");
            Bauthor=rs.getString("Author");
            strm=rs.getString("Stream");
            cls=rs.getString("Class");
            avl=rs.getString("Available");
            Object[] row = {BId,Bname,Bauthor,strm,cls,avl,avl};
            model.addRow(row);
        }
        disconnect();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}

private void c1ActionPerformed(java.awt.event.ActionEvent evt) {
    c2.enable();
    if(c1.getSelectedItem()=="Science")
    {
        c2.removeAllItems();
        c2.addItem("Select Class");
	    c2.addItem("FYBScCS");
	    c2.addItem("SYBScCS");
	    c2.addItem("TYBScCS");
    }
    if(c1.getSelectedItem()=="Arts")
    {
        c2.removeAllItems();
        c2.addItem("Select Class");
        c2.addItem("FYBA");
	    c2.addItem("SYBA");
        c2.addItem("TYBA");
    }
    if(c1.getSelectedItem()=="Commerce")
    {
        c2.removeAllItems();
        c2.addItem("Select Class");
        c2.addItem("FYBCom");
	    c2.addItem("SYBCom");
        c2.addItem("TYBCom");
    }
}

private void txt1KeyReleased(java.awt.event.KeyEvent evt) {
    DefaultTableModel model=(DefaultTableModel)table.getModel();
    model.setRowCount(0);
    String txt=txt1.getText();
    if(txt.equals(""))
    System.out.println("");
    else
    {
        try
        {
            connect();
            query="select * from books where Book_Name LIKE '%"+txt1.getText()+"%';";
            rs=stmt.executeQuery(query); 
            while(rs.next())
            {
                BId=rs.getString("Book_ID");
                Bname=rs.getString("Book_Name");
                Bauthor=rs.getString("Author");
                strm=rs.getString("Stream");
                cls=rs.getString("Class");
                avl=rs.getString("Available");
                Object[] row = {BId,Bname,Bauthor,strm,cls,avl};
                model.addRow(row);
            }
            disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }   
}

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    AddNewBook anb=new AddNewBook();
    anb.setVisible(true);
    this.setVisible(false);
}

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    MainLayer mn=new MainLayer();
    mn.setVisible(true);
    this.dispose();
}

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    IssueBook ib=new IssueBook();
    ib.setVisible(true);
    this.setVisible(false);
}

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    ReturnBook rb=new ReturnBook();
    rb.setVisible(true);
    this.setVisible(false);
}

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    IssuedBooks ibs=new IssuedBooks();
    ibs.setVisible(true);
    this.setVisible(false);
}


public static void main(String args[]) {
    
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new BookDetails().setVisible(true);
        }
    });
}
public void connect()
{
    try
    {  
        con = DriverManager.getConnection(url, user, password);
        stmt=con.createStatement(); 
    }
    catch(Exception e)
    { 
        System.out.println(e);
        JOptionPane.showMessageDialog(this,"connection error");
    }
}
public void disconnect()
{
    try
    {
        con.close(); 
    }
    catch(Exception e)
    {}
    
}


private javax.swing.ButtonGroup b1;
private javax.swing.JComboBox<String> c1;
private javax.swing.JComboBox<String> c2;
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton3;
private javax.swing.JButton jButton4;
private javax.swing.JButton jButton5;
private javax.swing.JLabel jLabel1;
private javax.swing.JScrollPane jScrollPane2;
private javax.swing.JRadioButton r1;
private javax.swing.JRadioButton r2;
private javax.swing.JTable table;
private javax.swing.JTextField txt1;
}