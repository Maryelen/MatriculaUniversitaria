package Visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controle.ControleDeCurso;
import Controle.ControlePrincipal;
import Entidade.Disciplina;
import Entidade.Unidade;
import Util.KeySelectionRenderer;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroDeCurso extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNome;
	private JComboBox<Unidade> cmbUnidade;
	private Unidade unidade;
	
	public CadastroDeCurso() {

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(400, 400));
		getContentPane().add(panel, BorderLayout.NORTH);
		this.setSize(500, 376);
		
		JLabel lblUnidade = new JLabel("Unidade:");
		
		JLabel lblNome = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		cmbUnidade  = new JComboBox<Unidade>();

		JLabel lblCadastroDeCurso = new JLabel("Cadastro de Curso");
		
		/////////	INÍCIO DISCIPLINAS //////////	
		JLabel lblVincularDisciplina = new JLabel("Vincular Disciplina:");
		JScrollPane scrollPaneDisciplinasCurso = new JScrollPane();
		
		JList<Disciplina> listDisciplinasCurso = new JList<Disciplina>(ControlePrincipal.VectorDisciplinas());
		scrollPaneDisciplinasCurso.setViewportView(listDisciplinasCurso);
		
		listDisciplinasCurso.setVisibleRowCount(5);
		listDisciplinasCurso.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		listDisciplinasCurso.setCellRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                if (renderer instanceof JLabel && value instanceof Disciplina) {
	                    
	                    ((JLabel) renderer).setText(((Disciplina) value).getNome());
	                }
	                return renderer;
	            }
	        });
		/////////	FIM DISCIPLINAS //////////	
		
		
		///////// INÍCIO UNIDADES //////////	
		for(Unidade unidade : ControlePrincipal.VectorUnidades())
		{
			cmbUnidade.addItem(unidade);
		}
		
		KeySelectionRenderer renderer = new KeySelectionRenderer(cmbUnidade)
		{
			@Override
			public String getDisplayValue(Object value){
				
			Unidade unidade = (Unidade) value;
			return unidade.getNome();
			
			}
		};
		
		unidade = (Unidade)cmbUnidade.getSelectedItem();
		
		cmbUnidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<Unidade> comboBox = (JComboBox<Unidade>)e.getSource();
				unidade = (Unidade)comboBox.getSelectedItem();
			}
		});
		/////////	FIM UNIDADES //////////	
		
		JButton button = new JButton("Voltar");
		JButton button_1 = new JButton("Salvar");
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleDeCurso controleDeCurso = new ControleDeCurso();			
				controleDeCurso.CadastrarCurso(listDisciplinasCurso, txtNome, unidade);
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
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblCadastroDeCurso))
								.addComponent(scrollPaneDisciplinasCurso, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbUnidade, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(302))
						.addGroup(gl_panel.createSequentialGroup()
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
							.addComponent(lblUnidade))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPaneDisciplinasCurso, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVincularDisciplina))))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		
		panel.setLayout(gl_panel);
		
	}
}
