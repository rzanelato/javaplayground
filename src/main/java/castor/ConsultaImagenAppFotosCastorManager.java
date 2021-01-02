package castor;

import java.io.StringReader;

import org.apache.log4j.helpers.Loader;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Unmarshaller;


public class ConsultaImagenAppFotosCastorManager {

	private static ConsultaImagenAppFotosCastorManager castorManager;

	private Unmarshaller unmarshaller;

	private ConsultaImagenAppFotosCastorManager() {
	}

	public synchronized static ConsultaImagenAppFotosCastorManager getInstance() throws Exception {
		if (castorManager == null) {
			String pathMappings = "castor/";

			// Unmarshller Consulta Imagen
			Unmarshaller unmarshallerImagen = new Unmarshaller(RespuestaConsultaImagenAppFotos.class);
			Mapping mappingSalida = new Mapping(ConsultaImagenAppFotosCastorManager.class.getClassLoader());
			mappingSalida.loadMapping(Loader.getResource(pathMappings+"consultaImagenAppFotos-salida.xml"));
			unmarshallerImagen.setMapping(mappingSalida);

			castorManager = new ConsultaImagenAppFotosCastorManager();
			castorManager.unmarshaller = unmarshallerImagen;

			return castorManager;

		} else {
			return castorManager;
		}
	}

	public synchronized RespuestaConsultaImagenAppFotos xmlToObjectRespuesta(String xmlRespuesta) throws Exception{
		StringReader stringReader = new StringReader(xmlRespuesta);
		RespuestaConsultaImagenAppFotos respuesta = (RespuestaConsultaImagenAppFotos) unmarshaller.unmarshal(stringReader);
		stringReader.close();
		return respuesta;
	}
}
