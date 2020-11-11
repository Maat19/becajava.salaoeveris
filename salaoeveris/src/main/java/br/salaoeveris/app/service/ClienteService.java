package br.salaoeveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;
import br.salaoeveris.app.response.ListClienteResponse;

@Service
public class ClienteService {

	final ClienteRepository _repository;

	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}

	
	
	//CRIAR CLIENTE
	public BaseResponse criar(ClienteRequest request) {

		Cliente cliente = new Cliente();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		
	if(request.getTelefone()==null){
		response.message = "Telefone não preenchido";
		return response;
	}

	if(request.getEndereco()==null){
		response.message = "Endereço não preenchido";
		return response;
	}

	if(request.getNome()==null){
		response.message = "Nome não preenchido";
		return response;
		}
	
	if(request.getNome()==null){
		response.message = "CPF não preenchido";
		return response;
		}
	

	cliente.setNome(request.getNome());
	cliente.setCpf(request.getCpf());
	cliente.setEndereco(request.getEndereco());
	cliente.setTelefone(request.getTelefone());
	
	_repository.save(cliente);
	response.statusCode = 201;
	response.message = "Cliente inserido com sucesso.";
	return response;
	
	}
	
	
	//Obter um cliente
	
	public ClienteResponse obter(Long id) {
		
		Optional<Cliente> cliente = _repository.findById(id);
		
		ClienteResponse response = new ClienteResponse();
		
		if (cliente.isEmpty()) {
			response.statusCode = 400;
			response.message = "Cliente não encontrado";
			return response;
		}
		
		
		
		response.statusCode = 200;
		response.message = "Cliente obtido com sucesso.";
		response.setEndereco(cliente.get().getEndereco());
		response.setTelefone(cliente.get().getTelefone());
		response.setNome(cliente.get().getNome());
		return response;
	}
	
	//Listar todos os clientes
	
	
	public ListClienteResponse listar() {
		
		List<Cliente> lista = _repository.findAll();
		List<ClienteResponse> listaResposta = new ArrayList<ClienteResponse>();
		
		ListClienteResponse response = new ListClienteResponse();
		
		
		
		
		for(Cliente c: lista) {
			ClienteResponse cliente = new ClienteResponse();
			
			cliente.setId(c.getId());
			cliente.setEndereco(c.getEndereco());
			cliente.setTelefone(c.getTelefone());
			cliente.setNome(c.getNome());
			
			listaResposta.add(cliente);
		}
		
		response.setClientes(listaResposta);
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso.";
		
		return response;
	}
	
}