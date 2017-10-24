package com.consulta.preco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulta.preco.model.Preco;

public interface PrecoRepository extends JpaRepository<Preco, Long> {
	
	public List<Preco> findByCodigoBarras(String codigoBarras);

}
