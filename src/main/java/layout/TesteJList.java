package layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TesteJList extends JFrame{
	
	public static void main(String[] args) {
		new TesteJList();
	}
	
	public TesteJList() {
		super("Teste JList");
		
		setSize(800,600);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		testeJList();
		
		setVisible(true);
	}
	
	private void testeJList(){
		JPanel painel = new JPanel(new BorderLayout());
		
		File[] listaPopulada = getListaPopulada();
		List<File> lista = new ArrayList<File>();
		for(File file : listaPopulada){
			lista.add(file);
		}
		
		JList jList = new JList(new RenderJlist(lista));
		jList.addKeyListener(acao(jList, lista));
		JScrollPane scroll = new JScrollPane(jList);
		scroll.setPreferredSize(new Dimension(300, 200));
		
		painel.add(scroll, BorderLayout.CENTER);
		add(painel);
		
	}
	
	private KeyAdapter acao(final JList jListArquivos, final List<File> listArquivos) {
		KeyAdapter key = new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					verificarArquivo(jListArquivos,listArquivos);
				}else if(e.getKeyCode() == KeyEvent.VK_D){
					removerItens(jListArquivos,listArquivos);
				}else if(e.getKeyCode() == KeyEvent.VK_V){
					retornaItem(jListArquivos,listArquivos);
				}
			}
		};
		return key;
	}
	
	private void verificarArquivo(JList jListArquivos, List<File> listArquivos) {
		int index = jListArquivos.getSelectedIndex();
		
		if(index >= 0){
			System.out.println(listArquivos.get(index).getName());
		}
	}
	
	private void removerItens(final JList jList, final List<File> listFile) {
		int[] indexs = jList.getSelectedIndices();
		
		for(int i = indexs.length-1; i >= 0;i--){
			listFile.remove(indexs[i]);
		}
		jList.setModel(new RenderJlist(listFile));
		jList.updateUI();
	}
	private void retornaItem(final JList jList, final List<File> listFile) {
		int indexs = jList.getSelectedIndex();
		RenderJlist modelo = (RenderJlist)jList.getModel();
		File file = (File)modelo.getValue(indexs);
		System.out.println(file.getAbsolutePath());
		
	}

	private File[] getListaPopulada() {
		File file = new File("D:\\Meus documentos\\_teste");
		return file.listFiles();
	}
	
	@SuppressWarnings("serial")
	private class RenderJlist extends AbstractListModel {

		private List<File> valores = null;  

		public RenderJlist(List<File> valores) {  
			this.valores = valores;  
		}  

		public int getSize() {  
			return valores.size();  
		}  

		public Object getElementAt(int index) {
			File file = valores.get(index);
			return file.getName();  
		}
		
		public Object getValue(int index) {
			return valores.get(index);  
		}
	}

}
