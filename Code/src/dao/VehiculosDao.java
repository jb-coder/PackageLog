package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.CargaVehiculos;

import beans.Vehiculos;
import conexion.Conexion;
import daoI.VehiculosDaoI;

public class VehiculosDao implements VehiculosDaoI {

	@Override
	public Vehiculos buscar(String matricula) throws SQLException {

		Connection c = Conexion.getConnection();
		Vehiculos salida = null ;
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select * from vehiculos where matricula = '" + matricula + "' ;");

		if (result.next()) {
			do {
				salida = new Vehiculos(result.getInt("idvehiculo"), result.getString("matricula"),
						result.getString("rutadesde"), result.getString("rutahasta"), result.getString("fechaAlta"),
						result.getString("fechaBaja"));
			} while (result.next());
			
		}
		else {
			c.close();
			return salida;
		}
		
		salida.setCarga(sacarCarga(salida.getId()));
		
		c.close();
		return salida;
	}
	
	public List<CargaVehiculos> sacarCarga(int id) throws SQLException {

		Connection c = Conexion.getConnection();
		List<CargaVehiculos> salidalista = new ArrayList<CargaVehiculos>();
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(
				"select * from cargavehiculos where idvehiculo = " + id + " and fechaBaja is null ;");
		if (result.next()) {
			do {
				CargaVehiculos carga = new CargaVehiculos(result.getInt("idcarga"), result.getString("nenvio"),
						id, result.getString("fechaAlta"), result.getString("fechaBaja"));
				salidalista.add(carga);
			} while (result.next());
			st.close();
		}
		else {
			c.close();
			return salidalista;
		}

		
		c.close();
		return salidalista;
	}
	

	@Override
	public int addVehiculo(Vehiculos vehiculo) throws SQLException {
		Connection c = Conexion.getConnection();
		Statement st = c.createStatement();
		int id = 1;

		ResultSet result = st.executeQuery("select max(idvehiculo) + 1 as id from vehiculos");
		if (result.next()) {
			do {
				id = result.getInt("id");
			} while (result.next());
		}

		String sql = "INSERT INTO vehiculos VALUES (" + id + ",'" + vehiculo.getMatricula() + "','"
				+ vehiculo.getRutaDesde() + "','" + vehiculo.getRutaHasta() + "',now(),null)";

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public int addCarga(CargaVehiculos carga) throws SQLException {
		Connection c = Conexion.getConnection();
		Statement st = c.createStatement();

		int id = 1;

		ResultSet result = st.executeQuery("select max(idcarga) + 1 as id from cargavehiculos");
		if (result.next()) {
			do {
				id = result.getInt("id");
			} while (result.next());
		}

		String sql = "INSERT INTO cargavehiculos VALUES (" + id + ",'" + carga.getNenvio() + "',"
				+ carga.getIdVehiculo() + ",now(),null)";

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public int quitarCarga(int id) throws SQLException {
		Connection c = Conexion.getConnection();
		Statement st = c.createStatement();

		String sql = "update cargavehiculos set fechaBaja = now() where idCarga = " + id ;

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public int quitarVehiculo(String matricula) throws SQLException {
		Connection c = Conexion.getConnection();
		Statement st = c.createStatement();

		String sql = "update vehiculos set fechaBaja = now() where matricula = '" + matricula+"'" ;

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public int modificarVehiculo(String matricula, String desde, String hasta) throws SQLException {
		Connection c = Conexion.getConnection();
		Statement st = c.createStatement();

		String sql = "update vehiculos set rutadesde = '" + desde + "', rutahasta= '" + hasta + "' where matricula = '"	+ matricula+"'" ;
		System.out.println(sql);

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public List<Vehiculos> clasificar(String cpDestino) throws SQLException {

		Connection c = Conexion.getConnection();
		Vehiculos salida = null;
		List<Vehiculos> salidalista = new ArrayList<Vehiculos>();
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select * from vehiculos where rutadesde<= '" + cpDestino + "'and rutahasta>='"
				+ cpDestino + "' and fechaBaja is null ");

		if (result.next()) {
			do {
				salida = new Vehiculos(result.getInt("idvehiculo"), result.getString("matricula"),
						result.getString("rutadesde"), result.getString("rutahasta"), result.getString("fechaAlta"),
						result.getString("fechaBaja"));
				salidalista.add(salida);

			} while (result.next());
		} else {
			c.close();
			return salidalista;
		}
		c.close();
		return salidalista;
	}

	public List<String> enviosEnVehiculos() throws SQLException{
		Connection c = Conexion.getConnection();
		
		List<String> salidalista = new ArrayList<String>();
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select nenvio from cargavehiculos where fechaBaja is null");

		if (result.next()) {
			do {
				String salida =result.getString("nenvio");
				salidalista.add(salida);

			} while (result.next());
		} else {
			c.close();
			return salidalista;
		}
		c.close();
		return salidalista;
	}


}
