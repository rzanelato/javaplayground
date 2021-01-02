package string;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class TesteStringSqlTemplate {

	public static void main(String[] args) {
		//SqlTemplate sql = new SqlTemplate();
		//sql = getSql();
		//System.out.println(sql.toString());
		
		telaTeste();
		/*
		for(String string: getSqlString()){
			verificaSqlTemplate(string,sql);
		}
		System.out.println(sql.toString());
		*/
	}
	private static void metodoTela(final JTextArea text,
			final JTextArea textResultado) {
		String[] texto = text.getText().split(";");
		SqlTemplate sql = new SqlTemplate();
		for(String string: texto)
			verificaSqlTemplate(string, sql);
		textResultado.setText(sql.toString());
	}
	
	private static void metodoTela2(final JTextArea text,
			final JTextArea textResultado) {
		String texto = text.getText();
		String result = verificaSqlParaTemplate(texto);
		textResultado.setText(result);
	}

	private static String verificaSqlParaTemplate(String texto) {
		String aux = texto.toUpperCase();
		String distinct = "";
		String select = "";
		String from = "";
		String where = "";
		String groupBy = "";
		String having = "";
		String orderBy = "";
		
		if(aux.contains("DISTINCT")){
			distinct = "sql.setDistinct();\n";
			aux = aux.replace("DISTINCT", "");
		}
		String selectAux = aux.substring(aux.indexOf("SELECT")+6, aux.indexOf("FROM"));
		select = alterarSelect(selectAux);
		
		if(aux.contains("WHERE")){
			String fromAux = aux.substring(aux.indexOf("FROM")+4, aux.indexOf("WHERE"));
			from = alterarFrom(fromAux);
			
			if(aux.contains("GROUP BY")){
				String whereAux = aux.substring(aux.indexOf("WHERE")+5, aux.indexOf("GROUP BY"));
				where = alterarWhere(whereAux);
				if(aux.contains("HAVING")){
					String groupByAux = aux.substring(aux.indexOf("GROUP BY")+8, aux.indexOf("HAVING"));
					groupBy = alterarGroupBy(groupByAux);
					
					if (aux.contains("ORDER BY")){
						String havingAux = aux.substring(aux.indexOf("HAVING")+6, aux.indexOf("ORDER BY"));
						having = alterarHaving(havingAux);
						String orderByAux = aux.substring(aux.indexOf("ORDER BY")+8, aux.length()).replace("\t", "");
						orderBy = alterarOrderBy(orderByAux);
						
					} else{
						String havingAux = aux.substring(aux.indexOf("HAVING")+6, aux.length());
						having = alterarHaving(havingAux);
					}
				} else if (aux.contains("ORDER BY")){
					String groupByAux = aux.substring(aux.indexOf("GROUP BY")+8, aux.indexOf("ORDER BY"));
					groupBy = alterarGroupBy(groupByAux);
					String orderByAux = aux.substring(aux.indexOf("ORDER BY")+8, aux.length()).replace("\t", "");
					orderBy = alterarOrderBy(orderByAux);
					
				} else{
					String groupByAux = aux.substring(aux.indexOf("GROUP BY")+8, aux.length());
					groupBy = alterarGroupBy(groupByAux);
				}
			} else if(aux.contains("ORDER BY")) {
				String whereAux = aux.substring(aux.indexOf("WHERE")+5, aux.indexOf("ORDER BY"));
				where = alterarWhere(whereAux);
				String orderByAux = aux.substring(aux.indexOf("ORDER BY")+8, aux.length()).replace("\t", "");
				orderBy = alterarOrderBy(orderByAux);
				
			} else{
				String whereAux = aux.substring(aux.indexOf("WHERE")+5, aux.length()).replace("\t", "");
				where = alterarWhere(whereAux);
			}
		}
		
		return distinct+select+from+where+groupBy+having+orderBy;
	}
	private static String alterarSelect(String select) {
		String[] aux = select.split(",");
		StringBuilder result = new StringBuilder();
		for(String string: aux){
			string = limpaEspacoEmBranco(string);
			//remove alias
			if(string.contains(" AS "))
				string = string.replace(" AS ", "\",\"");
			else if(string.contains(" "))
				string = string.replace(" ", "\",\"");
			
			result.append("sql.addProjection(\""+string+"\");\n");
		}
		return result.toString();
	}
	
	private static String alterarFrom(String from) {
		String[] aux = from.split(",");
		StringBuilder result = new StringBuilder();
		for(String string: aux){
			string = limpaEspacoEmBranco(string);
			if(string.contains(" "))
				string = string.replace(" ", "\",\"");
			
			result.append("sql.addFrom(\""+string+"\");\n");
		}
		return result.toString();
	}
	
	private static String alterarWhere(String where){
		String[] aux = where.split("AND");
		StringBuilder result = new StringBuilder();
		for(String string: aux){
			if(string.contains("AND"))
				string = string.replace("AND", "");
			string = limpaEspacoEmBranco(string);

			if(string.contains("=")){
				String igual = string.substring(string.indexOf("=")+1, string.length());
				if(igual.contains("'")){
					result.append("sql.addCriteria(\""+string+"\");\n");
				}else if(igual.contains("(+)")){
					string = string.replace("=", "\",\"");
					result.append("sql.addJoin(\""+string+"\");\n");
				}else if(validaJoin(igual)){
					if(igual.contains(".")){
						string = string.replace("=", "\",\"");
						result.append("sql.addJoin(\""+string+"\");\n");
					} else {
						result.append("sql.addCriteria(\""+string+"\");\n");
					}
				} else
					result.append("sql.addCriteria(\""+string+"\");\n");

			}else{
				result.append("sql.addCriteria(\""+string+"\");\n");
			}
		}
		return result.toString();
	}
	
	private static String alterarGroupBy(String from) {
		String[] aux = from.split(",");
		StringBuilder result = new StringBuilder();
		for(String string: aux){
			string = limpaEspacoEmBranco(string);
			result.append("sql.addGroupBy(\""+string+"\");\n");
		}
		return result.toString();
	}
	
	private static String alterarHaving(String from) {
		String[] aux = from.split(",");
		StringBuilder result = new StringBuilder();
		for(String string: aux){
			string = limpaEspacoEmBranco(string);
			result.append("sql.setHaving(\""+string+"\");\n");
		}
		return result.toString();
	}
	
	private static String alterarOrderBy(String from) {
		String[] aux = from.split(",");
		StringBuilder result = new StringBuilder();
		for(String string: aux){
			string = limpaEspacoEmBranco(string);
			if(string.contains(" "))
				string = string.replace(" ", "\",\"");
			
			result.append("sql.addOrderBy(\""+string+"\");\n");
		}
		return result.toString();
	}
	
	private static boolean validaJoin(String string) {
		String aux = limpaEspacoEmBranco(string);
		try{
			Long.valueOf(aux);
			return false;
		}catch (Exception e) {
			return true;
		}
	}
	private static String limpaEspacoEmBranco(String string) {
		//remove tabulacao e proxima linha.
		string = string.replace("\n", "").replace("\t", "");
		
		//remove espaços em branco no começo.
		while(string.startsWith(" "))
			string = string.replaceFirst(" ", "");
		
		//remove espaços em branco no final.
		while(string.endsWith(" "))
			string = string.replaceFirst(" ", "");
		
		return string;
	}
	
	private static SqlTemplate getSql() {
		SqlTemplate sql = new SqlTemplate();
		String variavel = "nada";
		
		sql.addProjection("ROWNUM","LINHA");
        sql.addProjection("AST.ID_ALUNOSUBTURMA");
        sql.addProjection("A.NR_MATRICULA");
        sql.addProjection("P.NM_PESSOA");
        sql.addProjection("AST.NR_CHAMADA");
        sql.addProjection("T.NR_TURMA");
        sql.addProjection("ID_FALTA");
        sql.addProjection("DT_FALTA");
        sql.addProjection("F.QT_FALTAS");        

        sql.addFrom( "TURMA" , "T");
        sql.addFrom("SUBTURMA","ST");
        sql.addFrom("ALUNOSSUBTURMA","AST");
        sql.addFrom("ALUNO","A");
        sql.addFrom("PESSOA", "P" );
        sql.addFrom("HISTORICOALUNO","HA");
        sql.addFrom("MATRICULA","M");
        sql.addFrom("INGRESSOSALUNO","IA");
        sql.addFrom("CURRICULO","C");
        sql.addFrom("FALTA","F");

        sql.addJoin("T.ID_TURMA","ST.ID_TURMA");
        sql.addJoin("ST.ID_SUBTURMA","AST.ID_SUBTURMA");
        sql.addJoin("AST.ID_ALUNOSUBTURMA","F.ID_ALUNOSUBTURMA(+)");
        sql.addJoin("AST.ID_SUBTURMA","HA.ID_SUBTURMA");
        sql.addJoin("AST.ID_HISTORICO","HA.ID_HISTORICO");
        sql.addJoin("AST.ID_ALUNO","A.ID_ALUNO");
        sql.addJoin("A.ID_PESSOA","P.ID_PESSOA");
        sql.addJoin("A.ID_ALUNO","IA.ID_ALUNO");
        sql.addJoin("IA.ID_CURRICULO","C.ID_CURRICULO");
        sql.addJoin("IA.ID_INGRESSOSALUNO","M.ID_INGRESSOSALUNO");
        sql.addJoin("M.ID_MATRICULA","HA.ID_MATRICULA");

        sql.addCriteria("IA.ST_INGRESSOALUNO IN ('A','S')");
        sql.addCriteria("M.ST_MATRICULA IN ('A','P')");
        sql.addCriteria("HA.ST_HISTORICO = 'A'");
        sql.addCriteria("AST.ID_SUBTURMA = "+variavel);
        sql.addCriteria("TO_CHAR(F.DT_FALTA(+),'YYYYMMDD') = ");   
        
        /*
        sql.addCriteria("IA.ST_INGRESSOALUNO IN ('A','S')");
        sql.addCriteria("M.ST_MATRICULA NOT IN ('A','P')");
        sql.addCriteria("HA.ST_HISTORICO IN (" + variavel1+")");
        sql.addCriteria("AST.ID_SUBTURMA = "+variavel);
        sql.addCriteria("TO_CHAR(F.DT_FALTA(+),'YYYYMMDD') = xxxx");
        sql.addCriteria("HA.ST_HISTORICO", "=", cacacacaca, MappingType );
        sql.addCriteria("AST.ID_SUBTURMA = 'A' ", tipoVariavel);
        sql.addCriteria("TO_CHAR(F.DT_FALTA(+),'YYYYMMDD') = ");      
        */
        
        sql.addOrderBy("AST.NR_CHAMADA");
        sql.addOrderBy("T.NR_TURMA");
		
		return sql;
	}
	
	private static void verificaSqlTemplate(String stringSql, SqlTemplate sql) {
		stringSql = stringSql.trim().replace(" ", "");
		if(stringSql.contains(".addProjection(")){
			if(stringSql.contains(",")){
				String aux1 = stringSql.substring(stringSql.indexOf(".addProjection(\"")+16, stringSql.indexOf(",")-1);
				String aux2 = stringSql.substring(stringSql.indexOf(",\"")+2, stringSql.indexOf("\")"));
				sql.addProjection(aux1,aux2);
			}else{
				String aux = stringSql.substring(stringSql.indexOf(".addProjection(\"")+16, stringSql.indexOf("\")"));
				sql.addProjection(aux);
			}
		} else if(stringSql.contains(".addFrom(")){
			if(stringSql.contains(",")){
				String aux1 = stringSql.substring(stringSql.indexOf(".addFrom(\"")+10, stringSql.indexOf(",")-1);
				String aux2 = stringSql.substring(stringSql.indexOf(",\"")+2, stringSql.indexOf("\")"));
				sql.addFrom(aux1,aux2);
			}else{
				String aux = stringSql.substring(stringSql.indexOf(".addFrom(\"")+10, stringSql.indexOf("\")"));
				sql.addFrom(aux);
			}
		} else if(stringSql.contains(".addJoin(")){
			String aux1 = stringSql.substring(stringSql.indexOf(".addJoin(\"")+10, stringSql.indexOf(",")-1);
			String aux2 = stringSql.substring(stringSql.indexOf(",\"")+2, stringSql.indexOf("\")"));
			sql.addJoin(aux1, aux2);
		} else if(stringSql.contains(".addCriteria(")){
			if(stringSql.contains("('")){
				String aux = stringSql.substring(stringSql.indexOf(".addCriteria(\"")+14, stringSql.lastIndexOf("\")"));
				sql.addCriteria(aux.replace("NOTIN(", " NOT IN (").replace("IN(", " IN ("));
			}else if(stringSql.contains("IN(\"+")){
				String aux1 = stringSql.substring(stringSql.indexOf(".addCriteria(\"")+14, stringSql.indexOf("+")-1);
				String aux2 = stringSql.substring(stringSql.indexOf("+")+1, stringSql.lastIndexOf("+"));
				aux1 = aux1.replace("NOTIN(", " NOT IN (").replace("IN(", " IN (");
				sql.addCriteria(aux1+" "+aux2+" )");
			}else if(stringSql.contains("\",")){
				String aux1 = stringSql.substring(stringSql.indexOf(".addCriteria(\"")+14, stringSql.indexOf("\","));
				String aux2 = stringSql.substring(stringSql.indexOf("\",")+2, stringSql.lastIndexOf(")"));
				if(aux2.contains(",")){
					aux2 = aux2.substring(0,aux2.lastIndexOf(","));
					if(aux2.contains(",")){
						aux2 = aux2.substring(aux2.indexOf(",")+1, aux2.length());	
					}
					aux2 = " = --".concat(aux2);
				}else{
					aux2 = "";
				}
				aux1 = aux1.replace("=", " = ");
				sql.addCriteria(aux1+aux2);
			}else if(stringSql.contains("\"+")){
				String aux1 = stringSql.substring(stringSql.indexOf(".addCriteria(\"")+14, stringSql.indexOf("=\""));
				String aux2 = stringSql.substring(stringSql.indexOf("\"+")+2, stringSql.lastIndexOf(")"));
				sql.addCriteria(aux1+" = --"+aux2);
			}else{
				String aux = stringSql.substring(stringSql.indexOf(".addCriteria(\"")+14, stringSql.indexOf("\")"));
				sql.addCriteria(aux.replace("NOTIN(", " NOT IN (").replace("IN(", " IN (").replace("=", " = "));
			}
		} else if(stringSql.contains(".addOrderBy(")){
			String aux = stringSql.substring(stringSql.indexOf(".addOrderBy(\"")+13, stringSql.indexOf("\")"));
			sql.addOrderBy(aux);
		}
	}
	
	private static String[] getSqlString() {
		StringBuilder aux = new StringBuilder() 
		.append("sql.addFrom(\"TURMA\");")
		.append("sql.addProjection(\"ST.ID_SUBTURMA\",\"SUBTURMA\");")
        .append("sql.addJoin(\"POLO.ID_TURMA\",\"ST.ID_TURMA\");")
        .append("sql.addFrom(\"POLO\");")
        .append("sql.addFrom(\"SUBTURMA\",\"ST\");")
        .append("sql.addJoin(\"T.ID_TURMA\",\"ST.ID_TURMA\");")
        .append("sql.addCriteria(\"T.ID_TURMA = \");")
		.append("sql.addCriteria(\"T.ST_TURMA = 'B'\");")
		.append("sql.addOrderBy(\"T.ID_TURMA\");");
		
		String[] string = aux.toString().split(";");
        		
		return string;
	}
	
	private static void telaTeste() {
		JFrame frame = new JFrame("Teste");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.setDividerSize(3);
		
		final JTextArea text = new JTextArea();
		text.setSize(200,200);
		text.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		final JTextArea textResultado = new JTextArea();
		textResultado.setSize(200,200);
		textResultado.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		textResultado.setEditable(false);
		
		JButton botao = new JButton("vai");
		botao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				metodoTela2(text, textResultado);
			}
		});
		
		JPanel painel = new JPanel(new BorderLayout());
		painel.setPreferredSize(new Dimension(380,500));
		painel.add(text, BorderLayout.CENTER);
		
		JPanel resultado = new JPanel(new BorderLayout());
		resultado.setPreferredSize(new Dimension(380,500));
		resultado.add(textResultado, BorderLayout.CENTER);
		
		split.setLeftComponent(new JScrollPane(painel));
		split.setRightComponent(new JScrollPane(resultado));
		
		frame.add(split, BorderLayout.CENTER);
		frame.add(botao, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	
}
