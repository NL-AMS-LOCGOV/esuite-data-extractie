package net.atos.esuite.extract.api.model.zaak

import jakarta.validation.constraints.NotNull
import net.atos.esuite.extract.api.validation.ValidBoolean
import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaakPatch {

    @Schema(description = "Is zaak gemigreerd", required = true, implementation = Boolean::class)
    @NotNull
    @ValidBoolean
    var gemigreerd: String? = null
}
