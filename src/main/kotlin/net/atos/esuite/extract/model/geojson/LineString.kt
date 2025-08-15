package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty
import java.math.BigDecimal

private val LINESTRING = "LINESTRING"

fun isLineString(wkt: WKT) = wkt.value.startsWith(LINESTRING)

@Schema(
    description = "GeoJSON LineString Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "LineString")]
)
class LineString private constructor(val coordinates: Line2D) : Geometry(GeometryType.LineString) {
    
    companion object : GeometryFactory {
        override fun create(wkt: WKT) = LineString(
            Line2D(
                listOf(
                    Point2D(BigDecimal("1.0"), BigDecimal("1.0")),
                    Point2D(BigDecimal("1.0"), BigDecimal("1.0"))
                )
            )
        )
    }

}
