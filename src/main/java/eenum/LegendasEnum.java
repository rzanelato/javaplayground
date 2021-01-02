package eenum;

public enum LegendasEnum {
	
	SRT(".srt"),
	SUB(".sub");
	
	private String extensao;
	
	private LegendasEnum(String extensao) {
		this.extensao = extensao;
	}
	
	public String value(){
		return this.extensao;
	}
}
