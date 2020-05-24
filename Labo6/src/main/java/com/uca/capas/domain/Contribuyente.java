package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(generator="contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contribuyente_c_contribuyente_seq", sequenceName = "public.contribuyente_c_contribuyente_seq", allocationSize = 1)
	private Integer codigo_c;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	@Column(name="s_nombre")
	@Size(message="El nombre no debe tener mas de 30 caracteres", max = 30)
	private String nombre;
	
	@Column(name="s_apellido")
	@Size(message="El apellido no debe tener mas de 30 caracteres", max = 30)
	private String apellido;
	
	@Column(name="s_nit")
	@Pattern(regexp="\\d{14}", message = "El campo Nit debe tener 14 dígitos.")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private Date fecha;
	
	public Integer getCodigo_c() {
		return codigo_c;
	}
	public void setCodigo_c(Integer codigo_c) {
		this.codigo_c = codigo_c;
	}
	public Importancia getImportancia() {
		return importancia;
	}
	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Contribuyente(){
		super();
	}
	
	public String getFechaDelegate(){
		if(this.fecha == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String shortdate = sdf.format(this.fecha.getTime());
			return shortdate;
		}
	}
}
