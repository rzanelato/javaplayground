package reflection;

import java.lang.reflect.Method;

public class GetClassReflection {
	
	public static void main(String[] args) {
		GetClassReflection getClassReflection = new GetClassReflection();
		getClassReflection.metodoTest();
		
	}
	
	public void metodoTest(){
		addLog();
		getMetodo();
		
	}
	private void addLog() {
		String classeName = this.getClass().getSimpleName();
		
		String methodName = "nada";
		try {
			Method method = new Object(){}.getClass().getEnclosingMethod();
			method.setAccessible(true);
			StackTraceElement[] ste = Thread.currentThread().getStackTrace();
			int posistion = ste.length-3;
			String metodo = ste[posistion].getMethodName();
			System.out.println("metodo: "+metodo + " - method: "+ method.getName());
			if (metodo.equals(method.getName())) {
				posistion = posistion + 1;
				metodo = ste[posistion].getMethodName();
			}
			methodName = metodo;
		} catch (SecurityException e) {
		}

		System.out.println(classeName+"."+methodName);
	}
	
	private String setLog(String string){
		return string;
	}
	
	private void getMetodo(){
		this.getClass().getMethods();
		
		
		for (Method metodo : this.getClass().getMethods()) {
			String name = metodo.getName();
			if(name.contains("set")) {
				System.out.println("Nome:" + name);
			}
			
		}
		
		Object newClass = new GetClassReflection();
		
		for (Method metodo : newClass.getClass().getMethods()) {
			String name = metodo.getName();
			if(name.contains("set")) {
				System.out.println("entrada." + name + "();");
			}
			
		}
		addLog();
	}
	
}
