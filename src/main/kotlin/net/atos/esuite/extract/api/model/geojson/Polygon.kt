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

fun WKT.isPolygon() = geometryType == "POLYGON"

fun WKT.createPolygon(): Polygon {
    val polygon2D = Polygon2D.create(coordinates)
    require(polygon2D != null) { "WKT contains invalid Polygon coordinates: $coordinates" }
    return Polygon(polygon2D)
}
