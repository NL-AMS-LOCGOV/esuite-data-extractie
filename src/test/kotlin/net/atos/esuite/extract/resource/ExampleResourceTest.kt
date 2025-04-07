package net.atos.esuite.extract.resource

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import net.atos.esuite.extract.model.ZaakOverzicht
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.junit.jupiter.api.Test

@QuarkusTest
class ExampleResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .`when`().get("/zaken")
            .then()
            .statusCode(200)
            .body(ZaakOverzicht::functioneleIdentificatie.name, `is`("zaaktypeNaam"))
            .and().body(ZaakOverzicht::zaaktypeNaam.name, `is`(""))
    }
}
