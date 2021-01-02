package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class TrocarConteudoDeProperties {

	private Properties prop;
	private Properties propDev;
	private Properties propPre;
	private Properties propProd;

	public TrocarConteudoDeProperties() {
		init();
	}

	private void init() {
		prop = cargaProperties("prop.prop");
		System.out.println(getUrl());
		propDev = cargaProperties("prop-dev.prop");
		propPre = cargaProperties("prop-pre.prop");
		propProd = cargaProperties("prop-prod.prop");
		try {
			trocaBase(prop, propPre);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Properties cargaProperties(String path) {
		try {
			Properties propertie= new Properties();
			String propFileName = path;
			InputStream fileProp = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (fileProp != null) {
				propertie.load(fileProp);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			return propertie;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void trocaBase(Properties propPrincipal, Properties otroProp) throws IOException {
		for (Object obj : otroProp.keySet()) {
			propPrincipal.setProperty(obj.toString(), otroProp.getProperty(obj.toString()));
		}
		
		saveProp();
		
	}
	
	private void saveProp() {
		try {
			File novoProp = new File("prop.prop");
			prop.store(new OutputStreamWriter(new FileOutputStream(novoProp), "UTF-8"),null);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		//String nomeCompleto = prop.getProperty("server.path")+prop.getProperty("project.name")+prop.getProperty("login.svc");
		String nomeCompleto = prop.getProperty("dataSource.url");
		return nomeCompleto;
	}

	public static void main(String[] args) {
		TrocarConteudoDeProperties teste = new TrocarConteudoDeProperties();
		System.out.println("URL: " + teste.getUrl());
	}

}
