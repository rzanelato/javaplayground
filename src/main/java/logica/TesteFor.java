package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TesteFor {
	
	public static void main(String[] args) {
		TesteFor tst = new TesteFor();
		
		tst.testaForVacio();
	}
	
	public void testaForVacio(){
		List<Testando> list = new ArrayList<TesteFor.Testando>();
		//System.out.println("Lista = "+list.isEmpty());
		Testando tst = new Testando();

		System.out.println("Lista = "+list.isEmpty());
		
		for (Testando testando : list) {
			System.out.println("Item "+ list.indexOf(testando));
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Item "+ list.get(i));
		}
		
	}
	
	
	public void testaFor(){
		List<Testando> list = new ArrayList<Testando>();
		Testando tst = new Testando();
		Testando tst2 = new Testando();
		Testando tst3 = new Testando();
		list.add(tst);
		list.add(tst2);
		list.add(tst3);
		
		List<Testando> list2 = new ArrayList<Testando>();
		Testando tst4 = new Testando();
		tst4.setValue("primero");
		list2.add(tst4);

		Testando tst5 = new Testando();
		tst5.setValue("segundo");
		list2.add(tst5);
		
		Testando tst6 = new Testando();
		tst6.setValue("tercero");
		list2.add(tst6);
		
		
		for (Testando testando : list) {
			int index = list.indexOf(testando);
			testando.setValue("Valor: "+ (index+1) +" - "+list.get(index));
		}
		
		for (Testando testando : list) {
			System.out.println(testando.toString());
		}
	}

	private class Testando {
		private String value;

		public Testando() {
		}
		
		public void setValue(String value){
			this.value = value;
		}
		public String toString(){
			return this.value;
		}
	}
	
}

class Outer_Demo {
	   int num;
	   
	   // inner class
	   private class Inner_Demo {
	      public void print() {
	         System.out.println("This is an inner class");
	      }
	   }
	   
	   // Accessing he inner class from the method within
	   void display_Inner() {
	      Inner_Demo inner = new Inner_Demo();
	      inner.print();
	   }
	}
