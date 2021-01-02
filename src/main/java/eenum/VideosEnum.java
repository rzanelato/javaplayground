package eenum;

public enum VideosEnum {
	
	AVI(".avi"),
	RMVB(".rmvb"),
	MKV(".mkv"),
	MP1(".mp1"),
	MP2(".mp2"),
	MP3(".mp3"),
	MP4(".mp4");
	
	private String extensao;
	
	private VideosEnum(String extensao) {
		this.extensao = extensao;
	}
	
	public String value(){
		return this.extensao;
	}
}
