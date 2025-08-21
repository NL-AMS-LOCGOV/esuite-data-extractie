package net.atos.esuite.extract.api.model.shared

import org.eclipse.microprofile.openapi.annotations.media.Schema

open class Fout(
    @field:Schema(description = "Foutmelding")
    val melding: String,
    )
