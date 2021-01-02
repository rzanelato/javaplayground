package logica;

public class PegarQtdInformacaoJson {

	public static void main(String[] args) {
		String json = "{\"codigoError\":\"0\",\"descripcionError\":\"\",\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"tipoObjeto\":\"UR (Unidad Registral)\",\"imagenesEntidad\":[{\"claseDocumento\":\"APP Fotos. Pendiente de Revisión\",\"usuarioAlta\":\"TesteJUnit\",\"fechaAlta\":\"19/04/2018\",\"usuarioModificacion\":\"userDoc\",\"fechaModificacion\":\"26/04/2018\",\"eliminada\":\"S\",\"publicada\":\"S\",\"etiqueta\":\"0\",\"urlImagen\":\"http://www.servihabitat.com/ServidorDeImagenesWeb/slir/w100-h100/historical/images_0/imagen_156190.jgp\",\"orden\":1},{\"claseDocumento\":\"APP Fotos. Pendiente de Revisión\",\"usuarioAlta\":\"TesteJUnit\",\"fechaAlta\":\"19/04/2018\",\"usuarioModificacion\":\"userDoc\",\"fechaModificacion\":\"26/04/2018\",\"eliminada\":\"S\",\"publicada\":\"S\",\"etiqueta\":\"0\",\"urlImagen\":\"http://www.servihabitat.com/ServidorDeImagenesWeb/slir/w100-h100/historical/images_5/imagen_156195.jpg\",\"orden\":1},{\"claseDocumento\":\"APP Fotos. Pendiente de Revisión\",\"usuarioAlta\":\"TesteJUnit\",\"fechaAlta\":\"19/04/2018\",\"usuarioModificacion\":\"TesteJUnit\",\"fechaModificacion\":\"19/04/2018\",\"eliminada\":\"N\",\"publicada\":\"S\",\"etiqueta\":\"0\",\"urlImagen\":\"http://www.servihabitat.com/ServidorDeImagenesWeb/slir/w100-h100/current/images_2/imagen_156192.jgp\",\"orden\":1},{\"claseDocumento\":\"APP Fotos. Pendiente de Revisión\",\"usuarioAlta\":\"TesteJUnit\",\"fechaAlta\":\"19/04/2018\",\"usuarioModificacion\":\"TesteJUnit\",\"fechaModificacion\":\"19/04/2018\",\"eliminada\":\"N\",\"publicada\":\"S\",\"etiqueta\":\"0\",\"urlImagen\":\"http://www.servihabitat.com/ServidorDeImagenesWeb/slir/w100-h100/current/images_4/imagen_156194.jpg\",\"orden\":1},{\"claseDocumento\":\"APP Fotos. Pendiente de Revisión\",\"usuarioAlta\":\"TesteJUnit\",\"fechaAlta\":\"19/04/2018\",\"usuarioModificacion\":\"userDoc\",\"fechaModificacion\":\"26/04/2018\",\"eliminada\":\"S\",\"publicada\":\"S\",\"etiqueta\":\"0\",\"urlImagen\":\"http://www.servihabitat.com/ServidorDeImagenesWeb/slir/w100-h100/historical/images_1/imagen_156191.jgp\",\"orden\":1},{\"claseDocumento\":\"APP Fotos. Pendiente de Revisión\",\"usuarioAlta\":\"TesteJUnit\",\"fechaAlta\":\"19/04/2018\",\"usuarioModificacion\":\"userDoc\",\"fechaModificacion\":\"26/04/2018\",\"eliminada\":\"S\",\"publicada\":\"S\",\"etiqueta\":\"0\",\"urlImagen\":\"http://www.servihabitat.com/ServidorDeImagenesWeb/slir/w100-h100/historical/images_9/imagen_156189.jgp\",\"orden\":1},{\"claseDocumento\":\"APP Fotos. Pendiente de Revisión\",\"usuarioAlta\":\"TesteJUnit\",\"fechaAlta\":\"19/04/2018\",\"usuarioModificacion\":\"TesteJUnit\",\"fechaModificacion\":\"19/04/2018\",\"eliminada\":\"N\",\"publicada\":\"S\",\"etiqueta\":\"0\",\"urlImagen\":\"http://www.servihabitat.com/ServidorDeImagenesWeb/slir/w100-h100/current/images_3/imagen_156193.jgp\",\"orden\":1},{\"claseDocumento\":\"APP Fotos. Pendiente de Revisión\",\"usuarioAlta\":\"TesteJUnit\",\"fechaAlta\":\"19/04/2018\",\"usuarioModificacion\":\"userDoc\",\"fechaModificacion\":\"26/04/2018\",\"eliminada\":\"S\",\"publicada\":\"S\",\"etiqueta\":\"0\",\"urlImagen\":\"http://www.servihabitat.com/ServidorDeImagenesWeb/slir/w100-h100/historical/images_8/imagen_156188.jgp\",\"orden\":1}]}";
		//json = json.replace("\"", "");
		
		int count = 0;
		for (String teste: json.split(",")) {
			if(teste.contains("usuarioAlta")) {
				System.out.println(teste);
				count++;
			}
		}
		System.out.println("Total: "+count);

	}

}
