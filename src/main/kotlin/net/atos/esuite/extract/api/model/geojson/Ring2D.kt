package net.atos.esuite.extract.api.model.geojson

import jakarta.json.bind.adapter.JsonbAdapter
import jakarta.json.bind.annotation.JsonbTypeAdapter
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal

@Schema(
    description = "A connected sequence of four or more points creating a closed ring",
    type = SchemaType.ARRAY,
    implementation = Point2D::class,
    minItems = 4
)
@JsonbTypeAdapter(Ring2DJsonbAdapter::class)
class Ring2D private constructor(val points: List<Point2D>) {

    companion object {
        fun create(coordinates: String): Ring2D? {
            val points = coordinates.split(COMMA_SEPARATOR)
                .map { Point2D.create(it) ?: return null }
            if (points.size < 4) return null
            return Ring2D(points)
        }
    }

    fun toCoordinates() = points.map { it.toCoordinates() }.toTypedArray()
}

class Ring2DJsonbAdapter : JsonbAdapter<Ring2D, Array<Array<BigDecimal>>> {

    override fun adaptToJson(ring: Ring2D): Array<Array<BigDecimal>> = ring.toCoordinates()

    override fun adaptFromJson(json: Array<Array<BigDecimal>>): Ring2D {
        error("Not supported")
    }
}

