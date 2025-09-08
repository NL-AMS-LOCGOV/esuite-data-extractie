package net.atos.esuite.extract.api.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.DiscriminatorMapping
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(
    oneOf = [
        BooleanDomeinObjectAttribuutWaarde::class,
        DatumDomeinObjectAttribuutWaarde::class,
        DatumTijdDomeinObjectAttribuutWaarde::class,
        DecimaalDomeinObjectAttribuutWaarde::class,
        GeoDomeinObjectAttribuutWaarde::class,
        MemoDomeinObjectAttribuutWaarde::class,
        NummerDomeinObjectAttribuutWaarde::class,
        StringDomeinObjectAttribuutWaarde::class,
        DomeinObjectDomeinObjectAttribuutWaarde::class,
        ReferentietabelRecordDomeinObjectAttribuutWaarde::class,
    ],
    discriminatorProperty = "type",
    discriminatorMapping = [
        DiscriminatorMapping(value = "boolean", schema = BooleanDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "datum", schema = DatumDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "datum_tijd", schema = DatumTijdDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "decimaal", schema = DecimaalDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "geo", schema = GeoDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "memo", schema = MemoDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "nummer", schema = NummerDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "string", schema = StringDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "domein_object", schema = DomeinObjectDomeinObjectAttribuutWaarde::class),
        DiscriminatorMapping(value = "referentietabel_record", schema = ReferentietabelRecordDomeinObjectAttribuutWaarde::class),
    ]
)
abstract class DomeinObjectAttribuutWaarde(

    @field:Schema(description = "Type attribuut waarde")
    val type: DomeinObjectAttribuutWaardeType,

    @field:Schema(description = "Positie van deze waarde tussen andere waarden voor attribuut", required = true)
    val volgnummer: Int,
)
