package pojo;

import java.util.List;

public class PojoConListaJSon {
	
	private String codigo;
	private String descripcion;
	private List<JSonPojo> listaJson;
	
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
	
	public List<JSonPojo> getListaJson() {
		return listaJson;
	}
	
	public void setListaJson(List<JSonPojo> listaJson) {
		this.listaJson = listaJson;
	}
}
