package pojo;

public class JSonPojo {

	private String sociedad;
	private String identificador;
	private String promocion;
	//private String cartel;
	private String estado;
	private String tipoCarteleria;
	private String tipologiaKO;
	private String fechaColocacion;
	private String usuario;
	
	public String getSociedad() {
		return sociedad;
	}
	
	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getPromocion() {
		return promocion;
	}
	
	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}
	
	/*public String getCartel() {
		return cartel;
	}
	
	public void setCartel(String cartel) {
		this.cartel = cartel;
	}*/
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getTipoCarteleria() {
		return tipoCarteleria;
	}
	
	public void setTipoCarteleria(String tipoCarteleria) {
		this.tipoCarteleria = tipoCarteleria;
	}
	
	public String getTipologiaKO() {
		return tipologiaKO;
	}
	
	public void setTipologiaKO(String tipologiaKO) {
		this.tipologiaKO = tipologiaKO;
	}
	
	public String getFechaColocacion() {
		return fechaColocacion;
	}
	
	public void setFechaColocacion(String fechaColocacion) {
		this.fechaColocacion = fechaColocacion;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "JSonPojo [sociedad=" + sociedad + ", identificador=" + identificador + ", promocion=" + promocion
				//+ ", cartel=" + cartel 
				+", estado=" + estado + ", tipoCarteleria=" + tipoCarteleria + ", tipologiaKO="
				+ tipologiaKO + ", fechaColocacion=" + fechaColocacion + ", usuario=" + usuario + "]";
	}
	
}