package Visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {
	public TelaInicial() {

		getContentPane().setLayout(new FlowLayout());
		setResizable(false);
		this.setSize(500, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlSistemaMatriUniversitario = new JPanel();
		getContentPane().add(pnlSistemaMatriUniversitario, BorderLayout.CENTER);

		JButton btnCadastroDisciplina = new JButton();
		btnCadastroDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroDeDisciplina cadastroDeDisciplina = new CadastroDeDisciplina();
				cadastroDeDisciplina.setVisible(true);
			}
		});
		btnCadastroDisciplina.setText("Cadastro de Disciplina");

		JButton btnRelatorios = new JButton();
		btnRelatorios.setText("Relatórios");

		JButton btnConsultarUsuario = new JButton();
		btnConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarUsuario consultar = new ConsultarUsuario();
				consultar.setVisible(true);
			}
		});
		btnConsultarUsuario.setText("Consultar Usu\u00E1rio");

		JButton btnCadastroUsuario = new JButton();
		btnCadastroUsuario.setText("Cadastro de Usuários");
		btnCadastroUsuario.setName("");

		btnCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {

				CadastroDeUsuario cadastroDeUsuario = new CadastroDeUsuario();
				cadastroDeUsuario.setVisible(true);
			}
		});

		JButton btnCadastroCurso = new JButton();
		btnCadastroCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroDeCurso cadastroDeCurso = new CadastroDeCurso();
				cadastroDeCurso.setVisible(true);
			}
		});
		btnCadastroCurso.setText("Cadastro de Curso");

		JLabel lblSistemaMatriUniversitario = new JLabel();
		lblSistemaMatriUniversitario.setToolTipText("");
		lblSistemaMatriUniversitario.setText("Sistema de Matr\u00EDcula Universitário");
		GroupLayout gl_pnlSistemaMatriUniversitario = new GroupLayout(pnlSistemaMatriUniversitario);
		gl_pnlSistemaMatriUniversitario.setHorizontalGroup(gl_pnlSistemaMatriUniversitario
				.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlSistemaMatriUniversitario.createSequentialGroup().addGap(115)
						.addGroup(gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCadastroDisciplina, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
								.addComponent(btnRelatorios, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
								.addComponent(btnConsultarUsuario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 257,
										Short.MAX_VALUE)
								.addComponent(btnCadastroUsuario, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
								.addComponent(btnCadastroCurso, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
						.addGap(109))
				.addGroup(Alignment.TRAILING, gl_pnlSistemaMatriUniversitario.createSequentialGroup()
						.addContainerGap(132, Short.MAX_VALUE).addComponent(lblSistemaMatriUniversitario).addGap(129)));
		gl_pnlSistemaMatriUniversitario
				.setVerticalGroup(gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlSistemaMatriUniversitario.createSequentialGroup().addContainerGap()
								.addComponent(lblSistemaMatriUniversitario).addGap(18).addComponent(btnCadastroUsuario)
								.addGap(18).addComponent(btnCadastroCurso).addGap(18)
								.addComponent(btnCadastroDisciplina).addGap(18).addComponent(btnConsultarUsuario)
								.addGap(18).addComponent(btnRelatorios).addContainerGap(44, Short.MAX_VALUE)));
		pnlSistemaMatriUniversitario.setLayout(gl_pnlSistemaMatriUniversitario);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
