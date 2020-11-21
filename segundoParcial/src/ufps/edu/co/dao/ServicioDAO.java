package ufps.edu.co.dao;

import ufps.edu.co.model.Servicio;

public class ServicioDAO extends Conexion<Servicio> implements GenericDao<Servicio> {
public ServicioDAO() {
	super(Servicio.class);
}
}
