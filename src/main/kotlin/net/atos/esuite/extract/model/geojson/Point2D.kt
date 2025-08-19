package net.atos.esuite.extract.model.geojson

import jakarta.json.bind.adapter.JsonbAdapter
import jakarta.json.bind.annotation.JsonbTypeAdapter
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal

@Schema(
    description = "Position as [longitude, latitude]",
    type = SchemaType.ARRAY,
    implementation = BigDecimal::class,
    minItems = 2, maxItems = 2
)
@JsonbTypeAdapter(Point2DJsonbAdapter::class)
data class Point2D(
    private val longitude: BigDecimal,
    private val latitude: BigDecimal,
) {
    fun toCoordinates() = arrayOf(longitude, latitude)
}

class Point2DJsonbAdapter : JsonbAdapter<Point2D, Array<BigDecimal>> {

    override fun adaptToJson(point2D: Point2D): Array<BigDecimal> = point2D.toCoordinates()

    override fun adaptFromJson(json: Array<BigDecimal>): Point2D {
        error("Not supported")
    }
}
