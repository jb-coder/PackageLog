package daoI;

import java.sql.SQLException;
import java.util.List;

import beans.DatosEnvio;

public interface DatosEnvioDaoI {

	DatosEnvio buscar(String nenvio) throws SQLException;

	int addEnvio(DatosEnvio datos) throws SQLException;

	List<DatosEnvio> sacarTodos() throws SQLException;

}
