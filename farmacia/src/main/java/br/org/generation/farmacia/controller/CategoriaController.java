package br.org.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.farmacia.model.Categoria;
import br.org.generation.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repositorio;

	// metodo Get

	@GetMapping
	public ResponseEntity<List<Categoria>> listarTodos() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	// metodo post

	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(categoria));

	}
	// metodo Put

	@PutMapping("/categoria/{id}")
	public ResponseEntity<Categoria> putCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
		categoria.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(categoria));
	}

	// metodo Delete

	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		repositorio.deleteById(id);
	}

}