package com.flexpag.paymentscheduler.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.flexpag.paymentscheduler.domain.Agendamento;
import com.flexpag.paymentscheduler.domain.dtos.AgendamentoDTO;
import com.flexpag.paymentscheduler.domain.enuns.Status;
import com.flexpag.paymentscheduler.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public Agendamento findById(long id) {
		Optional<Agendamento> obj = agendamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id, null));
	}

	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
	}

	public Agendamento create(AgendamentoDTO objDTO) {
		objDTO.setStatus(Status.PENDING);
		Agendamento newObj = new Agendamento(objDTO);
		return agendamentoRepository.save(newObj);
	}

	public Agendamento update(long id, @Validated AgendamentoDTO objDTO) {

		if (agendamentoRepository.existsById(id)) {
			Agendamento oldObj = findById(id);
			if (oldObj.getStatus().equals(Status.PENDING)) {
				oldObj.setDataHora(objDTO.getDataHora());
				return agendamentoRepository.save(oldObj);

			} else {
				throw new RuntimeException("Operação não permitida, Status PAID.");
			}
		} else {
			throw new org.springframework.dao.DataIntegrityViolationException("Agendamento não Encontrado");
		}

	}

	public Agendamento pagar(long id) {

		if (agendamentoRepository.existsById(id)) {
			Agendamento oldObj = findById(id);
			if (oldObj.getStatus().equals(Status.PENDING)) {
				oldObj.setStatus(Status.PAID);
				return agendamentoRepository.save(oldObj);
			} else {
				throw new RuntimeException("Operação não permitida, Status PAID.");
			}

		} else {
			throw new org.springframework.dao.DataIntegrityViolationException("Agendamento não Encontrado");
		}

	}

	public void delete(Long id) {

		if (agendamentoRepository.existsById(id)) {
			Agendamento obj = findById(id);
			if (obj.getStatus().equals(Status.PENDING)) {
				agendamentoRepository.deleteById(id);

			} else {
				throw new RuntimeException("Operação não permitida, Status PAID.");

			}

		} else {
			throw new org.springframework.dao.DataIntegrityViolationException("Agendamento não Encontrado");
		}
	}
}
