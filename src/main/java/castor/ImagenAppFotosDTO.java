package castor;

public class ImagenAppFotosDTO {

	private String id;
	private String user;
	private String token;
	private String tag;
	private String subtag;
	private String tipologia;
	private String nombre;
	private byte[] content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSubtag() {
		return subtag;
	}

	public void setSubtag(String subtag) {
		this.subtag = subtag;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ImagenAppFotos [id=" + id +", user=" + user + ", token=" + token + ", tag=" + tag + ", subtag=" + subtag + ", tipologia=" + tipologia + ", nombre=" + nombre + "]";
	}
	
}