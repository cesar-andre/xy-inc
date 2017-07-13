package br.com.xyinc.tests;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AplicacaoTest {
	
	@Before
	public void setup() {
		RestAssured.baseURI = "http://localhost/xy-inc";
		RestAssured.port = 8088;
	}

	@Test
	public void obterTodosTest() {
		Response response = given().get("/pontos-interesse").andReturn();
		assertEquals(200, response.getStatusCode());
	}
	
	@Test
	public void obterProximosTest() {
		Response response = given().get("/pontos-interesse/20/10/10").andReturn();
		assertEquals(200, response.getStatusCode());
	}
	
	@Test
	public void inserirPontoDeInteresseTest(){
		String ponto = "{ \"nome\": \"Casa do Cesar\", \"coordenadaX\": 35, \"coordenadaY\": 15 }";
		
		Response response = given().contentType("application/json").body(ponto).post("/pontos-interesse").andReturn();
		assertEquals(201, response.getStatusCode());
		JsonPath json = response.jsonPath();
		assertNotNull(json.get("id"));
	}
	
	@Test
	public void inserirPontoDeInteresseInvalido() {
		String ponto = "{ \"nome\": \"Shopping\", \"coordenadaX\": -20, \"coordenadaY\": 15 }";
		Response response = given().contentType("application/json").body(ponto).post("/pontos-interesse").andReturn();
		assertEquals(400, response.getStatusCode());
		
	}

}
