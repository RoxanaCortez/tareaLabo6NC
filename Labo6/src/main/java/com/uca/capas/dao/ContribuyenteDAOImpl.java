package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	
	//Método para obtener todos los contribuyentes
	@Override
	public List<Contribuyente> findAll() throws DataAccessException { 
		StringBuffer sb = new StringBuffer();    //objeto StringBuffer
		sb.append("select * from public.contribuyente");	//definiendo consulta
		Query query = entityManager.createNativeQuery(sb.toString(),Contribuyente.class);
		List<Contribuyente>resulset=query.getResultList();	//obtenemos lista de contribuyentes
		return resulset;
	}
	
	@Override
	public Contribuyente findOne(Integer codigo) throws DataAccessException {
		Contribuyente c = entityManager.find(Contribuyente.class, codigo);
		return c;
	}
	
	//Método para insertar un nuevo contribuyente
	@Override
	@Transactional
	public void insertar(Contribuyente c) throws DataAccessException {
		
		if(c.getCodigo_c() == null) { //Si llave primaria viene vacío, entonces es un INSERT
			entityManager.persist(c); //Utilizamos persist
		}
		else { //Caso contrario, se buscó al contribuyente
			entityManager.merge(c); //Utilizamos merge ya que es un UPDATE
		}
		
	}
}
