package net.atos.esuite.extract.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class RechtWaarde(waarde: String) {

    @field:Schema(description = "Type recht waarde")
    val type: RechtWaardeType? = parseRechtWaardeType(waarde)

    @field:Schema(description = "Naam van object waarop 'type' van toepassing is", maxLength = 255)
    val objectNaam: String? = if (type != null) parseObjectNaam(waarde) else null

    @field:Schema(description = "Waarde van recht indien 'type'of 'objectNaam' niet bepaald kunnen worden", maxLength = 255)
    val waarde: String? = if (type == null || objectNaam == null) waarde else null

    private fun parseRechtWaardeType(waarde: String) =
        getPrefixIfFollowedBySpace(waarde)?.let {
            when (it) {
                "afdeling" -> RechtWaardeType.afdeling
                "groep" -> RechtWaardeType.groep
                "vestiging" -> RechtWaardeType.vestiging
                "DSR_domein" -> RechtWaardeType.dsr_domein
                "veld" -> RechtWaardeType.veld
                "rapp_categorie" -> RechtWaardeType.rapportage_categorie
                "zaaktype_v2" -> RechtWaardeType.zaaktype
                else -> null
            }
        }

    private fun getPrefixIfFollowedBySpace(waarde: String): String? {
        val firstSpaceIndex = waarde.indexOf(' ')
        return if (firstSpaceIndex > 0) {
            waarde.substring(0, firstSpaceIndex)
        } else {
            null
        }
    }

    private fun parseObjectNaam(waarde: String): String? {
        val postfix = waarde.substring( waarde.indexOf(' ') + 1)
        return if (postfix.startsWith('\'') && postfix.endsWith('\'')) {
            postfix.substring(1, postfix.length - 1)
        } else
            null
    }
}
