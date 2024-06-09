/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PLPASIG
 */
public class TransactionHistory extends javax.swing.JFrame {
        private String username;

        /**
         * Creates new form TransactionHistory
         */
        public TransactionHistory(String username) {
                this.username = username;
                initComponents();
                usernameText.setText(username);
                try {
                        connectToDatabase();
                } catch (Exception e) {
                        System.out.println(e);
                }
                updateDateandTime();
                addTable();
        }

        public TransactionHistory() {
                initComponents();
                try {
                        connectToDatabase();
                } catch (Exception e) {
                        System.out.println(e);
                }
                updateDateandTime();
                addTable();
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

        public void updateDateandTime() {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

                Timer timer = new Timer(1, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                LocalDate currentDate = LocalDate.now();
                                LocalTime currentTime = LocalTime.now();

                                date1.setText(currentDate.format(dateFormatter));
                                time1.setText(currentTime.format(timeFormatter).toUpperCase());
                        }
                });
                timer.start();
        }

        public void addTable() {
                String query = "SELECT * FROM accounttransactionhistory WHERE name = ?";
                try {
                        PreparedStatement statement = connection.prepareStatement(query);
                        statement.setString(1, username);
                        ResultSet resultSet = statement.executeQuery();

                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0); // Clear existing rows

                        int rowCount = 0;
                        while (resultSet.next()) {
                                rowCount++;
                                String dateDb = resultSet.getString("date");
                                String timeDb = resultSet.getString("time");
                                String type = resultSet.getString("type");
                                String amount = resultSet.getString("amount");

                                // Format date and time
                                LocalDateTime dateTime = LocalDateTime.parse(dateDb + " " + timeDb,
                                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
                                String formattedTime = dateTime.format(DateTimeFormatter.ofPattern("hh:mm a"));

                                model.addRow(new Object[] { formattedDate, formattedTime, type, amount });
                        }
                        System.out.println("Total rows retrieved: " + rowCount);
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
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
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel2 = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                amountText = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                time = new javax.swing.JLabel();
                date = new javax.swing.JLabel();
                withdrawButton = new javax.swing.JButton();
                filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                                new java.awt.Dimension(0, 32767));
                jPanel4 = new javax.swing.JPanel();
                jPanel5 = new javax.swing.JPanel();
                usernameText = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                backButton = new javax.swing.JButton();
                time1 = new javax.swing.JLabel();
                date1 = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();

                jPanel2.setBackground(new java.awt.Color(249, 115, 0));

                jPanel3.setBackground(new java.awt.Color(50, 1, 47));

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

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(withdrawButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                129,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(date)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                jPanel3Layout.createSequentialGroup()
                                                                                                                                .addComponent(jLabel4)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(time))
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(amountText,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                273,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addContainerGap(26, Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(36, 36, 36)
                                                                .addComponent(date)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(time)
                                                                                .addComponent(jLabel4))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(amountText,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                68,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel2))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(withdrawButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(23, Short.MAX_VALUE)));

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jPanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 93, Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setResizable(false);

                jPanel4.setBackground(new java.awt.Color(249, 115, 0));
                jPanel4.setForeground(new java.awt.Color(255, 255, 255));

                jPanel5.setBackground(new java.awt.Color(50, 1, 47));

                usernameText.setFont(new java.awt.Font("Inter Light", 0, 36)); // NOI18N
                usernameText.setForeground(new java.awt.Color(255, 255, 255));
                usernameText.setText("Username");

                jLabel3.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("Transaction History");

                backButton.setBackground(new java.awt.Color(255, 255, 255));
                backButton.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
                backButton.setForeground(new java.awt.Color(50, 1, 47));
                backButton.setText("Back");
                backButton.setBorderPainted(false);
                backButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                backButtonActionPerformed(evt);
                        }
                });

                time1.setBackground(new java.awt.Color(50, 1, 47));
                time1.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
                time1.setForeground(new java.awt.Color(255, 255, 255));
                time1.setText("12:00AM");
                time1.setToolTipText("");

                date1.setBackground(new java.awt.Color(50, 1, 47));
                date1.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
                date1.setForeground(new java.awt.Color(255, 255, 255));
                date1.setText("April 18, 2005");
                date1.setToolTipText("");

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(time1,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(date1,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING))
                                                                .addGap(16, 16, 16))
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(15, 15, 15)
                                                                                                .addComponent(jLabel3))
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(47, 47, 47)
                                                                                                .addComponent(usernameText))
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(27, 27, 27)
                                                                                                .addComponent(backButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                212,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(35, Short.MAX_VALUE)));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addComponent(date1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(time1)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(usernameText)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(backButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                53,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(23, 23, 23)));

                jTable1.setBackground(new java.awt.Color(249, 115, 0));
                jTable1.setForeground(new java.awt.Color(255, 255, 255));
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null }
                                },
                                new String[] {
                                                "Date", "Time", "Type", "Amount"
                                }) {
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jTable1.setToolTipText("");
                jScrollPane2.setViewportView(jTable1);

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
                                jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(jPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                jPanel4Layout.setVerticalGroup(jPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(19, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backButtonActionPerformed
                HomePage homePage = new HomePage(username);
                homePage.setVisible(true);
                homePage.pack();
                this.dispose();
        }// GEN-LAST:event_backButtonActionPerformed

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
                        java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new TransactionHistory().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTextField amountText;
        private javax.swing.JButton backButton;
        private javax.swing.JLabel date;
        private javax.swing.JLabel date1;
        private javax.swing.Box.Filler filler1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTable jTable1;
        private javax.swing.JLabel time;
        private javax.swing.JLabel time1;
        private javax.swing.JLabel usernameText;
        private javax.swing.JButton withdrawButton;
        // End of variables declaration//GEN-END:variables
}
