package com.uol.CompassoWS.repository;

import com.uol.CompassoWS.model.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Long>{

    List<Cidade> findAllByNomeContaining(String nome);

    List<Cidade> findAllByEstado(String estado);

}
