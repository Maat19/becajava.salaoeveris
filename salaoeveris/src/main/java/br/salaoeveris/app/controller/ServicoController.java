package br.salaoeveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ListServicoResponse;
import br.salaoeveris.app.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController extends BaseController {

	private final ServicoService _service;
	
	public ServicoController(ServicoService service) {
		_service = service;
	}
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar (@RequestBody ServicoRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		}catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}

	
	
	@GetMapping(path="/{id}")
	public ResponseEntity<BaseResponse> obter (@PathVariable Long id) {
		try {
			BaseResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);	
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}   	
	}
	
	
	@GetMapping
    public ResponseEntity<BaseResponse> listar() {		
		try {
			ListServicoResponse clientes = _service.listar();  		
	    	return ResponseEntity.status(clientes.statusCode).body(clientes);			
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);			
		}		
    }
	
	
	
}
