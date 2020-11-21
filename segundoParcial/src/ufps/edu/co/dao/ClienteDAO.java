package ufps.edu.co.dao;

import ufps.edu.co.model.Cliente;

public class ClienteDAO extends Conexion<Cliente> implements GenericDao<Cliente>{
public ClienteDAO() {
	super(Cliente.class);
}
}
