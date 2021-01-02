package file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.birosoft.liquid.LiquidLookAndFeel;

public class TesteExcel {
	
	private static List<File> listArquivos;
	
	public static void main(String[] args) {
		
		quartoTeste();
		
	}
	
	private static void quartoTeste(){
		JPanel panel = new JPanel();

        /* add a new action named "foo" to the panel's action map */
        panel.getActionMap().put("foo", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("hello, world");
                }
            });
        
        panel.getActionMap().put("fii", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello, Mommy");
            }
        });

        /* connect two keystrokes with the newly created "foo" action:
           - a
           - CTRL-a
        */
        InputMap inputMap = panel.getInputMap();
//        inputMap.put(KeyStroke.getKeyStroke(Character.valueOf('p'), Modifier.PUBLIC), "foo");	
        //inputMap.put(KeyStroke.getKeyStroke(Character.valueOf('a'), KeyEvent.CTRL_DOWN_MASK), "foo");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.CTRL_DOWN_MASK),"foo");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.CTRL_DOWN_MASK),"fii");

        /* display the panel in a frame */
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);


		
		
	}
	
	private static void terceiroTeste(){
		
		Workbook workbook = null;
		WritableWorkbook copy = null;
		
		try {
			
			JFrame frame = new JFrame("Excel");
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setSize(500, 400);

			final JTextField nome = new JTextField();
			nome.setBounds(10, 10, 150, 25);
			
			final JTextField sobrenome = new JTextField();
			sobrenome.setBounds(10, 40, 150, 25);
			
			JButton botao = new JButton("OK");
			botao.setBounds(10, 80, 80, 25);
			botao.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			frame.add(nome);
			frame.add(sobrenome);
			
			File file = new File("D:\\TesteExcel1.xls");
			workbook = Workbook.getWorkbook(file);
			copy = Workbook.createWorkbook(file, workbook);

			WritableSheet sheet = copy.getSheet(0);
			WritableCell cell = sheet.getWritableCell(0, 4);

			if (cell.getType() == CellType.LABEL) {
				Label l = (Label) cell;
				String teste = l.getString();
				
				System.out.println(teste);
				
			}
			
			List<WritableCell> listCelula = new ArrayList<WritableCell>();
			
			for(int i = 0; i < 10;i++){
				listCelula.add(sheet.getWritableCell(0, i));
				
			}
			
			for (WritableCell celll : listCelula) {
				if(celll.getType() == CellType.LABEL){
					Label l = (Label) celll;
					System.out.println(l.getString());
				}
				if(celll.getType() == CellType.NUMBER){
					Number n = (Number) celll;
					System.out.println(n.getContents());
				}
				if(celll.getType() == CellType.EMPTY){
					Label ll = new Label(0,listCelula.indexOf(celll),"Nada");
					System.out.println(ll.getContents());
					sheet.addCell(ll);
				}
				
				
					
				
				
			}


			

			copy.write();
			copy.close();

		} catch (RowsExceededException e) {
		} catch (WriteException e) {
		} catch (IOException e) {
		} catch (BiffException ee) {
		}


		
	}
	
	private static void segundoTeste(){
		
		JFrame frame = new JFrame("Tela");
		frame.setSize(400, 400);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		try {
			frame.setUndecorated(true);
			frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
			UIManager.setLookAndFeel(new com.birosoft.liquid.LiquidLookAndFeel());
			LiquidLookAndFeel.setLiquidDecorations(true,"mac");
			LiquidLookAndFeel.setStipples(false);

			
		} catch (Exception e) { }
		
		JButton botao = new JButton("OK");
		botao.setBounds(0, 0, 80, 25);
		//botao.addActionListener(buscarArquivo());
		
		frame.add(botao);
		frame.setVisible(true);
		
		
		
		
	}
	private static void gravaExcel(){
		try{
			
			File file = new File("D:\\TesteExcel1.xls");
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			
			WritableSheet sheet = workbook.createSheet("MP3", 0);
			
			for (File arq:listArquivos){
				Label label = new Label(0, listArquivos.indexOf(arq), arq.getName());
				sheet.addCell(label);
			}
			workbook.write();
			workbook.close(); 
			
		} catch (RowsExceededException e) {
		} catch (WriteException e) {
		} catch (IOException e) {
		}
	}
	
	private static ActionListener buscarArquivo() {
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.setAcceptAllFileFilterUsed(true);
				jfc.setMultiSelectionEnabled(true);
				jfc.setAutoscrolls(true);
				jfc.setDialogTitle("Selecionar Pasta");
				
				listArquivos = new ArrayList<File>();
				
				if(jfc.showOpenDialog(jfc) == JFileChooser.APPROVE_OPTION){
					for(File file: jfc.getSelectedFile().listFiles()){
						if(file.getName().endsWith(".mp3")){
							try {
								listArquivos.add(file);
							} catch (Exception e1) {
								System.out.println("Erro JFileChooser: "+e1.getMessage());
							}
							
						}
					}
				}
				gravaExcel();
				
			}
		};
		return action;
	}

	private static void primeiroTeste() {
		WritableWorkbook workbook = null;
		try {
			File file = new File("D:\\TesteExcel.xls");
			FileOutputStream out = new FileOutputStream(file);
			
			//workbook =Workbook.createWorkbook(new File("D:\\testeExcel.xls"));
			workbook =Workbook.createWorkbook(out);
		} catch (IOException e) {
			System.out.println("Error Create Workbook: "+e.getMessage());
		}
		
		WritableSheet sheet = workbook.createSheet("Oh Sheet!", 0);
		WritableSheet sheet2 = workbook.createSheet("New Sheet!", 1);
		
		WritableCellFormat integerFormat = new WritableCellFormat (NumberFormats.INTEGER);
		Number number2 = new Number(0, 0, 1, integerFormat);
		Number number21 = new Number(0, 1, 1, integerFormat);
		Label label = new Label(0, 2, "A label record");
		Formula formula = new Formula(0,3,"AVERAGE(A1:A2)");
		try {
			
			sheet.addCell(label);
			sheet.addCell(formula);
			sheet2.addCell(number2);
			sheet2.addCell(number21);

			Number number = new Number(3, 4, 3.1459);
			sheet.addCell(number); 
		
			// Create a cell format for Arial 10 point font
			WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
			WritableCellFormat arial10format = new WritableCellFormat (arial10font);
			
			// Create the label, specifying content and format
			Label label23 = new Label(1,0, "Arial 10 point label", arial10format);
			sheet.addCell(label23);
		
			Label label3 = new Label(2, 0, "Another Arial 10 point label", arial10format);
			sheet.addCell(label3); 
			
			// Create a cell format for Times 16, bold and italic
			WritableFont times16font = new WritableFont(WritableFont.TIMES, 16, WritableFont.BOLD, true);
			WritableCellFormat times16format = new WritableCellFormat (times16font);

			// Create the label, specifying content and format
			Label label4 = new Label(3,0, "Times 16 bold italic label", times16format);
			sheet.addCell(label4); 
			
			Number number24 = new Number(0, 4, 3.141519, integerFormat);
			sheet.addCell(number24);

			WritableCellFormat floatFormat = new WritableCellFormat (NumberFormats.FLOAT);
			Number number3 = new Number(1, 4, 3.141519, floatFormat);
			sheet.addCell(number3); 
			
			NumberFormat fivedps = new NumberFormat("#.#####");
			WritableCellFormat fivedpsFormat = new WritableCellFormat(fivedps);
			Number number4 = new Number(2, 4, 3.141519, fivedpsFormat);
			sheet.addCell(number4); 
			
			WritableCellFormat fivedpsFontFormat = new WritableCellFormat (times16font, fivedps);
			Number number5 = new Number(3, 4, 3.141519, fivedpsFontFormat);
			sheet.addCell(number5); 
		
		
		
			
		
			workbook.write();
			workbook.close(); 
		
		} catch (RowsExceededException e) {
		} catch (WriteException e) {
		} catch (IOException e) {
		}
	}
	
	

}

