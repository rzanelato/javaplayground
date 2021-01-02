package file;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class TestePropertiesConfiguration {
	
	private PropertiesConfiguration config;
	
	public TestePropertiesConfiguration() {
		load();
	}
	
	public static void main(String[] args) {
		TestePropertiesConfiguration teste = new TestePropertiesConfiguration();
		System.out.println(teste.getLoginUrl());
	}
	
	private void load() {
		try {
			if (config == null) {
				Configurations configs = new Configurations();
				configs.properties("properties.prop");
			}

		}
		catch(ConfigurationException cex) {
			System.out.println("Error: " + cex.getMessage());
		}
		
	}
	
	public String getLoginUrl() {
		return config.getString("login.url");
	}

}
