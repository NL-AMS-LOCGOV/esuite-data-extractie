package net.atos.esuite.extract.api.convert.dsr

import net.atos.esuite.extract.api.convert.shared.toLocalDate
import net.atos.esuite.extract.api.convert.shared.toZonedDateTime
import net.atos.esuite.extract.api.model.dsr.tabel.*
import net.atos.esuite.extract.db.entity.dsr.tabel.*

fun AbstractReferentietabelRecordExtraAttribuutEntity.toReferentietabelRecordAttribuut() =
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

fun ReferentietabelRecordEntity.toReferentietabelRecord() =
    ReferentietabelRecord(
        naam = naam,
        omschrijving = omschrijving,
        ingangsdatumGeldigheid = ingangsdatumGeldigheid,
        einddatumGeldigheid = einddatumGeldigheid,
        categorie = categorie,
        attributen = extraAttributen.map {it.toReferentietabelRecordAttribuut()}
    )
