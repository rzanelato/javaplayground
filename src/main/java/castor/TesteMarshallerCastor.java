package castor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

public class TesteMarshallerCastor {
	
	public static void main(String[] args) {
		try {
			ImagenAppFotosDTO imagen = new ImagenAppFotosDTO();
			byte[] foto = encodeFileToBase64Binary("resources/imageTest.jpg");
			imagen.setContent(foto);
			
			System.out.println("foto:\n"+new String(foto,"UTF-8"));
		
		
			String xml = ImagenAppFotosCastorManager.getInstance().imagenToXML(imagen);
			
			String xml64 = new String(xml.getBytes());
			
			String content = xml.substring(xml.indexOf("<content>")+"<content>".length(), xml.indexOf("</content>"));
			
			byte[] ssss = Base64.decodeBase64(content);
			
			String fotossss = new String(ssss, "UTF-8");
			
			System.out.println("foto:\n"+new String(foto,"UTF-8"));
			System.out.println(content);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static byte[] encodeFileToBase64Binary(String fileName) throws IOException {
		File file = new File(fileName);
		byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		return encoded;
	}

}
