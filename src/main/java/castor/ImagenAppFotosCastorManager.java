package castor;

import java.io.StringWriter;

import org.apache.log4j.helpers.Loader;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;

import castor.ImagenAppFotosDTO;

public class ImagenAppFotosCastorManager {

	private static ImagenAppFotosCastorManager castorManager;

	private Marshaller marshaller;
	
	private ImagenAppFotosCastorManager() {
	}

	public synchronized static ImagenAppFotosCastorManager getInstance() throws Exception {
		if (castorManager == null) {
			String pathMappings = "castor/";

			// Marshaller Imagen
			Marshaller marshallerImagen = new Marshaller();
			Mapping mappingEntrada = new Mapping(ImagenAppFotosCastorManager.class.getClassLoader());
			mappingEntrada.loadMapping(Loader.getResource(pathMappings+"imagenAppFotos-entrada.xml"), "UTF-8");
			marshallerImagen.setMapping(mappingEntrada);

			castorManager = new ImagenAppFotosCastorManager();
			castorManager.marshaller = marshallerImagen;
			
			return castorManager;

		} else {
			return castorManager;
		}
	}

	public synchronized String imagenToXML(ImagenAppFotosDTO imagen) throws Exception{
		StringWriter stringWriter = new StringWriter();
		
		
		marshaller.setWriter(stringWriter);
		marshaller.marshal(imagen);
		return stringWriter.toString();
	}
	
}