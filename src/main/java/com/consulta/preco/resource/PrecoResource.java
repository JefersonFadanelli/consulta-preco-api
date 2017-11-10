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
	public List<ConsultaPreco> buscarCodigoBarras(@PathVariable String codigoBarras){
		
		Preco preco = precoRepository.findByCodigoBarras( codigoBarras );
		
		if(preco == null) {
			return null;
		}
		
		ConsultaPreco consultaPreco;
		List<ConsultaPreco> listaPrecos = new ArrayList<ConsultaPreco>();
		
		Produto produto;
		Estabelecimento estabelecimento;

		
		consultaPreco = new ConsultaPreco();

		consultaPreco.setCodigoBarras( preco.getCodigoBarras() );
		consultaPreco.setPreco( preco.getPreco() );
		
		produto = produtoRepository.findByCodigoBarras( preco.getCodigoBarras() );

		consultaPreco.setDescricaoProduto( produto.getDescricao() );
		consultaPreco.setEmbalagem( produto.getEmbalagem() );
		
		estabelecimento = estabelecimentoRepository.getById( preco.getIdEstabelecimento() );
		
		consultaPreco.setDescricaoEstabelecimento( estabelecimento.getFantasia() );

		listaPrecos.add( consultaPreco );
		
		return listaPrecos;
	}
	
	@GetMapping("/preco/descricao/{descricao}")
	public List<ConsultaPreco> buscarDescricao(@PathVariable String descricao){
		
		List<Produto> produtos = produtoRepository.findByDescricao( descricao );
		
		if(produtos == null) {
			return null;
		}

		ConsultaPreco consultaPreco;
		List<ConsultaPreco> listaPrecos = new ArrayList<ConsultaPreco>();
		
		Preco preco;
		Estabelecimento estabelecimento;

		for( Produto p : produtos) {
			consultaPreco = new ConsultaPreco();

			consultaPreco.setCodigoBarras( p.getCodigoBarras() );
			consultaPreco.setDescricaoProduto( p.getDescricao() );
			consultaPreco.setEmbalagem( p.getEmbalagem() );
			
			preco = precoRepository.findByCodigoBarras( p.getCodigoBarras() );
			consultaPreco.setPreco( preco.getPreco() );
			
			estabelecimento = estabelecimentoRepository.getById( preco.getIdEstabelecimento() );
			
			consultaPreco.setDescricaoEstabelecimento( estabelecimento.getFantasia() );

			listaPrecos.add( consultaPreco );
		}
		
		return listaPrecos;
	}

}
