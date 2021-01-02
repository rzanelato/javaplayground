package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

public class EjemploJsonWeb {

	public static void main(String[] args) {
		String json = "[{\"codigo\": 1, \"nome\": \"Jos�\"}, {\"codigo\": 2, \"nome\": \"Jo�o\"}]";
		List<String> campos = new LinkedList<String>();

		campos.add("codigo");
		campos.add("nome");

		EjemploJsonWeb.transformar(campos, new JSONArray(json), "C:/SLM/teste.xls");

	}

	public static void transformar(String array, String caminho) {
		EjemploJsonWeb.transformar(new JSONArray(array), caminho);
	}

	public static void transformar(JSONArray array, String caminho) {
		Set<String> campos = new HashSet<String>();

		for (Object objeto : array) {
			JSONObject linha = (JSONObject) objeto;

			campos.addAll(linha.keySet());
		}

		EjemploJsonWeb.transformar(new LinkedList<String>(campos), array, caminho);
	}

	public static void transformar(List<String> campos, String array, String caminho) {
		EjemploJsonWeb.transformar(campos, new JSONArray(array), caminho);
	}

	public static void transformar(List<String> campos, JSONArray array, String caminho) {
		SXSSFWorkbook xls = new SXSSFWorkbook(50);
		Sheet aba = xls.createSheet();
		FileOutputStream saida;
		File arquivo;

		EjemploJsonWeb.criarCabecalho(campos, aba);

		for (int indice = 1; indice <= array.length(); indice++) {
			List<Object> celulas = new ArrayList<Object>();
			JSONObject objeto = array.getJSONObject(indice - 1);

			for(String campo: campos) {
				if (objeto.has(campo)) {
					celulas.add(objeto.get(campo));
				} else {
					celulas.add("");
				}

			}

			EjemploJsonWeb.criarLinha(celulas, aba, indice);
		}

		try {
			arquivo = new File(caminho);

			if (!arquivo.exists()) {
				arquivo.getParentFile().mkdirs();
				arquivo.createNewFile();
			}

			saida = new FileOutputStream(caminho);
			xls.write(saida);

			saida.close();
		} catch (IOException excecao) {
			throw new RuntimeException(excecao);
		}

		xls.dispose();
	}

	private static void criarCabecalho(List<String> rotulos, Sheet aba) {
		CellStyle estilo;
		Font fonte;
		Row row;
		int indice;

		row = aba.createRow(0);

		for (indice = 0; indice < rotulos.size(); indice++) {
			row.createCell(indice).setCellValue(rotulos.get(indice));
		}

		estilo = aba.getWorkbook().createCellStyle();
		fonte = aba.getWorkbook().createFont();
		//fonte.setBold(true);
		estilo.setFont(fonte);

		for (indice = 0; indice < row.getLastCellNum(); indice++) {
			row.getCell(indice).setCellStyle(estilo);
		}
	}

	private static void criarLinha(List<Object> celulas, Sheet aba, int indiceLinha) {
		Row linha = aba.createRow(indiceLinha);

		for (int indice = 0; indice < celulas.size(); indice++) {
			Object celula = celulas.get(indice);

			linha.createCell(indice).setCellValue(String.valueOf(celula));
		}
	}
}
