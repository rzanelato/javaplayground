package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectDB {
	
	private Connection connect;
	private Properties prop;

	public ConnectDB() {
		getConnection();
	}
	
	private void getConnection() {
		if(connect == null) {
			executeProperties();
			try {
				Class.forName(prop.getProperty("dataSource.driverClassName"));
				this.connect = DriverManager.getConnection(prop.getProperty("dataSource.url"), prop.getProperty("dataSource.username"), prop.getProperty("dataSource.password"));
				
			} catch (ClassNotFoundException ex) {
				System.out.println("Error: No ha encontrado el Driver de BBDD.");
			} catch (SQLException ex) {
				System.out.println("Erro al conectar en la base de datos.");
			}
		} else {
			try {
				if (connect.isClosed()) {
					connect = null;
					getConnection();
				}
			} catch (SQLException e) {
				System.out.println("Erro al conectar en la base de datos.");
				e.printStackTrace();
			}
		}
	}
	
	private void executeProperties() {
		try {
			if (prop == null) {
				prop= new Properties();
				String propFileName = "svhOwner.prop";
				InputStream fileProp = getClass().getClassLoader().getResourceAsStream(propFileName);
				
				if (fileProp != null) {
					prop.load(fileProp);
				} else {
					throw new FileNotFoundException("Archivo '" + propFileName + "' no encontrado en camino");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Statement getStatement() {
		try {
			return this.connect.createStatement();
		} catch (SQLException ex) {
			System.out.println("Erro al llamar la busqueda.");
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet getQuery(Statement stm, String query) {
    	try {
    		return stm.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Erro ao chamar query.");
            ex.printStackTrace();
            return null;
        }
	}
	
	public void closeResultset(ResultSet rs) {
		try {
			if (rs!= null) {
				rs.close();
			}
		} catch (SQLException ex) {
			System.out.println("Error cerrando resultset ->"+ex.getMessage());
		}
	}
	
	 public void closeStatement(Statement stm) {
        try {
        	if (stm!= null) {
        		stm.close();
        	}
        } catch (SQLException ex) {
            System.out.println("Error cerrando statment ->"+ex.getMessage());
	    }
	}
    
    public void closeConnection() {
        try {
            this.connect.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar a conexion de la base de datos.");
        }
    }

}
