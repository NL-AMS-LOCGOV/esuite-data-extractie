package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(description = "GeoJSON MultiPolygon Geometry object")
class MultiPolygon(
    val coordinates: List<Polygon2D>
) : GeoJsonGeometry(GeometryType.MultiPolygon)
