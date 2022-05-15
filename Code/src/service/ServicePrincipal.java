package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CargaVehiculos;
import beans.DatosEnvio;
import beans.Estados;
import beans.Vehiculos;
import dao.DatosEnvioDao;
import dao.EstadosDao;
import dao.VehiculosDao;

public class ServicePrincipal {

	EstadosDao eDao = new EstadosDao();
	DatosEnvioDao deDao = new DatosEnvioDao();
	VehiculosDao fuDao = new VehiculosDao();

	public List<Estados> historico(String nenvio) {

		List<Estados> estados = new ArrayList<Estados>();

		try {
			estados = eDao.buscar(nenvio);
		} catch (SQLException e) {
			return estados;
		}
		return estados;
	}

	public String entradaEstado(String estado, String nenvio,String origen) {

		List<Estados> estados = new ArrayList<Estados>();
		estados = historico(nenvio);
		int respuesta = 0;

		for (Estados e : estados) {
			if (e.getEstado().equals("Entregado")) {
				return "El paquete ya ha sido entregado no se puede modificar su estado";
			}
		}
		
		List<String> envios = enviosEnVehículos();
		
		for (String de: envios) {
			if(de.equals(nenvio) && !origen.equals("Clasificador") && estado.equals("Entregado") ) {
				return "No puedes entregar un paquete sin bajarlo del vehículo";
			}
		}

		try {
			respuesta = eDao.addEstado(estado, nenvio);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (respuesta != 0) {
			return "Añadido un nuevo estado al envio:" + estado;
		}
		return "";

	}

	public DatosEnvio BuscarEnvio(String nenvio) {
		DatosEnvio salida = new DatosEnvio();

		try {
			salida = deDao.buscar(nenvio);
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}

	public String altaEnvio(DatosEnvio envio) {

		int respuesta = 0;

		try {
			respuesta = deDao.addEnvio(envio);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (respuesta != 0) {
			entradaEstado("Entrada en el sistema", envio.getNenvio(),"Pantalla");
			return "Envio dado de entrada: su numero de envio es : " + envio.getNenvio();
		}
		return "";

	}

	public Vehiculos buscarVehiculos(String matricula) {

		Vehiculos salida = null;

		try {
			salida = fuDao.buscar(matricula);
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}

	public String eliminarVehículos(String matricula) {

		
		int funciono = 0;

		try {
			funciono = fuDao.quitarVehiculo(matricula);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (funciono != 0) {
			return "OK vehículo dado de baja";
		}

		else {
			return "Ha ocurrido un error";
		}

	}

	public String entradaVehiculo(String matricula, String desde, String hasta) {

		Vehiculos f = new Vehiculos(null, matricula, desde, hasta, null, null);

		
		int funciono = 0;

		Vehiculos f2 = buscarVehiculos(matricula);
		if (f2 == null) {

			try {
				funciono = fuDao.addVehiculo(f);
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error en la base de datos";
			}
			if (funciono != 0) {
				return "OK Furgoneta dada de alta";
			}

			else {
				return "Ha ocurrido un error";
			}
		} else {
			return "Ya hay un vehículo con esa matricula";
		}

	}

	public String EliminarCarga(int id, String nenvio) {

		
		int funciono = 0;

		try {
			funciono = fuDao.quitarCarga(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (funciono != 0) {
			entradaEstado("Envio bajado del vehículo",nenvio,"PDA");
			return "Mercancia dada de baja";
		}

		else {
			return "Ha ocurrido un error";
		}

	}

	public String modificarVehiculo(String matricula, String desde, String hasta) {

		
		int a = 0;

		try {
			a = fuDao.modificarVehiculo(matricula, desde, hasta);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (a != 0) {
			return "OK vehículo modificado correctamente";
		}

		else {
			return "Ha ocurrido un error";
		}

	}

	public List<DatosEnvio> buscarTodosEnvios() {

		List<DatosEnvio> salida = new ArrayList<DatosEnvio>();

		try {
			salida = deDao.sacarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}
	
	public List<String> enviosEnVehículos() {

		List<String> salida = new ArrayList<String>();

		try {
			salida = fuDao.enviosEnVehiculos();
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}

	public List<Vehiculos> clasificar(String cp) {

		List<Vehiculos> salida = new ArrayList<Vehiculos>();

		try {
			salida = fuDao.clasificar(cp);
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}

	public String addCarga(String nenvio, int id) {

		CargaVehiculos subir = new CargaVehiculos(null, nenvio, id, null, null);
		int resultado = 0;

		try {
			resultado = fuDao.addCarga(subir);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (resultado != 0) {
			entradaEstado("Envio añadido a vehículo: "+id,nenvio,"Clasificador");
			return "OK Carga añadida correctamente";
		}
		else{
			return "ha ocurrido un error";
		}

	}

}
