package com.uol.CompassoWS.controller;

import com.uol.CompassoWS.model.Cidade;
import com.uol.CompassoWS.service.CidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cidadeservice")
public class CidadeController {

    static final String FIND_ALL_BY_NOME = "/findAllByNome";
    static final String FIND_ALL_BY_ESTADO = "/findAllByEstado";
    static final String SAVE = "/save";

    private static final Logger logger = LoggerFactory.getLogger(CidadeController.class);

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(value = FIND_ALL_BY_NOME, method = RequestMethod.GET)
    public List<Cidade> findAllByNome(@RequestParam String nome) throws Exception {
        logger.info("Start findAllByNome");

        List<Cidade> cidades = cidadeService.findAllByNome(nome);

        logger.info("Finish findAllByNome");
        return cidades;
    }

    @RequestMapping(value = FIND_ALL_BY_ESTADO, method = RequestMethod.GET)
    public List<Cidade> findAllByEstado(@RequestParam String estado) throws Exception {
        logger.info("Start findAllByEstado");

        List<Cidade> cidades = cidadeService.findAllByEstado(estado);

        logger.info("Finish findAllByEstado");
        return cidades;
    }

    @RequestMapping(value = SAVE, method = RequestMethod.POST)
    public Cidade save(@RequestBody Cidade cidade) throws Exception {
        logger.info("Start save");

        Cidade cidadeCadastrada = cidadeService.save(cidade);

        logger.info("Finish save");
        return cidadeCadastrada;
    }

}
