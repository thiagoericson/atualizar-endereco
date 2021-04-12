package br.com.treinamento.atualizarendereco.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.atualizarendereco.model.Cliente;
import br.com.treinamento.atualizarendereco.model.Endereco;
import br.com.treinamento.atualizarendereco.service.ClienteService;
import br.com.treinamento.atualizarendereco.service.EnderecoService;

@RestController
@RequestMapping("/clientes/{idCliente}/enderecos/{id}")
public class EnderecoController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	EnderecoService enderecoService;
	
	// PUT
	@PutMapping("")
	public ResponseEntity<?> update(@PathVariable Integer idCliente, @PathVariable Integer id, @RequestBody Endereco endereco) {
		try {
			Cliente cliente = clienteService.getCliente(idCliente);
			Endereco enderecoAtual = enderecoService.getEndereco(id, cliente);
			endereco.setId(enderecoAtual.getId());
			endereco.setCliente(enderecoAtual.getCliente());
			enderecoService.saveEndereco(endereco);
			return new ResponseEntity<>(HttpStatus.OK); // 200
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404	
		}
	}
	
	// DELETE
	@DeleteMapping("")
	public ResponseEntity<?> delete(@PathVariable Integer idCliente, @PathVariable Integer id) {
		try {
			Cliente cliente = clienteService.getCliente(idCliente);
			Endereco enderecoAtual = enderecoService.getEndereco(id, cliente);
			enderecoService.deleteEndereco(enderecoAtual.getId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404	
		}
	}
	
}
