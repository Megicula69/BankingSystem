import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author PLPASIG
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 413));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(50, 1, 47));
        jPanel2.setPreferredSize(new java.awt.Dimension(697, 400));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 170, 70, 19);

        jLabel4.setFont(new java.awt.Font("Inter Light", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Don't have an account?");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 330, 127, 16);

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        loginButton.setForeground(new java.awt.Color(50, 1, 47));
        loginButton.setText("Login");
        loginButton.setBorderPainted(false);
        loginButton.setMaximumSize(new java.awt.Dimension(100, 25));
        loginButton.setMinimumSize(new java.awt.Dimension(100, 25));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel2.add(loginButton);
        loginButton.setBounds(220, 220, 80, 30);

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
        passwordText.setBounds(120, 170, 180, 24);

        registerButton.setBackground(new java.awt.Color(255, 255, 255));
        registerButton.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        registerButton.setForeground(new java.awt.Color(50, 1, 47));
        registerButton.setText("Register");
        registerButton.setBorderPainted(false);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        jPanel2.add(registerButton);
        registerButton.setBounds(160, 330, 77, 23);

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
        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });
        jPanel2.add(usernameText);
        usernameText.setBounds(120, 120, 180, 26);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(120, 50, 90, 30);

        jLabel2.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 120, 70, 19);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\PLPASIG\\Music\\IMG\\login bg.png")); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 720, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameTextMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextMouseClicked

    private void passwordTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextMouseClicked
        passwordText.setText("");
    }//GEN-LAST:event_passwordTextMouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // Check if the username text field is empty
        if (usernameText.getText().equals("Enter Username") || usernameText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your username");
        }
        // Check if the password field is empty
        else if (passwordText.getText().equals("Password") || passwordText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your password");
        }
        // Connecting to database and checking username and password
        else {
            try {
                String username = usernameText.getText();
                String password = passwordText.getText();
                String queryLogin = "SELECT * FROM accountdetails WHERE Name = '" + username + "' AND Password = '"
                        + password + "'";
                statement.executeQuery(queryLogin);
                // Checking if the username and password is correct
                try {
                    preparedStatement = connection.prepareStatement(queryLogin);
                    ResultSet result = preparedStatement.executeQuery();
                    // If the username and password is incorrect
                    if (!result.next()) {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                    // If the username and password is correct
                    else {
                        HomePage homePage = new HomePage(username);
                        homePage.setVisible(true);
                        homePage.pack();
                        this.dispose();
                    }
                }
                // Catching any exceptions
                catch (Exception e) {
                    System.out.println(e);
                }
            }
            // Catching any exceptions
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                System.out.println(e);
            }
        }
    
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        RegisterPage registerPage = new RegisterPage();
        registerPage.setVisible(true);
        registerPage.pack();
        this.dispose();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        usernameText.setText("");
    }//GEN-LAST:event_usernameTextActionPerformed

   /* private void passwordTextMouseClicked(java.awt.event.MouseEvent evt) {                                          
        passwordText.setText("");
    }                                         

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Check if the username text field is empty
        if (usernameText.getText().equals("Enter Username") || usernameText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your username");
        }
        // Check if the password field is empty
        else if (passwordText.getText().equals("Password") || passwordText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your password");
        }
        // Connecting to database and checking username and password
        else {
            try {
                String username = usernameText.getText();
                String password = passwordText.getText();
                String queryLogin = "SELECT * FROM accountdetails WHERE Name = '" + username + "' AND Password = '"
                        + password + "'";
                statement.executeQuery(queryLogin);
                // Checking if the username and password is correct
                try {
                    preparedStatement = connection.prepareStatement(queryLogin);
                    ResultSet result = preparedStatement.executeQuery();
                    // If the username and password is incorrect
                    if (!result.next()) {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                    // If the username and password is correct
                    else {
                        HomePage homePage = new HomePage(username);
                        homePage.setVisible(true);
                        homePage.pack();
                        this.dispose();
                    }
                }
                // Catching any exceptions
                catch (Exception e) {
                    System.out.println(e);
                }
            }
            // Catching any exceptions
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                System.out.println(e);
            }
        }
    
    }                                           

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        RegisterPage registerPage = new RegisterPage();
        registerPage.setVisible(true);
        registerPage.pack();
        this.dispose();
    }                                              

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {                                             
        usernameText.setText("");
    }     */   
    
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
