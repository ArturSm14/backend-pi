package com.example.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto.dto.AgendamentoDTO;
import com.example.projeto.entity.AgendamentoEntity;
import com.example.projeto.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<AgendamentoDTO> listarTodos() {
		List<AgendamentoEntity> agendamentos = agendamentoRepository.findAll();
		return agendamentos.stream().map(AgendamentoDTO:: new).toList();
	}
	
	public void inserir(AgendamentoDTO agendamento) {
		AgendamentoEntity agendamentoEntity = new AgendamentoEntity(agendamento);
		agendamentoRepository.save(agendamentoEntity);
	}
	
	public AgendamentoDTO alterar(AgendamentoDTO agendamento) {
		AgendamentoEntity agendamentoEntity = new AgendamentoEntity(agendamento);
		return new AgendamentoDTO(agendamentoRepository.save(agendamentoEntity));
		
	}
	
	public void excluir(Long id) {
		AgendamentoEntity agendamento = agendamentoRepository.findById(id).get();
		agendamentoRepository.delete(agendamento);
	}
}
