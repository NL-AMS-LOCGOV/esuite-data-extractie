package net.atos.esuite.extract.api.model.subject

import jakarta.ws.rs.QueryParam
import net.atos.esuite.extract.api.validator.ValidKVKNummer
import net.atos.esuite.extract.api.validator.ValidVestigingsnummer
import org.eclipse.microprofile.openapi.annotations.media.Schema

class BedrijfListParameters {

    @Schema(description = "KvK nummer", minLength = 8, maxLength = 8)
    @QueryParam("kvk_nummer")
    @ValidKVKNummer
    var kvkNummer: String? = null

    @Schema(description = "vestigingsnummer", minLength = 12, maxLength = 12)
    @QueryParam("vestigingsnummer")
    @ValidVestigingsnummer
    var vestigingsnummer: String? = null
}
