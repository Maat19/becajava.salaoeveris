package br.salaoeveris.app.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;


import br.salaoeveris.app.model.Agendamento;
import br.salaoeveris.app.repository.AgendamentoRepository;
import br.salaoeveris.app.request.AgendamentoRequest;
import br.salaoeveris.app.response.BaseResponse;;


@Service
public class AgendamentoService {

	final AgendamentoRepository _repository;

	public AgendamentoService(AgendamentoRepository repository) {
		_repository = repository;
	}
	


    //CRIAR AGENDAMENTO
    public BaseResponse criar(AgendamentoRequest request) {

        BaseResponse response = new BaseResponse();
        Agendamento agendamento = new Agendamento();
        response.statusCode = 400;

        if(request.getDataHora() == null) {
            response.message = "Data do Agendamento não inserida.";
            return response;
        }
        else if(request.getCliente() == null) {
            response.message = "Cliente não inserido";
            return response;
        }
        else if(request.getServico() == null) {
            response.message = "Serviço não Inserido";
            return response;
        }

        agendamento.setCliente(request.getCliente());
        agendamento.setServico(request.getServico());
        agendamento.setDataHora(request.getDataHora());

        _repository.save(agendamento);

        response.statusCode = 201;
        response.message = "Agendamento Realizado.";
        return response;

    }
    
    
//    public ListRelAgendamentoResponse relatorio(String dataInicio, String dataFim) {
//    	
//    	String dtInicio = dataInicio.toLocalDateTime().toString();
//    	String dtFim = dataInicio.toLocalDateTime().toString();
//    	
//    	
//    	ListRelAgendamentoResponse relatorio = new ListRelAgendamentoResponse();
//
//    	relatorio.setRelatorio(_repository.findAgendamento(dtInicio, dtFim));
//    	
//    	return relatorio;
//    	}
		
	}
    
	
	
	

