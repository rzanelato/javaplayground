package robot;

import java.awt.AWTEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ConverteKeyEvent {

	
	public static List<Integer> converterString(String string){
		List<Integer> lista = new ArrayList<Integer>();
		String[] teste = string.split("");
		
		int index = 0;
		for(String str: teste){
			if(index != 0){
				lista.add(buscaKeyEvent(str));
			}else
				index++;
			
		}
	
	
		return lista;
	}
	
	private static int buscaKeyEvent(String string){
		if(string.toLowerCase().equals("a"))
			return KeyEvent.VK_A;
		if(string.toLowerCase().equals("b"))
			return KeyEvent.VK_B;
		if(string.toLowerCase().equals("c"))
			return KeyEvent.VK_C;
		if(string.toLowerCase().equals("d"))
			return KeyEvent.VK_D;
		if(string.toLowerCase().equals("e"))
			return KeyEvent.VK_E;
		if(string.toLowerCase().equals("f"))
			return KeyEvent.VK_F;
		if(string.toLowerCase().equals("g"))
			return KeyEvent.VK_G;
		if(string.toLowerCase().equals("h"))
			return KeyEvent.VK_H;
		if(string.toLowerCase().equals("i"))
			return KeyEvent.VK_I;
		if(string.toLowerCase().equals("j"))
			return KeyEvent.VK_J;
		if(string.toLowerCase().equals("k"))
			return KeyEvent.VK_K;
		if(string.toLowerCase().equals("l"))
			return KeyEvent.VK_L;
		if(string.toLowerCase().equals("m"))
			return KeyEvent.VK_M;
		if(string.toLowerCase().equals("n"))
			return KeyEvent.VK_N;
		if(string.toLowerCase().equals("o"))
			return KeyEvent.VK_O;
		if(string.toLowerCase().equals("p"))
			return KeyEvent.VK_P;
		if(string.toLowerCase().equals("q"))
			return KeyEvent.VK_Q;
		if(string.toLowerCase().equals("r"))
			return KeyEvent.VK_R;
		if(string.toLowerCase().equals("s"))
			return KeyEvent.VK_S;
		if(string.toLowerCase().equals("t"))
			return KeyEvent.VK_T;
		if(string.toLowerCase().equals("u"))
			return KeyEvent.VK_U;
		if(string.toLowerCase().equals("v"))
			return KeyEvent.VK_V;
		if(string.toLowerCase().equals("w"))
			return KeyEvent.VK_W;
		if(string.toLowerCase().equals("x"))
			return KeyEvent.VK_X;
		if(string.toLowerCase().equals("y"))
			return KeyEvent.VK_Y;
		if(string.toLowerCase().equals("z"))
			return KeyEvent.VK_Z;
		if(string.toLowerCase().equals(" "))
			return KeyEvent.VK_SPACE;
		if(string.toLowerCase().equals("0"))
			return KeyEvent.VK_0;
		if(string.toLowerCase().equals("1"))
			return KeyEvent.VK_1;
		if(string.toLowerCase().equals("2"))
			return KeyEvent.VK_2;
		if(string.toLowerCase().equals("3"))
			return KeyEvent.VK_3;
		if(string.toLowerCase().equals("4"))
			return KeyEvent.VK_4;
		if(string.toLowerCase().equals("5"))
			return KeyEvent.VK_5;
		if(string.toLowerCase().equals("6"))
			return KeyEvent.VK_6;
		if(string.toLowerCase().equals("7"))
			return KeyEvent.VK_7;
		if(string.toLowerCase().equals("8"))
			return KeyEvent.VK_8;
		if(string.toLowerCase().equals("9"))
			return KeyEvent.VK_9;
		if(string.toLowerCase().equals("["))
			return KeyEvent.VK_OPEN_BRACKET;
		if(string.toLowerCase().equals("]"))
			return KeyEvent.VK_CLOSE_BRACKET;
		if(string.toLowerCase().equals(";"))
			return KeyEvent.VK_SEMICOLON;
		if(string.toLowerCase().equals("."))
			return KeyEvent.VK_PERIOD;
		if(string.toLowerCase().equals(","))
			return KeyEvent.VK_COMMA;
		if(string.toLowerCase().equals("="))
			return KeyEvent.VK_EQUALS;
		if(string.toLowerCase().equals("-"))
			return KeyEvent.VK_MINUS;
		if(string.toLowerCase().equals("*"))
			return KeyEvent.VK_MULTIPLY;
		if(string.toLowerCase().equals("/"))
			return KeyEvent.VK_DIVIDE;
		if(string.toLowerCase().equals("+"))
			return KeyEvent.VK_ADD;
		if(string.toLowerCase().equals("'"))
			return KeyEvent.VK_QUOTE;
		if(string.toLowerCase().equals("!"))
			return KeyEvent.VK_EXCLAMATION_MARK;
		if(string.toLowerCase().equals("\\"))
			return KeyEvent.VK_BACK_SLASH;
		
		
		return KeyEvent.VK_UNDERSCORE;
	}
	
}
