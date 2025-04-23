package net.atos.esuite.extract.model.zaakdata

import net.atos.esuite.extract.model.Bedrijf
import net.atos.esuite.extract.model.Persoon
import org.eclipse.microprofile.openapi.annotations.media.DiscriminatorMapping
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(
    oneOf = [
        AanvullijstDataElement::class,
        BooleanDataElement::class,
        CalendarDataElement::class,
        ComplexDataElement::class,
        DecimaalDataElement::class,
        DecimalenDataElement::class,
        DocumentDataElement::class,
        OptiesDataElement::class,
        SelectDocumentDataElement::class,
        StringDataElement::class,
        StringsDataElement::class,
    ],
    discriminatorProperty = "type",
    discriminatorMapping = [
        DiscriminatorMapping("aanvullijst", schema = AanvullijstDataElement::class),
        DiscriminatorMapping("boolean", schema = BooleanDataElement::class),
        DiscriminatorMapping("calendar", schema = CalendarDataElement::class),
        DiscriminatorMapping("datummettijdstip", schema = CalendarDataElement::class),
        DiscriminatorMapping("adresgegevens", schema = ComplexDataElement::class),
        DiscriminatorMapping("afstand", schema = ComplexDataElement::class),
        DiscriminatorMapping("generieke_afspraak", schema = ComplexDataElement::class),
        DiscriminatorMapping("geo_informatie", schema = ComplexDataElement::class),
        DiscriminatorMapping("optie", schema = ComplexDataElement::class),
        DiscriminatorMapping("referentietabel_record", schema = ComplexDataElement::class),
        DiscriminatorMapping("digitale_notificaties", schema = ComplexDataElement::class),
        DiscriminatorMapping("zaak_besluit", schema = ComplexDataElement::class),
        DiscriminatorMapping("decimaal", schema = DecimaalDataElement::class),
        DiscriminatorMapping("decimalen", schema = DecimalenDataElement::class),
        DiscriminatorMapping("zaak_documenten", schema = DocumentDataElement::class),
        DiscriminatorMapping("opties", schema = OptiesDataElement::class),
        DiscriminatorMapping("select_documents", schema = SelectDocumentDataElement::class),
        DiscriminatorMapping("string", schema = StringDataElement::class),
        DiscriminatorMapping("strings", schema = StringsDataElement::class),
    ]
)
abstract class DataElement(
    @field:Schema(description = "Type data element")
    val type: DataElementType
) {
    @Schema(description = "Naam van data element", maxLength = 255)
    var naam: String = ""

    @Schema(description = "Omschrijving of verklarende waarde voor data element")
    var omschrijving: String? = null
}
