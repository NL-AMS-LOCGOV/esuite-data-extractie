package net.atos.esuite.extract.api.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON GeometryCollection Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "GeometryCollection")]
)
class GeometryCollection(
    @field:Schema(name = "geometries")
    val geometries: List<Geometry>
) : Geometry(GeometryType.GeometryCollection)

fun WKT.isGeometryCollection() = geometryType == "GEOMETRYCOLLECTION"

fun WKT.createGeometryCollection() =
    GeometryCollection(
        coordinates.replaceFirst(GEOMETRY_TYPE_FIRST_LETTER_AT_BEGIN, "")
            .split(COMMA_GEOMETRY_TYPE_FIRST_LETTER_SEPARATOR)
            .map { toGeometry(it) ?: error("WKT contains invalid GeometryCollection coordinates: $coordinates") }
    )

private fun toGeometry(wkt: String): Geometry? {
    return when {
        wkt.startsWith(POINT.substring(1)) -> WKT(wkt).createPoint()
        wkt.startsWith(LINESTRING.substring(1)) -> WKT(wkt).createLineString()
        wkt.startsWith(POLYGON.substring(1)) -> WKT(wkt).createPolygon()
        wkt.startsWith(MULTIPOLYGON.substring(1)) -> WKT(wkt).createMultiPolygon()
        else -> null
    }
}
