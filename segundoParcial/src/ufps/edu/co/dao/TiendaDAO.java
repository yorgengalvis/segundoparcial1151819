package ufps.edu.co.dao;

import ufps.edu.co.model.Tienda;

public class TiendaDAO extends Conexion<Tienda> implements GenericDao<Tienda>{
	public TiendaDAO() {
		super(Tienda.class);
	}
}
