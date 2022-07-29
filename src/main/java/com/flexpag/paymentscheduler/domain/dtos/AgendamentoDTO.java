package com.flexpag.paymentscheduler.domain.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flexpag.paymentscheduler.domain.Agendamento;
import com.flexpag.paymentscheduler.domain.enuns.Status;

public class AgendamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataHora ;
	private Status status;



	public AgendamentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgendamentoDTO(Agendamento obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataHora = obj.getDataHora();
		this.status = obj.getStatus();
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
