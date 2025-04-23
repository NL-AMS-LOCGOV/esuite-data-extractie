package net.atos.esuite.extract.model.zaakdata

import net.atos.esuite.extract.model.Subject
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class AanvullijstDataElement(

    @field:Schema(description = "Aanvullijst records")
    val waarden: List<AanvullijstRecord>,

    ) : DataElement(DataElementType.aanvullijst)
