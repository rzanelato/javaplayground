package file;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.v1.ID3V1_0Tag;
import org.blinkenlights.jid3.v1.ID3V1_1Tag;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;

public class TesteRenomearArquivoLote {

	private static JFrame frame = new JFrame("Teste de Renomear Arquivo em Lote");
	private static JList jListArquivos;
	private static List<File> listArquivos;
	private static JPanel painelArquivos;
	private static JPanel painelDetalhes;
	private static JTextField nomeArquivo;
	private static JCheckBox underline;
	private static JCheckBox maiusculo;
	
	public static void main(String[] args) {
		
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciaPainel();
		frame.setVisible(true);
		
	}

	private static void addPaineis() throws IOException {
		
		String caminho = "D:\\Meus documentos\\_teste";
		
		File file = new File(caminho);
		
		List<File> arquivos = getListaArquivos(file.listFiles());
		
		JTable tabelaArquivos = new JTable();
		
		ArquivoTableModel tableModel = new ArquivoTableModel(arquivos.size(),arquivos);
		
		tabelaArquivos.setModel(tableModel);
		
		tabelaArquivos.getColumnModel().getColumn(0).setPreferredWidth(450);

		tabelaArquivos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaArquivos.setCellSelectionEnabled(true);
		tabelaArquivos.getTableHeader().setReorderingAllowed(true);
		tabelaArquivos.setRowHeight(18);
		
		JScrollPane scroll = new JScrollPane(tabelaArquivos);
		scroll.setPreferredSize(new Dimension(563, 455));
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(790, 590));
		panel.add(scroll);
		
