package ufps.edu.co.dao;

import ufps.edu.co.model.Seguir;

public class SeguirDAO extends Conexion<Seguir> implements GenericDao<Seguir>{
public SeguirDAO() {
	super(Seguir.class);
}
}
