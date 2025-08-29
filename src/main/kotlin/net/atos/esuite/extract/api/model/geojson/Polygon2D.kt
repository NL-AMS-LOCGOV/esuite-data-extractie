package net.atos.esuite.extract.api.model.geojson

import jakarta.json.bind.adapter.JsonbAdapter
import jakarta.json.bind.annotation.JsonbTypeAdapter
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal

@Schema(
    description = "The first ring is the outer boundary. Any subsequent rings represent holes (interior boundaries)",
    type = SchemaType.ARRAY,
    implementation = Ring2D::class,
)
@JsonbTypeAdapter(Polygon2DJsonbAdapter::class)
class Polygon2D(val rings: List<Ring2D>) {
    fun toCoordinates() = rings.map { it.toCoordinates() }.toTypedArray()
}

class Polygon2DJsonbAdapter : JsonbAdapter<Polygon2D, Array<Array<Array<BigDecimal>>>> {
    override fun adaptToJson(polygon: Polygon2D): Array<Array<Array<BigDecimal>>> = polygon.toCoordinates()

    override fun adaptFromJson(json: Array<Array<Array<BigDecimal>>>): Polygon2D {
        error("Not supported")
    }
}
