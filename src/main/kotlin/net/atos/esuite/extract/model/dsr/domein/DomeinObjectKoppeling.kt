package net.atos.esuite.extract.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

class DomeinObjectKoppeling(

    @field:Schema(description = "Type object waaraan het domein object gekoppeld is")
    val gekoppeldObjectType: DomeinObjectKoppelingType,

    @field:Schema(description = "Id van object waaraan domein object gekoppeld is", maxLength = 64)
    val gekoppeldObjectId: String,
)
