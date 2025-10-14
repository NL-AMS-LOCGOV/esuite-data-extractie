package net.atos.esuite.extract.api.convert

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.model.dsr.tabel.*
import net.atos.esuite.extract.db.dsr.entity.definitie.ReferentietabelDefinitieEntity
import net.atos.esuite.extract.db.dsr.entity.tabel.*
import net.atos.esuite.extract.db.dsr.repository.ReferentietabelRecordRepository

@ApplicationScoped
class ReferentietabelConverter(
    private val referentietabelRecordRepository: ReferentietabelRecordRepository,
) {
    fun toReferentietabel(referentietabelDefinitieEntity: ReferentietabelDefinitieEntity) =
        Referentietabel(
            naam = referentietabelDefinitieEntity.naam,
            omschrijving = referentietabelDefinitieEntity.omschrijving,
            actief = referentietabelDefinitieEntity.actief,
            masterDetail = referentietabelDefinitieEntity.masterDetail,
            aantalRecords = referentietabelRecordRepository.countByReferentietabelDefinitieId(referentietabelDefinitieEntity.identifier)
        )
}

fun ReferentietabelRecordEntity.toReferentietabelRecord() =
    ReferentietabelRecord(
        naam = naam,
        omschrijving = omschrijving,
        ingangsdatumGeldigheid = ingangsdatumGeldigheid,
        einddatumGeldigheid = einddatumGeldigheid,
        categorie = categorie,
        attributen = extraAttributen.map { it.toReferentietabelRecordAttribuut() }
    )

private fun AbstractReferentietabelRecordExtraAttribuutEntity.toReferentietabelRecordAttribuut() =
    when (this) {
        is BooleanReferentietabelRecordExtraAttribuutEntity -> BooleanReferentietabelRecordAttribuut(
            waarde,
            referentietabelAttribuutDefinitie.naam,
            referentietabelAttribuutDefinitie.omschrijving
        )

        is DatumReferentietabelRecordExtraAttribuutEntity -> DatumReferentietabelRecordAttribuut(
            waarde.toLocalDate(),
            referentietabelAttribuutDefinitie.naam,
            referentietabelAttribuutDefinitie.omschrijving
        )

        is DatumTijdReferentietabelRecordExtraAttribuutEntity -> DatumTijdReferentietabelRecordAttribuut(
            waarde.toZonedDateTime(),
            referentietabelAttribuutDefinitie.naam,
            referentietabelAttribuutDefinitie.omschrijving
        )

        is DecimaalReferentietabelRecordExtraAttribuutEntity -> DecimaalReferentietabelRecordAttribuut(
            waarde,
            referentietabelAttribuutDefinitie.naam,
            referentietabelAttribuutDefinitie.omschrijving
        )

        is GeoInformatieReferentietabelRecordExtraAttribuutEntity -> GeoReferentietabelRecordAttribuut(
            waarde,
            referentietabelAttribuutDefinitie.naam,
            referentietabelAttribuutDefinitie.omschrijving
        )

        is MemoReferentietabelRecordExtraAttribuutEntity -> MemoReferentietabelRecordAttribuut(
            waarde,
            referentietabelAttribuutDefinitie.naam,
            referentietabelAttribuutDefinitie.omschrijving
        )

        is NummerReferentietabelRecordExtraAttribuutEntity -> NummerReferentietabelRecordAttribuut(
            waarde,
            referentietabelAttribuutDefinitie.naam,
            referentietabelAttribuutDefinitie.omschrijving
        )

        is StringReferentietabelRecordExtraAttribuutEntity -> StringReferentietabelRecordAttribuut(
            waarde,
            referentietabelAttribuutDefinitie.naam,
            referentietabelAttribuutDefinitie.omschrijving
        )

        else -> error("Unsupported ReferentietabelRecordExtraAttribuutEntity type: ${this.javaClass.name}")
    }
