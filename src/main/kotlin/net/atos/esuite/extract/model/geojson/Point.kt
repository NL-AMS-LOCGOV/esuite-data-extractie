package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty
import java.math.BigDecimal

private val POINT = "POINT"

fun isPoint(wkt: String) = wkt.startsWith(POINT)

@Schema(
    description = "GeoJSON Point Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "Point")]
)
class Point private constructor(val coordinates: Point2D) : Geometry(GeometryType.Point) {
    
    companion object : GeometryFactory {
        override fun createFromWKT(wkt: String) = Point(Point2D(BigDecimal("1.0"), BigDecimal("1.0")))
    }
}
