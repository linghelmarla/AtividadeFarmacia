package br.org.generation.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.farmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
