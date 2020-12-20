package com.uol.CompassoWS.repository;

import com.uol.CompassoWS.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    List<Cliente> findAllByNomeContaining(String nome);

}
