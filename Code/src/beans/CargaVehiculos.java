package beans;

public class CargaVehiculos {
	
	private Integer id;
	private String nenvio;
	private Integer idVehiculo;
	private String fechaAlta;
	private String fechaBaja;
	
	
	public CargaVehiculos(Integer id,String nenvio,Integer idVehiculo, String fechaAlta, String fechaBaja) {
		super();
		this.id=id;
		this.nenvio = nenvio;
		this.idVehiculo=idVehiculo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	
	public CargaVehiculos() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNenvio() {
		return nenvio;
	}
	public void setNenvio(String nenvio) {
		this.nenvio = nenvio;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	@Override
	public String toString() {
		return "Numero envio=" + nenvio + ", Fecha de Alta=" + fechaAlta ;
	}
	
	
	

}
