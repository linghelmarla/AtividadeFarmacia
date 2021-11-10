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

import br.org.generation.farmacia.model.Produto;
import br.org.generation.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repositorio;

	// metodo Get

	@GetMapping
	public ResponseEntity<List<Produto>> listarTodos() {
		return ResponseEntity.ok(repositorio.findAll());
	}
	// metodo Post

	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(produto));
	}
	// metodo Put

	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> putProduto(@PathVariable Long id, @RequestBody Produto produto) {
		produto.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(produto));
	}
	// metodo Delete

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		repositorio.deleteById(id);
	}
}