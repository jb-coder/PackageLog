package daoI;

import java.sql.SQLException;
import java.util.List;

import beans.Estados;

public interface EstadosDaoI {

	List<Estados> buscar(String nenvio) throws SQLException;

	int addEstado(String estado, String nenvio) throws SQLException;

}
