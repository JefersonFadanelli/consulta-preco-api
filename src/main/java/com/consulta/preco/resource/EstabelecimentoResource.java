package com.consulta.preco.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consulta.preco.model.Estabelecimento;
import com.consulta.preco.repository.EstabelecimentoRepository;

@CrossOrigin(origins = "*")
@RestController
public class EstabelecimentoResource {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping("/estabelecimentos")
	public List<Estabelecimento> listar(){
		return estabelecimentoRepository.findAll();
	}
	
	@PostMapping("/estabelecimento")
	public Estabelecimento adicionar(@RequestBody @Valid Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

}
