package br.salaoeveris.app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ListClienteResponse;
import br.salaoeveris.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {
	
	private final ClienteService _service;
	
	public ClienteController(ClienteService service) {
		_service = service;
	}
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar (@RequestBody ClienteRequest request) {
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
			ListClienteResponse clientes = _service.listar();  		
	    	return ResponseEntity.status(clientes.statusCode).body(clientes);			
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);			
		}		
    }
	
	
}
