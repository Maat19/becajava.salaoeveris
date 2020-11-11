package br.salaoeveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Servico;
import br.salaoeveris.app.repository.ServicoRepository;
import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ListServicoResponse;
import br.salaoeveris.app.response.ServicoResponse;

@Service
public class ServicoService {
	
	final ServicoRepository _repository;
	
	public ServicoService(ServicoRepository repository) {
		_repository = repository;
	}
	
	public BaseResponse criar (ServicoRequest request) {
		
		Servico servico = new Servico();
		BaseResponse response = new BaseResponse();
		response.statusCode =400;
		
		if(request.getNome().isEmpty()) {
			response.message = "Dado não inserido";	
			return response;
			}
		if(request.getValor() == null) {
			response.message = "Valor não inserido";
			return response;
			}
		
		
	 servico.setNome(request.getNome());
	 servico.setValor(request.getValor());
	 
	 _repository.save(servico);
	 response.statusCode = 201;
		response.message = "Serviço inserido com sucesso.";
		return response;
	}
	
	
	public ServicoResponse obter (Long id) {
		
		Optional<Servico> servico = _repository.findById(id);
		
		ServicoResponse response = new ServicoResponse();
		
		if (servico.isEmpty()) {
			response.statusCode = 400;
			response.message = "Serviço não encontrado";
			return response;
		}
		
		
		response.statusCode = 200;
		response.message = "Serviçoo obtido com sucesso.";
		response.setNome(servico.get().getNome());
		response.setValor(servico.get().getValor());
		return response;
	}
	
	
	
	public ListServicoResponse listar() {
		
		List<Servico> lista = _repository.findAll();
		
		ListServicoResponse response = new ListServicoResponse();
		
		
		
		response.setServicos(lista);
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso.";
		
		return response;
	}
	}
	
	


