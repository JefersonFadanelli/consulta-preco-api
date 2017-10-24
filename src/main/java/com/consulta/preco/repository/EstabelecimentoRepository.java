package com.consulta.preco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulta.preco.model.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

}
