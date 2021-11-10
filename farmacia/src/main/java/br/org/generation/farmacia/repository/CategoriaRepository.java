package br.org.generation.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.farmacia.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
