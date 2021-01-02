package file;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v1.ID3V1_0Tag;
import org.blinkenlights.jid3.v1.ID3V1_1Tag;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;


public class TesteMP3 {

	private static MediaFile mp3file;
	
public static void main(String[] args) {
		
		JFrame frame = new JFrame("Frame");
		
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
//		final List<File> arquivos = new ArrayList<File>();
		
		JButton botao = new JButton("Teste");
		botao.setBounds(20, 10, 100, 30);
		
		final JTextField txtartista = new JTextField();
		txtartista.setBounds(20, 50, 200, 25);
		
		final JTextField txttitulo = new JTextField();
		txttitulo.setBounds(20, 90, 200, 25);
		
		botao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//String teste = "";
				JFileChooser jfc = new JFileChooser();
				
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.setAcceptAllFileFilterUsed(true);
				jfc.setMultiSelectionEnabled(true);
				jfc.setAutoscrolls(true);
				jfc.setDialogTitle("Dialog Title");
				jfc.setFileFilter(new FileFilter(){
				
					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						return null;
					}
				
					@Override
					public boolean accept(File f) {
						/*if(f.getPath().endsWith(".mp3"))
							return true;
						else
							return false;*/
						return true;
					}
				});
				
				File arq1 = null;
				if(jfc.showOpenDialog(jfc) == JFileChooser.APPROVE_OPTION){
					
					//teste = jfc.getSelectedFile().getPath();
					//for(File file:jfc.getSelectedFile().listFiles())
					
						if(jfc.getSelectedFile().toString().endsWith(".mp3"))
							arq1 = jfc.getSelectedFile(); 
//						System.out.println(arq1.getAbsolutePath());
//						System.out.println(arq1.getPath());
							//for(File file: jfc.getSelectedFile())
								//arquivos.add(file);
						
				}
				//teste = JOptionPane.showInputDialog(null, "Arquivo", JOptionPane.MESSAGE_PROPERTY);
				
//				System.out.println(teste);
//				File arq1 = new File("D:\\Meus documentos\\Deploy\\NovoNovo.txt");
				
				/*for(File arq: arquivos){
					System.out.println(arq.getName());
					if(arquivos.indexOf(arq) == 0){
						arq1 = arq;
						
					}else if(arquivos.indexOf(arq) == 1)
						arq2 = arq;
				*/	
				/*
					System.out.println(arq1.getParentFile().getPath());
					teste = "Kid Cudi - Day 'N' Nite (Crookers Remix)";
					if(arq1.renameTo(new File(arq1.getParentFile().getPath()+"\\"+teste+".mp3")));
						System.out.println("Foi renomeado");
					
					*/	
				//}
				
				
				try {
					mp3file = new MP3File(arq1);
					System.out.println(arq1.getAbsolutePath());
					System.out.println(arq1.getName());
					System.out.println(arq1.getParent());
					System.out.println(arq1.getPath());
					
					String nomearquivo = arq1.getName();
					nomearquivo = nomearquivo.substring(0, nomearquivo.length() - 4);
					System.out.println(nomearquivo);
					
					/*
					try {
						System.out.println(mp3file.getID3V1Tag().getArtist());
						System.out.println(mp3file.getID3V1Tag().getTitle());
						System.out.println("�lbum: " + mp3file.getID3V2Tag().getAlbum());
						System.out.println("Artista: " + mp3file.getID3V2Tag().getArtist());
						System.out.println("Titulo: " + mp3file.getID3V2Tag().getTitle());
						System.out.println("Fim");
						System.out.println();
						
					}catch (ID3Exception e1) {
						System.out.println("ID3 Exception");
					}catch (NullPointerException e1) {
						System.out.println("Null Exception");
					}
					
					String artista = JOptionPane.showInputDialog(null, "Arquivo");
					String titulo = JOptionPane.showInputDialog(null, "Arquivo");
					*/
					ID3V1_1Tag id3 = (ID3V1_1Tag) mp3file.getID3V1Tag();
					//ID3V1_0Tag id3 = (ID3V1_0Tag) mp3file.getID3V1Tag();
					ID3V2_3_0Tag id3v2 = (ID3V2_3_0Tag) mp3file.getID3V2Tag();
					
					if(id3v2 != null){
						System.out.println("n�o � null");
						txtartista.setText(mp3file.getID3V2Tag().getArtist());
						txttitulo.setText(mp3file.getID3V2Tag().getTitle());
						
					}else{
						System.out.println("� null");
						id3v2 = new ID3V2_3_0Tag();
						
						String artista = JOptionPane.showInputDialog(null, "Arquivo");
						String titulo = JOptionPane.showInputDialog(null, "Arquivo");
						id3v2.setArtist(artista);
						id3v2.setTitle(titulo);
						
						mp3file.setID3Tag(id3v2);
						mp3file.sync();
						
						txtartista.setText(mp3file.getID3V2Tag().getArtist());
						txttitulo.setText(mp3file.getID3V2Tag().getTitle());
					}

					
					
					
					if(id3 != null){
						System.out.println(mp3file.getID3V1Tag().getArtist());
						System.out.println(mp3file.getID3V1Tag().getTitle());
					}
					/*
					id3.setArtist(artista);
					id3.setTitle(titulo);
					
					id3v2.setArtist(artista);
					id3v2.setTitle(titulo);
					
					mp3file.setID3Tag(id3);
					mp3file.setID3Tag(id3v2);
					mp3file.sync();
					*/
					/*
					System.out.println(mp3file.getID3V2Tag().getAlbum());
					System.out.println(mp3file.getID3V2Tag().getArtist());
					System.out.println(mp3file.getID3V2Tag().getTitle());
					System.out.println();
					System.out.println(mp3file.getID3V1Tag().getArtist());
					System.out.println(mp3file.getID3V1Tag().getTitle());
					*/
					
				
					
				} catch (ID3Exception e1) {
					System.out.println("ID3 Exception");
				} catch (ClassCastException ce){
					System.out.println("Deu merda no Cast");
				} 

			}});
		
		JButton botao2 = new JButton("MP3");
		botao2.setBounds(20, 130, 100, 30);
		
		botao2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtartista.getText());
				System.out.println(txttitulo.getText());
				
				try {
					ID3V2_3_0Tag id = new ID3V2_3_0Tag();
					id.setArtist(txtartista.getText());
					id.setTitle(txttitulo.getText());
					mp3file.setID3Tag(id);
					mp3file.sync();
					
					System.out.println(mp3file.getID3V2Tag().getArtist());
					System.out.println(mp3file.getID3V2Tag().getTitle());
				} catch (ID3Exception id){
					System.out.println("merda!");
				}
		

		}});

		frame.add(txtartista);
		frame.add(txttitulo);
		frame.add(botao);
		frame.add(botao2);
		
	}
}