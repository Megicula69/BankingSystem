
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author PLPASIG
 */
public class WithdrawPage extends javax.swing.JFrame {
    private String username;

    /**
     * Creates new form WithdrawPage
     */
    public WithdrawPage(String username) {
        initComponents();
        this.username = username;
        try {
            connectToDatabase();
        } catch (Exception e) {
            System.out.println(e);
        }
        updateDateandTime();
    }

    public WithdrawPage() {
        initComponents();
        try {
            connectToDatabase();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;

    private static final String DbName = "bankingsystem";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/" + DbName;
    private static final String DbUsername = "root";
    private static final String DbPassword = "";

    public void connectToDatabase() {
        try {
            Class.forName(DbDriver);
            connection = DriverManager.getConnection(DbUrl, DbUsername, DbPassword);
            statement = connection.createStatement();
            if (connection != null) {
                System.out.println("Connected to the database");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkBalance() {
        try {
            int amount = Integer.parseInt(amountText.getText());

            String queryGetBalance = "SELECT balance FROM accountdetails WHERE name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(queryGetBalance);
            preparedStatement.setString(1, username);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                String currentBalance = result.getString("balance");
                int currentBal = Integer.parseInt(currentBalance);
                if (currentBal < amount) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public void updateBalance(double amount) {
        try {
            String queryUpdate = "UPDATE accountdetails SET Balance = Balance - ? WHERE Name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);

            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, username);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Balance updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDateandTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate currentDate = LocalDate.now();
                LocalTime currentTime = LocalTime.now();

                date.setText(currentDate.format(dateFormatter));
                time.setText(currentTime.format(timeFormatter).toUpperCase());
            }
        });
        timer.start();
    }

    public void Transaction(String name, String transactionType) {
        try {
            String queryInsert = "INSERT INTO accounttransactionhistory (name, date, time, type, amount) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);

            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            preparedStatement.setTime(3, java.sql.Time.valueOf(LocalTime.now()));
            preparedStatement.setString(4, transactionType);
            preparedStatement.setString(5, "-" + amountText.getText());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new transaction was inserted successfully!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        exitButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jlabel6 = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();
        withdrawButton = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        exitButton.setForeground(new java.awt.Color(50, 1, 47));
        exitButton.setText("EXIT");
        exitButton.setBorderPainted(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(703, 440));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        exitButton1.setBackground(new java.awt.Color(255, 255, 255));
        exitButton1.setFont(new java.awt.Font("Inter Medium", 1, 12)); // NOI18N
        exitButton1.setForeground(new java.awt.Color(50, 1, 47));
        exitButton1.setText("EXIT");
        exitButton1.setBorderPainted(false);
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(exitButton1);
        exitButton1.setBounds(610, 380, 70, 20);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel5.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Enter Amount:");

        jlabel6.setFont(new java.awt.Font("Inter Medium", 2, 12)); // NOI18N
        jlabel6.setForeground(new java.awt.Color(0, 0, 0));
        jlabel6.setText("(Please Check the amount given to avoid errors)");

        amountText.setBackground(new java.awt.Color(255, 255, 255));
        amountText.setFont(new java.awt.Font("Inter Medium", 0, 48)); // NOI18N
        amountText.setForeground(new java.awt.Color(50, 1, 47));
        amountText.setText("00.00");
        amountText.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        amountText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amountTextMouseClicked(evt);
            }
        });

        withdrawButton.setBackground(new java.awt.Color(51, 204, 0));
        withdrawButton.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        withdrawButton.setForeground(new java.awt.Color(0, 0, 0));
        withdrawButton.setText("Withdraw");
        withdrawButton.setBorderPainted(false);
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });

        date.setBackground(new java.awt.Color(255, 255, 255));
        date.setFont(new java.awt.Font("Inter Medium", 2, 14)); // NOI18N
        date.setForeground(new java.awt.Color(0, 0, 0));
        date.setText("April 18, 2005");

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setFont(new java.awt.Font("Inter Medium", 2, 14)); // NOI18N
        time.setForeground(new java.awt.Color(0, 0, 0));
        time.setText("12:00AM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jlabel6)))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(time)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(time))
                .addGap(58, 58, 58)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(20, 20, 340, 360);

        jButton10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setText("5");
        jPanel2.add(jButton10);
        jButton10.setBounds(410, 160, 70, 50);

        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("2");
        jPanel2.add(jButton5);
        jButton5.setBounds(410, 230, 70, 50);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WITHDRAW");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(420, 30, 240, 40);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("←");
        jPanel2.add(jButton1);
        jButton1.setBounds(590, 90, 70, 50);

        jButton9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 0, 0));
        jButton9.setText("6");
        jPanel2.add(jButton9);
        jButton9.setBounds(500, 160, 70, 50);

