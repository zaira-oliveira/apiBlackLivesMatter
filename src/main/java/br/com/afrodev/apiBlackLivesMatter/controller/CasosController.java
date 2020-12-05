package br.com.afrodev.apiBlackLivesMatter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.afrodev.apiBlackLivesMatter.models.Casos;
import br.com.afrodev.apiBlackLivesMatter.services.CasosServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController // Informa que a classe controla as requisições Web
@RequestMapping(value = "/api/BLM/") // URI Padrão de acesso
@Api(value = "API REST Casos")
@CrossOrigin(origins = "*") // Qualquer domínio pode acessar essa API

public class CasosController {
	// Um resource/Controller é o ponto de injeção dos métodos para se conectar ao
	// Banco de
	// Dados

	@Autowired
	private CasosServices casosServices;

	@ApiOperation(value = "Retorna lista com todos os casos BLM")
	@GetMapping("/casos")
	public ResponseEntity<List<Casos>> pegaTodosCasos() {
		return ResponseEntity.ok().body(casosServices.pegaTodosCasos());

	}

	@ApiOperation(value = "Retorna um único caso BLM")
	@GetMapping("/casos/{id}")
	public ResponseEntity<Casos> peloId(@PathVariable(value = "id") long id) {
		return ResponseEntity.ok().body(casosServices.peloId(id));
	}

	@ApiOperation(value = "Retorna Casos BLM por ano")
	@GetMapping("/casos/ano/{ano}")
	public ResponseEntity<Casos> peloAno(@PathVariable(value = "ano") int ano) {
		return ResponseEntity.ok().body(casosServices.peloAno(ano));
	}

	@ApiOperation(value = "Retorna Casos BLM por cidade")
	@GetMapping("/casos/cidade/{cidade}")
	public ResponseEntity<Casos> pelaCidade(@PathVariable(value = "cidade") String cidade) {
		String cidade2 = cidade.toUpperCase();
		return ResponseEntity.ok().body(casosServices.pelaCidade(cidade2));
	}

	@ApiOperation(value = "Retorna Casos BLM por mês")
	@GetMapping("/casos/mes/{mes}")
	public ResponseEntity<Casos> peloMes(@PathVariable(value = "mes") String mes) {
		String mes2 = mes.toUpperCase();
		return ResponseEntity.ok().body(casosServices.peloMes(mes2));
	}

	@ApiOperation(value = "Inclui um caso BLM")
	@PostMapping("/casos")
	public ResponseEntity<Casos> criaCaso(@RequestBody @Valid Casos caso) {
		return ResponseEntity.ok().body(this.casosServices.criaCaso(caso));
	}

	@ApiOperation(value = "Atualiza um caso BLM")
	@PutMapping("/casos/{id}")
	public ResponseEntity<Casos> atualizaCaso(@PathVariable(value = "id") long id, @RequestBody Casos caso) {
		caso.setId(id);
		return ResponseEntity.ok().body(this.casosServices.atualizaCaso(caso));
	}

	@ApiOperation(value = "Deleta um caso BLM")
	@DeleteMapping("/casos/{id}")
	public HttpStatus deletaCaso(@PathVariable(value = "id") long id) {
		this.casosServices.deletaCaso(id);
		return HttpStatus.OK;
	}

}