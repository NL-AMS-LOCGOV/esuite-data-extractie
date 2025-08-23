package net.atos.esuite.extract.api.convert.dsr

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.convert.shared.toLocalDate
import net.atos.esuite.extract.api.convert.shared.toZonedDateTime
import net.atos.esuite.extract.api.model.dsr.domein.*
import net.atos.esuite.extract.db.entity.dsr.definitie.DomeinDefinitieEntity
import net.atos.esuite.extract.db.entity.dsr.domein.*
import net.atos.esuite.extract.db.repository.dsr.DomeinObjectRepository

@ApplicationScoped
class DomeinConverter(
    private val domeinObjectRepository: DomeinObjectRepository,
) {
    fun toDomein(domeinDefinitieEntity: DomeinDefinitieEntity) =
        Domein(
            naam = domeinDefinitieEntity.naam,
            omschrijving = domeinDefinitieEntity.omschrijving,
            actief = domeinDefinitieEntity.actief,
            aantalObjecten = domeinObjectRepository.countByDomeinDefinitieId(domeinDefinitieEntity.identifier),
        )
}

fun DomeinObjectEntity.toDomeinObject() =
    DomeinObject(
        identifier = identifier,
        naam = domeinObjectDefinitie.naam,
        omschrijving = domeinObjectDefinitie.omschrijving,
        aangemaaktDoor = idAangemaaktDoor,
        aangemaaktOp = aangemaaktOp,
        laatstGewijzigdDoor = idGewijzigdDoor,
        laatstGewijzigdOp = gewijzigdOp,
        attributen = attributen.map { it.toDomeinObjectAttribuut() },
        koppelingen = koppelingen.map { it.toDomeinObjectKoppeling() }.ifEmpty { null },
        historie = historie.map { it.toDomeinObjectHistorie() }.ifEmpty { null },
    )

private fun AttribuutEntity.toDomeinObjectAttribuut() =
    DomeinObjectAttribuut(
        naam = attribuutDefinitie.naam,
        omschrijving = attribuutDefinitie.omschrijving,
        waarden = waarden.map { it.toDomeinObjectAttribuutWaarde() },
    )

private fun AbstractAttribuutWaardeEntity.toDomeinObjectAttribuutWaarde() =
    when (this) {
        is BooleanAttribuutWaardeEntity -> BooleanDomeinObjectAttribuutWaarde(waarde)
        is DatumAttribuutWaardeEntity -> DatumDomeinObjectAttribuutWaarde(waarde.toLocalDate())
        is DatumTijdAttribuutWaardeEntity -> DatumTijdDomeinObjectAttribuutWaarde(waarde.toZonedDateTime())
        is DecimaalAttribuutWaardeEntity -> DecimaalDomeinObjectAttribuutWaarde(waarde)
        is GeoInformatieAttribuutWaardeEntity -> GeoDomeinObjectAttribuutWaarde(waarde)
        is MemoAttribuutWaardeEntity -> MemoDomeinObjectAttribuutWaarde(waarde)
        is NummerAttribuutWaardeEntity -> NummerDomeinObjectAttribuutWaarde(waarde.longValueExact())
        is StringAttribuutWaardeEntity -> StringDomeinObjectAttribuutWaarde(waarde)
        is DomeinObjectAttribuutWaardeEntity -> DomeinObjectDomeinObjectAttribuutWaarde(identifier)
        is ReferentietabelRecordAttribuutWaardeEntity -> ReferentietabelRecordDomeinObjectAttribuutWaarde(
            referentietabelRecord.toReferentietabelRecord()
        )
        else -> error("Unsupported AttribuutWaardeEntity type: ${this.javaClass.name}")
    }.apply {
        volgnummer = this@toDomeinObjectAttribuutWaarde.volgnummer
    }

private fun DomeinObjectKoppelingEntity.toDomeinObjectKoppeling() =
    DomeinObjectKoppeling(
        gekoppeldObjectType = DomeinObjectKoppelingType.valueOf(gekoppeldAanType.lowercase()),
        gekoppeldObjectId = idGekoppeldObject,
    )

private fun DomeinObjectHistorieEntity.toDomeinObjectHistorie() =
    DomeinObjectHistorie(
        wijzigingDatum = datumwijziging,
        gewijzigdDoor = gewijzigddoor,
        oudeWaarde = oudewaarde,
        nieuweWaarde = nieuwewaarde,
        toelichting = toelichting,
        wijziging = typeWijziging,
    )
