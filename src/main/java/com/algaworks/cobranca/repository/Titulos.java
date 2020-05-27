package com.algaworks.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.cobranca.model.Titulo;

// params: <Entity, ID data type of this Entity>
public interface Titulos extends JpaRepository<Titulo, Long> {

}
