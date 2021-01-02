package string;

public class SqlTemplate  {
    public  boolean      usesTrunc  = true;
    private boolean      distinct   = false;
    private StringBuffer sqlHint;
    private StringBuffer sqlProjection;
    private StringBuffer sqlFrom;
    private StringBuffer sqlCriteria;
    private StringBuffer sqlOrderBy;
    private StringBuffer sqlGroupBy;
    private StringBuffer sqlHaving;
    private StringBuffer sqlString;
    private String paggingHeader;
    private String paggingFooter;
    private String countHeader;
    private String countFooter;
    private static final String lineSeparator = System.getProperty("line.separator");
    private String tab;


	/**
     * Construtor da classe.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public SqlTemplate() {

        sqlProjection = new StringBuffer();
        sqlFrom = new StringBuffer();
        sqlCriteria = new StringBuffer();
        sqlOrderBy = new StringBuffer();
        sqlGroupBy = new StringBuffer();
        sqlHaving = new StringBuffer();
        sqlHint   = new StringBuffer();
        sqlString = new StringBuffer();
        paggingHeader = null;
        paggingFooter = null;
        countHeader = null;
        countFooter = null;
        tab = "";
    }

	/**
     * Construtor da classe.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public SqlTemplate(int level) {

        sqlProjection = new StringBuffer();
        sqlFrom = new StringBuffer();
        sqlCriteria = new StringBuffer();
        sqlOrderBy = new StringBuffer();
        sqlGroupBy = new StringBuffer();
        sqlHaving = new StringBuffer();
        sqlHint   = new StringBuffer();
        sqlString = new StringBuffer();
        paggingHeader = null;
        paggingFooter = null;
        countHeader = null;
        countFooter = null;
        tab = "";

        for (int i = 0; i < (level-1) * 4; i++) {
            tab = tab + " ";
        }
    }

	/**
     * M�todo respons�vel por incluir uma nova linha na cl�usula SELECT.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addProjection(String tableColumnName, String aliasColumnName) {

        if (sqlProjection.length() == 0) {
            if(distinct){
                if(sqlHint.length() > 0){
                    sqlProjection.append(tab + "SELECT "+sqlHint.toString()+" DISTINCT ");
                }else{
                    sqlProjection.append(tab + "SELECT DISTINCT ");
                }
            }else{
                if(sqlHint.length() > 0){
                    sqlProjection.append(tab + "SELECT "+sqlHint.toString()+" ");
                }else{
                    sqlProjection.append(tab + "SELECT ");
                }
            }
        } else {
            sqlProjection.append(lineSeparator + tab + "         ");
        }
        sqlProjection.append(tableColumnName + " AS " + aliasColumnName + ",");
    }

	/**
     * M�todo respons�vel por incluir uma nova linha na cl�usula SELECT.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addProjection(String linha) {

        if (sqlProjection.length() == 0) {
            if(distinct){
                if(sqlHint.length() > 0){
                    sqlProjection.append(tab + "SELECT "+sqlHint.toString()+" DISTINCT ");
                }else{
                    sqlProjection.append(tab + "SELECT DISTINCT ");
                }
            }else{
                if(sqlHint.length() > 0){
                    sqlProjection.append(tab + "SELECT "+sqlHint.toString()+" ");
                }else{
                    sqlProjection.append(tab + "SELECT ");
                }
            }
        } else {
            sqlProjection.append(lineSeparator + tab + "         ");
        }
        sqlProjection.append(linha + ",");
    }


	/**
     * M�todo respons�vel por incluir uma nova linha na cl�usula FROM.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addFrom(String tableName, String aliasName) {

        if (sqlFrom.length() == 0) {
            sqlFrom.append(lineSeparator + tab + "FROM     ");
        } else {
            sqlFrom.append(lineSeparator + tab + "         ");
        }
        sqlFrom.append(tableName + " " + aliasName + ",");
    }

    public void addFrom(String tableName) {

        if (sqlFrom.length() == 0) {
            sqlFrom.append(lineSeparator + tab + "FROM     ");
        } else {
            sqlFrom.append(lineSeparator + tab + "         ");
        }
        sqlFrom.append(tableName + ",");
    }

	/**
     * M�todo respons�vel por incluir uma nova linha na cl�usula WHERE.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addJoin(String tableColumnName1, String tableColumnName2) {

        if (sqlCriteria.length() == 0) {
            sqlCriteria.append(lineSeparator + tab + "WHERE    ");
        } else {
            sqlCriteria.append(lineSeparator + tab + "         " + "AND ");
        }
        sqlCriteria.append(tableColumnName1 + " = " + tableColumnName2);
    }


    /**
     * M�todo respons�vel por incluir uma nova linha na cl�usula WHERE.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addCriteria(String linha) {

        if (sqlCriteria.length() == 0) {
            sqlCriteria.append(lineSeparator + tab + "WHERE    ");
        } else {
            sqlCriteria.append(lineSeparator + tab + "         " + "AND ");
        }
        sqlCriteria.append(linha);
    }

    /**
     * M�todo respons�vel por incluir uma nova linha na cl�usula WHERE.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addCriteria(String linha, String type) {

        if (sqlCriteria.length() == 0) {
            sqlCriteria.append(lineSeparator + tab + "WHERE    ");
        } else {
            sqlCriteria.append(lineSeparator + tab + "         " + type+" ");
        }
        sqlCriteria.append(linha);
    }

	/**
     * M�todo respons�vel por incluir uma nova linha na cl�usula ORDER BY.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addOrderBy(String columnName) {

        if (sqlOrderBy.length() == 0) {
            sqlOrderBy.append(lineSeparator + tab + "ORDER BY ");
        } else {
            sqlOrderBy.append(lineSeparator + tab + "         ");
        }
        sqlOrderBy.append(columnName + ",");
    }

	/**
     * M�todo respons�vel por incluir uma nova linha na cl�usula ORDER BY.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addOrderBy(String columnName, String order) {

        if (sqlOrderBy.length() == 0) {
            sqlOrderBy.append(lineSeparator + tab + "ORDER BY ");
        } else {
            sqlOrderBy.append(lineSeparator + tab + "         ");
        }
        sqlOrderBy.append(columnName + " " + order + ",");
    }

    public void setDistinct(){
        this.distinct = true;
    }
    /**
     * M�todo respons�vel por incluir uma nova linha na cl�usula GROUP BY.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void addGroupBy(String columnName) {

        if (sqlGroupBy.length() == 0) {
            sqlGroupBy.append(lineSeparator + tab + "GROUP BY ");
        } else {
            sqlGroupBy.append(lineSeparator + tab + "         ");
        }
        sqlGroupBy.append(columnName + ",");
    }

    /**
     * M�todo respons�vel por incluir a cl�usula HAVING.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void setHaving(String param) {
        sqlHaving.append(lineSeparator + tab + "HAVING " + param);
    }

    /**
     * M�todo respons�vel por incluir uma simples linha/Comando de SQL.
     *
     * @version 1.0, 05/12/2003
     * @author  Mauro Merola
     */
    public void add(String param) {
        sqlString.append(lineSeparator + param);
    }

