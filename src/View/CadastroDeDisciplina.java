package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Entity.Disciplina;
import Entity.Principal;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CadastroDeDisciplina extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtCargaHoraria;
	private JTextField txtNumDeVagas;
	private JTextField txtSemestre;
	private JTextField txtAno;

	public CadastroDeDisciplina() {
		
		getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 376);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(400, 400));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblCadastroDeDisciplina = new JLabel("Cadastro de Disciplina");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblCodigo = new JLabel("Código:");
		
		JLabel lblCargaHoraria = new JLabel("Carga Horária:");
		
		JLabel lblNumeroDeVagas = new JLabel("Nº de vagas:");
		
		JLabel lblSemestre = new JLabel("Semestre:");
		
		JLabel lblAno = new JLabel("Ano:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setColumns(10);
		
		txtNumDeVagas = new JTextField();
		txtNumDeVagas.setColumns(10);
		
		txtSemestre = new JTextField();
		txtSemestre.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendar = Calendar.getInstance();
				
				if(txtAno.getText().isEmpty() || Integer.parseInt(txtAno.getText()) < calendar.get(Calendar.YEAR)){
					JOptionPane.showMessageDialog(null, String.format("Ano inválido! Ano deve ser maior ou igual a ano %d.", calendar.get(Calendar.YEAR)));
				}else{
					
				Disciplina disciplina = new Disciplina();
				disciplina.setNome(txtNome.getText());
				disciplina.setAno(Integer.parseInt(txtAno.getText()));
				disciplina.setCodigo(Integer.parseInt(txtCodigo.getText()));
				disciplina.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
				disciplina.setNumeroVagas(Integer.parseInt(txtNumDeVagas.getText()));
				disciplina.setSemestre(Integer.parseInt(txtSemestre.getText()));
				Principal.listaDisciplinas.add(disciplina);
					
				}
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumeroDeVagas)
						.addComponent(lblSemestre)
						.addComponent(lblAno)
						.addComponent(lblCargaHoraria)
						.addComponent(lblCodigo)
						.addComponent(lblNome))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCargaHoraria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSemestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumDeVagas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(217, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnVoltar)
					.addPreferredGap(ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
					.addComponent(btnSalvar))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(lblCadastroDeDisciplina)
					.addGap(151))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblCadastroDeDisciplina)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargaHoraria)
						.addComponent(txtCargaHoraria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDeVagas)
						.addComponent(txtNumDeVagas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSemestre)
						.addComponent(txtSemestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAno)
						.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(74)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnVoltar))
					.addGap(52))
		);
		panel.setLayout(gl_panel);
	}
}
