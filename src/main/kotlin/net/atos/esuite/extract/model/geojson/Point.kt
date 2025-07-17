package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(description = "GeoJSON Point Geometry object")
class Point(
    val coordinates: Point2D,
) : GeoJsonGeometry(GeometryType.Point)
