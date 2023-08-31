/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.volleybox.frontend.forms;

import java.time.LocalDate;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.domain.PlayerEngagement;
import rs.volleybox.common_lib.enumeration.Hand;
import rs.volleybox.frontend.communication.Communication;
import rs.volleybox.frontend.models.PlayerEngagementsTableModel;

/**
 *
 * @author
 */
public class PlayerForm extends javax.swing.JDialog {

    private List<Country> countries;
    private Player player = null;

    /**
     * Creates new form PlayerAddForm
     */
    public PlayerForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setComboBoxes();
        btnUpdateInfo.setVisible(false);
        setFieldsEnabled(false);
    }

    public PlayerForm(java.awt.Frame parent, boolean modal, Player player) {
        super(parent, modal);
        initComponents();
        setComboBoxes();
        this.player = player;
        btnAdd.setVisible(false);
        btnUpdateInfo.setVisible(false);
        txtFirstname.setText(player.getFirstname());
        txtLastname.setText(player.getLastname());
        comboYear.setSelectedItem(player.getBirthdate().getYear());
        comboMonth.setSelectedItem(player.getBirthdate().getMonthValue());
        comboDay.setSelectedItem(player.getBirthdate().getDayOfMonth());
        txtHeight.setText(String.valueOf(player.getHeight()));
        txtWeight.setText(String.valueOf(player.getWeight()));
        txtSpike.setText(String.valueOf(player.getSpike()));
        txtBlock.setText(String.valueOf(player.getBlock()));
        comboHand.setSelectedItem(player.getDominantHand());
        comboNationality.setSelectedItem(player.getNationality().getCountryName());
        setFieldsEnabled(true);
        List<PlayerEngagement> engagements = Communication.getInstance().getPlayerEngagements(player);
        tblEngagements.setModel(new PlayerEngagementsTableModel(engagements));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        comboDay = new javax.swing.JComboBox<>();
        comboMonth = new javax.swing.JComboBox<>();
        comboYear = new javax.swing.JComboBox<>();
        txtHeight = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        txtSpike = new javax.swing.JTextField();
        txtBlock = new javax.swing.JTextField();
        comboHand = new javax.swing.JComboBox<>();
        comboNationality = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdateInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEngagements = new javax.swing.JTable();
        btnAddEng = new javax.swing.JButton();
        btnDeleteEng = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Firstname:");

        jLabel2.setText("Lastname:");

        jLabel3.setText("Birthdate:");

        jLabel4.setText("Height:");

        jLabel5.setText("Weight:");

        jLabel6.setText("Spike:");

        jLabel7.setText("Block:");

        jLabel8.setText("Dominant hand:");

        jLabel9.setText("Nationality:");

        comboDay.setToolTipText("");

        btnAdd.setText("Add player");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdateInfo.setText("Update info");
        btnUpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateInfoActionPerformed(evt);
            }
        });

        tblEngagements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Season", "Team"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEngagements);

        btnAddEng.setText("Add engagement");
        btnAddEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEngActionPerformed(evt);
            }
        });

        btnDeleteEng.setText("Delete engagement");
        btnDeleteEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEngActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete player");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFirstname)
                            .addComponent(txtLastname)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboYear, 0, 81, Short.MAX_VALUE))
                            .addComponent(txtBlock, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtSpike)
                            .addComponent(txtWeight)
                            .addComponent(txtHeight)
                            .addComponent(comboHand, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboNationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdateInfo)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(46, 46, 46)
                        .addComponent(btnAdd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddEng)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteEng)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSpike, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(comboNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddEng)
                            .addComponent(btnDeleteEng))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdateInfo)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtFirstname.getText().isEmpty() || txtLastname.getText().isEmpty() || txtHeight.getText().isEmpty() || txtWeight.getText().isEmpty() || txtSpike.getText().isEmpty() || txtBlock.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Not entered all informations");
            return;
        }
        try {
            String firstname = txtFirstname.getText();
            String lastname = txtLastname.getText();
            int year = (int) comboYear.getSelectedItem();
            int month = (int) comboMonth.getSelectedItem();
            int day = (int) comboDay.getSelectedItem();
            LocalDate birthdate = LocalDate.of(year, month, day);
            int height = Integer.parseInt(txtHeight.getText());
            int weight = Integer.parseInt(txtWeight.getText());
            int spike = Integer.parseInt(txtSpike.getText());
            int block = Integer.parseInt(txtBlock.getText());
            Hand dominantHand = (Hand) comboHand.getSelectedItem();
            Country nationality = countries.get(comboNationality.getSelectedIndex());
            Player player = new Player(firstname, lastname, birthdate, height, weight, spike, block, dominantHand, nationality);
            Communication.getInstance().addPlayer(player);
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Height, weight, spike and block are numbers");
            return;
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateInfoActionPerformed
        if (txtFirstname.getText().isEmpty() || txtLastname.getText().isEmpty() || txtHeight.getText().isEmpty() || txtWeight.getText().isEmpty() || txtSpike.getText().isEmpty() || txtBlock.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Not entered all informations");
            return;
        }
        try {
            String firstname = txtFirstname.getText();
            String lastname = txtLastname.getText();
            int year = (int) comboYear.getSelectedItem();
            int month = (int) comboMonth.getSelectedItem();
            int day = (int) comboDay.getSelectedItem();
            LocalDate birthdate = LocalDate.of(year, month, day);
            int height = Integer.parseInt(txtHeight.getText());
            int weight = Integer.parseInt(txtWeight.getText());
            int spike = Integer.parseInt(txtSpike.getText());
            int block = Integer.parseInt(txtBlock.getText());
            Hand dominantHand = (Hand) comboHand.getSelectedItem();
            Country nationality = countries.get(comboNationality.getSelectedIndex());
            Player player = new Player(this.player.getPlayerId(), firstname, lastname, birthdate, height, weight, spike, block, dominantHand, nationality);
            Communication.getInstance().updatePlayer(player);
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Height, weight, spike and block are numbers");
            return;
        }
    }//GEN-LAST:event_btnUpdateInfoActionPerformed

    private void btnDeleteEngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEngActionPerformed
        int row = tblEngagements.getSelectedRow();
        if (row == -1) {
            return;
        }
        PlayerEngagementsTableModel etm = (PlayerEngagementsTableModel) tblEngagements.getModel();
        PlayerEngagement engagement = etm.getEngagement(row);
        etm.removeEngagement(row);
        Communication.getInstance().deletePlayerEngagement(engagement);
    }//GEN-LAST:event_btnDeleteEngActionPerformed

    private void btnAddEngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEngActionPerformed
        new AddPlayerEngagementForm(this, true, player).setVisible(true);
        List<PlayerEngagement> engagements = Communication.getInstance().getPlayerEngagements(player);
        tblEngagements.setModel(new PlayerEngagementsTableModel(engagements));
    }//GEN-LAST:event_btnAddEngActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Communication.getInstance().deletePlayer(player);
        dispose();
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddEng;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteEng;
    private javax.swing.JButton btnUpdateInfo;
    private javax.swing.JComboBox<Integer> comboDay;
    private javax.swing.JComboBox<Hand> comboHand;
    private javax.swing.JComboBox<Integer> comboMonth;
    private javax.swing.JComboBox<String> comboNationality;
    private javax.swing.JComboBox<Integer> comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEngagements;
    private javax.swing.JTextField txtBlock;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtSpike;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables

    private void setComboBoxes() {
        for (int i = 1; i <= 31; i++) {
            comboDay.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            comboMonth.addItem(i);
        }
        for (int i = 1970; i <= 2010; i++) {
            comboYear.addItem(i);
        }
        comboHand.setModel(new DefaultComboBoxModel<>(Hand.values()));
        countries = Communication.getInstance().getAllCountries();
        for (Country country : countries) {
            comboNationality.addItem(country.getCountryName());
        }
    }

    private void setFieldsEnabled(boolean b) {
        jScrollPane1.setVisible(b);
        tblEngagements.setVisible(b);
        btnAddEng.setVisible(b);
        btnDeleteEng.setVisible(b);
        btnUpdateInfo.setVisible(b);
        btnDelete.setVisible(b);
    }
}
