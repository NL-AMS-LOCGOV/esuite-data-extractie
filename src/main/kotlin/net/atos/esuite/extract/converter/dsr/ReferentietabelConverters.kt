package net.atos.esuite.extract.converter.dsr

import net.atos.esuite.extract.converter.toLocalDate
import net.atos.esuite.extract.converter.toZonedDateTime
import net.atos.esuite.extract.entity.dsr.tabel.AbstractReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.entity.dsr.tabel.BooleanReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.entity.dsr.tabel.DatumReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.entity.dsr.tabel.DatumTijdReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.entity.dsr.tabel.DecimaalReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.entity.dsr.tabel.GeoInformatieReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.entity.dsr.tabel.MemoReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.entity.dsr.tabel.NummerReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.entity.dsr.tabel.ReferentietabelRecordEntity
import net.atos.esuite.extract.entity.dsr.tabel.StringReferentietabelRecordExtraAttribuutEntity
import net.atos.esuite.extract.model.dsr.tabel.BooleanReferentietabelRecordAttribuut
import net.atos.esuite.extract.model.dsr.tabel.DatumReferentietabelRecordAttribuut
import net.atos.esuite.extract.model.dsr.tabel.DatumTijdReferentietabelRecordAttribuut
import net.atos.esuite.extract.model.dsr.tabel.DecimaalReferentietabelRecordAttribuut
import net.atos.esuite.extract.model.dsr.tabel.GeoReferentietabelRecordAttribuut
import net.atos.esuite.extract.model.dsr.tabel.MemoReferentietabelRecordAttribuut
import net.atos.esuite.extract.model.dsr.tabel.NummerReferentietabelRecordAttribuut
import net.atos.esuite.extract.model.dsr.tabel.ReferentietabelRecord
import net.atos.esuite.extract.model.dsr.tabel.StringReferentietabelRecordAttribuut

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
    }.also {
        it.naam = referentietabelAttribuutDefinitie.naam
        it.omschrijving = referentietabelAttribuutDefinitie.omschrijving
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
