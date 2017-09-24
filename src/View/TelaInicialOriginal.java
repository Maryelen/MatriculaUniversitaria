package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaInicialOriginal extends JFrame
{
	public TelaInicialOriginal() {
		
		getContentPane().setLayout(new FlowLayout());
		setResizable(false);
		this.setSize(500, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlSistemaMatriUniversitario = new JPanel();
		getContentPane().add(pnlSistemaMatriUniversitario, BorderLayout.CENTER);
		
		JButton btnCadastroDisciplina = new JButton();
		btnCadastroDisciplina.setText("Cadastro de Disciplina");
		
		JButton btnRelatorios = new JButton();
		btnRelatorios.setText("Relatórios");
		
		JButton btnConsultar = new JButton();
		btnConsultar.setText("Consultar");
		
		JButton btnCadastroUsuario = new JButton();
		btnCadastroUsuario.setText("Cadastro de Usuários");
		btnCadastroUsuario.setName("");
		
		btnCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
        	
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("teste");
                
                CadastroDeUsuarioOriginal cadastroDeUsuarioOriginal = new CadastroDeUsuarioOriginal();
                cadastroDeUsuarioOriginal.setVisible(true);
                //btnCadastroUsuario = 
                //chamar cadastro de aluno
                //e de professor
                
            }
        });
		
		JButton btnCadastroCurso = new JButton();
		btnCadastroCurso.setText("Cadastro de Curso");
		
		JLabel lblSistemaMatriUniversitario = new JLabel();
		lblSistemaMatriUniversitario.setToolTipText("");
		lblSistemaMatriUniversitario.setText("Sistema de Matr\u00EDcula Universitário");
		GroupLayout gl_pnlSistemaMatriUniversitario = new GroupLayout(pnlSistemaMatriUniversitario);
		gl_pnlSistemaMatriUniversitario.setHorizontalGroup(
			gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlSistemaMatriUniversitario.createSequentialGroup()
					.addGap(115)
					.addGroup(gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastroDisciplina, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(btnRelatorios, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(btnConsultar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(btnCadastroUsuario, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(btnCadastroCurso, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
					.addGap(109))
				.addGroup(Alignment.TRAILING, gl_pnlSistemaMatriUniversitario.createSequentialGroup()
					.addContainerGap(132, Short.MAX_VALUE)
					.addComponent(lblSistemaMatriUniversitario)
					.addGap(129))
		);
		gl_pnlSistemaMatriUniversitario.setVerticalGroup(
			gl_pnlSistemaMatriUniversitario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSistemaMatriUniversitario.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSistemaMatriUniversitario)
					.addGap(18)
					.addComponent(btnCadastroUsuario)
					.addGap(18)
					.addComponent(btnCadastroCurso)
					.addGap(18)
					.addComponent(btnCadastroDisciplina)
					.addGap(18)
					.addComponent(btnConsultar)
					.addGap(18)
					.addComponent(btnRelatorios)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		pnlSistemaMatriUniversitario.setLayout(gl_pnlSistemaMatriUniversitario);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
