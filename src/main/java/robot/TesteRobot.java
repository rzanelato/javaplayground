package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TesteRobot {
	
	public static void main(String[] args) throws AWTException,IOException{
		
		int index = 0;
		while (index < 5){
			++index;
			System.out.println("index "+(index));
		}
		

	}

	private static void firefox() throws AWTException {
		String texto = JOptionPane.showInputDialog("Digite");
		
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		
		
		robot.delay(1000);
		List<Integer> firefox = ConverteKeyEvent.converterString("firefox");
		
		for (Integer inteiro:firefox){ 
			robot.keyPress(inteiro);
			robot.keyRelease(inteiro);
			robot.delay(100);  
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		
		List<Integer> lista = ConverteKeyEvent.converterString(texto);
		
		robot.delay(3000); 
		for (Integer inteiro:lista){ 
			if(inteiro == KeyEvent.VK_EXCLAMATION_MARK){
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_1);
				robot.keyRelease(KeyEvent.VK_1);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			}else{
				robot.keyPress(inteiro);
				robot.keyRelease(inteiro);
			}
			robot.delay(100);
		}  
			
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.delay(10000);
		int index = 0;
		while(index != 21){
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(100);
			index++;
			
		}
		robot.delay(1000);
		List<Integer> usuario = ConverteKeyEvent.converterString("rzanelato");
		
		for (Integer inteiro:usuario){ 
			robot.keyPress(inteiro);
			robot.keyRelease(inteiro);
			robot.delay(100);  
		}
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		List<Integer> senha = ConverteKeyEvent.converterString("renato");
		
		for (Integer inteiro:senha){ 
			robot.keyPress(inteiro);
			robot.keyRelease(inteiro);
			robot.delay(100);  
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@SuppressWarnings("unused")
	private static void notepad() throws AWTException, IOException{
		int keyInput[] = {  
				KeyEvent.VK_H,  
				KeyEvent.VK_E,  
				KeyEvent.VK_L,  
				KeyEvent.VK_L,
				KeyEvent.VK_O
				
		};  
		
		Runtime.getRuntime().exec("notepad");  
		
		Robot robot = new Robot();  
		
		robot.keyPress(KeyEvent.VK_SHIFT);  
		for (int cnt2 = 0;cnt2 < keyInput.length; cnt2++){  
			if(cnt2 > 0){  
				robot.keyRelease(KeyEvent.VK_SHIFT);  
			}  
			robot.keyPress(keyInput[cnt2]);  
			robot.delay(500);  
		}  
		
	}
	
	@SuppressWarnings("unused")
	private static void altTab() throws AWTException{
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		
		robot.keyRelease(KeyEvent.VK_ALT);
	}
	
	@SuppressWarnings("unused")
	private static void mouseDesliga() throws AWTException{
		Robot robot = new Robot();  
		
		robot.mouseMove(650,400);
		robot.delay(1000);
		robot.mouseMove(700,480);
		robot.delay(1000);
		robot.mouseMove(30,1010);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(60,980);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(1000);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(1000);
		robot.mouseMove(700,480);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
	}
	
	@SuppressWarnings("unused")
	private static void firefoxGoogle() throws AWTException{
		Robot robot = new Robot();
		
		//Runtime.getRuntime().exec("iexplorer.exe");
		
		robot.delay(5000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		int keyInput[] = {  
				KeyEvent.VK_W,  
				KeyEvent.VK_W,  
				KeyEvent.VK_W,  
				KeyEvent.VK_PERIOD,  
				KeyEvent.VK_G,
				KeyEvent.VK_O,
				KeyEvent.VK_O,
				KeyEvent.VK_G,
				KeyEvent.VK_L,
				KeyEvent.VK_E,
				KeyEvent.VK_PERIOD,
				KeyEvent.VK_C,
				KeyEvent.VK_O,
				KeyEvent.VK_M,
				KeyEvent.VK_ENTER
		};  
		
		for (int cnt2 = 0;cnt2 < keyInput.length; cnt2++){  
			robot.keyPress(keyInput[cnt2]);  
			robot.delay(200);  
		} 
		
		robot.delay(2000);
		int keyInput2[] = {  
				KeyEvent.VK_P,  
				KeyEvent.VK_O,  
				KeyEvent.VK_L,  
				KeyEvent.VK_I,  
				KeyEvent.VK_T,
				KeyEvent.VK_I,
				KeyEvent.VK_C,
				KeyEvent.VK_O,
				KeyEvent.VK_SPACE,
				KeyEvent.VK_H,
				KeyEvent.VK_O,
				KeyEvent.VK_N,
				KeyEvent.VK_E,
				KeyEvent.VK_S,
				KeyEvent.VK_T,
				KeyEvent.VK_O,
				KeyEvent.VK_ENTER
		};  
		
		for (int cnt2 = 0;cnt2 < keyInput2.length; cnt2++){  
			robot.keyPress(keyInput2[cnt2]);  
			robot.delay(200);  
		} 
	}
	
	
}
