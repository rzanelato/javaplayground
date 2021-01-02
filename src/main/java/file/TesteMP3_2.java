package file;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.blinkenlights.jid3.MP3File;


public class TesteMP3_2 {

	private static MP3File mp3file;
	
	public static void main(String[] args) {
			
			JFrame frame = new JFrame("Frame");
			
			frame.setSize(800,600);
			frame.setVisible(true);
			frame.setLayout(null);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			
			JButton botao = new JButton("Teste");
			botao.setBounds(20, 10, 100, 30);
			
			final JTextField txtartista = new JTextField();
			txtartista.setBounds(20, 50, 200, 25);
			
			final JTextField txttitulo = new JTextField();
			txttitulo.setBounds(20, 90, 200, 25);
			
			final JTextField nmarquivo = new JTextField();
			nmarquivo.setBounds(250, 90, 200, 25);
			
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
							return null;
						}
					
						@Override
						public boolean accept(File f) {
							return true;
						}
					});
					
					File arq1 = null;
					if(jfc.showOpenDialog(jfc) == JFileChooser.APPROVE_OPTION){
						
							if(jfc.getSelectedFile().toString().endsWith(".mp3"))
								arq1 = jfc.getSelectedFile(); 
							
					}/*
						try {
							mp3file = new MP3File(arq1);
						} catch (IOException e2) {
							e2.printStackTrace();
						} catch (TagException e2) {
							e2.printStackTrace();
						}
						
						String nomearquivo = arq1.getName();
						nomearquivo = nomearquivo.substring(0, nomearquivo.length() - 4);
						nmarquivo.setText(nomearquivo);
						System.out.println(nomearquivo);
						
						ID3v2_3 id3v2 =  (ID3v2_3) mp3file.getID3v2Tag();
						
						if(id3v2 != null){
							System.out.println("não é null");
							txtartista.setText(mp3file.getID3v2Tag().getLeadArtist());
							txttitulo.setText(mp3file.getID3v2Tag().getSongTitle());
							
							System.out.println(mp3file.getID3v2Tag().getAuthorComposer());
							System.out.println(mp3file.getID3v2Tag().getIdentifier());
							System.out.println(mp3file.getID3v2Tag().getLeadArtist());
							System.out.println(mp3file.getID3v2Tag().getSongComment());
							System.out.println(mp3file.getID3v2Tag().getSongGenre());
							System.out.println(mp3file.getID3v2Tag().getSongTitle());
							System.out.println(mp3file.getID3v2Tag().getAlbumTitle());
							
						}else{
							System.out.println("é null");
							id3v2 = new ID3v2_3();
							
							String artista = JOptionPane.showInputDialog(null, "Arquivo");
							String titulo = JOptionPane.showInputDialog(null, "Arquivo");
							id3v2.setAuthorComposer(artista);
							id3v2.setSongTitle(titulo);
							
							mp3file.setID3v2Tag(id3v2);
							File file = mp3file.getMp3file();
							try {
								mp3file.save(file);
							} catch (IOException e1) {
								e1.printStackTrace();
							} catch (TagException e1) {
								e1.printStackTrace();
							}
							
							txtartista.setText(mp3file.getID3v2Tag().getLeadArtist());
							txttitulo.setText(mp3file.getID3v2Tag().getSongTitle());
						}

						*/
					
						

				}});
			
			JButton botao2 = new JButton("MP3");
			botao2.setBounds(20, 130, 100, 30);
			
			botao2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.out.println(txtartista.getText());
					System.out.println(txttitulo.getText());
					
					
					
/*
						ID3v2_3 id = new ID3v2_3();
						id.setLeadArtist(txtartista.getText());
						id.setSongTitle(txttitulo.getText());
						mp3file.setID3v2Tag(id);
						try {
							File novonome = mp3file.getMp3file();
							novonome.renameTo(new File(mp3file.getMp3file().getPath()+"\\"+nmarquivo.getText()+".mp3"));
							mp3file.setMp3file(novonome);
							mp3file.save(novonome);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (TagException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						System.out.println(mp3file.getID3v2Tag().getLeadArtist());
						System.out.println(mp3file.getID3v2Tag().getSongTitle());
			
 					*/
			}});

			frame.add(txtartista);
			frame.add(txttitulo);
			frame.add(nmarquivo);
			frame.add(botao);
			frame.add(botao2);
			
		}
	}
