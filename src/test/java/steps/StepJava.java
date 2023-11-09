package steps;

import config.GerenciadorJava;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;

public class StepJava extends GerenciadorJava {
    @Test
    public void dadoqueQueiraConsultarOPrimeiroValor_quandoPassarAsInformações_entãoOSistemaDeveRetornarStatusCode200Sucesso () {
        when().
                get("/breeds")
                .then()
                .statusCode(200)
                .body("current_page", is(1))
                .body("per_page", is(25))
                .body("data[0].breed", is("Abyssinian"))
                .body("data[0].country", is("Ethiopia"))
                .body("data[0].origin", is("Natural/Standard"))
                .body("data[0].coat", is("Short"))
                .body("data[0].pattern", is("Ticked"));
    }

    @Test
    public void dadoquePasseUmLimiteInexistente_quandoPreencherEsseValorInexistente_entãoOSistemaDeveRetornarErroComStatusCode404 () {
        when().
                get("/breeds?limit=-1")
                .then()
                .statusCode(404);
    }
}
