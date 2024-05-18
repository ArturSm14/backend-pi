package com.example.projeto.dto;



import java.util.Date;

import org.springframework.beans.BeanUtils;
import com.example.projeto.entity.AgendamentoEntity;
import com.example.projeto.entity.AgendamentoEntity.Status;



public class AgendamentoDTO {
	
	private Long id;
	private String nomePaciente;
	private String medico;
	private String clinica;
	private String email;
	private String dataConsulta;
	private Status status;
	
	public AgendamentoDTO(AgendamentoEntity agendamento) {
		BeanUtils.copyProperties(agendamento, this);
	}
	
	public AgendamentoDTO() {
		
	}

	public String getDataConsulta() {
		return dataConsulta;
	}
	
	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	

}
