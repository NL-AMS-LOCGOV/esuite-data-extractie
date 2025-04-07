package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Zaakresultaat (
    @field:Schema(description = "Naam van resultaat", maxLength = 255)
    val naam: String,

    @field:Schema(description = "Omschrijving van resultaat", maxLength = 255)
    val omschrijving: String?,

    @field:Schema(description = "Code welke gebruikt wordt voor het uitwisselen van zaak informatie naar externe systemen zoals bijvoorbeeld via StUF-ZKN-DMS", maxLength = 255)
    val uitwisselingscode: String,
)
