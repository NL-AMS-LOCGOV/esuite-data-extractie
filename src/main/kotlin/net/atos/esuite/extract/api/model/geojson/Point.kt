package net.atos.esuite.extract.api.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON Point Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "Point")]
)
class Point(
    @field:Schema(name = "coordinates")
    val point2D: Point2D
) : Geometry(GeometryType.Point)

val POINT = "POINT"

fun WKT.isPoint() = geometryType == POINT

fun WKT.createPoint(): Point {
    val point2D = Point2D.create(coordinates)
    require(point2D != null) { "WKT contains invalid Point coordinates: $coordinates" }
    return Point(point2D)
}
