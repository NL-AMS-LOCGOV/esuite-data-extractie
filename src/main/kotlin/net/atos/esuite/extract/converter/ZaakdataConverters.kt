package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AanvullijstDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AanvullijstRecordEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AdresgegevensDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AfstandDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.BooleanDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.CalendarDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.DatumMetTijdStipDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.DecimaalDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.DecimalenDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.DocumentDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.GeneriekeAfspraakItemDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.GeoInformatieDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.NummerFormattering
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.OptieDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.OptiesDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.ReferentietabelRecordItemDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.SelectDocumentElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.StringDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.StringsDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.ToestemmingDigitaleNotificatiesDataElementEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.ZaakBesluitItemDataElementEntity
import net.atos.esuite.extract.model.zaakdata.AanvullijstDataElement
import net.atos.esuite.extract.model.zaakdata.AanvullijstRecord
import net.atos.esuite.extract.model.zaakdata.DataElement
import net.atos.esuite.extract.model.zaakdata.BooleanDataElement
import net.atos.esuite.extract.model.zaakdata.CalendarDataElement
import net.atos.esuite.extract.model.zaakdata.ComplexDataElement
import net.atos.esuite.extract.model.zaakdata.DataElementType.*
import net.atos.esuite.extract.model.zaakdata.DecimaalDataElement
import net.atos.esuite.extract.model.zaakdata.DecimalenDataElement
import net.atos.esuite.extract.model.zaakdata.DocumentDataElement
import net.atos.esuite.extract.model.zaakdata.OptiesDataElement
import net.atos.esuite.extract.model.zaakdata.SelectDocumentDataElement
import net.atos.esuite.extract.model.zaakdata.StringDataElement
import net.atos.esuite.extract.model.zaakdata.StringsDataElement

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
        is DocumentDataElementEntity -> DocumentDataElement(documentEntities.map {it.bestandsNaam})
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
        else -> error("Unsupported data element type: ${this.javaClass.name}")
    }.also {
        it.naam = sleutel
        it.omschrijving = omschrijving
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
            NummerFormattering.GEHEEL_GETAL -> net.atos.esuite.extract.model.zaakdata.NummerFormattering.geheel_getal
            NummerFormattering.GEHEEL_GETAL_GEFORMATTEERD -> net.atos.esuite.extract.model.zaakdata.NummerFormattering.geheel_getal_geformatteerd
            NummerFormattering.TWEE_DECIMALEN_GEFORMATTEERD -> net.atos.esuite.extract.model.zaakdata.NummerFormattering.twee_decimalen_geformatteerd
            NummerFormattering.MAXIMAAL_DECIMALEN_GEFORMATTEERD -> net.atos.esuite.extract.model.zaakdata.NummerFormattering.maximaal_decimalen_geformatteerd
            null -> null
        }
    )
