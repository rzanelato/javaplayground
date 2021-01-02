package logica;

import java.util.ArrayList;
import java.util.List;

import pojo.BeanTest;

public class ListaParaArray {
	
	public static void main(String[] args) {
		lista();
	}
	
	private static void lista() {
		List<BeanTest> beans = new ArrayList<BeanTest>();
		for (int i = 0; i < 5 ; i++) {
			BeanTest bean = new BeanTest();
			bean.setNombre("Nome["+i+"]");
			bean.setNumero(i);
			beans.add(bean);
		}
		
		BeanTest[] beanArray = beans.toArray(new BeanTest[0]);
		
		for (BeanTest beanTest : beanArray) {
			System.out.println(beanTest.getNombre()+" - "+beanTest.getNumero());
		}
		
	}
}
