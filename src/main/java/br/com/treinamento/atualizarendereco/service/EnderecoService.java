package br.com.treinamento.atualizarendereco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.atualizarendereco.model.Cliente;
import br.com.treinamento.atualizarendereco.model.Endereco;
import br.com.treinamento.atualizarendereco.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco getEndereco(Integer id, Cliente cliente) {
		return enderecoRepository.findByIdAndCliente(id, cliente).get();
	}

	public void saveEndereco(Endereco endereco) {
		enderecoRepository.save(endereco);
	}

	public void deleteEndereco(Integer id) {
		enderecoRepository.deleteById(id);
	}
}
