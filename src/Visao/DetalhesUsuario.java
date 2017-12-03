package Visao;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controle.ControleDeCurso;
import Controle.ControleUsuario;
import Dao.DAOException;
import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Usuario;
import Util.KeySelectionRenderer;

public class DetalhesUsuario extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DetalhesUsuario(Usuario usuario) {
		
		this.setSize(500, 485);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 5, 482, 433);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDetalhesDoUsuario = new JLabel("Detalhes do Usuário");
		lblDetalhesDoUsuario.setBounds(187, 12, 114, 16);
		panel.add(lblDetalhesDoUsuario);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(77, 46, 57, 16);
		panel.add(lblMatricula);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(77, 77, 38, 16);
		panel.add(lblNome);
		
		JScrollPane scrollPaneCursosMatriculados = new JScrollPane();
		scrollPaneCursosMatriculados.setBounds(33, 123, 192, 134);
		panel.add(scrollPaneCursosMatriculados);
		
		JList<Curso> listCursosMatriculados = new JList<Curso>();
		
		JScrollPane scrollPaneDisciplinas = new JScrollPane();
		scrollPaneDisciplinas.setBounds(258, 123, 192, 134);
		panel.add(scrollPaneDisciplinas);
		
		JList<Object> listDisciplinas = new JList<Object>();
		scrollPaneDisciplinas.setViewportView(listDisciplinas);
		listDisciplinas.setEnabled(false);
		
		JLabel lblCursosMatriculados = new JLabel("Cursos Matriculados:");
		lblCursosMatriculados.setBounds(33, 106, 152, 16);
		panel.add(lblCursosMatriculados);
		
		JLabel lblDisciplinas = new JLabel("Disciplinas:");
		lblDisciplinas.setBounds(258, 106, 152, 16);
		panel.add(lblDisciplinas);
		
		JLabel lblMatriculaUsuariolblMatriculaUsuario = new JLabel(String.valueOf(usuario.getMatricula()));
		lblMatriculaUsuariolblMatriculaUsuario.setBounds(156, 46, 254, 16);
		panel.add(lblMatriculaUsuariolblMatriculaUsuario);
		
		JLabel lblNomeUsuario = new JLabel(usuario.getNome());
		lblNomeUsuario.setBounds(156, 77, 294, 16);
		panel.add(lblNomeUsuario);
		
		ControleUsuario controleUsuario = new ControleUsuario();
		try {
			usuario.setListaCursos(controleUsuario.pegaCursosDoUsuarioPeloIdUsuario(usuario.getIdUsuario()));
			
			listCursosMatriculados.setListData(new Vector<Curso>(usuario.getListaCursos()));
			listCursosMatriculados.setVisibleRowCount(5);
			listCursosMatriculados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			
			listCursosMatriculados.setCellRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                if (renderer instanceof JLabel && value instanceof Curso) {
	                    
	                    ((JLabel) renderer).setText(((Curso) value).getNome());
	                }
	                return renderer;
	            }
	        });
			
			scrollPaneCursosMatriculados.setViewportView(listCursosMatriculados);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listCursosMatriculados.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				try {
					usuario.setListaDisciplinas(
							controleUsuario.pegaDisciplinasDoCursoSelecionadoPeloIdCurso(listCursosMatriculados.getSelectedValue().getIdCurso()));
					
					listDisciplinas.setListData(new Vector<Disciplina>(usuario.getListaDisciplinas()));
					listDisciplinas.setVisibleRowCount(5);
					listDisciplinas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
					
					listDisciplinas.setCellRenderer(new DefaultListCellRenderer() {
			            @Override
			            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			                if (renderer instanceof JLabel && value instanceof Disciplina) {
			                    
			                    ((JLabel) renderer).setText(((Disciplina) value).getNome());
			                }
			                return renderer;
			            }
			        });
					
					scrollPaneDisciplinas.setViewportView(listDisciplinas);
					
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
	}
}
