
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */

    private String username = "Username";

    public HomePage(String username) {
        this.username = username;
        initComponents();
        try {
            connectToDatabase();
        } catch (Exception e) {
            System.out.println(e);
        }
        updateDateandTime();
        usernameText.setText(username);
    }

    public HomePage() {
        initComponents();
        try {
            connectToDatabase();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.print(username);
        usernameText.setText(username);
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

            String queryBalance = "SELECT Balance FROM accountdetails WHERE Name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryBalance);

            preparedStatement.setString(1, this.username);
            ResultSet balanceResult = preparedStatement.executeQuery();
            if (connection != null) {
                System.out.println("Connected to the database");
            }
            if (balanceResult.next()) {
                double balance = balanceResult.getDouble("Balance");
                NumberFormat numFormat = NumberFormat.getInstance();
                String formattedBalance = numFormat.format(balance);
                String formattedBalanceString = "PHP " + formattedBalance + ".00";

                balanceText.setText(formattedBalanceString);
            }
        } catch (Exception e) {
            System.out.println(e);
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        usernameText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        balanceText = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        depositButton = new javax.swing.JButton();
        withdrawButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        transactionHistoryButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(249, 115, 0));

        jPanel3.setBackground(new java.awt.Color(50, 1, 47));

        usernameText.setFont(new java.awt.Font("Inter Light", 0, 36)); // NOI18N
        usernameText.setForeground(new java.awt.Color(255, 255, 255));
        usernameText.setText("Username");

        jLabel1.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Balance");

        jLabel2.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome Back!");

        balanceText.setFont(new java.awt.Font("Inter Light", 0, 36)); // NOI18N
        balanceText.setForeground(new java.awt.Color(255, 255, 255));
        balanceText.setText("PHP 0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(balanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameText)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameText)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        date.setBackground(new java.awt.Color(50, 1, 47));
        date.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        date.setForeground(new java.awt.Color(50, 1, 47));
        date.setText("April 18, 2005");

        time.setBackground(new java.awt.Color(50, 1, 47));
        time.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        time.setForeground(new java.awt.Color(50, 1, 47));
        time.setText("12:00AM");

        depositButton.setBackground(new java.awt.Color(255, 255, 255));
        depositButton.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        depositButton.setForeground(new java.awt.Color(50, 1, 47));
        depositButton.setText("Deposit");
        depositButton.setBorderPainted(false);
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        withdrawButton.setBackground(new java.awt.Color(255, 255, 255));
        withdrawButton.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        withdrawButton.setForeground(new java.awt.Color(50, 1, 47));
        withdrawButton.setText("Withdraw");
        withdrawButton.setBorderPainted(false);
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(50, 1, 47));
        logoutButton.setText("Logout");
        logoutButton.setBorderPainted(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        transactionHistoryButton.setBackground(new java.awt.Color(255, 255, 255));
        transactionHistoryButton.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        transactionHistoryButton.setForeground(new java.awt.Color(50, 1, 47));
        transactionHistoryButton.setText("Transaction History");
        transactionHistoryButton.setBorderPainted(false);
        transactionHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionHistoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(time, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(19, 19, 19))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transactionHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time)
                .addGap(37, 37, 37)
                .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(transactionHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void transactionHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_transactionHistoryButtonActionPerformed
        TransactionHistory transactionHistory = new TransactionHistory(username);
        transactionHistory.setVisible(true);
        transactionHistory.pack();
        this.dispose();
    }// GEN-LAST:event_transactionHistoryButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutButtonActionPerformed
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        loginPage.pack();
        this.dispose();
    }// GEN-LAST:event_logoutButtonActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_depositButton1ActionPerformed
        WithdrawPage withdrawPage = new WithdrawPage(username);
        withdrawPage.setVisible(true);
        withdrawPage.pack();
        this.dispose();
    }// GEN-LAST:event_depositButton1ActionPerformed

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_depositButtonActionPerformed
        DepositPage depositPage = new DepositPage(username);
        depositPage.setVisible(true);
        depositPage.pack();
        this.dispose();
    }// GEN-LAST:event_depositButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceText;
    private javax.swing.JLabel date;
    private javax.swing.JButton depositButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel time;
    private javax.swing.JButton transactionHistoryButton;
    private javax.swing.JLabel usernameText;
    private javax.swing.JButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}
