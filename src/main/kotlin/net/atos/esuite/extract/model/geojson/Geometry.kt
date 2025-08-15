package net.atos.esuite.extract.model.geojson

import org.eclipse.microprofile.openapi.annotations.media.DiscriminatorMapping
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(
    description = "GeoJSON Geometry object in coördinatensysteem: RD-NEW (EPSG-code: 28992)",
    discriminatorProperty = "type",
    discriminatorMapping = [
        DiscriminatorMapping("Point", schema = Point::class),
        DiscriminatorMapping("LineString", schema = LineString::class),
        DiscriminatorMapping("MultiLineString", schema = MultiLineString::class),
        DiscriminatorMapping("Polygon", schema = Polygon::class),
        DiscriminatorMapping("MultiPolygon", schema = MultiPolygon::class),
        DiscriminatorMapping("GeometryCollection", schema = GeometryCollection::class)
    ],
    oneOf = [
        Point::class,
        LineString::class,
        MultiLineString::class,
        Polygon::class,
        MultiPolygon::class,
        GeometryCollection::class
    ]
)
sealed class Geometry(
    @field:Schema(description = "Geometry type")
    val type: GeometryType,
)

interface GeometryFactory {
    fun createFromWKT(wkt: String): Geometry
}
