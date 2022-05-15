package beans;

public class Estados {
	
	private Integer idestado;
	private String nenvio ;
	private String estado ;
	private String fecha ;
	
	public Estados(Integer idestado, String nenvio, String estado, String fecha) {
		super();
		this.idestado = idestado;
		this.nenvio = nenvio;
		this.estado = estado;
		this.fecha = fecha;
	}

	public Estados() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdestado() {
		return idestado;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
	}

	public String getNenvio() {
		return nenvio;
	}

	public void setNenvio(String nenvio) {
		this.nenvio = nenvio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return " Nºenvio= " + nenvio + ", Estado: " + estado + ", " + fecha + "\n";
	}
	
	
	

}
