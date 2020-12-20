package com.uol.CompassoWS.controller;

import com.uol.CompassoWS.dto.ClienteDTOV1;
import com.uol.CompassoWS.mapper.ClienteMapperV1;
import com.uol.CompassoWS.model.Cliente;
import com.uol.CompassoWS.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clienteservice")
public class ClienteController {

    static final String SAVE = "/save";
    static final String FIND_ALL_BY_NOME = "/findAllByNome";
    static final String FIND_BY_ID = "/findById";
    static final String DELETE_BY_ID = "/deleteById";

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @Resource
    private ClienteMapperV1 clienteMapperV1;

    @RequestMapping(value = FIND_BY_ID, method = RequestMethod.GET)
    public ResponseEntity<Cliente> findById(@RequestParam Long codigoCliente) {
        logger.info("Start findById");
        ResponseEntity<Cliente> responseEntity;

        if(codigoCliente == null || codigoCliente < 0){
            return ResponseEntity.badRequest().build();
        }

        Optional<Cliente> client = clienteService.findByID(codigoCliente);

        if(client.isPresent()) {
            responseEntity = ResponseEntity.ok(client.get());
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }

        logger.info("Finish findById");
        return responseEntity;
    }

    @RequestMapping(value = FIND_ALL_BY_NOME, method = RequestMethod.GET)
    public List<Cliente> findAllByNome(@RequestParam String nome) throws Exception {
        logger.info("Start findAllByNome");

        List<Cliente> clients = clienteService.findAllByNome(nome);

        logger.info("Finish findAllByNome");
        return clients;
    }

    @RequestMapping(value = SAVE, method = RequestMethod.POST)
    public Cliente save(@RequestBody ClienteDTOV1 cliente) throws Exception {
        logger.info("Start save");

        Cliente clienteCadastrado = clienteService.save(clienteMapperV1.convertToModel(cliente, null));

        logger.info("Finish save");
        return clienteCadastrado;
    }

    @RequestMapping(value = DELETE_BY_ID, method = RequestMethod.DELETE)
    public void deleteById(@RequestParam Long codigoCliente) {
        logger.info("Start deleteById");

        clienteService.deleteById(codigoCliente);

        logger.info("Finish deleteById");
    }

}
