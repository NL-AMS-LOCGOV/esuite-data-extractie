package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(description = "GeoJSON LineString Geometry object")
class LineString(
    val coordinates: Line2D
) : GeoJsonGeometry(GeometryType.LineString)
