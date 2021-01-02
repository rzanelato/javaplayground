package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import robot.ConverteKeyEvent;

public class TesteReflection {
	
	public static void main(String[] args) {
		Class<ConverteKeyEvent> classe = ConverteKeyEvent.class;
		
		Field[] fields = classe.getFields();
		Method[] metodo = classe.getMethods();
		
		for(Field ff: fields)
			System.out.println(ff.getName());
		
		System.out.println();
		System.out.println();
		for(Method m: metodo){
			if(m.isAccessible() == true)
				System.out.println(Modifier.toString(m.getModifiers()));
			
		}
		
		
	}

}
