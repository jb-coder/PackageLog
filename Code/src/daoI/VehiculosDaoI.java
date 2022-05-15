package daoI;

import java.sql.SQLException;
import java.util.List;

import beans.CargaVehiculos;
import beans.Vehiculos;

public interface VehiculosDaoI {

	Vehiculos buscar(String matricula) throws SQLException;

	int addVehiculo(Vehiculos vehiculo) throws SQLException;

	int addCarga(CargaVehiculos carga) throws SQLException;


	int modificarVehiculo(String matricula, String desde, String hasta) throws SQLException;

	int quitarVehiculo(String matricula) throws SQLException;

	List<Vehiculos> clasificar(String cpDestino) throws SQLException;

	int quitarCarga(int id) throws SQLException;

	

}
