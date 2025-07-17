package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(description = "GeoJSON MultiLineString Geometry object")
class MultiLineString(
    val coordinates: List<Line2D>
) : GeoJsonGeometry(GeometryType.MultiLineString)
