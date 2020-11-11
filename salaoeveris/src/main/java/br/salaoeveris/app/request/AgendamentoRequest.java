package br.salaoeveris.app.request;

import java.time.LocalDateTime;

import br.salaoeveris.app.model.*;

public class AgendamentoRequest {

	private LocalDateTime dataHora;
	private  Servico servico;
	private  Cliente cliente;
	
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
}
