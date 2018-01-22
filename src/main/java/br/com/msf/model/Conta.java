package br.com.msf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Entidade Conta
 * 
 * @author Márcio Simon
 */
@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @NotNull
    @Column(name="NUMERO")
	private String numero;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CLIENTE", referencedColumnName = "id")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}