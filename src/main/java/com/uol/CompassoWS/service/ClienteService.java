package com.uol.CompassoWS.service;

import com.uol.CompassoWS.model.Cliente;
import com.uol.CompassoWS.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAllByNome(String nome){
        return clienteRepository.findAllByNomeContaining(nome);
    }

    public Optional<Cliente> findByID(Long codigoCliente){
        return clienteRepository.findById(codigoCliente);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long codigoCliente) {
        clienteRepository.deleteById(codigoCliente);
    }

}
