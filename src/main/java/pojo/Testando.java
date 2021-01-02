package pojo;

public class Testando {
	private String value;
	private Number number;
	
	public Testando() {
	}
	
	public String toString(){
		return this.value;
	}
	public void setValue(String value){
		this.value = value;
	}
	public Number getNumber(){
		return this.number;
	}
	
	public void setNumber(Number number){
		this.number = number;
	}
	
}