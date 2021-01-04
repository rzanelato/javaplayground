package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TesteLayout extends JFrame {
	
	private String caminho = null;
	
	private JPanel painelCentro;
	private JPanel painelLabel;
	private JPanel painelInferior;
	private JScrollPane scrollAlteracao;
	private JTextField nomeVideo = null;
	
	private List<File> listFileVideo;
	private List<File> listFileLegenda;
	private List<String> strFileVideo;
	private List<String> strFileLegenda;
	private List<JTextField> listNumeroVideo;
	private List<JTextField> listObsVideo;
	
	private JButton btUpVideo;
	private JButton btDownVideo;
	private JButton btRemoveVideo;
	private JButton btUpLegenda;
	private JButton btDownLegenda;
	private JButton btSemLegenda;
	private JButton btRemoveLegenda;
	private JButton btAbrirPasta;
	private JButton btAdicionar;
	private JButton btAlterar;
	
	private JList jListVideos;
	private JList jListLegenda;
	
	public TesteLayout(){
		super("Organizador Videos");
		
		setSize(800,600);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciaPainel();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TesteLayout();
	}

	private void iniciaPainel() {
		painelCentro = new JPanel();
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
		
		listFileVideo = new ArrayList<File>();
		listFileLegenda = new ArrayList<File>();
		strFileVideo = new ArrayList<String>();
		strFileLegenda = new ArrayList<String>();
		listNumeroVideo = new ArrayList<JTextField>();
		listObsVideo = new ArrayList<JTextField>();
		
		btAbrirPasta = new JButton("Abrir Pasta");
		btAbrirPasta.addActionListener(buscaVideos());
		
		JPanel painelCabecalho = new JPanel(new BorderLayout());
		painelCabecalho.add(btAbrirPasta,BorderLayout.CENTER);
		
		painelLabel();
		
		JPanel painelRodape = painelRodape();

		
		add(painelCabecalho, BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(8,10)), BorderLayout.WEST);
		add(painelCentro, BorderLayout.CENTER);
		add(Box.createRigidArea(new Dimension(8,10)), BorderLayout.EAST);
		add(painelRodape, BorderLayout.SOUTH);
		
		iniciaPainelListas();
		iniciaPainelAlteracao();
	}

	private JPanel painelRodape() {
		JPanel painel = new JPanel(new GridLayout(1,2));

		JButton btNovo = new JButton("Novo/Limpar");
		btNovo.addActionListener(novo());
		
		btAlterar = new JButton("Alterar videos");
		btAlterar.setVisible(false);
		btAlterar.addActionListener(alterar());
		
		painel.add(btNovo);
		painel.add(btAlterar);
		
		return painel;
	}

	private void iniciaPainelListas() {
		
		//Painel Video
		JPanel painelVideo = painelVideo();
		
		//Painel Legenda
		JPanel painelLegenda = painelLegenda();
		
		//Painel Botao Adicionar Video e Legenda
		JPanel painelBtAdicionar = painelBtAdicionar();
		
		JPanel painelLista = new JPanel(new GridLayout(1,2,5,5));
		painelLista.setPreferredSize(new Dimension(300,250));
		painelLista.setVisible(true);
		painelLista.add(painelVideo);
		painelLista.add(painelLegenda);
		
		JPanel painelInternoSuperior = new JPanel(new BorderLayout());
		painelInternoSuperior.add(painelLista, BorderLayout.CENTER);
		painelInternoSuperior.add(painelBtAdicionar, BorderLayout.SOUTH);
		
		painelCentro.add(painelInternoSuperior);
		
	}

	private JPanel painelVideo() {
		Font fontebotao = new Font("Times", Font.BOLD, 11);
		JPanel painelVideo = new JPanel();
		GridBagLayout layoutVideo = new GridBagLayout();
		GridBagConstraints constraintsVideo = new GridBagConstraints();
		
		/**
		 * Label Video
		 */
		JLabel jlVideo = new JLabel("Video:");
		jlVideo.setFont(new Font("Times", Font.BOLD, 15));
		constraintsVideo.fill = GridBagConstraints.BOTH;
		addConstraints(painelVideo,layoutVideo,constraintsVideo,jlVideo,0,0,1,1);
		
		/**
		 * JList Video
		 */
		jListVideos = new JList();
		JScrollPane scrollVideo = new JScrollPane(jListVideos);
		constraintsVideo.weightx = 1000;
		constraintsVideo.weighty = 10;
		addConstraints(painelVideo,layoutVideo,constraintsVideo,scrollVideo,0,1,1,5);
		
		/**
		 * Botao Cima Video 
		 */
		btUpVideo = new JButton("Cima");
		btUpVideo.setFont(fontebotao);
		btUpVideo.setEnabled(false);
		btUpVideo.addActionListener(upItem(jListVideos, listFileVideo, strFileVideo));
		constraintsVideo.fill = GridBagConstraints.HORIZONTAL;
		constraintsVideo.weightx = 0;
		constraintsVideo.weighty = 0;
		addConstraints(painelVideo,layoutVideo,constraintsVideo,btUpVideo,1,1,1,1);
		
		/**
		 * Botao Baixo Video 
		 */
		btDownVideo = new JButton("Baixo");
		btDownVideo.setFont(fontebotao);
		btDownVideo.setEnabled(false);
		btDownVideo.addActionListener(downItem(jListVideos, listFileVideo, strFileVideo));
		addConstraints(painelVideo,layoutVideo,constraintsVideo,btDownVideo,1,2,1,1);
		
		/**
		 * Espaco em branco 
		 */
		constraintsVideo.fill = GridBagConstraints.VERTICAL;
		constraintsVideo.weightx = 0;
		constraintsVideo.weighty = 1000;
		addConstraints(painelVideo,layoutVideo,constraintsVideo,Box.createRigidArea(new Dimension(30,95)),1,3,1,2);
		
		/**
		 * Botao Remove Video 
		 */
		btRemoveVideo = new JButton("Remove");
		btRemoveVideo.setFont(fontebotao);
		btRemoveVideo.setEnabled(false);
		btRemoveVideo.addActionListener(removerItem(jListVideos, listFileVideo, strFileVideo));
		constraintsVideo.fill = GridBagConstraints.HORIZONTAL;
		constraintsVideo.weightx = 0;
		constraintsVideo.weighty = 0;
		addConstraints(painelVideo,layoutVideo,constraintsVideo,btRemoveVideo,1,5,1,1);
		
		painelVideo.setLayout(layoutVideo);
		
		return painelVideo;
	}
	
	private JPanel painelLegenda() {
		Font fontebotao = new Font("Times", Font.BOLD, 11);
		JPanel painelLegenda = new JPanel();
		GridBagLayout layoutLegenda = new GridBagLayout();
		GridBagConstraints constraintsLegenda = new GridBagConstraints();

		/**
		 * Label Legenda 
		 */
		JLabel jlLegenda= new JLabel("Legenda:");
		jlLegenda.setFont(new Font("Times", Font.BOLD, 15));
		constraintsLegenda.fill = GridBagConstraints.BOTH;
		addConstraints(painelLegenda,layoutLegenda,constraintsLegenda,jlLegenda,0,0,1,1);
		
		/**
		 * JList Legenda
		 */
		jListLegenda = new JList();
		JScrollPane scrollLegenda = new JScrollPane(jListLegenda);
		constraintsLegenda.weightx = 1000;
		constraintsLegenda.weighty = 1000;
		addConstraints(painelLegenda,layoutLegenda,constraintsLegenda,scrollLegenda,0,1,1,5);
		
		/**
		 * Botao Cima Legenda
		 */
		btUpLegenda = new JButton("Cima");
		btUpLegenda.setFont(fontebotao);
		btUpLegenda.setEnabled(false);
		btUpLegenda.addActionListener(upItem(jListLegenda, listFileLegenda, strFileLegenda));
		constraintsLegenda.fill = GridBagConstraints.HORIZONTAL;
		constraintsLegenda.weightx = 0;
		constraintsLegenda.weighty = 0;
		addConstraints(painelLegenda,layoutLegenda,constraintsLegenda,btUpLegenda,1,1,1,1);
		
		/**
		 * Botao Baixo Legenda
		 */
		btDownLegenda = new JButton("Baixo");
		btDownLegenda.setFont(fontebotao);
		btDownLegenda.setEnabled(false);
		btDownLegenda.addActionListener(downItem(jListLegenda, listFileLegenda, strFileLegenda));
		addConstraints(painelLegenda,layoutLegenda,constraintsLegenda,btDownLegenda,1,2,1,1);
		
		/**
		 * Espaco em branco
		 */
		constraintsLegenda.fill = GridBagConstraints.VERTICAL;
		constraintsLegenda.weightx = 0;
		constraintsLegenda.weighty = 1000;
		addConstraints(painelLegenda,layoutLegenda,constraintsLegenda,Box.createRigidArea(new Dimension(50,70)),1,3,1,1);
		
		/**
		 * Botao adicionar "sem legenda"
		 */
		btSemLegenda = new JButton("Adicionar");
		btSemLegenda.setFont(fontebotao);
		btSemLegenda.setEnabled(false);
		btSemLegenda.addActionListener(semLegenda());
		constraintsLegenda.fill = GridBagConstraints.HORIZONTAL;
		constraintsLegenda.weightx = 0;
		constraintsLegenda.weighty = 0;
		addConstraints(painelLegenda,layoutLegenda,constraintsLegenda,btSemLegenda,1,4,1,1);
		
		/**
		 * Botao Remove Legenda
		 */
		btRemoveLegenda = new JButton("Remove");
		btRemoveLegenda.setFont(fontebotao);
		btRemoveLegenda.setEnabled(false);
		btRemoveLegenda.addActionListener(removerItem(jListLegenda, listFileLegenda, strFileLegenda));
		addConstraints(painelLegenda,layoutLegenda,constraintsLegenda,btRemoveLegenda,1,5,1,1);
		
		painelLegenda.setLayout(layoutLegenda);
		
		return painelLegenda;
	}
	
	private void addConstraints(JPanel painel, GridBagLayout layout, GridBagConstraints constraints
			, Component componente, int coluna, int linha, int largura, int altura){
		constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.gridwidth = largura;
		constraints.gridheight = altura;
		layout.setConstraints(componente, constraints);
		painel.add(componente);
	}
	
	private JPanel painelBtAdicionar() {
		/**
		 * Botao Adicionar Video e Legenda
		 */
		btAdicionar = new JButton("Adicionar");
		btAdicionar.setEnabled(true);
		btAdicionar.setPreferredSize(new Dimension(getSize().width, 30));
		btAdicionar.addActionListener(adicionar());
		
		JPanel painelBotao = new JPanel(new BorderLayout());
		painelBotao.setIgnoreRepaint(false);
		painelBotao.setPreferredSize(new Dimension(300,30));
		painelBotao.add(btAdicionar);
		
		return painelBotao;
	}
	
	private void painelLabel() {
		painelLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel jlnomevideo = new JLabel("Nome Video");
		jlnomevideo.setPreferredSize(new Dimension(330,20));
		
		JLabel jlnumerovideo = new JLabel("Nr");
		jlnumerovideo.setPreferredSize(new Dimension(35,20));
		
		JLabel jlobsvideo = new JLabel("Observaçao");
		jlobsvideo.setPreferredSize(new Dimension(320, 20));
		
		painelLabel.add(jlnomevideo);
		painelLabel.add(jlnumerovideo);
		painelLabel.add(jlobsvideo);
	}
	
	private void iniciaPainelAlteracao(){
		painelInferior = new JPanel(new BorderLayout());
		painelInferior.setPreferredSize(new Dimension(500,300));
		painelInferior.add(painelLabel, BorderLayout.NORTH);

		painelCentro.add(painelInferior);
	}

	private void painelAlterarNomes() {
		int indexLegenda = 0;
		
		JPanel painelalteracao;
		
		painelLabel.setVisible(true);
		
		Box box = Box.createVerticalBox();
		
		for(int index = 0; index < strFileVideo.size(); index++){
			painelalteracao = new JPanel(new FlowLayout(FlowLayout.CENTER));
			painelalteracao.setPreferredSize(new Dimension(740,30));
			painelalteracao.setVisible(true);

			if(index == 0){
				nomeVideo = new JTextField();
				nomeVideo.setPreferredSize(new Dimension(330, 25));
				painelalteracao.add(nomeVideo);
			} else{
				painelalteracao.add(Box.createRigidArea(new Dimension(330,25)));
			}
			listNumeroVideo.add(new JTextField());
			listNumeroVideo.get(index).setPreferredSize(new Dimension(25, 25));
			listNumeroVideo.get(index).setText(new DecimalFormat("00").format(index+1));
			
			JLabel hifem = new JLabel("-");

			listObsVideo.add(new JTextField());
			listObsVideo.get(index).setPreferredSize(new Dimension(230, 25));
			
			painelalteracao.add(listNumeroVideo.get(index));
			painelalteracao.add(hifem);
			painelalteracao.add(listObsVideo.get(index));
			
			if(strFileLegenda.get(indexLegenda).equals("Sem Legenda")){
				painelalteracao.add(Box.createRigidArea(new Dimension(90,25)));
			}else{
				JLabel comLegenda = new JLabel("Com Legenda");
				comLegenda.setPreferredSize(new Dimension(90,25));
				
				painelalteracao.add(comLegenda);
			}
			
			box.add(painelalteracao);
			
			if(strFileLegenda.size() > indexLegenda)
				indexLegenda++;
		}
		
		JPanel painel = new JPanel();
		painel.add(box);
		
		scrollAlteracao = new JScrollPane(painel);
		scrollAlteracao.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		scrollAlteracao.setPreferredSize(new Dimension(500,300));
		scrollAlteracao.setVisible(true);
		
		painelInferior.add(scrollAlteracao, BorderLayout.CENTER);	
		painelInferior.updateUI();
	}
	
	
	private ActionListener buscaVideos() {
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc;
				if(caminho == null)
					jfc = new JFileChooser();
				else
					jfc = new JFileChooser(caminho);
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(jfc.showOpenDialog(jfc) == JFileChooser.APPROVE_OPTION){
					caminho = jfc.getSelectedFile().getAbsolutePath();
					for(File file:jfc.getSelectedFile().listFiles()){
						if(file.getName().endsWith(".avi")){
							listFileVideo.add(file);
							strFileVideo.add(file.getName());
						}
						if(file.getName().endsWith(".srt")){
							listFileLegenda.add(file);
							strFileLegenda.add(file.getName());
						}
					}
					for(File file:jfc.getSelectedFile().listFiles()){
						if(file.getName().endsWith(".rmvb")){
							listFileVideo.add(file);
							strFileVideo.add(file.getName());
						}
					}
					
					if(!listFileVideo.isEmpty()){
						jListVideos.setListData(strFileVideo.toArray());
						jListLegenda.setListData(strFileLegenda.toArray());
						jListVideos.updateUI();
						jListLegenda.updateUI();
						
						btUpVideo.setEnabled(true);
						btDownVideo.setEnabled(true);
						btUpLegenda.setEnabled(true);
						btDownLegenda.setEnabled(true);
						btSemLegenda.setEnabled(true);
						btRemoveLegenda.setEnabled(true);
						btRemoveVideo.setEnabled(true);
						btAbrirPasta.setEnabled(false);
						btAdicionar.setEnabled(true);
						repaint();
					}
				}
		}};
		return action;
	}
	
	private ActionListener upItem(final JList jList, final List<File> listFile, final List<String> listString) {
		ActionListener upAction = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = jList.getSelectedIndex();
				if(index > 0){
					File auxfile = listFile.get(index);
					String auxstr = listString.get(index);
					
					listFile.remove(index);
					listString.remove(index);
					
					listFile.add(index-1, auxfile);
					listString.add(index-1, auxstr);
					
					jList.setListData(listString.toArray());
					jList.updateUI();
					jList.setSelectedIndex(index-1);
				}		
			}
		};
		return upAction;
	}
	
	private ActionListener downItem(final JList jList, final List<File> listFile, final List<String> listString) {
		ActionListener downAction = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = jList.getSelectedIndex();
				
				if(index < listFile.size()-1){
					File auxfile = listFile.get(index);
					String auxstr = listString.get(index);
					
					listFile.remove(index);
					listString.remove(index);
					
					listFile.add(index+1, auxfile);
					listString.add(index+1, auxstr);
					
					jList.setListData(listString.toArray());
					jList.updateUI();
					jList.setSelectedIndex(index+1);
				}
			}
		};
		return downAction;
	}
	
	private ActionListener removerItem(final JList jList, final List<File> listFile, final List<String> listString) {
		ActionListener remover = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int[] indexs = jList.getSelectedIndices();
				
				for(int i = indexs.length-1; i >= 0;i--){
					listFile.remove(indexs[i]);
					listString.remove(indexs[i]);
				}
				jList.setListData(listString.toArray());
				jList.updateUI();
			}
		};
		return remover;
	}
	
	private ActionListener semLegenda() {
		ActionListener semLegenda = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listFileLegenda.size() < listFileVideo.size()){
					strFileLegenda.add("Sem Legenda");
					listFileLegenda.add(new File("Em Branco"));
					
					jListLegenda.setListData(strFileLegenda.toArray());
					jListLegenda.updateUI();
				}
			}
		};
		return semLegenda;
	}
	
	private ActionListener novo() {
		ActionListener novo = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				listFileVideo.clear();
				listFileLegenda.clear();
				strFileVideo.clear();
				strFileLegenda.clear();
				listNumeroVideo.clear();
				listObsVideo.clear();

				jListVideos.setListData(strFileVideo.toArray());
				jListLegenda.setListData(strFileLegenda.toArray());

				btAbrirPasta.setEnabled(true);
				btUpVideo.setEnabled(false);
				btDownVideo.setEnabled(false);
				btRemoveVideo.setEnabled(false);
				btUpLegenda.setEnabled(false);
				btDownLegenda.setEnabled(false);
				btSemLegenda.setEnabled(false);
				btRemoveLegenda.setEnabled(false);
				btAdicionar.setEnabled(false);
				btAlterar.setEnabled(true);
				btAlterar.setVisible(false);
				
				if(scrollAlteracao != null){
					scrollAlteracao.setVisible(false);
					scrollAlteracao.updateUI();
				}
							
				jListVideos.updateUI();
				jListLegenda.updateUI();
			}
		};
		
		return novo;
	}
	
	private ActionListener adicionar() {
		ActionListener adicionar = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					if(strFileVideo.size() !=0){
						painelAlterarNomes();
						desabilitaBotoes();
					}else{
						JOptionPane.showMessageDialog(null, "Nao e possivel alterar", "Aviso", JOptionPane.WARNING_MESSAGE);
						btAdicionar.setEnabled(false);
					}
				}catch(IndexOutOfBoundsException ex){
					if(listFileLegenda.size() < listFileVideo.size()){
						int index = listFileVideo.size() - listFileLegenda.size();
						
						for(int i = 0; i < index; i++){
							strFileLegenda.add("Sem Legenda");
							listFileLegenda.add(new File("Em Branco"));
						}
						
						jListLegenda.setListData(strFileLegenda.toArray());
						jListLegenda.updateUI();
						
						painelAlterarNomes();
						desabilitaBotoes();
					}else{
						//painelLabel.setVisible(false);
						btAdicionar.setEnabled(true);
						
						JOptionPane.showMessageDialog(null, "Numero de legendas maior que de videos!", "Aviso", JOptionPane.WARNING_MESSAGE);
						System.out.println("Erro: "+ex.getMessage());
					}
				}
			}

			private void desabilitaBotoes() {
				btAdicionar.setEnabled(false);
				btUpVideo.setEnabled(false);
				btDownVideo.setEnabled(false);
				btUpLegenda.setEnabled(false);
				btDownLegenda.setEnabled(false);
				btSemLegenda.setEnabled(false);
				btRemoveLegenda.setEnabled(false);
				btRemoveVideo.setEnabled(false);
				btAlterar.setVisible(true);
			}
		};
		
		return adicionar;
	}
	
	private ActionListener alterar() {
		ActionListener altera = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(strFileVideo.size() !=0  || strFileLegenda.size() != 0){
					if(!nomeVideo.getText().equals("")){
						btAlterar.setEnabled(false);
					}else{
						JOptionPane.showMessageDialog(null, "Campo nao informado!", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				}else{
					btAlterar.setEnabled(false);
				}
			}
		};
		
		return altera;
	}
	
}