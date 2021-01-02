package file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PegarInformacaoImagem {
	
	public static void main(String[] args) {
		try {
			File fileImagen = new File("resources/sizeImage.jpg");
			BufferedImage image = ImageIO.read(fileImagen);
			System.out.println("Size:\nAltura: " + image.getHeight() + "\nLargura: " + image.getWidth() );
			
			double bytes = fileImagen.length();
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);
			
			System.out.println("Tamanho KB: " + new Double(Math.ceil(kilobytes)).intValue());
			System.out.println("Tamanho KB: " + new Double(Math.ceil(bytes/1024)).intValue());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
