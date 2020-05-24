package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{

	@Autowired
	ContribuyenteDAO contribuyenteDao;
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDao.findAll();
	}

	@Override
	public Contribuyente findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDao.findOne(codigo);
	}

	@Override
	public void insertar(Contribuyente c) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDao.insertar(c);
	}

}
