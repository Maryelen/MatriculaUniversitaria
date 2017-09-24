/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

/**
 *
 * @author ariane
 */
public class CadastroDeUsuario extends javax.swing.JPanel {

    // Variables declaration
    private javax.swing.JButton btnVincularDisciplina;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel lblCadastroDeUsuario;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPanel pnlCadastroDeUsuario;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
	
    /**
     * Creates new form CadastroDeUsuario
     */
    public CadastroDeUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlCadastroDeUsuario = new javax.swing.JPanel();
        btnVincularDisciplina = new javax.swing.JButton();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        lblTipoUsuario = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lblCadastroDeUsuario = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(400, 336));

        btnVincularDisciplina.setText("Vincular disciplina");
        btnVincularDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno", "Professor" }));
        cmbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
            
        });

        lblTipoUsuario.setText("Tipo de Usuario:");

        lblMatricula.setText("Matrícula:");

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
        	
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
                System.out.println("teste");
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gl_pnlCadastroDeUsuario = new javax.swing.GroupLayout(pnlCadastroDeUsuario);
        gl_pnlCadastroDeUsuario.setHorizontalGroup(
        	gl_pnlCadastroDeUsuario.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnlCadastroDeUsuario.createSequentialGroup()
        			.addGroup(gl_pnlCadastroDeUsuario.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pnlCadastroDeUsuario.createSequentialGroup()
        					.addGap(51)
        					.addGroup(gl_pnlCadastroDeUsuario.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblMatricula)
        						.addComponent(lblTipoUsuario))
        					.addGap(18)
        					.addGroup(gl_pnlCadastroDeUsuario.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(cmbTipoUsuario, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(txtMatricula, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
        				.addGroup(gl_pnlCadastroDeUsuario.createSequentialGroup()
        					.addGap(35)
        					.addComponent(btnVoltar)
        					.addGap(33)
        					.addComponent(btnVincularDisciplina)
        					.addGap(35)
        					.addComponent(btnSalvar)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pnlCadastroDeUsuario.setVerticalGroup(
        	gl_pnlCadastroDeUsuario.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnlCadastroDeUsuario.createSequentialGroup()
        			.addContainerGap(53, Short.MAX_VALUE)
        			.addGroup(gl_pnlCadastroDeUsuario.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTipoUsuario)
        				.addComponent(cmbTipoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_pnlCadastroDeUsuario.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblMatricula)
        				.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(135)
        			.addGroup(gl_pnlCadastroDeUsuario.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnVincularDisciplina)
        				.addComponent(btnSalvar)
        				.addComponent(btnVoltar))
        			.addContainerGap())
        );
        pnlCadastroDeUsuario.setLayout(gl_pnlCadastroDeUsuario);

        lblCadastroDeUsuario.setText("Cadastro de Usuário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(lblCadastroDeUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCadastroDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblCadastroDeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCadastroDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed
}
