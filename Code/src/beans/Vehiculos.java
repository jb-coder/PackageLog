package beans;

import java.util.List;

public class Vehiculos {
	
	private Integer id;
	private String matricula;
	private String rutaDesde;
	private String rutaHasta;
	private String fechaAlta;
	private String fechaBaja;
	private List<CargaVehiculos> carga;
	
	
	
	public Vehiculos(Integer id, String matricula, String rutaDesde, String rutaHasta, String fechaAlta,
			String fechaBaja) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.rutaDesde = rutaDesde;
		this.rutaHasta = rutaHasta;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	public Vehiculos() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getRutaDesde() {
		return rutaDesde;
	}
	public void setRutaDesde(String rutaDesde) {
		this.rutaDesde = rutaDesde;
	}
	public String getRutaHasta() {
		return rutaHasta;
	}
	public void setRutaHasta(String rutaHasta) {
		this.rutaHasta = rutaHasta;
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
	public List<CargaVehiculos> getCarga() {
		return carga;
	}
	public void setCarga(List<CargaVehiculos> carga) {
		this.carga = carga;
	}
	
	

}
