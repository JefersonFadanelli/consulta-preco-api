package com.consulta.preco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consulta.preco.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Produto findByCodigoBarras(String codigoBarras);
	
	@Query(value = "SELECT * FROM PRODUTO WHERE DESCRICAO like '%' || upper( ?1 ) || '%'", nativeQuery = true)
	public List<Produto> findByDescricao(String descricao);

}
