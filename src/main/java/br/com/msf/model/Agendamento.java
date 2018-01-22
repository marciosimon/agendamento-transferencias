package br.com.msf.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidade Agendamento
 * 
 * @author Márcio Simon
 */
@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CONTA_ORIGEM", referencedColumnName = "id")
	public Conta contaOrigem;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CONTA_DESTINO", referencedColumnName = "id")
	public Conta contaDestino;
	
    @NotNull
    @Column(name="VALOR")
	public float valor;

    @NotNull
    @Column(name="TAXA")
	public float taxa;

    @NotNull
    @Column(name="DATA_TRANSFERENCIA")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    public LocalDate dataTransferencia;

    @NotNull
    @Column(name="DATA_AGENDAMENTO")
    @DateTimeFormat(pattern="dd/MM/yyyy")
	public LocalDate dataAgendamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
}