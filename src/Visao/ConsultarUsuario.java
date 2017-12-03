package Visao;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.MouseEvent;

import Controle.ControlePrincipal;
import Controle.ControleUsuario;
import Entidade.Aluno;
import Entidade.Professor;
import Entidade.Usuario;
import Util.TableModelUsuario;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Component;

public class ConsultarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declarando variáveis e componentes
	private JScrollPane scrollPane;

	private JList<Object> listaObjetosEncontrados;

	private ArrayList<Usuario> objetosEncontrados;

	private JLabel lblConsultarUsuario;
	private JLabel lblNome;
	private JLabel lblMatricula;
	private JLabel lblResultado;

	private JTextField txtNome;
	private JTextField textMatricula;

	private JButton btnPesquisar;
	private JButton btnVoltar;
	
	private ControleUsuario controleUsuario;

	// Instanciando variáveis e componentes
	public void IniciarControles() {

//		scrollPane = new JScrollPane((Component) null);

		objetosEncontrados = new ArrayList<>();

		lblConsultarUsuario = new JLabel("Consultar Usuário");
		lblNome = new JLabel("Nome:");
		lblResultado = new JLabel("Resultado:");
		lblMatricula = new JLabel("Matrícula:");

		txtNome = new JTextField();
		textMatricula = new JTextField();
		textMatricula.setText("0");

		btnVoltar = new JButton("Voltar");
		btnPesquisar = new JButton("Pesquisar");

	}

	public ConsultarUsuario() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 376);
		getContentPane().setLayout(null);
		
		controleUsuario = new ControleUsuario();
		
		IniciarControles();

		lblConsultarUsuario.setBounds(179, 13, 145, 16);
		getContentPane().add(lblConsultarUsuario);

		lblNome.setBounds(51, 45, 38, 16);
		getContentPane().add(lblNome);

		txtNome.setBounds(158, 42, 198, 22);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		btnVoltar.setBounds(12, 291, 115, 25);
		getContentPane().add(btnVoltar);

		btnPesquisar.setBounds(355, 291, 115, 25);
		getContentPane().add(btnPesquisar);

		lblMatricula.setBounds(51, 80, 95, 16);
		getContentPane().add(lblMatricula);

		textMatricula.setBounds(158, 77, 198, 22);
		getContentPane().add(textMatricula);
		textMatricula.setColumns(10);

		lblResultado.setBounds(12, 109, 95, 16);
		getContentPane().add(lblResultado);

		JTable table = new JTable();
		scrollPane = new JScrollPane(table);
		
		scrollPane.setBounds(12, 126, 458, 135);
		getContentPane().add(scrollPane);
		
		btnPesquisar.addActionListener(new ActionListener() {
			// Ação do botão pesquisar
			public void actionPerformed(ActionEvent arg0) {

				objetosEncontrados = controleUsuario.pesquisaDeUsuario(textMatricula, txtNome);

//				listaObjetosEncontrados = new JList<Object>(
//						(ControlePrincipal.VetorObjetosEncontrados(objetosEncontrados)));
//				listaObjetosEncontrados.setVisibleRowCount(5);
//				listaObjetosEncontrados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				
				TableModelUsuario model = new TableModelUsuario(objetosEncontrados);
				
				table.setModel(model);
				
			}	
		});
		
		    ListSelectionModel cellSelectionModel = table.getSelectionModel();
		    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		    table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					super.mouseClicked(arg0);
					
					  table.setColumnSelectionAllowed(false);
		              table.setRowSelectionAllowed(true);
		              
		              Usuario usuario =  objetosEncontrados.get(table.convertRowIndexToModel(table.getSelectedRow()));
 		              
 		 			DetalhesUsuario detalhesUsuario = new DetalhesUsuario(usuario);
 		 			detalhesUsuario.setVisible(true);
 		              
				}
		    	
		    	
//		    	@Override
//		    	public void mouseClicked(MouseEvent e) { 
//		        	  
//		    	  
//		    		
//		          }		
		    	
			}); 
		    
    
//		    cellSelectionModel.addListSelectionListener((new ListSelectionListener() {
//				
//				@Override
//				public void valueChanged(ListSelectionEvent e) {
//					
//					int teste = table.getSelectedRow();
//					System.out.println(teste);
//					
//			        String selectedData = null;
//			        
//			        int[] selectedRow = table.getSelectedRows();
//			        int[] selectedColumns = table.getSelectedColumns();
//
//			        for (int i = 0; i < selectedRow.length; i++) {
//			          for (int j = 0; j < selectedColumns.length; j++) {
//			            selectedData += (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
//			          }
//			        }
//			        
//			        System.out.println("Selected: " + selectedData);
//			      }
//
//			    }));		  
	}
}
