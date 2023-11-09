package config;

import io.restassured.RestAssured;
import org.junit.Before;

public class GerenciadorJava {

    public static final String URL_BASE = "https://catfact.ninja";
    @Before
    public void setup() {
        RestAssured.baseURI = URL_BASE;}
}
