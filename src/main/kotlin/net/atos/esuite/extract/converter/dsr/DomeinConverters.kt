package net.atos.esuite.extract.converter.dsr

import net.atos.esuite.extract.converter.toLocalDate
import net.atos.esuite.extract.converter.toZonedDateTime
import net.atos.esuite.extract.entity.dsr.domein.AbstractAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.AttribuutEntity
import net.atos.esuite.extract.entity.dsr.domein.BooleanAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.DatumAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.DatumTijdAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.DecimaalAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.DomeinObjectAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.DomeinObjectEntity
import net.atos.esuite.extract.entity.dsr.domein.DomeinObjectHistorieEntity
import net.atos.esuite.extract.entity.dsr.domein.DomeinObjectKoppelingEntity
import net.atos.esuite.extract.entity.dsr.domein.GeoInformatieAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.MemoAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.NummerAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.ReferentietabelRecordAttribuutWaardeEntity
import net.atos.esuite.extract.entity.dsr.domein.StringAttribuutWaardeEntity
import net.atos.esuite.extract.model.dsr.domein.BooleanDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.DatumDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.DatumTijdDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.DecimaalDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.DomeinObject
import net.atos.esuite.extract.model.dsr.domein.DomeinObjectAttribuut
import net.atos.esuite.extract.model.dsr.domein.DomeinObjectDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.DomeinObjectHistorie
import net.atos.esuite.extract.model.dsr.domein.DomeinObjectKoppeling
import net.atos.esuite.extract.model.dsr.domein.DomeinObjectKoppelingType
import net.atos.esuite.extract.model.dsr.domein.GeoDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.MemoDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.NummerDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.ReferentietabelRecordDomeinObjectAttribuutWaarde
import net.atos.esuite.extract.model.dsr.domein.StringDomeinObjectAttribuutWaarde

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

fun AttribuutEntity.toDomeinObjectAttribuut() =
    DomeinObjectAttribuut(
        naam = attribuutDefinitie.naam,
        omschrijving = attribuutDefinitie.omschrijving,
        waarden = waarden.map { it.toDomeinObjectAttribuutWaarde() },
    )

fun AbstractAttribuutWaardeEntity.toDomeinObjectAttribuutWaarde() =
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
    }.also {
        it.volgnummer = volgnummer
    }

fun DomeinObjectKoppelingEntity.toDomeinObjectKoppeling() =
    DomeinObjectKoppeling(
        gekoppeldObjectType = DomeinObjectKoppelingType.valueOf(gekoppeldAanType.lowercase()),
        gekoppeldObjectId = idGekoppeldObject,
    )

fun DomeinObjectHistorieEntity.toDomeinObjectHistorie() =
    DomeinObjectHistorie(
        wijzigingDatum = datumwijziging,
        gewijzigdDoor = gewijzigddoor,
        oudeWaarde = oudewaarde,
        nieuweWaarde = nieuwewaarde,
        toelichting = toelichting,
        wijziging = typeWijziging,
    )
