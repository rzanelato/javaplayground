package utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class EasyCopier {
	
	private static Clipboard clip;
	
	private EasyCopier() {
	}
	
	public static void copy(String texto){
		if (clip == null) {
			clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		}
		StringSelection string = new StringSelection(texto);
		clip.setContents(string, null);
	}
	
	public static String getCopy(){
		if (clip == null) {
			clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		}
		Transferable trans = clip.getContents(null);
		
		try {
			if (trans != null && trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				return (String) trans.getTransferData(DataFlavor.stringFlavor);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "";
	}

}
