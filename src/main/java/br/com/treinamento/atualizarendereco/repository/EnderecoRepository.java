package br.com.treinamento.atualizarendereco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.atualizarendereco.model.Cliente;
import br.com.treinamento.atualizarendereco.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	Optional<Endereco> findByIdAndCliente(Integer id, Cliente cliente);

}
