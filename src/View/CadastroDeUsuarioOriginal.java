package View;

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
import javax.swing.ListSelectionModel;

import Entity.Aluno;
import Entity.Constantes;
import Entity.Principal;
import Entity.Professor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class CadastroDeUsuarioOriginal extends JFrame {
	public CadastroDeUsuarioOriginal() {

		getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 376);

		JList<Object> listDisciplinas = new JList<Object>(Principal.VetorDisciplinas());
		listDisciplinas.setVisibleRowCount(5);
		listDisciplinas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(listDisciplinas);

		JPanel pnlCadastroUsuario = new JPanel();
		pnlCadastroUsuario.setMaximumSize(new Dimension(400, 400));
		getContentPane().add(pnlCadastroUsuario, BorderLayout.CENTER);

		JLabel lblMatricula = new JLabel();
		lblMatricula.setText("Matrícula:");

		JLabel lblTipoUsuario = new JLabel();
		lblTipoUsuario.setText("Tipo de Usuário:");

		JComboBox<String> cmbTipoUsuario = new JComboBox<String>();
		cmbTipoUsuario.setName("Tipo de Usuário");
		cmbTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"", "Aluno", "Professor"}));

		txtMatricula = new JTextField();

		JButton btnVoltar = new JButton();
		btnVoltar.setText("Voltar");

		JButton btnSalvar = new JButton();
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				
				String resumoDeValidacoes = "";

				// Valida se tem algo selecionado no combo de Tipo de Usuario
				if (cmbTipoUsuario.getSelectedIndex() <= 0) {
					resumoDeValidacoes += String.format("Campo %s Obrigatório!", cmbTipoUsuario.getName()) + "\n";
				}

				// Valida se tem mais de 5 disciplinas selecionadas
				if (listDisciplinas.getSelectedValuesList().size() > 5) {
					// String destinations = "";
					// List<Object> obj =
					// listDisciplinas.getSelectedValuesList();
					//
					// for(int i = 0; i < obj.size(); i++)
					// {
					// destinations += obj.get(i).toString();
					// }

					resumoDeValidacoes += "Não é possível selecionar mais de 5 disciplinas! \n";

				}
				
				if (!resumoDeValidacoes.isEmpty()) {
					JOptionPane.showMessageDialog(null, resumoDeValidacoes);
					
				} else {

					if (cmbTipoUsuario.getSelectedIndex() == Constantes.idTipoUsuarioAluno) {
						Aluno aluno = new Aluno();
						
						// TODO: Terminar dados
						//aluno.setNome(txtNo);
						aluno.setMatricula(Integer.parseInt(txtMatricula.getText()));
						Principal.listaAlunos.add(aluno);
						
					} else if (cmbTipoUsuario.getSelectedIndex() == Constantes.idTipoUsuarioProfessor) {
						Professor professor = new Professor();
						
						// TODO: Terminar dados
						//professor.setNome("");
						professor.setMatricula(Integer.parseInt(txtMatricula.getText()));
						Principal.listaProfessores.add(professor);
						
					}
				}
			}
		});
		btnSalvar.setText("Salvar");

		JLabel lblCadastroUsuario = new JLabel();
		lblCadastroUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadastroUsuario.setText("Cadastro de Usuário");

		JLabel lblVincularDisciplina = new JLabel("Vincular disciplina:");

		GroupLayout gl_pnlCadastroUsuario = new GroupLayout(pnlCadastroUsuario);
		gl_pnlCadastroUsuario.setHorizontalGroup(
			gl_pnlCadastroUsuario.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMatricula)
						.addComponent(lblTipoUsuario)
						.addComponent(lblVincularDisciplina))
					.addGap(18)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(txtMatricula)
						.addComponent(cmbTipoUsuario, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(82, Short.MAX_VALUE))
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addGap(40)
					.addComponent(btnVoltar)
					.addPreferredGap(ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addGap(39))
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addGap(156)
					.addComponent(lblCadastroUsuario, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGap(155))
		);
		gl_pnlCadastroUsuario.setVerticalGroup(
			gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addComponent(lblCadastroUsuario)
					.addGap(30)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoUsuario)
						.addComponent(cmbTipoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatricula)
						.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVincularDisciplina)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(btnSalvar))
					.addContainerGap(20, Short.MAX_VALUE))
		);

		pnlCadastroUsuario.setLayout(gl_pnlCadastroUsuario);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMatricula;
}
