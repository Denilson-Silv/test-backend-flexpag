package com.flexpag.paymentscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.paymentscheduler.domain.Agendamento;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>  {

}
