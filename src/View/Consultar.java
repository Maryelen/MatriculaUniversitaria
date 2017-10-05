package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import Entity.Aluno;
import Entity.Principal;
import Entity.Professor;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;

public class Consultar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField textMatricula;

	JList<Object> listaObjetosEncontrados;
	
	public Consultar() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 376);
		getContentPane().setLayout(null);
		
		JLabel lblConsultarUsuario = new JLabel("Consultar Usuário");
		lblConsultarUsuario.setBounds(179, 13, 145, 16);
		getContentPane().add(lblConsultarUsuario);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(51, 45, 38, 16);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(158, 42, 198, 22);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(12, 291, 115, 25);
		getContentPane().add(btnVoltar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(355, 291, 115, 25);
		getContentPane().add(btnPesquisar);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(51, 80, 95, 16);
		getContentPane().add(lblMatricula);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(158, 77, 198, 22);
		getContentPane().add(textMatricula);
		textMatricula.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(51, 109, 95, 16);
		getContentPane().add(lblResultado);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(158, 126, 198, 135);
		getContentPane().add(scrollPane);

		//JList<Object> listResultados = new JList<Object>(Principal.VetorResultados());
		//scrollPane.setViewportView(listResultados);
		//listResultados.setVisibleRowCount(5);
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Object> objetosEncontrados = new ArrayList<>();
				
				for(Professor professor : Principal.listaProfessores ){
					if(Integer.parseInt(textMatricula.getText()) == professor.getMatricula()){
						objetosEncontrados.add(professor);
					}
				} 
				
				
				// TODO: CRIAR ESTE FOR PARA ALUNO
				for(Aluno aluno : Principal.listaAlunos){
					if(Integer.parseInt(textMatricula.getText()) == aluno.getMatricula()){
						objetosEncontrados.add(aluno);
					}
				}
				
				listaObjetosEncontrados = new JList<Object>((Principal.VetorObjetosEncontrados(objetosEncontrados)));
				listaObjetosEncontrados.setVisibleRowCount(5);
				listaObjetosEncontrados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				scrollPane.add(listaObjetosEncontrados);
				scrollPane.setViewportView(listaObjetosEncontrados);
			}
		});
	}
}
