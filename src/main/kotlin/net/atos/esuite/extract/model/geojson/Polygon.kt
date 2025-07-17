package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(description = "GeoJSON Polygon Geometry object")
class Polygon(
    val coordinates: Polygon2D
) : GeoJsonGeometry(GeometryType.Polygon)
