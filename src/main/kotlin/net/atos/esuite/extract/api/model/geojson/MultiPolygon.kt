package net.atos.esuite.extract.api.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON MultiPolygon Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "MultiPolygon")]
)
class MultiPolygon(
    @field:Schema(name = "coordinates")
    val polygons: List<Polygon2D>
) : Geometry(GeometryType.MultiPolygon)

fun WKT.isMultiPolygon() = geometryType == "MULTIPOLYGON"

fun WKT.createMultiPolygon(): MultiPolygon {
    val invalidWKTMessage = { "WKT contains invalid MultiPolygon coordinates: $coordinates" }
    require(coordinates.contains(DOUBLE_LEFT_PARENTHESIS_AT_BEGIN) && coordinates.contains(DOUBLE_RIGHT_PARENTHESIS_AT_END)) { invalidWKTMessage() }
    val polygons2D: List<Polygon2D> = coordinates
        .replaceFirst(DOUBLE_LEFT_PARENTHESIS_AT_BEGIN, "")
        .replaceFirst(DOUBLE_RIGHT_PARENTHESIS_AT_END, "")
        .split(DOUBLE_PARENTHESIS_SURROUNDED_COMMA_SEPARATOR)
        .map { Polygon2D.create(it) ?: throw IllegalArgumentException(invalidWKTMessage()) }
    require(polygons2D.isNotEmpty()) { invalidWKTMessage() }
    return MultiPolygon(polygons2D)
}

