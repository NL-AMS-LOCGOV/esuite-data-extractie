package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(description = "GeoJSON GeometryCollection Geometry object")
class GeometryCollection(
    val geometries: List<GeoJsonGeometry>
) : GeoJsonGeometry(GeometryType.GeometryCollection)
