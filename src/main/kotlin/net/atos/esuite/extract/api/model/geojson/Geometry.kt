package net.atos.esuite.extract.api.model.geojson

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

// Well-Known Text
@JvmInline
value class WKT(val value: String)

interface GeometryFactory {
    fun create(wkt: WKT): Geometry
}
