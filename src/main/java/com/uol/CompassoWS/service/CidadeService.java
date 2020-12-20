package com.uol.CompassoWS.service;

import com.uol.CompassoWS.model.Cidade;
import com.uol.CompassoWS.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAllByNome(String nome){
        return cidadeRepository.findAllByNomeContaining(nome);
    }

    public List<Cidade> findAllByEstado(String estado){
        return cidadeRepository.findAllByEstado(estado);
    }

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }
}
