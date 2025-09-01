package net.atos.esuite.extract.api.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON LineString Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "LineString")]
)
class LineString(
    @field:Schema(name = "coordinates")
    val line2D: Line2D
) : Geometry(GeometryType.LineString)

val LINESTRING = "LINESTRING"

fun WKT.isLineString() = geometryType == LINESTRING

fun WKT.createLineString(): LineString {
    val line2D = Line2D.create(coordinates)
    require(line2D != null) { "WKT contains invalid LineString coordinates: $coordinates" }
    return LineString(line2D)
}
