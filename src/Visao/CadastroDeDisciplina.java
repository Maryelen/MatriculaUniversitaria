package Visao;

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

import Controle.ControleDisciplina;
import Controle.ControlePrincipal;
import Entidade.Disciplina;

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
	
	ControleDisciplina controleDisciplina;
	
	private static final long serialVersionUID = 1L;
	
	private GroupLayout gl_panel;
	
	private JPanel panel;
	
	private JLabel lblCadastroDeDisciplina;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JLabel lblCargaHoraria;
	private JLabel lblNumeroDeVagas;
	private JLabel lblSemestre;
	private JLabel lblAno;
	
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtCargaHoraria;
	private JTextField txtNumDeVagas;
	private JTextField txtSemestre;
	private JTextField txtAno;
	
	private JButton btnSalvar;
	private JButton btnVoltar;
	
	public void iniciarControles(){
		
		panel = new JPanel();
		
		lblCadastroDeDisciplina = new JLabel("Cadastro de Disciplina");
		lblNome = new JLabel("Nome:");
		lblCodigo = new JLabel("Código:");
		lblAno = new JLabel("Ano:");
		lblCargaHoraria = new JLabel("Carga Horária:");
		lblNumeroDeVagas = new JLabel("Nº de vagas:");
		lblSemestre = new JLabel("Semestre:");
		
		txtNome = new JTextField();
		txtCodigo = new JTextField();
		txtCargaHoraria = new JTextField();
		txtNumDeVagas = new JTextField();
		txtSemestre = new JTextField();
		txtAno = new JTextField();
		
		btnSalvar = new JButton("Salvar");
		btnVoltar = new JButton("Voltar");
		
	}

	public CadastroDeDisciplina() {
		
		controleDisciplina = new ControleDisciplina();
		
		iniciarControles();
		
		getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 376);
		
		panel.setMaximumSize(new Dimension(400, 400));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		txtNome.setColumns(10);
		txtCodigo.setColumns(10);
		txtCargaHoraria.setColumns(10);
		txtNumDeVagas.setColumns(10);
		txtSemestre.setColumns(10);
		txtAno.setColumns(10);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleDisciplina.cadastrarDisciplina(txtAno, txtNome, txtCodigo, txtCargaHoraria, txtNumDeVagas, txtSemestre);
			}
		});
		
		gl_panel = new GroupLayout(panel);
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
