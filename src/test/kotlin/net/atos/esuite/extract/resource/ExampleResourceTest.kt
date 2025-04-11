package net.atos.esuite.extract.resource

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.junit.jupiter.api.Test

@QuarkusTest
class ExampleResourceTest {

//    @Test
//    fun testHelloEndpoint() {
//        given()
//            .`when`().get("/zaken")
//            .then()
//            .statusCode(200)
//            .body(Zaak::functioneleIdentificatie.name, `is`("zaaktypeNaam"))
//            .and().body(Zaak::zaaktypeNaam.name, `is`(""))
//    }
}
