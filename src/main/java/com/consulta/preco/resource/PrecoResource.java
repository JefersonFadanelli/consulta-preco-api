package com.consulta.preco.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consulta.preco.model.Preco;
import com.consulta.preco.repository.PrecoRepository;

@CrossOrigin(origins = "*")
@RestController
public class PrecoResource {
	
	@Autowired
	private PrecoRepository precoRepository;
	
	@GetMapping("/precos")
	public List<Preco> listar(){
		return precoRepository.findAll();
	}
	
	@PostMapping("/preco")
	public Preco adicionar(@RequestBody @Valid Preco preco) {
		return precoRepository.save(preco);
	}
	
	@GetMapping("/preco/id/{codigoBarras}")
	public List<Preco> buscar(@PathVariable String codigoBarras){
		return precoRepository.findByCodigoBarras( codigoBarras );
	}

}
