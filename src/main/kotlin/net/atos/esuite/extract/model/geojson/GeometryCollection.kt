package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty

@Schema(
    description = "GeoJSON GeometryCollection Geometry object",
    properties = [SchemaProperty(name = "type", defaultValue = "GeometryCollection")]
)
class GeometryCollection private constructor(val geometries: List<Geometry>) : Geometry(GeometryType.GeometryCollection)
