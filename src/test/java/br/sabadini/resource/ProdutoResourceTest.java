package br.sabadini.resource;

import br.sabadini.TesteBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProdutoResourceTest {

//    @LocalServerPort
//    public int port;
//
//    @Before
//    public void setUp() throws Exception {
//        RestAssured.port = port;
//    }
//
//    @Test
//    public void getProdutos() {
//        given()
//            .contentType(ContentType.JSON)
//            .when()
//            .get("/api/produtos")
//            .then()
//            .statusCode(200);
//    }
}
