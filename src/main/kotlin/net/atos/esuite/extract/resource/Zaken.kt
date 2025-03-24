package net.atos.esuite.extract.resource

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.converter.ZaakOverzichtConverter
import net.atos.esuite.extract.repository.ZaakRepository

@Path("/zaken")
class Zaken(
    private val ZaakRepository: ZaakRepository,
    private val zaakOverzichtConverter: ZaakOverzichtConverter,
    private val zaakRepository: ZaakRepository
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun listZaken() = zaakRepository.listAll()
        .slice(1..10)
        .map { zaakOverzichtConverter.convert(it) }
}
