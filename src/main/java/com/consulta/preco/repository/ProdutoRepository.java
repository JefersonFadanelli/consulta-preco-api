package com.consulta.preco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulta.preco.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
