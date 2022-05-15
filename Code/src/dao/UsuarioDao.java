package dao;




import java.sql.Connection;
import java.sql.ResultSet;

import beans.Usuario;
import conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import daoI.UsuarioDaoI;

public class UsuarioDao implements UsuarioDaoI{
	
	

	@Override
	public boolean insertarUsuario(Usuario u) {
		
		return true;
	}

	@Override
	public Usuario buscar(String usuario) throws SQLException {
		
		Connection c = Conexion.getConnection();
		Usuario salida;
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select * from usuarios where usuario = '"+usuario+"';");
		if (result.next()) {
		    do {
		      salida = new Usuario(result.getString("usuario"),result.getString("contraseña"));
		    } while(result.next());
		} else {
		    salida = null;
		}
		c.close();
		return salida;
	}
	
	@Override
	public int add(Usuario usuario) throws SQLException {
		
		Connection c = Conexion.getConnection();
		Statement st = c.createStatement();
		String sql = "INSERT INTO usuarios VALUES ('"+usuario.getUser()+"','"+usuario.getPass()+"')";
		
		int act = st.executeUpdate(sql);
		
		return act;
	}
	
	@Override
	public Usuario buscar(String usuario,String pass) throws SQLException {
		
		Connection c = Conexion.getConnection();
		Usuario salida;
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select * from usuarios where usuario = '"+usuario+"' and contraseña ='"+pass+"';");
		if (result.next()) {
		    do {
		      salida = new Usuario(result.getString("usuario"),result.getString("contraseña"));
		    } while(result.next());
		} else {
		    salida = null;
		}
		c.close();
		return salida;
	}


}
