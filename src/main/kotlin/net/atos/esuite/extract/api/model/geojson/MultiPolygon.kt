package net.atos.esuite.extract.api.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON MultiPolygon Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "MultiPolygon")]
)
class MultiPolygon private constructor(val coordinates: List<Polygon2D>) : Geometry(GeometryType.MultiPolygon)
