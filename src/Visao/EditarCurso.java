package Visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import Controle.ControleDeCurso;
import Controle.ControlePrincipal;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Unidade;
import Util.KeySelectionRenderer;

import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;

public class EditarCurso extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	
	
	public EditarCurso(Curso curso){
		
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setSize(500, 376);
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBounds(0, 0, 482, 329);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	txtNome = new JTextField();
	txtNome.setBounds(171, 29, 210, 22);
	panel.add(txtNome);
	txtNome.setColumns(10);
	txtNome.setText(curso.getNome());
	
	JLabel lblEditarCurso = new JLabel("Editar Curso");
	lblEditarCurso.setBounds(204, 0, 116, 16);
	panel.add(lblEditarCurso);
	
	JLabel lblNome = new JLabel("Nome:");
	lblNome.setBounds(30, 32, 56, 16);
	panel.add(lblNome);
	
	JComboBox<Unidade> cmbIdUnidade = new JComboBox<Unidade>();
	cmbIdUnidade.setBounds(171, 64, 210, 22);
	panel.add(cmbIdUnidade);
	
	for(Unidade unidade : ControlePrincipal.VectorUnidades())
	{
		cmbIdUnidade.addItem(unidade);
		if(unidade.getIdUnidade() == curso.getUnidade().getIdUnidade())
		{
			cmbIdUnidade.setSelectedItem(unidade);
		}
	}
	
	JLabel lblDisciplina = new JLabel("Vincular Disciplina:");
	lblDisciplina.setBounds(30, 101, 108, 16);
	panel.add(lblDisciplina);
	
	JScrollPane scrollPaneDisciplina = new JScrollPane();
	scrollPaneDisciplina.setBounds(171, 99, 210, 135);
	panel.add(scrollPaneDisciplina);
	
	curso.setListaDisciplinasCurso(new ArrayList<Disciplina>(ControleDeCurso.pegarDisciplinasPeloCurso(curso.getIdCurso())));
	
	JList<Disciplina> listDisciplina = new JList<Disciplina>();
	listDisciplina.setListData(new Vector<Disciplina>(ControlePrincipal.getListaDisciplinas()));
	scrollPaneDisciplina.setViewportView(listDisciplina);
	
	ListModel<Disciplina> model = listDisciplina.getModel();
	
	ArrayList<Disciplina> listaDisciplinaDoCurso = curso.getListaDisciplinasCurso();
	
	int indicesParaSelecionar[] = new int[listaDisciplinaDoCurso.size()]; 
	
	int count = 0;
	
	for(int i=0; i < model.getSize(); i++){

		Disciplina disciplinaDaLista = (Disciplina)model.getElementAt(i);
		
		for(Disciplina disciplina : listaDisciplinaDoCurso)
		
		if(disciplina.getIdDisciplina() == disciplinaDaLista.getIdDisciplina())
		{
			indicesParaSelecionar[count] = i;
			count ++;
		}
	}
	
	listDisciplina.setSelectedIndices(indicesParaSelecionar);
	
	KeySelectionRenderer rendererDisciplina = new KeySelectionRenderer(listDisciplina) {
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
	
	KeySelectionRenderer rendererUnidade = new KeySelectionRenderer(cmbIdUnidade) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getDisplayValue(Object value) {

			Unidade unidade = (Unidade) value;
			return unidade.getNome();

		}
	};

	JButton btnSalvar = new JButton("Salvar");
	btnSalvar.setBounds(377, 252, 93, 25);
	panel.add(btnSalvar);
	
	JButton btnVoltar = new JButton("Voltar");
	btnVoltar.setBounds(23, 252, 93, 25);
	panel.add(btnVoltar);
	
	JLabel lblUnidade = new JLabel("Unidade:");
	lblUnidade.setBounds(30, 67, 51, 16);
	panel.add(lblUnidade);
	
	btnSalvar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO FAZER
			
			ArrayList<Disciplina> listaDisciplinasPerderamSelecao = new ArrayList<>();
				
				for(Disciplina disciplina : listaDisciplinaDoCurso){
					
					int count = 0;
				
					for(Disciplina disciplinaSelecionada : listDisciplina.getSelectedValuesList()){
						
						if(disciplina.getIdDisciplina() == disciplinaSelecionada.getIdDisciplina())
						{
							count ++;
						}
					}
				
				if(count == 0)
				{
					listaDisciplinasPerderamSelecao.add(disciplina);
				}
					
			}
			
			ControleDeCurso controleDeCurso = new ControleDeCurso();
			
			controleDeCurso.atualizarCurso(curso, listaDisciplinasPerderamSelecao, ((Unidade)cmbIdUnidade.getSelectedItem()).getIdUnidade());
			
		}
	});

	}
}
