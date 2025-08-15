package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON Polygon Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "Polygon")]
)
class Polygon private constructor(val coordinates: Polygon2D) : Geometry(GeometryType.Polygon)
