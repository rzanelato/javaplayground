package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PegarInformacaoDeBD {
	
	private Connection connect;
	private Properties prop;

	public static void main(String[] args) {
		System.setProperty("http.proxyHost", "10.129.8.100");
		System.setProperty("http.proxyPort", "8080");

		PegarInformacaoDeBD teste = new PegarInformacaoDeBD();
		System.out.println(teste.getToken("sys"));
		System.out.println(teste.getToken("admin"));
		//System.out.println(teste.getToken("renato"));
		System.out.println(teste.getToken("userDoc"));

	}
	
	public PegarInformacaoDeBD() {
		getConnection();
	}
	
	private void getConnection() {
		if(connect == null) {
			init();
			try {
				Class.forName(prop.getProperty("dataSource.driverClassName"));
				this.connect = DriverManager.getConnection(prop.getProperty("dataSource.url")
			            , prop.getProperty("dataSource.username")
			            , prop.getProperty("dataSource.password"));
			} catch (ClassNotFoundException ex) {
				System.out.println("Nao encontrou driver do banco.");
				//JOptionPane.showMessageDialog(null,"Nao encontrou driver do banco.\n"+ex.getMessage());
			} catch (SQLException ex) {
				System.out.println("Erro ao conectar no banco de dados."+ex.getMessage());
				//JOptionPane.showMessageDialog(null,"Erro ao conectar no banco de dados. \n"+ex.getMessage());
			}
		} else {
			try {
				if (connect.isClosed()) {
					connect = null;
					getConnection();
				}
			} catch (SQLException e) {
				System.out.println("Erro ao verificar a conexao fechada.");
				e.printStackTrace();
			}
		}
	}
	
	private void init() {
		try {
			if (prop == null) {
				prop= new Properties();
				String propFileName = "resources/prop-prod.prop";
				InputStream fileProp = new FileInputStream(propFileName);
				
				if (fileProp != null) {
					prop.load(fileProp);
				} else {
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}
				fileProp.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getToken(String user) {
		getConnection();
		String token = "";
		ResultSet returnRS = null;
		Statement stm = null;
    	try {
    		String query = "select TOKEN from MST_USUARIOS where USUARIO = \'"+user+"\'";
            stm = this.connect.createStatement();
            returnRS = stm.executeQuery(query);
            if(returnRS.next()) {
            	token = returnRS.getString("TOKEN");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta.");
            //JOptionPane.showMessageDialog(null,"Erro ao executar a consulta.");
            ex.printStackTrace();
        } finally {
        	fecharConexao(stm, returnRS);
        }
    	
		return token;
	}
    
    private void fecharConexao(Statement statement, ResultSet resultSet) {
        try {
        	resultSet.close();
        	statement.close();
            this.connect.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao fechar conexao com o banco de dados.");
            //JOptionPane.showMessageDialog(null,"Falha ao fechar conexao com o banco de dados.");
        }
    }
}
