package com.flexpag.paymentscheduler.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.domain.Agendamento;
import com.flexpag.paymentscheduler.domain.dtos.AgendamentoDTO;
import com.flexpag.paymentscheduler.service.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendmentoController {
	@Autowired
	private AgendamentoService service;

	@GetMapping
	public ResponseEntity<List<AgendamentoDTO>> findAll() {
		List<Agendamento> list = service.findAll();
		List<AgendamentoDTO> listDTO = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AgendamentoDTO> finById(@PathVariable Long id) {
		Agendamento obj = service.findById(id);
		return ResponseEntity.ok().body(new AgendamentoDTO(obj));
	}

	@PostMapping
	public ResponseEntity<Long> post(@Validated @RequestBody AgendamentoDTO objDTO) {

		Agendamento newObj = service.create(objDTO);
		return ResponseEntity.ok(newObj.getId());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AgendamentoDTO> update(@PathVariable(value = "id") long id,
			@Validated @RequestBody AgendamentoDTO objDTO) {
		Agendamento obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AgendamentoDTO(obj));
	}

	@PutMapping(value = "/pagar/{id}")
	public ResponseEntity<AgendamentoDTO> pagar(@PathVariable(value = "id") long id){
		Agendamento obj = service.pagar(id);
		return ResponseEntity.ok().body(new AgendamentoDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
}
