
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
            preparedStatement.setString(2, username); // Assuming you have username field in this class

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        amountText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        withdrawButton = new javax.swing.JButton();
        exitButton1 = new javax.swing.JButton();

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
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(249, 115, 0));

        jPanel3.setBackground(new java.awt.Color(50, 1, 47));

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

        jLabel2.setFont(new java.awt.Font("Inter Medium", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PHP");

        jLabel4.setFont(new java.awt.Font("Inter Medium", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Amount");

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("12:00AM");

        date.setBackground(new java.awt.Color(255, 255, 255));
        date.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("April 18, 2005");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(time))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        exitButton1.setBackground(new java.awt.Color(255, 255, 255));
        exitButton1.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        exitButton1.setForeground(new java.awt.Color(50, 1, 47));
        exitButton1.setText("EXIT");
        exitButton1.setBorderPainted(false);
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitButtonActionPerformed
        HomePage homepage = new HomePage(username);
        homepage.setVisible(true);
        homepage.pack();
        this.dispose();
    }// GEN-LAST:event_exitButtonActionPerformed

    private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitButton1ActionPerformed
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel time;
    private javax.swing.JButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}
