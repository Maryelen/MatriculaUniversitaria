package Visao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
	private JList<Object> listaDisciplinas;
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
	private JComboBox cmbCurso;
	private JLabel lblCurso;

	public void IniciarControles() {
		pnlCadastroUsuario = new JPanel();
		lblMatricula = new JLabel();
		lblTipoUsuario = new JLabel();
		lblCadastroUsuario = new JLabel();
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
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] { "", "Aluno", "Professor" }));
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
		
		cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel<>(controleUsuario.getCursos()) );
		
		lblCurso = new JLabel("Curso:");
		listaDisciplinas = new JList<Object>(ControlePrincipal.VetorDisciplinas());
		listaDisciplinas.setVisibleRowCount(5);
		listaDisciplinas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		GroupLayout gl_pnlCadastroUsuario = new GroupLayout(pnlCadastroUsuario);
		gl_pnlCadastroUsuario.setHorizontalGroup(
			gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addGap(156)
					.addComponent(lblCadastroUsuario, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addGap(155))
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addGap(38))
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoUsuario)
								.addComponent(lblNome)
								.addComponent(lblMatricula)
								.addComponent(lblCurso))
							.addGap(18))
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addComponent(lblVincularDisciplina)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbCurso, 0, 264, Short.MAX_VALUE)
								.addComponent(txtMatricula, 247, 264, Short.MAX_VALUE)
								.addComponent(cmbTipoUsuario, 0, 264, Short.MAX_VALUE)
								.addComponent(txtNomeUsuario, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
							.addGap(95))
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addComponent(listaDisciplinas, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCurso)
						.addComponent(cmbCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addGap(18)
							.addComponent(listaDisciplinas, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(87)
							.addComponent(btnSalvar))
						.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
							.addGap(29)
							.addComponent(lblVincularDisciplina)))
					.addContainerGap())
		);
		pnlCadastroUsuario.setLayout(gl_pnlCadastroUsuario);
	}
}