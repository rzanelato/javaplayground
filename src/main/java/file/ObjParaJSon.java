package file;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import pojo.JSonPojo;
import pojo.PojoConListaJSon;

public class ObjParaJSon {

	public static void main(String[] args) {
		PojoConListaJSon pojoLista = new PojoConListaJSon();
		
		JSonPojo pojo1 = new JSonPojo();
		pojo1.setSociedad("0001");
		pojo1.setIdentificador("102030");
		pojo1.setUsuario("OMesmo");
		
		
		JSonPojo pojo2 = new JSonPojo();
		pojo2.setSociedad("0002");
		pojo2.setIdentificador("203040");
		pojo2.setUsuario("OMesmo");
		
		
		
		JSonPojo pojo3 = new JSonPojo();
		pojo3.setSociedad("0003");
		pojo3.setIdentificador("304050");
		pojo3.setUsuario("OMesmo");
		
		List<JSonPojo> lista = new ArrayList<JSonPojo>();
		lista.add(pojo1);
		lista.add(pojo2);
		lista.add(pojo3);
		
		pojoLista.setCodigo("201");
		pojoLista.setDescripcion("Teste sem erro");
		pojoLista.setListaJson(lista);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(pojoLista);
		
		System.out.println(jsonStr);

	}

}
