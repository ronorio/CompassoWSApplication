package com.uol.CompassoWS.mapper;

import com.uol.CompassoWS.dto.ClienteDTOV1;
import com.uol.CompassoWS.model.Cidade;
import com.uol.CompassoWS.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperV1 {

    public ClienteDTOV1 convertToDto(Cliente model) {
        if (model == null) {
            return null;
        }

        ClienteDTOV1 dto = new ClienteDTOV1();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setSexo(model.getSexo());
        dto.setDataNascimento(model.getDataNascimento());
        dto.setCodigoCidade(model.getCidade().getId());

        return dto;
    }

    public Cliente convertToModel(ClienteDTOV1 dto, Cliente model) {
        if (dto == null) {
            return null;
        }

        if (model == null || !model.getId().equals(dto.getId())) {
            model = new Cliente();
        }

        model.setId(dto.getId());
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setSexo(dto.getSexo());
        model.setDataNascimento(dto.getDataNascimento());

        Cidade cidade = new Cidade();
        cidade.setId(dto.getCodigoCidade());
        model.setCidade(cidade);

        return model;
    }

}
