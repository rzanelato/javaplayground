package castor;

public class InmuebleImageAppFotos {
	
	private String codigo;
	private String provincia;
	private String codigoPostal;
	private String tipoVia;
	private String direccion;
	private String escalera;
	private String piso;
	private String puerta;
	private String poblacion;
	private String tipo;
	private Integer numFotos;
	private String coordenadaX;
	private String coordenadaY;
	private String textoLista;
	private String textoDetalle;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEscalera() {
		return escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNumFotos() {
		return numFotos;
	}

	public void setNumFotos(Integer numFotos) {
		this.numFotos = numFotos;
	}

	public String getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(String coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public String getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(String coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public String getTextoLista() {
		return textoLista;
	}

	public void setTextoLista(String textoLista) {
		this.textoLista = textoLista;
	}

	public String getTextoDetalle() {
		return textoDetalle;
	}

	public void setTextoDetalle(String textoDetalle) {
		this.textoDetalle = textoDetalle;
	}

	@Override
	public String toString() {
		return "inmuebles [codigo=" + codigo +", provincia=" + provincia + ", codigoPostal=" + codigoPostal + ", tipoVia=" + tipoVia + ", direccion=" + direccion + ", escalera=" + escalera 
				+ ", piso=" + piso + ", puerta=" + puerta + ", poblacion=" + poblacion + ", tipo=" + tipo + ", numFotos=" + numFotos + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY 
				+ ", textoLista=" + textoLista + ", textoDetalle=" + textoDetalle + "]";
	}
	
}
