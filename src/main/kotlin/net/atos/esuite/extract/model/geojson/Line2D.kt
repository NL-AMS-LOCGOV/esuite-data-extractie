package net.atos.esuite.extract.model.geojson

import jakarta.json.bind.adapter.JsonbAdapter
import jakarta.json.bind.annotation.JsonbTypeAdapter
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal

@Schema(
    description = "A connected sequence of two or more points",
    type = SchemaType.ARRAY,
    implementation = Point2D::class,
    minItems = 2)
@JsonbTypeAdapter(Line2DJsonbAdapter::class)
class Line2D (
    val points: List<Point2D>
) {
    fun toCoordinates() = points.map { it.toCoordinates() }.toTypedArray()
}

class Line2DJsonbAdapter : JsonbAdapter<Line2D, Array<Array<BigDecimal>>> {

    override fun adaptToJson(line: Line2D): Array<Array<BigDecimal>> = line.toCoordinates()

    override fun adaptFromJson(json: Array<Array<BigDecimal>>): Line2D {
        error("Not supported")
    }
}

