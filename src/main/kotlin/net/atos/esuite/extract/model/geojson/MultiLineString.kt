package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON MultiLineString Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "MultiLineString")]
)
class MultiLineString private constructor(val coordinates: List<Line2D>) : Geometry(GeometryType.MultiLineString)
