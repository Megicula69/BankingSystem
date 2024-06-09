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
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jMenuItem1 = new javax.swing.JMenuItem();
                jSeparator1 = new javax.swing.JSeparator();
                buttonGroup1 = new javax.swing.ButtonGroup();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jPanel2 = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                usernameText = new javax.swing.JTextField();
                passwordText = new javax.swing.JPasswordField();
                submitButton = new javax.swing.JButton();
                jLabel4 = new javax.swing.JLabel();
                loginButton = new javax.swing.JButton();

                jMenuItem1.setText("jMenuItem1");

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null }
                                },
                                new String[] {
                                                "Title 1", "Title 2", "Title 3", "Title 4"
                                }));
                jScrollPane1.setViewportView(jTable1);

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("BankingSystem");
                setAutoRequestFocus(false);
                setBackground(new java.awt.Color(50, 1, 47));
                setResizable(false);

                jPanel2.setBackground(new java.awt.Color(50, 1, 47));

                jPanel3.setBackground(new java.awt.Color(249, 115, 0));

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 350, Short.MAX_VALUE));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 401, Short.MAX_VALUE));

                jLabel1.setFont(new java.awt.Font("Inter Black", 0, 24)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("REGISTRATION");

                jLabel2.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                jLabel2.setText("Username");

                jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("Password");

                usernameText.setBackground(new java.awt.Color(226, 223, 208));
                usernameText.setFont(new java.awt.Font("Inter Light", 0, 12)); // NOI18N
                usernameText.setForeground(new java.awt.Color(50, 1, 47));
                usernameText.setText("Enter Username");
                usernameText.setBorder(
                                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 223, 208), 5));
                usernameText.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                usernameTextMouseClicked(evt);
                        }
                });

                passwordText.setBackground(new java.awt.Color(226, 223, 208));
                passwordText.setForeground(new java.awt.Color(50, 1, 47));
                passwordText.setText("Password");
                passwordText.setToolTipText("");
                passwordText.setBorder(
                                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 223, 208), 5));
                passwordText.setPreferredSize(new java.awt.Dimension(64, 24));
                passwordText.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                passwordTextMouseClicked(evt);
                        }
                });

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

                jLabel4.setFont(new java.awt.Font("Inter Light", 0, 12)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                jLabel4.setText("Already have an account?");

                loginButton.setBackground(new java.awt.Color(255, 255, 255));
                loginButton.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
                loginButton.setForeground(new java.awt.Color(50, 1, 47));
                loginButton.setText("Login");
                loginButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loginButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jPanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(41, 41, 41)
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel4)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(loginButton))
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(submitButton,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                80,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(jLabel2,
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                .addComponent(jLabel3,
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING))
                                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(passwordText,
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                180,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(usernameText,
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                180,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                                                .addContainerGap(43,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel2Layout.createSequentialGroup()
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel1)
                                                                                                                .addGap(80, 80, 80)))));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addGap(68, 68, 68)
                                                                .addComponent(jLabel1)
                                                                .addGap(37, 37, 37)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(usernameText,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(passwordText,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel3))
                                                                .addGap(26, 26, 26)
                                                                .addComponent(submitButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(loginButton))
                                                                .addGap(29, 29, 29)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

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
        private javax.swing.JMenuItem jMenuItem1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JTable jTable1;
        private javax.swing.JButton loginButton;
        private javax.swing.JPasswordField passwordText;
        private javax.swing.JButton submitButton;
        private javax.swing.JTextField usernameText;
        // End of variables declaration//GEN-END:variables
}