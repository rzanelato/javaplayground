package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import utils.ConnectDB;

public class NavegarPorTabelas {
	
	private final static String NL = " \n ";
	
	public static void main(String[] args) {
		NavegarPorTabelas tabelas = new NavegarPorTabelas();
		tabelas.executar();
		
	}

	public void executar() {
		String tableOrigin = "SVH_ENTIDAD";
		String tableEnd = "MST_POBLACION";
		
		try {
			
			String connection = ""; 
			connection = getTableConnections(tableOrigin,tableEnd);
			List<String> lista = Arrays.asList(connection.split("\n"));
			
			for (int index = lista.size(); index < lista.size() ; index -- ) {
				if (index != lista.size() && lista.get(index+1).equals(lista.get(index))) {
					System.out.println("atual: " + lista.get(index) + "\nanterior:" + lista.get(index+1));
					//lista.remove(index);
				}
				System.out.println("Linha["+index+"] - " + lista.get(index));
			}
			System.out.println("#######");
			//System.out.println("Teste \n" + connection);
		} catch(Exception ex) {
			System.out.println("Deu errado: " + ex.getMessage());
		} finally {
			
		}
	}
	
	private String getTableConnections(String tableOrigin, String tableEnd) throws SQLException {
		ConnectDB conn = new ConnectDB();
		Statement stm = conn.getStatement();
		String query = getQuery(tableOrigin);
		ResultSet rs = conn.getQuery(stm, query);
		String linha = "";
			
		while(rs.next()) {
			String tabelaEnd = rs.getString("TABLE_END");
			//System.out.println("Origem: "+tableOrigin + "\t\t TableEnd: "+tableEnd + "\t\t Intermediaria: " + tabelaEnd);
			
			String novalinha = rs.getString("TABLE_ORIGIN") +"."+rs.getString("COLUMN_ORIGIN") + " - "+ rs.getString("TABLE_END") +"."+ rs.getString("COLUMN_END")+"\n";
			linha += novalinha;
			//System.out.println("Antes :" + novalinha);
			//System.out.println("Depois :" + linha);
			
			if (tabelaEnd.equals(tableEnd)) {
				System.out.println("Entrou");
				return linha;
				
			} else if (!tableOrigin.equals(tabelaEnd)){
				String resp = getPathTables(conn, linha, tabelaEnd, tableEnd);
				if(resp != null && !resp.isEmpty()) {
					if (!linha.contains(resp)) {
						linha += resp;
						//System.out.println("Resp: "+resp);
					} else {
						linha = linha.replaceAll(novalinha, "");
						//resp = getTableConnections(conn, novalinha, sair, tabelaEnd, tableEnd);
					}
				}
			}
		}
		conn.closeResultset(rs);
		conn.closeStatement(stm);
		conn.closeConnection();
		return linha;
	}
	
	private String getPathTables(ConnectDB conn, String linha, String tableOrigin, String tableEnd) throws SQLException {
		Statement stm = conn.getStatement();
		String query = getQuery(tableOrigin);
		ResultSet rs = conn.getQuery(stm, query);

		while(rs.next()) {

			String tabelaEnd = rs.getString("TABLE_END");
			if (tabelaEnd.equals(tableEnd)) {
				String novalinha = rs.getString("TABLE_ORIGIN") +"."+rs.getString("COLUMN_ORIGIN") + " - "+ rs.getString("TABLE_END") +"."+ rs.getString("COLUMN_END")+"\n";
				linha += novalinha;
				System.out.println("Entrou");
				return linha;
			} else if (!tableOrigin.equals(tabelaEnd)){

				String resp = getPathTables(conn, linha, tabelaEnd, tableEnd);
				if(resp != null && !resp.isEmpty()) {
					if (!linha.equals(resp)) {
						linha += resp;
						System.out.println("Resp: "+resp);
					}
					//resp = getTableConnections(conn, novalinha, sair, tabelaEnd, tableEnd);
					//} else {
					//linha = linha.replace(novalinha, "");
				}
			}
		}
		conn.closeResultset(rs);
		conn.closeStatement(stm);
		return linha;
	}

	private String getQuery(String tableOrigin) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT UCC.TABLE_NAME AS TABLE_ORIGIN").append(NL);
		sql.append(", UCC.COLUMN_NAME AS COLUMN_ORIGIN").append(NL);
		sql.append(", UCC2.COLUMN_NAME AS COLUMN_END").append(NL);
		sql.append(", UCC2.TABLE_NAME AS TABLE_END").append(NL);
		sql.append("FROM USER_CONS_COLUMNS UCC").append(NL);
		sql.append("JOIN USER_CONSTRAINTS UC1 ON UC1.CONSTRAINT_NAME = UCC.CONSTRAINT_NAME AND UC1.TABLE_NAME = UCC.TABLE_NAME").append(NL);
		sql.append("JOIN USER_CONSTRAINTS UC2 ON UC2.CONSTRAINT_NAME = UC1.R_CONSTRAINT_NAME").append(NL);
		sql.append("JOIN USER_CONS_COLUMNS UCC2 ON UCC2.CONSTRAINT_NAME = UC2.CONSTRAINT_NAME AND UCC2.TABLE_NAME = UC2.TABLE_NAME").append(NL);
		sql.append("WHERE UPPER(UCC.TABLE_NAME) = UPPER(\'"+tableOrigin+"\')");
		return sql.toString();
				
	}
	
	
}

