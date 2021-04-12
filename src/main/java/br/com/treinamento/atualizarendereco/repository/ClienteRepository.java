package br.com.treinamento.atualizarendereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.atualizarendereco.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
