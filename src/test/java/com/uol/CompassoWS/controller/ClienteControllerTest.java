package com.uol.CompassoWS.controller;

import com.uol.CompassoWS.mapper.ClienteMapperV1;
import com.uol.CompassoWS.model.Cidade;
import com.uol.CompassoWS.model.Cliente;
import com.uol.CompassoWS.model.enums.Sexo;
import com.uol.CompassoWS.service.CidadeService;
import com.uol.CompassoWS.service.ClienteService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.*;

@WebMvcTest
public class ClienteControllerTest {

    @Autowired
    private ClienteController clienteController;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private CidadeService cidadeService;

    @MockBean
    private ClienteMapperV1 clienteMapperV1;

    private Cliente clienteRetornado;

    @BeforeEach
    public void setup(){
        Cidade cidadeRetornada = new Cidade();
        cidadeRetornada.setId(1L);
        cidadeRetornada.setNome("Itajaí");
        cidadeRetornada.setEstado("SC");

        clienteRetornado = new Cliente();
        clienteRetornado.setId(1L);
        clienteRetornado.setNome("Rafael Gustavo Onorio");
        clienteRetornado.setSexo(Sexo.M);
        clienteRetornado.setDataNascimento(new Date("18/09/1996"));
        clienteRetornado.setCidade(cidadeRetornada);

        standaloneSetup(this.clienteController);
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarClientePorID() {

        when(this.clienteService.findByID(1L))
                .thenReturn(Optional.of(clienteRetornado));

        given()
                .accept(ContentType.JSON)
                .when()
                    .get("/clienteservice/findById?codigoCliente={codigoCliente}", 1L)
                .then()
                    .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarNotFount_QuandoBuscarClientePorID() {
        when(this.clienteService.findByID(999L))
                .thenReturn(Optional.ofNullable(null));

        given()
                .accept(ContentType.JSON)
                .when()
                    .get("/clienteservice/findById?codigoCliente={codigoCliente}", 999L)
                .then()
                    .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void deveRetornarBadRequest_QuandoBuscarClientePorID(){
        given()
                .accept(ContentType.JSON)
                .when()
                    .get("/clienteservice/findById?codigoCliente={codigoCliente}", -1L)
                .then()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        verify(this.clienteService, never()).findByID(-1L);
    }

}
