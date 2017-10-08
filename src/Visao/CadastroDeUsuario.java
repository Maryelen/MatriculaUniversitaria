package Visao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.LayoutStyle.ComponentPlacement;

import Controle.ControlePrincipal;
import Controle.ControleUsuario;
import Entidade.Aluno;
import Entidade.Constantes;
import Entidade.Disciplina;
import Entidade.Professor;

import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class CadastroDeUsuario extends JFrame {
	
	ControleUsuario controleUsuario;
	
	private JPanel pnlCadastroUsuario;
	private JScrollPane scrollPane;
	private JList<String> listaDisciplinas;
	
	private JLabel lblMatricula;
	private JLabel lblTipoUsuario;
	private JLabel lblCadastroUsuario;
	private JLabel lblVincularDisciplina;
	private JLabel lblNome;
	
	private JTextField txtMatricula;
	private JTextField txtNomeUsuario;
	
	private JComboBox<String> cmbTipoUsuario; 
	
	private JButton btnSalvar;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void IniciarControles()
	{
		pnlCadastroUsuario = new JPanel();
		scrollPane = new JScrollPane();
		
		lblMatricula = new JLabel();
		lblTipoUsuario = new JLabel();
		lblCadastroUsuario = new JLabel();
		listaDisciplinas = new JList<String>(ControlePrincipal.VetorDisciplinas());
		lblNome = new JLabel("Nome:");
		
		cmbTipoUsuario = new JComboBox<String>();
		
		txtMatricula = new JTextField();
		txtNomeUsuario = new JTextField();
		
		btnSalvar = new JButton();
	}
	
	public CadastroDeUsuario() {
		
		controleUsuario = new ControleUsuario();
		
		IniciarControles();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 376);
		getContentPane().setLayout(null);
				
		pnlCadastroUsuario.setBounds(0, 0, 482, 329);
		pnlCadastroUsuario.setMaximumSize(new Dimension(500, 376));
		getContentPane().add(pnlCadastroUsuario);
		
		lblMatricula.setText("Matrícula:");

		lblTipoUsuario.setText("Tipo de Usuário:");

		
		cmbTipoUsuario.setName("Tipo de Usuário");
		cmbTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"", "Aluno", "Professor"}));

		scrollPane.setViewportView(listaDisciplinas);
		listaDisciplinas.setVisibleRowCount(5);
		listaDisciplinas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controleUsuario.CadastrarUsuario(cmbTipoUsuario, listaDisciplinas, txtMatricula, txtNomeUsuario);
			}
		});
		btnSalvar.setText("Salvar");

		lblCadastroUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadastroUsuario.setText("Cadastro de Usuário");

		lblVincularDisciplina = new JLabel("Vincular disciplina:");
		
		txtNomeUsuario.setColumns(10);

		GroupLayout gl_pnlCadastroUsuario = new GroupLayout(pnlCadastroUsuario);
		gl_pnlCadastroUsuario.setHorizontalGroup(
			gl_pnlCadastroUsuario.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoUsuario)
								.addComponent(lblNome)
								.addComponent(lblMatricula))
							.addGap(18)
							.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMatricula, 247, 247, Short.MAX_VALUE)
								.addComponent(cmbTipoUsuario, 0, 247, Short.MAX_VALUE)
								.addComponent(txtNomeUsuario, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addComponent(lblVincularDisciplina)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
					.addGap(95))
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addGap(156)
					.addComponent(lblCadastroUsuario, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addGap(155))
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addContainerGap(375, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addGap(38))
		);
		gl_pnlCadastroUsuario.setVerticalGroup(
			gl_pnlCadastroUsuario.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCadastroUsuario)
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipoUsuario)
								.addComponent(cmbTipoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNomeUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatricula))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVincularDisciplina)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(btnSalvar)
					.addContainerGap())
		);

		pnlCadastroUsuario.setLayout(gl_pnlCadastroUsuario);
	}
}
