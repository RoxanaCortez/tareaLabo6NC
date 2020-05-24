package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (schema = "public", name = "importancia")
public class Importancia {
	
	@Id
	@Column(name = "c_importacnia")
	private Integer codigo_i;
	
	@Column(name = "s_importancia")
	private String	importancia;

	public Integer getCodigo_i() {
		return codigo_i;
	}

	public void setCodigo_i(Integer codigo_i) {
		this.codigo_i = codigo_i;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
	
	public Importancia() {
		super();
	}
}
