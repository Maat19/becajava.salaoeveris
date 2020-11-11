package br.salaoeveris.app.response;

import java.time.LocalDateTime;

public class AgendamentoResponse {

	private Long Id;
	private LocalDateTime dataHora;
	private  Long servicoId;
	private  Long clienteId;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Long getServicoId() {
		return servicoId;
	}
	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}	

	
	
}
