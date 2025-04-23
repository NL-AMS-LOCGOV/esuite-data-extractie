package net.atos.esuite.extract.model

import net.atos.esuite.extract.entity.configuratiemagazijn.ReferentieOrganisatieEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ContactBAGObjectEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ContactEntity
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

class ContactOverzicht (
    @field:Schema(description = "Functionele identificatie", maxLength = 128)
    val functioneleIdentificatie: String,
)
