package com.consulta.preco.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consulta.preco.model.Produto;
import com.consulta.preco.repository.ProdutoRepository;

@CrossOrigin(origins = "*")
@RestController
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	@PostMapping("/produto")
	public Produto adicionar(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}

}
