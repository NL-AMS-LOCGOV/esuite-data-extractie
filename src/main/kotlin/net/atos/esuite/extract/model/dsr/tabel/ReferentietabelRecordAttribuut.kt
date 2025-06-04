package net.atos.esuite.extract.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.DiscriminatorMapping
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(
    oneOf = [
        BooleanReferentietabelRecordAttribuut::class,
        DatumReferentietabelRecordAttribuut::class,
        DatumTijdReferentietabelRecordAttribuut::class,
        DecimaalReferentietabelRecordAttribuut::class,
        GeoReferentietabelRecordAttribuut::class,
        MemoReferentietabelRecordAttribuut::class,
        NummerReferentietabelRecordAttribuut::class,
        StringReferentietabelRecordAttribuut::class,
    ],
    discriminatorProperty = "type",
    discriminatorMapping = [
        DiscriminatorMapping(value = "boolean", schema = BooleanReferentietabelRecordAttribuut::class),
        DiscriminatorMapping(value = "datum", schema = DatumReferentietabelRecordAttribuut::class),
        DiscriminatorMapping(value = "datum_tijd", schema = DatumTijdReferentietabelRecordAttribuut::class),
        DiscriminatorMapping(value = "decimaal", schema = DecimaalReferentietabelRecordAttribuut::class),
        DiscriminatorMapping(value = "geo", schema = GeoReferentietabelRecordAttribuut::class),
        DiscriminatorMapping(value = "memo", schema = MemoReferentietabelRecordAttribuut::class),
        DiscriminatorMapping(value = "nummer", schema = NummerReferentietabelRecordAttribuut::class),
        DiscriminatorMapping(value = "string", schema = StringReferentietabelRecordAttribuut::class),
    ]
)
abstract class ReferentietabelRecordAttribuut(

    @field:Schema(description = "Attribuut type")
    val type: ReferentietabelRecordAttribuutType,
) {
    @Schema(description = "Naam van attribuut", maxLength = 128 )
    var naam: String = ""

    @Schema(description = "Omschrijving van attribuut")
    var omschrijving: String? = null
}

