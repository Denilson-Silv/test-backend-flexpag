package com.flexpag.paymentscheduler.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.flexpag.paymentscheduler.domain.dtos.AgendamentoDTO;
import com.flexpag.paymentscheduler.domain.enuns.Status;

@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	
	private LocalDateTime dataHora ;
	

	private Status status;
	

	public Agendamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agendamento(AgendamentoDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataHora = obj.getDataHora();
		this.status = obj.getStatus();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