		frame.add(panel,BorderLayout.CENTER);
		
	}
	
	private static List<File> getListaArquivos(File[] listFiles) {
		List<File> lista = new ArrayList<File>();
		for(File f: listFiles){
			if(f.getName().endsWith(".mp3"))
				lista.add(f);
		}
		
		return lista;
	}

	private static void iniciaPainel() {
		String caminho = "D:\\Meus documentos\\_teste";
		
		File file = new File(caminho);
		
		listArquivos = getListaArquivos(file.listFiles());
		
		JButton buscarMP3 = new JButton("Selecionar...");
//		buscarMP3.addActionListener(acaoBuscarMp3());
		
		JPanel painelBtSelecionar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painelBtSelecionar.add(buscarMP3);
		
		painelArquivos = new JPanel();
		painelArquivos.setLayout(new BorderLayout());
		
		JButton limparLista = new JButton("Limpar Lista");
		//limparLista.addActionListener(acaoLimparDados());
		
		JPanel painelBtLimpar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painelBtLimpar.add(limparLista);
		
		JPanel painelSuperior = new JPanel(new BorderLayout());
		painelSuperior.add(painelArquivos, BorderLayout.CENTER);
		painelSuperior.add(painelBtLimpar, BorderLayout.SOUTH);

		painelDetalhes = new JPanel();
		painelDetalhes.setLayout(new BoxLayout(painelDetalhes, BoxLayout.Y_AXIS));
		painelDetalhes.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		painelDetalhes.setPreferredSize(new Dimension(200,200));
		
		JPanel painelCentro = new JPanel();
		painelCentro.setLayout(new BoxLayout(painelCentro,BoxLayout.Y_AXIS));
		painelCentro.add(painelSuperior);
		painelCentro.add(painelDetalhes);
	
		frame.add(painelBtSelecionar, BorderLayout.NORTH);
		frame.add(painelCentro, BorderLayout.CENTER);
		frame.add(Box.createRigidArea(new Dimension(7,10)), BorderLayout.WEST);
		frame.add(Box.createRigidArea(new Dimension(7,10)), BorderLayout.EAST);
		
		iniciarPainelArquivos();
		iniciaPainelDetalhes();
	}

	private static void iniciarPainelArquivos(){
		JLabel lbArquivos = new JLabel("Arquivos MP3:");
		
		jListArquivos = new JList(new RenderJlist(listArquivos));
		jListArquivos.addListSelectionListener(eventoSelecionarItem());
		//jListArquivos.addKeyListener(acaoKeySalvar());
		jListArquivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollserie = new JScrollPane(jListArquivos);
		
		painelArquivos.add(lbArquivos, BorderLayout.NORTH);
		painelArquivos.add(scrollserie, BorderLayout.CENTER);
		painelArquivos.updateUI();
	}
	
	private static void iniciaPainelDetalhes(){
		
		JLabel detalheID3 = new JLabel("Detalhe:");
		detalheID3.setPreferredSize(new Dimension(250, 25));
		
		JPanel painelLabel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		painelLabel.add(detalheID3);

		JLabel lbArtista = new JLabel("Nome do Arquivo:");
		lbArtista.setPreferredSize(new Dimension(100, 30));
		
		nomeArquivo = new JTextField();
		nomeArquivo.setPreferredSize(new Dimension(440, 25));
		//tfArtista.addKeyListener(acaoKeySalvar());

		JPanel painelArtista = new JPanel(new FlowLayout(FlowLayout.LEFT));
		painelArtista.add(lbArtista);
		painelArtista.add(nomeArquivo);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(acaoSalvarNome());
		
		JPanel painelBtSalvar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		painelBtSalvar.add(btSalvar);
		
		painelDetalhes.add(painelLabel);
		painelDetalhes.add(painelArtista);
		painelDetalhes.add(painelBtSalvar);
		painelDetalhes.updateUI();
		
	}
	
	private static ListSelectionListener eventoSelecionarItem(){
		ListSelectionListener action = new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				selecionarItem();
			}
		};
		return action;
	}
	
	private static void selecionarItem() {
		int index = jListArquivos.getSelectedIndex();
		if(index >= 0){
			try {
				nomeArquivo.setText(listArquivos.get(index).getName());
				File arquivo = listArquivos.get(index);
				nomeArquivo.setText(arquivo.getName());
				
			} catch (Exception ex) {
				System.out.println("Erro selecionar item: "+ex.getMessage());
			}
		}
	}
	
	private static ActionListener acaoSalvarNome() {
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				salvarNome();
			}

			private void salvarNome() {
				try {
					int index = jListArquivos.getSelectedIndex();
					File arquivo = listArquivos.get(index);

					ArquivoMP3 mp3 = new ArquivoMP3(arquivo);
					String novoNome = mp3.getArtista()+" - "+mp3.getTitulo()+".mp3";
					File novoDado = new File(arquivo.getParent()+File.separator+novoNome);
					arquivo.renameTo(novoDado);
					listArquivos.remove(index);
					listArquivos.add(index, novoDado);
					jListArquivos.setModel(new RenderJlist(listArquivos));
					jListArquivos.updateUI();
					nomeArquivo.setText(novoNome);
					nomeArquivo.updateUI();
					
				} catch (ID3Exception e) {
					e.printStackTrace();
				}
				
			}
		};
		return action;
	}
	
	
	private static class ArquivoTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private int rows; 
    	private List<File> dados;

    	@SuppressWarnings("unused")
		public ArquivoTableModel(int rows, List<File> lista){
    		this.rows = rows;
    		if(lista.isEmpty() && lista == null){
    			this.dados = new ArrayList<File>();
    		}else{
    			this.dados = lista;
    		}
    	}

        public int getColumnCount() {  
            return 1;
        }
        
        public String getColumnName(int coluna) {    
           switch(coluna){  
             case  0:return  "Nome Arquivo";  
             default:return "";  
           }  
        } 

        public int getRowCount() {
    		return rows;
    	}

        public Class<?> getColumnClass(int col) {
        	switch(col){
    	    	case  0:return String.class;    
    	    	case  1:return String.class;  
    	    	case  2:return String.class;  
    	    	case  3:return String.class;  
    	    	default:return Object.class;  
    		}  
    	}
        
        public Object getValueAt(int row, int col) {
        	File dado = dados.get(row);
        	try {
        		if(col == 0)
    	    		return dado.getName();
        		else
        			return null;
        	} catch (Exception e) {
        		System.out.println("Erro no getValueAt na TableModel");
        	}
        	return null;
    	}
        
        public void setValueAt(Object value, int row, int column) {
        	File dado = dados.get(row);
        	if(value !=  null){
        		if(column == 0){
        			File novoDado = new File(dado.getParent()+File.separator+value.toString());
        			dado.renameTo(novoDado);
        			dados.remove(row);
        			dados.add(row, novoDado);
        		}
        	}else
        		dado = null;
        	
        	fireTableCellUpdated(row,column);
        }
        
        public boolean isCellEditable(int row, int col) {
        	return true;  
        }
    } 
	
	@SuppressWarnings("serial")
	private static class RenderJlist extends AbstractListModel {

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
	
	private static class ArquivoMP3 extends MP3File {

		private static final long serialVersionUID = 3188123108560615493L;
		
		private String nmArquivo;
		private String artista;
		private String titulo;
		private String album;
		
		public ArquivoMP3(File sourceFile) {
			super(sourceFile);
			this.nmArquivo = sourceFile.getName();
		}
		
		public void preparaID3MP3() throws ID3Exception {
			ID3V2_3_0Tag id3V2 = null;
			try {
				id3V2 = (ID3V2_3_0Tag) this.getID3V2Tag();
			} catch (Exception e) {
				id3V2 = new ID3V2_3_0Tag();
				id3V2.setArtist("");
				id3V2.setTitle("");
				id3V2.setAlbum("");
				this.setID3Tag(id3V2);
				this.sync();
			}
			if(id3V2 == null){
				id3V2 = new ID3V2_3_0Tag();
				id3V2.setArtist("");
				id3V2.setTitle("");
				id3V2.setAlbum("");
				this.setID3Tag(id3V2);
				this.sync();
			}
		} 
		public void save() throws Throwable{
			try {
				ID3V2_3_0Tag id3 = (ID3V2_3_0Tag) getID3V2Tag();
				ID3V1_0Tag id3v1_0 = new ID3V1_0Tag();
				ID3V1_1Tag id3v1_1 = new ID3V1_1Tag();			
				
				if(artista != null){
					id3.setArtist(artista);
					id3v1_0.setArtist(artista);
					id3v1_1.setArtist(artista);
				}
				if(titulo != null){
					id3.setTitle(titulo);
					id3v1_0.setTitle(titulo);
					id3v1_1.setTitle(titulo);
				}
				if(album != null){
					id3.setAlbum(album);
					id3v1_0.setAlbum(album);
					id3v1_1.setAlbum(album);
				}
				
				this.setID3Tag(id3v1_0);
				this.setID3Tag(id3v1_1);
				this.setID3Tag(id3);
				this.sync();
			} catch (ID3Exception e) {
				System.out.println("Erro Save ID3");
			}
		}
		
		public String getNmArquivo() {
			return nmArquivo;
		}
		public String getArtista() throws ID3Exception {
			return this.getID3V2Tag().getArtist();
		}
		public void setArtista(String artista) {
			this.artista = artista;
		}
		public String getTitulo() throws ID3Exception {
			return this.getID3V2Tag().getTitle();
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getAlbum() throws ID3Exception {
			return this.getID3V2Tag().getAlbum();
		}
		public void setAlbum(String album) {
			this.album = album;
		}
	}
	
}
