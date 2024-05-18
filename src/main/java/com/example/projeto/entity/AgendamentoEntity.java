package com.example.projeto.entity;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.example.projeto.dto.AgendamentoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CONSULTAS")
public class AgendamentoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nomePaciente;
	
	@Column(nullable = false)
	private String medico;
	
	@Column(nullable = false)
	private String clinica;
	
	@Column(nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        AGENDADO,
        CANCELADO,
        REALIZADO
    }
	
	
    private String dataHoraAgendamento;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	public AgendamentoEntity(AgendamentoDTO agendamento) {
		BeanUtils.copyProperties(agendamento, this);
	}
	
	public AgendamentoEntity() {
		
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

	public String getDataHoraAgendamento() {
		return dataHoraAgendamento;
	}

	public void setDataHoraAgendamento(String dataHoraAgendamento) {
		this.dataHoraAgendamento = dataHoraAgendamento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@PrePersist
	protected void onCreate() {
		dataCadastro = new Date();
	}
	
}
