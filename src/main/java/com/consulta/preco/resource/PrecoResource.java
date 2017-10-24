package com.consulta.preco.resource;

import java.util.ArrayList;
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
import com.consulta.preco.model.Produto;
import com.consulta.preco.model.ConsultaPreco;
import com.consulta.preco.model.Estabelecimento;
import com.consulta.preco.repository.PrecoRepository;
import com.consulta.preco.repository.EstabelecimentoRepository;
import com.consulta.preco.repository.ProdutoRepository;

@CrossOrigin(origins = "*")
@RestController
public class PrecoResource {
	
	@Autowired
	private PrecoRepository precoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping("/precos")
	public List<Preco> listar(){
		return precoRepository.findAll();
	}
	
	@PostMapping("/preco")
	public Preco adicionar(@RequestBody @Valid Preco preco) {
		return precoRepository.save(preco);
	}
	
	@GetMapping("/preco/id/{codigoBarras}")
	public List<ConsultaPreco> buscar(@PathVariable String codigoBarras){
		
		List<Preco> precos = precoRepository.findByCodigoBarras( codigoBarras );
		ConsultaPreco consultaPreco;
		List<ConsultaPreco> listaPrecos = new ArrayList<ConsultaPreco>();
		
		Produto produto;
		Estabelecimento estabelecimento;

		for( Preco p : precos) {
			consultaPreco = new ConsultaPreco();

			consultaPreco.setCodigoBarras( p.getCodigoBarras() );
			consultaPreco.setPreco( p.getPreco() );
			
			produto = produtoRepository.getByCodigoBarras(p.getCodigoBarras() );
			
			consultaPreco.setDescricaoProduto( produto.getDescricao() );
			consultaPreco.setEmbalagem( produto.getEmbalagem() );
			
			estabelecimento = estabelecimentoRepository.getById( p.getIdEstabelecimento() );
			
			consultaPreco.setDescricaoEstabelecimento( estabelecimento.getFantasia() );

			listaPrecos.add( consultaPreco );
		}
		
		return listaPrecos;
	}

}
