package net.atos.esuite.extract.api.convert.dsr

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.convert.shared.toLocalDate
import net.atos.esuite.extract.api.convert.shared.toZonedDateTime
import net.atos.esuite.extract.api.model.dsr.tabel.*
import net.atos.esuite.extract.db.entity.dsr.definitie.ReferentietabelDefinitieEntity
import net.atos.esuite.extract.db.entity.dsr.tabel.*
import net.atos.esuite.extract.db.repository.dsr.ReferentietabelRecordRepository

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
    when(this) {
        is BooleanReferentietabelRecordExtraAttribuutEntity -> BooleanReferentietabelRecordAttribuut(waarde)
        is DatumReferentietabelRecordExtraAttribuutEntity -> DatumReferentietabelRecordAttribuut(waarde.toLocalDate())
        is DatumTijdReferentietabelRecordExtraAttribuutEntity -> DatumTijdReferentietabelRecordAttribuut(waarde.toZonedDateTime())
        is DecimaalReferentietabelRecordExtraAttribuutEntity -> DecimaalReferentietabelRecordAttribuut(waarde)
        is GeoInformatieReferentietabelRecordExtraAttribuutEntity -> GeoReferentietabelRecordAttribuut(waarde)
        is MemoReferentietabelRecordExtraAttribuutEntity -> MemoReferentietabelRecordAttribuut(waarde)
        is NummerReferentietabelRecordExtraAttribuutEntity -> NummerReferentietabelRecordAttribuut(waarde)
        is StringReferentietabelRecordExtraAttribuutEntity -> StringReferentietabelRecordAttribuut(waarde)
        else -> error("Unsupported ReferentietabelRecordExtraAttribuutEntity type: ${this.javaClass.name}")
    }.apply {
        naam = referentietabelAttribuutDefinitie.naam
        omschrijving = referentietabelAttribuutDefinitie.omschrijving
    }
