package service;

import java.sql.SQLException;

import beans.Usuario;
import dao.UsuarioDao;

public class ServiceLogin {

	private UsuarioDao usrdao =  new UsuarioDao() ;

	public String nuevaAlta(String user, String pass) {

		Usuario nuevo = new Usuario(user, pass);
	
		int ok = 0;

		Usuario existente = null;
		try {
			existente = usrdao.buscar(nuevo.getUser());
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (existente == null) {
			try {
				ok = usrdao.add(nuevo);
				if (ok != 0) {
					return "Usuario dado de alta correctamente";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error en la base de datos";
			
			}
		}
			return "Ya existe este usuario";
		

	}
	
	public String comprobar(String user, String pass) {

		Usuario existente = null;
		try {
			existente = usrdao.buscar(user,pass);
		} catch (SQLException e) {

			e.printStackTrace();
			return "Error Base de datos";
		}

		if (existente != null) {
			
					return "OK";
				}
			 
		
			return "Usuario o pass incorrectos";
		

	}

}
