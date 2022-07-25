package com.uce.edu.demo.repository.modelo.onetomany;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@Column(name="pedi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedi_id_seq")
	@SequenceGenerator(name = "pedi_id_seq", sequenceName = "pedi_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="pedi_numero")
	private String numero;
	@Column(name="pedi_fecha")
	private LocalDateTime fecha;
	@Column(name="pedi_costo")
	private String costo;
	
	@ManyToOne
	@JoinColumn(name = "pedi_id_cliente")
	private Cliente cliente;

	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", costo=" + costo + ", cliente="
				+ cliente + "]";
	}

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
