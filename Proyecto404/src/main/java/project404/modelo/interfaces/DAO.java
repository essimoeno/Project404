package project404.modelo.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DAO<E,T> { // E para que me pasen el objeto y T para que me pasen el id

	// Estos son lso m�todos que tienen que estar en todos los DAO
	public boolean create(E obj) throws SQLException; // Creo el objeto
	public E read(T id) throws SQLException; // Leo el objeto
	public boolean delete(E obj) throws SQLException; // Borro el objeto
	public boolean update(E obj) throws SQLException; // Actualizo el objeto
	public List<E> getValues() throws SQLException; // Coger todos (rellenamos un combo)
	public E getValuesById(T id) throws SQLException; // Coger por id (est� un poco feo porque pone values y solo devuelve uno)
	
}