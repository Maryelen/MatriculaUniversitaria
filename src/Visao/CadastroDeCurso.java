package Visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controle.ControleDeCurso;
import Controle.ControlePrincipal;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroDeCurso extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNome;
	private JTextField txtUnidade;
	
	public CadastroDeCurso() {
		
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(400, 400));
		getContentPane().add(panel, BorderLayout.NORTH);
		this.setSize(500, 376);
		
		JLabel lblUnidade = new JLabel("Unidade:");
		
		JLabel lblNome = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtUnidade = new JTextField();
		txtUnidade.setColumns(10);
		
		JLabel lblCadastroDeCurso = new JLabel("Cadastro de Curso");
		
		JLabel lblVincularDisciplina = new JLabel("Vincular Disciplina:");
		JScrollPane scrollPane = new JScrollPane();
		
		JList<Object> listDisciplinasCurso = new JList<Object>(ControlePrincipal.VetorDisciplinas());
		scrollPane.setViewportView(listDisciplinasCurso);
		
		listDisciplinasCurso.setVisibleRowCount(5);
		listDisciplinasCurso.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	
		
		JButton button = new JButton("Voltar");
		
		JButton button_1 = new JButton("Salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleDeCurso controleDeCurso = new ControleDeCurso();			
				controleDeCurso.CadastrarCurso(listDisciplinasCurso, txtNome, txtUnidade);
			}
		});
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblUnidade)
								.addComponent(lblVincularDisciplina)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblCadastroDeCurso))
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
							.addGap(302))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)
							.addGap(168))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblCadastroDeCurso)
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblUnidade)
							.addGap(18)
							.addComponent(lblVincularDisciplina))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGap(67))
		);
		
		panel.setLayout(gl_panel);
		
	}
}
