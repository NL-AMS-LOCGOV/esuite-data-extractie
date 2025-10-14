package net.atos.esuite.extract.api.converter

import net.atos.esuite.extract.api.model.zaakdata.*
import net.atos.esuite.extract.api.model.zaakdata.DataElementType.*
import net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement.*
import net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement.NummerFormattering

fun AbstractDataElementEntity.toDataElement(): DataElement =
    when (this) {
        is AanvullijstDataElementEntity -> AanvullijstDataElement(records.map { it.toAanvullijstRecord() }, sleutel, omschrijving)
        is AdresgegevensDataElementEntity -> ComplexDataElement(adresgegevens, complexeWaarde, sleutel, omschrijving)
        is AfstandDataElementEntity -> ComplexDataElement(afstand, complexeWaarde, sleutel, omschrijving)
        is BooleanDataElementEntity -> BooleanDataElement(waarde, sleutel, omschrijving)
        is CalendarDataElementEntity -> CalendarDataElement(calendar, waarde?.toZonedDateTime(), sleutel, omschrijving)
        is DatumMetTijdStipDataElementEntity -> CalendarDataElement(datummettijdstip, waarde?.toZonedDateTime(), sleutel, omschrijving)
        is DecimaalDataElementEntity -> this.toDecimaalDataElement(sleutel, omschrijving)
        is DecimalenDataElementEntity -> DecimalenDataElement(waarde, sleutel, omschrijving)
        is DocumentDataElementEntity -> DocumentDataElement(documentEntities.map { it.bestandsNaam }, sleutel, omschrijving)
        is GeneriekeAfspraakItemDataElementEntity -> ComplexDataElement(generieke_afspraak, complexeWaarde, sleutel, omschrijving)
        is GeoInformatieDataElementEntity -> ComplexDataElement(geo_informatie, complexeWaarde, sleutel, omschrijving)
        is OptieDataElementEntity -> ComplexDataElement(optie, complexeWaarde, sleutel, omschrijving)
        is OptiesDataElementEntity -> OptiesDataElement(gemarshalldeOptieWaarde, sleutel, omschrijving)
        is ReferentietabelRecordItemDataElementEntity -> ComplexDataElement(referentietabel_record, complexeWaarde, sleutel, omschrijving)
        is SelectDocumentElementEntity -> SelectDocumentDataElement(gemarshalldeOptieWaarde, sleutel, omschrijving)
        is StringDataElementEntity -> StringDataElement(waarde, sleutel, omschrijving)
        is StringsDataElementEntity -> StringsDataElement(waarde, sleutel, omschrijving)
        is ToestemmingDigitaleNotificatiesDataElementEntity -> ComplexDataElement(digitale_notificaties, complexeWaarde, sleutel, omschrijving)
        is ZaakBesluitItemDataElementEntity -> ComplexDataElement(zaak_besluit, complexeWaarde, sleutel, omschrijving)
        else -> error("Unsupported DataElementEntity type: ${this.javaClass.name}")
    }

private fun AanvullijstRecordEntity.toAanvullijstRecord() =
    AanvullijstRecord(
        recordNummer = recordNummer,
        itemIdentificatie = itemID,
        itemWaarde = itemWaarde,
    )

private fun DecimaalDataElementEntity.toDecimaalDataElement(naam: String, omschrijving: String?) =
    DecimaalDataElement(
        waarde = waarde,
        formattering = when (formattering) {
            NummerFormattering.GEHEEL_GETAL -> net.atos.esuite.extract.api.model.zaakdata.NummerFormattering.geheel_getal
            NummerFormattering.GEHEEL_GETAL_GEFORMATTEERD -> net.atos.esuite.extract.api.model.zaakdata.NummerFormattering.geheel_getal_geformatteerd
            NummerFormattering.TWEE_DECIMALEN_GEFORMATTEERD -> net.atos.esuite.extract.api.model.zaakdata.NummerFormattering.twee_decimalen_geformatteerd
            NummerFormattering.MAXIMAAL_DECIMALEN_GEFORMATTEERD -> net.atos.esuite.extract.api.model.zaakdata.NummerFormattering.maximaal_decimalen_geformatteerd
            null -> null
        },
        naam = naam,
        omschrijving = omschrijving,
    )