        jButton11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 0, 0));
        jButton11.setText("8");
        jPanel2.add(jButton11);
        jButton11.setBounds(410, 90, 70, 50);

        jButton8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setText("7");
        jPanel2.add(jButton8);
        jButton8.setBounds(590, 160, 70, 50);

        jButton12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 0, 0));
        jButton12.setText("9");
        jPanel2.add(jButton12);
        jButton12.setBounds(500, 90, 70, 50);

        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("3");
        jPanel2.add(jButton6);
        jButton6.setBounds(500, 230, 70, 50);

        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setText("4");
        jPanel2.add(jButton7);
        jButton7.setBounds(590, 230, 70, 50);

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("1");
        jPanel2.add(jButton2);
        jButton2.setBounds(590, 300, 70, 50);

        jButton13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 0));
        jButton13.setText("0");
        jPanel2.add(jButton13);
        jButton13.setBounds(500, 300, 70, 50);

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("00");
        jPanel2.add(jButton3);
        jButton3.setBounds(410, 300, 70, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton1ActionPerformed
        HomePage homepage = new HomePage(username);
        homepage.setVisible(true);
        homepage.pack();
        this.dispose();
    }//GEN-LAST:event_exitButton1ActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
      
        if (amountText.getText().equals("00.00") || amountText.getText().equals("")
                || !isInteger(amountText.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount");
        } else if (!checkBalance()) {
            JOptionPane.showMessageDialog(null, "Insufficient balance");
        } else {
            double amount = Double.parseDouble(amountText.getText());
            updateBalance(amount);

            Transaction(username, "Withdraw");

            this.dispose();

            HomePage homePage = new HomePage(username);
            homePage.setVisible(true);
    }//GEN-LAST:event_withdrawButtonActionPerformed
    }
    private void amountTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountTextMouseClicked
        amountText.setText("");
    }//GEN-LAST:event_amountTextMouseClicked

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitButtonActionPerformed
        HomePage homepage = new HomePage(username);
        homepage.setVisible(true);
        homepage.pack();
        this.dispose();
    }// GEN-LAST:event_exitButtonActionPerformed

    /*private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitButton1ActionPerformed
        HomePage homepage = new HomePage(username);
        homepage.setVisible(true);
        homepage.pack();
        this.dispose();
    }// GEN-LAST:event_exitButton1ActionPerformed

    private void amountTextMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_amountTextMouseClicked
        amountText.setText("");
    }// GEN-LAST:event_amountTextMouseClicked

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_depositButtonActionPerformed
        if (amountText.getText().equals("00.00") || amountText.getText().equals("")
                || !isInteger(amountText.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount");
        } else if (!checkBalance()) {
            JOptionPane.showMessageDialog(null, "Insufficient balance");
        } else {
            double amount = Double.parseDouble(amountText.getText());
            updateBalance(amount);

            Transaction(username, "Withdraw");

            this.dispose();

            HomePage homePage = new HomePage(username);
            homePage.setVisible(true);
        }
    }// GEN-LAST:event_depositButtonActionPerformed*/

    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WithdrawPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WithdrawPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WithdrawPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WithdrawPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WithdrawPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountText;
    private javax.swing.JLabel date;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JLabel time;
    private javax.swing.JButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}