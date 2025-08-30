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

fun WKT.createGeometryCollection() = GeometryCollection(emptyList()) // ToDo: implement
