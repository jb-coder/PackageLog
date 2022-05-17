package dao;




import java.sql.Connection;
import java.sql.ResultSet;

import beans.DatosEnvio;

import conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daoI.DatosEnvioDaoI;


public class DatosEnvioDao implements DatosEnvioDaoI{
	
	



	@Override
	public DatosEnvio buscar(String nenvio) throws SQLException {
		
		Connection c = Conexion.getConnection();
		DatosEnvio salida;
	
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select * from envios where nenvio = '"+nenvio+"';");
		if (result.next()) {
		    do {
		      salida = new DatosEnvio();
		      salida.setCliente(result.getString("cliente"));
		      salida.setCpDestino(result.getString("cpDestino"));
		      salida.setCpOrigen(result.getString("cpOrigen"));
		      salida.setDestinatario(result.getString("destinatario"));
		      salida.setDireccion(result.getString("direccion"));
		      salida.setLocalidadDestino(result.getString("localidadDestino"));
		      salida.setLocalidadOrigen(result.getString("localidadOrigen"));
		      salida.setNenvio(result.getString("nenvio"));
		      salida.setObservaciones(result.getString("observaciones"));
		      salida.setVolumen(result.getDouble("peso"));
		      salida.setPeso(result.getDouble("volumen"));
		   
		    } while(result.next());
		} else {
			c.close();
			 return null;
		}
		c.close();
		return salida;
	}
	
	@Override
	public int addEnvio(DatosEnvio datos) throws SQLException {
		
		Connection c = Conexion.getConnection();
		Statement st = c.createStatement();

		
	
		
		String sql = "INSERT INTO envios VALUES ('"+datos.getNenvio()+"','"+datos.getCliente()+"','"+datos.getCpOrigen()+"','"
		+datos.getLocalidadOrigen()+"','"+datos.getCpDestino()+"','"+datos.getLocalidadDestino()+"','"+datos.getDestinatario()+"','"+datos.getDireccion()
		+"','"+datos.getObservaciones()+"',"+datos.getPeso()+","+datos.getVolumen()+")";
		
		int act = st.executeUpdate(sql);
		
		return act;
	}
	
	@Override
	public List<DatosEnvio> sacarTodos() throws SQLException {
		
		Connection c = Conexion.getConnection();
		DatosEnvio salida;
		List<DatosEnvio> salidalista = new ArrayList<DatosEnvio>();
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM envios WHERE nenvio NOT IN (SELECT nenvio FROM estados WHERE estado='Entregado')"
				+ "AND nenvio NOT IN (SELECT nenvio FROM cargavehiculos WHERE fechaBaja IS NULL) ORDER BY cpDestino desc");
		if (result.next()) {
		    do {
		    	 salida = new DatosEnvio();
			      salida.setCliente(result.getString("cliente"));
			      salida.setCpDestino(result.getString("cpDestino"));
			      salida.setCpOrigen(result.getString("cpOrigen"));
			      salida.setDestinatario(result.getString("destinatario"));
			      salida.setDireccion(result.getString("direccion"));
			      salida.setLocalidadDestino(result.getString("localidadDestino"));
			      salida.setLocalidadOrigen(result.getString("localidadOrigen"));
			      salida.setNenvio(result.getString("nenvio"));
			      salida.setObservaciones(result.getString("observaciones"));
			      salida.setVolumen(result.getDouble("peso"));
			      salida.setPeso(result.getDouble("volumen"));
			      salidalista.add(salida);
		    } while(result.next());
		} else {
			c.close();
			return salidalista;
		}
		c.close();
		return salidalista;
	}
	

}
