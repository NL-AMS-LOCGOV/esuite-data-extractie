package net.atos.esuite.extract.api.convert

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.model.dsr.domein.*
import net.atos.esuite.extract.db.dsr.entity.definitie.DomeinDefinitieEntity
import net.atos.esuite.extract.db.dsr.entity.domein.*
import net.atos.esuite.extract.db.dsr.repository.DomeinObjectRepository

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
        is BooleanAttribuutWaardeEntity -> BooleanDomeinObjectAttribuutWaarde(waarde, this.volgnummer)
        is DatumAttribuutWaardeEntity -> DatumDomeinObjectAttribuutWaarde(waarde.toLocalDate(), this.volgnummer)
        is DatumTijdAttribuutWaardeEntity -> DatumTijdDomeinObjectAttribuutWaarde(waarde.toZonedDateTime(), this.volgnummer)
        is DecimaalAttribuutWaardeEntity -> DecimaalDomeinObjectAttribuutWaarde(waarde, this.volgnummer)
        is GeoInformatieAttribuutWaardeEntity -> GeoDomeinObjectAttribuutWaarde(waarde, this.volgnummer)
        is MemoAttribuutWaardeEntity -> MemoDomeinObjectAttribuutWaarde(waarde, this.volgnummer)
        is NummerAttribuutWaardeEntity -> NummerDomeinObjectAttribuutWaarde(waarde.longValueExact(), this.volgnummer)
        is StringAttribuutWaardeEntity -> StringDomeinObjectAttribuutWaarde(waarde, this.volgnummer)
        is DomeinObjectAttribuutWaardeEntity -> DomeinObjectDomeinObjectAttribuutWaarde(identifier, this.volgnummer)
        is ReferentietabelRecordAttribuutWaardeEntity -> ReferentietabelRecordDomeinObjectAttribuutWaarde(
            referentietabelRecord.toReferentietabelRecord(), this.volgnummer
        )

        else -> error("Unsupported AttribuutWaardeEntity type: ${this.javaClass.name}")
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
