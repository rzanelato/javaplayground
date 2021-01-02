package file;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SwitchProperties {

	private String RESOURCE_PATH = "resources/";

	public static void main(String[] args) {
		SwitchProperties teste = new SwitchProperties();
		try {
			teste.execute();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void execute() throws Exception {
		RadioButtonView radio = new RadioButtonView();
		radio.addActionButtonSwitch(acctionButtonSwitch(radio));
	}
	
	private ActionListener acctionButtonSwitch(final RadioButtonView view) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("[START] Changing properties\n");
					Enviroment radioSelected = view.getSelectedRadio();
					switchBase(radioSelected);
					System.out.println("\n[END] Properties changed to " + radioSelected.getName() + " profile");
				} catch (Exception innerEx) {
					System.out.println("Error: "+ innerEx.getMessage());
					innerEx.printStackTrace();
				}
			}
		};
		return action;
	}

	public void switchBase(Enviroment value) throws Exception {
		for (ConfigFiles enumm : ConfigFiles.values()) {
			String origin = getNameFile(enumm, value);
			changeInformation(origin, enumm.get());
			System.out.println("#Propertie " + enumm.get() + " was changed to " + origin);
		}
	}
	
	private String getNameFile(ConfigFiles config, Enviroment type) {
		String configName = config.get();
		return configName.substring(0, configName.indexOf(".")) + type.getExtension() + configName.substring(configName.indexOf(".")+1) ;
	}
	
	private void changeInformation(String origin, String destination) throws Exception {
		List<String> fileRead = readFile(origin);
		saveNewInformation(destination, fileRead);
	}
	
	private List<String> readFile(String fileName) throws Exception {
		File file = new File(RESOURCE_PATH+fileName);
		FileReader freader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(freader);
		
		List<String> linhas = new ArrayList<String>();
		while (buffer.ready()){
			linhas.add(buffer.readLine());
		}
		
		buffer.close();
		freader.close();
		
		return linhas;
	}
	
	private void saveNewInformation(String destination, List<String> fileRead) throws Exception {
		File newPropFile = new File(RESOURCE_PATH+destination);
		FileWriter fileWriter = new FileWriter(newPropFile);
		
		for (String lines : fileRead) {
			fileWriter.write(lines+"\n");
		}
		fileWriter.close();
	}
	
	private enum ConfigFiles {
		//SDI("sdi.properties"),
		//BATCH("batch.properties"),
		//SERVICE("service.properties"),
		//WEB("web.properties"),
		PROP("prop.prop");
		
		private String name;
		
		private ConfigFiles(String propName) {
			this.name = propName;
		}
		
		public String get() {
			return this.name;
		}
	}
	
	private enum Enviroment {
		DEV("DEV","-dev."),
		PRE("PRE","-pre."),
		PROD("PROD","-prod.");
		
		private String name;
		private String extension;
		
		private Enviroment(String name, String ext) {
			this.name = name;
			this.extension = ext;
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getExtension() {
			return this.extension;
		}
	}
	
	private class RadioButtonView extends JFrame {
		private static final long serialVersionUID = 1L;
		
		private ButtonGroup grupoRadio = new ButtonGroup();
		private JPanel mainPanel = new JPanel();
		private JButton btSwitch;
		
		public RadioButtonView() {
			super("");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setSize(180, 173);
			
			begin();
		}
		
		private void begin() {
			JLabel label = new JLabel("Switch Properties:");
			JPanel panelLabel = new JPanel(new BorderLayout());
			panelLabel.add(Box.createRigidArea(new Dimension(10,10)),BorderLayout.WEST);
			panelLabel.add(Box.createRigidArea(new Dimension(5,5)),BorderLayout.SOUTH);
			panelLabel.add(label, BorderLayout.CENTER);
			
			BoxLayout box = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
			mainPanel.setLayout(box);
			createRadio();
			
			btSwitch = new JButton("Switch");
			JPanel panelButton = new JPanel();
			panelButton.add(btSwitch);
			
			this.add(panelLabel, BorderLayout.NORTH);
			this.add(Box.createRigidArea(new Dimension(10,10)),BorderLayout.WEST);
			this.add(mainPanel,BorderLayout.CENTER);
			this.add(panelButton, BorderLayout.SOUTH);
			this.setVisible(true);
		}
		
		private void createRadio(){
			for (Enviroment envir : Enviroment.values()) {
				JRadioButton radio = new JRadioButton(envir.getName());
				radio.setSelected(true);
				grupoRadio.add(radio);
				mainPanel.add(radio);
			}
			mainPanel.updateUI();
		}
		
		public void addActionButtonSwitch(ActionListener action) {
			btSwitch.addActionListener(action);
		}

		public Enviroment getSelectedRadio(){
			Enumeration<AbstractButton> enumRadios = this.grupoRadio.getElements();
			JRadioButton radio = null;
			while(enumRadios.hasMoreElements()) {
				radio = (JRadioButton)enumRadios.nextElement();
				if(radio.isSelected()) {
					return Enviroment.valueOf(radio.getText());
				}
			}
			return null;
		}
	}
}