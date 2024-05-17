package com.example.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.dto.AgendamentoDTO;
import com.example.projeto.service.AgendamentoService;


@RestController
@RequestMapping(value = "/agendamento")
@CrossOrigin
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@GetMapping
	public List<AgendamentoDTO> listarTodos() {
		return agendamentoService.listarTodos();
	}
	
	@PostMapping
	public void inserir(@RequestBody AgendamentoDTO agendamento) {
		agendamentoService.inserir(agendamento);
	}
	
	@PutMapping
	public AgendamentoDTO alterar(@RequestBody AgendamentoDTO agendamento) {
		return agendamentoService.alterar(agendamento);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		agendamentoService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
