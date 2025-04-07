package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Zaakstatus(
    @field:Schema(description = "Naam van status", maxLength = 255)
    val naam: String,

    @field:Schema(description = "Omschrijving van status", maxLength = 255)
    val omschrijving: String?,

    @field:Schema(description = "Code welke gebruikt wordt voor het uitwisselen van zaak informatie naar externe systemen zoals bijvoorbeeld via StUF-ZKN-DMS", maxLength = 255)
    val uitwisselingscode: String,

    @field:Schema(description = "Naam van status zoals deze getoond wordt in het publieke deel (burger en bedrijven loket) van de e=Suite", maxLength = 255)
    val externeNaam: String,
    )
