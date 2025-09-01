package net.atos.esuite.extract.api.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON Polygon Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "Polygon")]
)
class Polygon(
    @field:Schema(name = "coordinates")
    val polygon2D: Polygon2D
) : Geometry(GeometryType.Polygon)

val POLYGON = "POLYGON"

fun WKT.isPolygon() = geometryType == POLYGON

fun WKT.createPolygon(): Polygon {
    val invalidWKTMessage = { "WKT contains invalid Polygon coordinates: $coordinates" }
    require(coordinates.contains(LEFT_PARENTHESIS_AT_BEGIN) && coordinates.contains(RIGHT_PARENTHESIS_AT_END)) { invalidWKTMessage() }
    val polygon2D = Polygon2D.create(
        coordinates
            .replaceFirst(LEFT_PARENTHESIS_AT_BEGIN, "")
            .replaceFirst(RIGHT_PARENTHESIS_AT_END, "")
    )
    require(polygon2D != null) { invalidWKTMessage() }
    return Polygon(polygon2D)
}
