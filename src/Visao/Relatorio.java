package Visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Relatorio extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Relatorio(){

	getContentPane().setLayout(new FlowLayout());
	setResizable(false);
	this.setSize(500, 450);

	JPanel pnlSistemaMatriUniversitario = new JPanel();
	getContentPane().add(pnlSistemaMatriUniversitario, BorderLayout.CENTER);

	JButton btnDisciplinasLecionadas = new JButton();
	btnDisciplinasLecionadas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DisciplinasPorProfessor disciplinasPorProfessor = new DisciplinasPorProfessor();
			disciplinasPorProfessor.setVisible(true);
		}
	});
	btnDisciplinasLecionadas.setText("Disciplinas j\u00E1 lecionadas (antes e atual) por professor");

	JButton btnMatriculadosDisciplina = new JButton();
	btnMatriculadosDisciplina.setText("Alunos matriculados em uma disciplina");
	btnMatriculadosDisciplina.setName("");

	btnMatriculadosDisciplina.addActionListener(new java.awt.event.ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent evt) {

			MatriculadosDisciplina matriculadosDisciplina = new MatriculadosDisciplina();
			matriculadosDisciplina.setVisible(true);
		}
	});

	JButton btnDisciplinasMatriculadasPorAluno = new JButton();
	btnDisciplinasMatriculadasPorAluno.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DisciplinasPorAluno disciplinasPorAluno = new DisciplinasPorAluno();
			disciplinasPorAluno.setVisible(true);
		}
	});
	btnDisciplinasMatriculadasPorAluno.setText("Disciplinas matriculadas por um aluno");

	JLabel lblRelatoriosDoSistema = new JLabel();
	lblRelatoriosDoSistema.setToolTipText("");
	lblRelatoriosDoSistema.setText("Relat\u00F3rios do Sistema");
	
	
	GroupLayout gl_pnlSistemaMatriUniversitario = new GroupLayout(pnlSistemaMatriUniversitario);
	gl_pnlSistemaMatriUniversitario.setHorizontalGroup(
		gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.TRAILING)
			.addComponent(btnMatriculadosDisciplina, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
			.addComponent(btnDisciplinasMatriculadasPorAluno, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
			.addGroup(gl_pnlSistemaMatriUniversitario.createSequentialGroup()
				.addContainerGap(149, Short.MAX_VALUE)
				.addComponent(lblRelatoriosDoSistema)
				.addGap(140))
			.addComponent(btnDisciplinasLecionadas, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
	);
	gl_pnlSistemaMatriUniversitario.setVerticalGroup(
		gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_pnlSistemaMatriUniversitario.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblRelatoriosDoSistema)
				.addGap(18)
				.addComponent(btnMatriculadosDisciplina)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnDisciplinasMatriculadasPorAluno)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnDisciplinasLecionadas)
				.addContainerGap(259, Short.MAX_VALUE))
	);
	pnlSistemaMatriUniversitario.setLayout(gl_pnlSistemaMatriUniversitario);
}

/**
 * 
 */
	
}
