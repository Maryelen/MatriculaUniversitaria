package Visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		btnRelatorios.setText("Relat�rios");

		JButton btnConsultarUsuario = new JButton();
		btnConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarUsuario consultar = new ConsultarUsuario();
				consultar.setVisible(true);
			}
		});
		btnConsultarUsuario.setText("Consultar Usu\u00E1rio");

		JButton btnCadastroUsuario = new JButton();
		btnCadastroUsuario.setText("Cadastro de Usu�rios");
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
		lblSistemaMatriUniversitario.setText("Sistema de Matr\u00EDcula Universit�rio");
		
		JButton btnConsultarCurso = new JButton();
		btnConsultarCurso.setText("Consultar Curso");
		btnConsultarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarCurso consultar = new ConsultarCurso();
				consultar.setVisible(true);
			}
		});
		
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatorio relatorio = new Relatorio();
				relatorio.setVisible(true);
			}
		});
		
		
		GroupLayout gl_pnlSistemaMatriUniversitario = new GroupLayout(pnlSistemaMatriUniversitario);
		gl_pnlSistemaMatriUniversitario.setHorizontalGroup(
			gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSistemaMatriUniversitario.createSequentialGroup()
					.addGap(115)
					.addComponent(lblSistemaMatriUniversitario))
				.addComponent(btnCadastroUsuario, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
				.addComponent(btnCadastroCurso, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
				.addComponent(btnCadastroDisciplina, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
				.addComponent(btnConsultarUsuario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
				.addComponent(btnRelatorios, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
				.addComponent(btnConsultarCurso, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
		);
		gl_pnlSistemaMatriUniversitario.setVerticalGroup(
			gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSistemaMatriUniversitario.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSistemaMatriUniversitario)
					.addGap(18)
					.addComponent(btnCadastroUsuario)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastroCurso)
					.addGap(18)
					.addComponent(btnCadastroDisciplina)
					.addGap(18)
					.addComponent(btnConsultarUsuario)
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addComponent(btnConsultarCurso)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRelatorios)
					.addContainerGap())
		);
		pnlSistemaMatriUniversitario.setLayout(gl_pnlSistemaMatriUniversitario);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
