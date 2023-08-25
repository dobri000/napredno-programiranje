/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.volleybox.frontend.forms;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.domain.PlayerEngagement;
import rs.volleybox.common_lib.domain.Roster;
import rs.volleybox.common_lib.domain.Season;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.PlayerPosition;
import rs.volleybox.frontend.communication.Communication;

/**
 *
 * @author HOME
 */
public class AddPlayerEngagementForm extends javax.swing.JDialog implements AddEngagement{

    private Player player;
    private Team team;
    private List<Season> seasons;

    public void setPlayer(Player player) {
        this.player = player;
        lblPlayer.setText(player.getFirstname() + " " + player.getLastname());
    }

    public void setTeam(Team team) {
        this.team = team;
        lblTeam.setText(team.getTeamName());
    }
    
    /**
     * Creates new form AddPlayerEngagementForm
     */
    public AddPlayerEngagementForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        seasons = Communication.getInstance().getAllSeasons();
        setComboBoxes();
    }
    
    public AddPlayerEngagementForm(java.awt.Dialog parent, boolean modal, Player player) {
        super(parent, modal);
        initComponents();
        seasons = Communication.getInstance().getAllSeasons();
        setComboBoxes();
        setPlayer(player);
    }
    
    public AddPlayerEngagementForm(java.awt.Dialog parent, boolean modal, Team team) {
        super(parent, modal);
        initComponents();
        seasons = Communication.getInstance().getAllSeasons();
        setComboBoxes();
        setTeam(team);
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
        comboSeason = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboPosition = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblPlayer = new javax.swing.JLabel();
        lblTeam = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Player:");

        jLabel2.setText("Team:");

        jLabel3.setText("Season:");

        jLabel4.setText("Position:");

        jLabel5.setText("Number:");

        jButton1.setText("Choose player");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Choose team");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add player engagement");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboSeason, 0, 135, Short.MAX_VALUE)
                        .addComponent(comboPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNumber))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(lblPlayer))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(lblTeam))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new PlayerSelectionForm(this, true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TeamSelectionForm(this, true).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(team == null || player == null){
            JOptionPane.showMessageDialog(null, "Not entered all informations");
            return;
        }
        try{
            Season season = seasons.get(comboSeason.getSelectedIndex());
            Roster roster = new Roster(team, season);
            PlayerPosition playerPosition = (PlayerPosition) comboPosition.getSelectedItem();
            int number = Integer.parseInt(txtNumber.getText());
            PlayerEngagement playerEngagement = new PlayerEngagement(player, roster, playerPosition, number);
            Communication.getInstance().addPlayerEngagement(playerEngagement);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Number should be number");
            return;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<PlayerPosition> comboPosition;
    private javax.swing.JComboBox<String> comboSeason;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblTeam;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables

    private void setComboBoxes() {
        for(Season season: seasons) {
            comboSeason.addItem(season.toString());
        }
        comboPosition.setModel(new DefaultComboBoxModel<>(PlayerPosition.values()));
    }
}