    /**
     * M�todo respons�vel por incluir uma hint na SELECT.
     *
     * @version 1.0, 27/05/2003
     * @author  Marcelo Prytula
     */
    public void setHint(String hint) {
        sqlHint.append(tab + "/*+"+hint+"*/");
    }
    /**
     * M�todo respons�vel por adicionar pagina��o ao comando SQL.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void setPaggingStuffs(int inicio, int fim) {

        paggingHeader = tab + "SELECT * FROM ( " + lineSeparator;
        paggingFooter = lineSeparator + tab + ") WHERE LINHA BETWEEN " + inicio + " AND " + fim + " " + lineSeparator;

        tab = tab + "    ";

        paggingHeader += tab + "SELECT TMP.*, ROWNUM AS LINHA FROM (" + lineSeparator;
        paggingFooter = lineSeparator + tab + ") TMP" + paggingFooter;

        tab = tab + "    ";
    }

    /**
     * M�todo respons�vel por adicionar pagina��o ao comando SQL.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void setPreparedPaggingStuffs() {

        paggingHeader = tab + "SELECT * FROM ( " + lineSeparator;
        paggingFooter = lineSeparator + tab + ") WHERE LINHA BETWEEN ? AND ? " + lineSeparator;

        tab = tab + "    ";

        paggingHeader += tab + "SELECT TMP.*, ROWNUM AS LINHA FROM (" + lineSeparator;
        paggingFooter = lineSeparator + tab + ") TMP" + paggingFooter;

        tab = tab + "    ";
    }

    /**
     * M�todo respons�vel por adicionar contagem ao comando SQL.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void setCount() {

        countHeader = tab + "SELECT COUNT(*) AS TOTAL FROM (" + lineSeparator;
        countFooter = lineSeparator + tab + ")" + lineSeparator;
        tab = tab + "    ";
    }

	/**
     * M�todo respons�vel por retornar uma String contendo o comando SQL formatado.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public String toString() {
        StringBuffer sql = new StringBuffer();

        if (paggingHeader != null) {
            sql.append(paggingHeader);
        } else if (countHeader != null) {
            sql.append(countHeader);
        }

        if (sqlProjection.length() > 0) {
            sql.append(sqlProjection.substring(0, sqlProjection.length() - 1));
        }

        if (sqlFrom.length() > 0) {
            sql.append(sqlFrom.substring(0, sqlFrom.length() - 1));
        }

        if (sqlCriteria.length() > 0) {
           sql.append(sqlCriteria.toString());
        }

        if (sqlString.length() > 0) {
           sql.append(sqlString.toString());
        }

        if (sqlGroupBy.length() > 0) {
            sql.append(sqlGroupBy.substring(0, sqlGroupBy.length() - 1));
        }

        if (sqlOrderBy.length() > 0) {
            sql.append(sqlOrderBy.substring(0, sqlOrderBy.length() - 1));
        }

        if (sqlHaving.length() > 0) {
            sql.append(sqlHaving.toString());
        }

        if (paggingFooter != null) {
            sql.append(paggingFooter);
        } else if (countFooter != null) {
            sql.append(countFooter);
        }

        return sql.toString();
    }

	/**
     * M�todo respons�vel por limpar o conte�do da classe.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void clear() {

        sqlProjection = new StringBuffer();
        sqlFrom = new StringBuffer();
        sqlCriteria = new StringBuffer();
        sqlOrderBy = new StringBuffer();
        sqlGroupBy = new StringBuffer();
        sqlHaving = new StringBuffer();
        sqlString = new StringBuffer();
        paggingHeader = null;
        paggingFooter = null;
        countHeader = null;
        countFooter = null;
        tab = "";
    }

	/**
     * M�todo respons�vel por ajustar o espa�amento ap�s o SqlTemplate ter sido limpo.
     *
     * @version 1.0, 30/07/2002
     * @author  Alberto Egon
     */
    public void setLevel(int level) {

        tab = "";
        for (int i = 0; i < (level-1) * 4; i++) {
            tab = tab + " ";
        }
    }
}