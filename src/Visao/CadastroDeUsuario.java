package Visao;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import Controle.ControleDeCurso;
import Controle.ControlePrincipal;
import Controle.ControleUsuario;
import Entidade.Curso;
import Entidade.Disciplina;
import Util.KeySelectionRenderer;

public class CadastroDeUsuario extends JFrame {
	ControleUsuario controleUsuario;
	private JPanel pnlCadastroUsuario;
	private JList<Disciplina> listaDisciplinas;
	private JLabel lblMatricula;
	private JLabel lblTipoUsuario;
	private JLabel lblCadastroUsuario;
	private JLabel lblCurso;
	private JLabel lblVincularDisciplina;
	private JLabel lblNome;
	private JLabel lblMatriculaValue;
	private JTextField txtNomeUsuario;
	private JComboBox<String> cmbTipoUsuario;
	private JComboBox<Curso> cmbCurso;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private Curso curso;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void IniciarControles() {
		pnlCadastroUsuario = new JPanel();
		lblMatricula = new JLabel();
		lblTipoUsuario = new JLabel("Tipo de Usuário:");
		lblCadastroUsuario = new JLabel("Cadastro de Usuário");
		lblNome = new JLabel("Nome:");
		lblVincularDisciplina = new JLabel("Vincular disciplina:");
		lblCurso = new JLabel("Curso:");
		cmbTipoUsuario = new JComboBox<String>();
		cmbCurso = new JComboBox<Curso>();
		lblMatriculaValue = new JLabel();
		txtNomeUsuario = new JTextField();
		btnSalvar = new JButton("Salvar");
		btnVoltar = new JButton("Voltar");
	}

	public CadastroDeUsuario() {
		controleUsuario = new ControleUsuario();
		IniciarControles();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 485);
		getContentPane().setLayout(null);
		pnlCadastroUsuario.setBounds(0, 0, 482, 438);
		pnlCadastroUsuario.setMaximumSize(new Dimension(500, 376));
		getContentPane().add(pnlCadastroUsuario);
		lblMatricula.setText("Matrícula:");
		lblMatriculaValue.setEnabled(false);
		lblMatriculaValue.setText("(Gerado Automaticamente ao Salvar)");
		cmbTipoUsuario.setName("Tipo de Usuário");

		cmbTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cmbTipoUsuario.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Aluno", "Professor" }));

		lblCadastroUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtNomeUsuario.setColumns(10);

		cmbCurso.addItem(null);
		cmbCurso.setSelectedItem(null);

		for (Curso curso : ControlePrincipal.VectorCursos()) {
			cmbCurso.addItem(curso);
		}

		KeySelectionRenderer renderer = new KeySelectionRenderer(cmbCurso) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getDisplayValue(Object value) {

				Curso curso = (Curso) value;
				return curso.getNome();

			}
		};
		
		if (cmbCurso.getSelectedItem() != null) {
			curso = (Curso) cmbCurso.getSelectedItem();

			listaDisciplinas = new JList<Disciplina>(
					ControleDeCurso.pegarDisciplinasPeloCurso(((Curso) cmbCurso.getSelectedItem()).getIdCurso()));
			listaDisciplinas.setVisibleRowCount(5);
			listaDisciplinas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

			listaDisciplinas.setCellRenderer(new DefaultListCellRenderer() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index,
						boolean isSelected, boolean cellHasFocus) {
					Component renderer = super.getListCellRendererComponent(list, value, index, isSelected,
							cellHasFocus);
					if (renderer instanceof JLabel && value instanceof Disciplina) {

						((JLabel) renderer).setText(((Disciplina) value).getNome());
					}
					return renderer;
				}
			});
		} else {
			listaDisciplinas = new JList<Disciplina>();
			listaDisciplinas.setVisibleRowCount(5);
			listaDisciplinas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}

		cmbCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JComboBox<Curso> comboBox = (JComboBox<Curso>)e.getSource();

				if (cmbCurso.getSelectedItem() != null) {
					
					curso = (Curso) cmbCurso.getSelectedItem();

					listaDisciplinas.setListData(ControleDeCurso.pegarDisciplinasPeloCurso(curso.getIdCurso()));
					
					KeySelectionRenderer rendererDisciplinas = new KeySelectionRenderer(listaDisciplinas) {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						@Override
						public String getDisplayValue(Object value) {

							Disciplina disciplina = (Disciplina) value;
							return disciplina.getNome();

						}
					};
				}
			}
		});

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMatriculaValue.setText(
						controleUsuario.CadastrarUsuario(cmbTipoUsuario, listaDisciplinas.getSelectedValuesList(),
								lblMatriculaValue.getText(), txtNomeUsuario.getText(), curso));
			}
		});
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

		GroupLayout gl_pnlCadastroUsuario = new GroupLayout(pnlCadastroUsuario);
		gl_pnlCadastroUsuario.setHorizontalGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup().addGap(156)
						.addComponent(lblCadastroUsuario, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE).addGap(155))
				.addGroup(
						Alignment.TRAILING,
						gl_pnlCadastroUsuario
								.createSequentialGroup().addGap(64)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
								.addComponent(btnSalvar).addGap(38))
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup().addGap(27)
						.addGroup(gl_pnlCadastroUsuario
								.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlCadastroUsuario
										.createSequentialGroup()
										.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
												.addComponent(lblMatricula).addComponent(lblNome)
												.addComponent(lblTipoUsuario).addComponent(lblCurso))
										.addGap(18))
								.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
										.addComponent(lblVincularDisciplina)
										.addPreferredGap(ComponentPlacement.UNRELATED)))
						.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
										.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
												.addComponent(cmbCurso, 0, 247, Short.MAX_VALUE)
												.addComponent(cmbTipoUsuario, 247, 247, Short.MAX_VALUE)
												.addComponent(lblMatriculaValue, 0, 247, Short.MAX_VALUE).addComponent(
														txtNomeUsuario, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
										.addGap(95))
								.addGroup(gl_pnlCadastroUsuario
										.createSequentialGroup().addComponent(listaDisciplinas,
												GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
		gl_pnlCadastroUsuario.setVerticalGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCadastroUsuario.createSequentialGroup()
						.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCadastroUsuario)
								.addGroup(gl_pnlCadastroUsuario.createSequentialGroup().addGap(34)
										.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblMatricula).addComponent(lblMatriculaValue,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtNomeUsuario, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNome))))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbTipoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipoUsuario))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE).addComponent(lblCurso)
								.addComponent(cmbCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCadastroUsuario.createSequentialGroup().addGap(18).addComponent(
										listaDisciplinas, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlCadastroUsuario.createSequentialGroup().addGap(29)
										.addComponent(lblVincularDisciplina)))
						.addGap(87).addGroup(gl_pnlCadastroUsuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSalvar).addComponent(btnVoltar))
						.addContainerGap()));

		pnlCadastroUsuario.setLayout(gl_pnlCadastroUsuario);
	}
}