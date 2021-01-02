package reflection;

import java.lang.reflect.Method;

import pojo.BeanTest;

public class CrearSetPorClasse {
	
	public static void main(String[] args) {
		
		Class<?> classe =  BeanTest.class;
		
		for (Method metodo : classe.getDeclaredMethods()) {
			if(metodo.getName().contains("set")) {
				System.out.println("objeto."+metodo.getName()+"(value);");
			}
		}
	}

}
