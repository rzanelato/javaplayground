package castor;

public class RespuestaConsultaImagenAppFotos {

	private String codigo;
	private String descripcion;
	private Integer page;
	private Integer pages;
	private Integer results;
	private InmuebleImageAppFotos[] inmuebles;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getResults() {
		return results;
	}

	public void setResults(Integer results) {
		this.results = results;
	}

	public InmuebleImageAppFotos[] getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(InmuebleImageAppFotos[] inmuebles) {
		this.inmuebles = inmuebles;
	}

	@Override
	public String toString() {
		return "respuesta [page=" + page + ", pages=" + pages + ", results=" + results + ", inmuebles [" + inmuebles + "] ]";
	}

}
