package net.atos.esuite.extract.model.shared

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Fout(
    @field:Schema(description = "Melding van fout")
    val melding: String,
    )
