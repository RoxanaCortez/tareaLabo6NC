package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	
	//Método para obtener todas las importancias
	@Override
	public List<Importancia> findAll() throws DataAccessException { 
		StringBuffer sb = new StringBuffer();    //objeto StringBuffer
		sb.append("select * from public.importancia");	//definiendo consulta
		Query query = entityManager.createNativeQuery(sb.toString(),Importancia.class);
		List<Importancia>resulset=query.getResultList();	//obtenemos lista de importancias
		return resulset;
	}
	
	@Override
	public Importancia findOne(Integer codigo) throws DataAccessException {
		Importancia i = entityManager.find(Importancia.class, codigo);
		return i;
	}
}
