package net.atos.esuite.extract.api.model.zaak

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaakZaakKoppeling(

    @field:Schema(description = "Zaaknummer van gekoppelde zaak", maxLength = 128)
    val gekoppeldeZaak: String,

    @field:Schema(description = "Type relatie van gekoppelde zaak")
    val relatietype: ZaakRelatietype,

    @field:Schema(description = "Indicatie of zaak eigenaar is van zaakdossier voor gekoppelde zaak in het DMS", required = true)
    val dossierEigenaar: Boolean,
)
