package net.atos.esuite.extract.convert.zaak

import net.atos.esuite.extract.api.model.zaakdata.*
import net.atos.esuite.extract.api.model.zaakdata.DataElementType.*
import net.atos.esuite.extract.db.entity.zakenmagazijn.dataelement.*
import net.atos.esuite.extract.db.entity.zakenmagazijn.dataelement.NummerFormattering

fun AbstractDataElementEntity.toDataElement(): DataElement =
    when (this) {
        is AanvullijstDataElementEntity -> AanvullijstDataElement(records.map { it.toAanvullijstRecord() })
        is AdresgegevensDataElementEntity -> ComplexDataElement(adresgegevens, complexeWaarde)
        is AfstandDataElementEntity -> ComplexDataElement(afstand, complexeWaarde)
        is BooleanDataElementEntity -> BooleanDataElement(waarde)
        is CalendarDataElementEntity -> CalendarDataElement(calendar, waarde?.toZonedDateTime())
        is DatumMetTijdStipDataElementEntity -> CalendarDataElement(datummettijdstip, waarde?.toZonedDateTime())
        is DecimaalDataElementEntity -> this.toDecimaalDataElement()
        is DecimalenDataElementEntity -> DecimalenDataElement(waarde)
        is DocumentDataElementEntity -> DocumentDataElement(documentEntities.map { it.bestandsNaam })
        is GeneriekeAfspraakItemDataElementEntity -> ComplexDataElement(generieke_afspraak, complexeWaarde)
        is GeoInformatieDataElementEntity -> ComplexDataElement(geo_informatie, complexeWaarde)
        is OptieDataElementEntity -> ComplexDataElement(optie, complexeWaarde)
        is OptiesDataElementEntity -> OptiesDataElement(gemarshalldeOptieWaarde)
        is ReferentietabelRecordItemDataElementEntity -> ComplexDataElement(referentietabel_record, complexeWaarde)
        is SelectDocumentElementEntity -> SelectDocumentDataElement(gemarshalldeOptieWaarde)
        is StringDataElementEntity -> StringDataElement(waarde)
        is StringsDataElementEntity -> StringsDataElement(waarde)
        is ToestemmingDigitaleNotificatiesDataElementEntity -> ComplexDataElement(digitale_notificaties, complexeWaarde)
        is ZaakBesluitItemDataElementEntity -> ComplexDataElement(zaak_besluit, complexeWaarde)
        else -> error("Unsupported DataElementEntity type: ${this.javaClass.name}")
    }.apply {
        naam = sleutel
        omschrijving = this@toDataElement.omschrijving
    }

private fun AanvullijstRecordEntity.toAanvullijstRecord() =
    AanvullijstRecord(
        recordNummer = recordNummer,
        itemIdentificatie = itemID,
        itemWaarde = itemWaarde,
    )

private fun DecimaalDataElementEntity.toDecimaalDataElement() =
    DecimaalDataElement(
        waarde = waarde,
        formattering = when (formattering) {
            NummerFormattering.GEHEEL_GETAL -> net.atos.esuite.extract.api.model.zaakdata.NummerFormattering.geheel_getal
            NummerFormattering.GEHEEL_GETAL_GEFORMATTEERD -> net.atos.esuite.extract.api.model.zaakdata.NummerFormattering.geheel_getal_geformatteerd
            NummerFormattering.TWEE_DECIMALEN_GEFORMATTEERD -> net.atos.esuite.extract.api.model.zaakdata.NummerFormattering.twee_decimalen_geformatteerd
            NummerFormattering.MAXIMAAL_DECIMALEN_GEFORMATTEERD -> net.atos.esuite.extract.api.model.zaakdata.NummerFormattering.maximaal_decimalen_geformatteerd
            null -> null
        }
    )
