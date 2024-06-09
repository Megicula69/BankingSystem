import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class RegisterPage extends javax.swing.JFrame {
        public RegisterPage() {
                initComponents();
                try {
                        connectToDatabase();
                } catch (Exception e) {
                        System.out.println(e);
                }
        }

        Connection connection;
        Statement statement;

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

        public void Transaction(String name, String transactionType) {
                try {
                        String queryInsert = "INSERT INTO accounttransactionhistory (name, date, time, type) VALUES (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);

                        preparedStatement.setString(1, name);
                        preparedStatement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
                        preparedStatement.setTime(3, java.sql.Time.valueOf(LocalTime.now()));
                        preparedStatement.setString(4, transactionType);

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                                System.out.println("A new transaction was inserted successfully!");
                        }
                } catch (Exception e) {
                        System.out.println(e);
                }
        }

        @SuppressWarnings("unchecked")
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BankingSystem");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(50, 1, 47));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(50, 1, 47));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRATION");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(460, 70, 210, 30);

        jLabel2.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(420, 140, 70, 19);

        jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(420, 190, 70, 19);

        usernameText.setBackground(new java.awt.Color(226, 223, 208));
        usernameText.setFont(new java.awt.Font("Inter Light", 0, 12)); // NOI18N
        usernameText.setForeground(new java.awt.Color(50, 1, 47));
        usernameText.setText("Enter Username");
        usernameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 223, 208), 5));
        usernameText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameTextMouseClicked(evt);
            }
        });
        jPanel2.add(usernameText);
        usernameText.setBounds(510, 140, 180, 26);

        passwordText.setBackground(new java.awt.Color(226, 223, 208));
        passwordText.setForeground(new java.awt.Color(50, 1, 47));
        passwordText.setText("Password");
        passwordText.setToolTipText("");
        passwordText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 223, 208), 5));
        passwordText.setPreferredSize(new java.awt.Dimension(64, 24));
        passwordText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordTextMouseClicked(evt);
            }
        });
        jPanel2.add(passwordText);
        passwordText.setBounds(510, 190, 180, 24);

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        submitButton.setForeground(new java.awt.Color(50, 1, 47));
        submitButton.setText("Submit");
        submitButton.setMaximumSize(new java.awt.Dimension(100, 25));
        submitButton.setMinimumSize(new java.awt.Dimension(100, 25));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(submitButton);
        submitButton.setBounds(610, 240, 80, 30);

        jLabel4.setFont(new java.awt.Font("Inter Light", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Already have an account?");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(450, 370, 139, 16);

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        loginButton.setForeground(new java.awt.Color(50, 1, 47));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel2.add(loginButton);
        loginButton.setBounds(590, 360, 72, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\PLPASIG\\Music\\IMG\\REGIS.png")); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 0, 390, 415);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
                loginPage.pack();
                this.dispose();
        }// GEN-LAST:event_jButton2ActionPerformed

        private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_submitButtonActionPerformed
                String username, password;
                // Check if username text field is empty
                if (usernameText.getText().equals("Enter Username") || usernameText.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Username cannot be empty");
                }
                // Check if password text field is empty
                else if (passwordText.getText().equals("Password") || passwordText.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Password cannot be empty");
                }
                // Check if password is less than 4 characters
                else if (passwordText.getText().length() < 4) {
                        JOptionPane.showMessageDialog(null, "Password must be at least 4 characters long");
                }
                // Connect to database and insert the username and password
                else {
                        username = usernameText.getText();
                        password = passwordText.getText();
                        try {
                                String queryRegister = "INSERT into accountdetails(Name, Password)"
                                                + "VALUES ('" + username + "','" + password + "')";
                                statement.execute(queryRegister);
                                JOptionPane.showMessageDialog(null, "Registration Successful");
                                usernameText.setText("Enter Username");
                                passwordText.setText("Password");
                                Transaction(username, "Registration");
                        }
                        // Catch exception if username already exists
                        catch (java.sql.SQLIntegrityConstraintViolationException e) {
                                JOptionPane.showMessageDialog(null, "Username already exists");
                        }
                        // Catch exception if any other error occurs
                        catch (Exception e) {
                                System.out.println(e);
                        }
                }
        }// GEN-LAST:event_submitButtonActionPerformed

        private void passwordTextMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_passwordTextMouseClicked
                passwordText.setText("");
        }// GEN-LAST:event_passwordTextMouseClicked

        private void usernameTextMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_UsernameTextMouseEntered
                usernameText.setText("");
        }// GEN-LAST:event_UsernameTextMouseEntered

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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new RegisterPage().setVisible(true);
                        }
                });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
