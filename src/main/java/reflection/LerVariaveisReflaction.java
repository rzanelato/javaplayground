package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import pojo.BeanTest;
import pojo.ClassTest;

public class LerVariaveisReflaction {

	public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		BeanTest bean = new BeanTest();
		bean.setNombre("Renato");
		bean.setNumero(5);
		bean.setLinea("10");
		
		ClassTest test = new ClassTest();
		test.setNombre("Renato");
		test.setApellido("Zanelato");
		test.setEdad(new BigDecimal("33"));
		
		System.out.println("Testando:");
		String xml = getObjToXml(bean);
		String xml2 = getObjToXml(test);
		

		
		System.out.println("xml: "+xml);
		System.out.println("xml: "+xml2);
		
		/*
		Class<?> targetType = field.getType();
		Object objectValue = targetType.newInstance();

		Object value = field.get(objectValue);
		field.get((targetType)objectValue);
		Object value = field.get(objectInstance);
		*/
	}
	
	public static String getObjToXml(Object obj) {
		String xml = "";

		try {
			for (Field campo : obj.getClass().getDeclaredFields()) {
				for (Method metodo : obj.getClass().getDeclaredMethods()) {
					campo.setAccessible(true);
					boolean isMethodSet = metodo.getName().startsWith("set");
					boolean isNameEqual = campo.getName().toLowerCase().equals(metodo.getName().substring(3).toLowerCase()); 
					if(isMethodSet && isNameEqual) {
						Object value = campo.get(obj);
						xml += "<"+campo.getName()+">"+value+"</"+campo.getName()+">";
					}
				}
				
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return xml;
	}
}
