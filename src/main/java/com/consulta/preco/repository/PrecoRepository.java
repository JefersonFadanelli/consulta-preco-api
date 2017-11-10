package com.consulta.preco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulta.preco.model.Preco;

public interface PrecoRepository extends JpaRepository<Preco, Long> {
	
	public Preco findByCodigoBarras(String codigoBarras);

}
