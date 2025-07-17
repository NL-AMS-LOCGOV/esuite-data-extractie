package net.atos.esuite.extract.converter.zaak

import net.atos.esuite.extract.model.geojson.GeoJsonGeometry
import net.atos.esuite.extract.model.geojson.Point
import net.atos.esuite.extract.model.geojson.Point2D
import java.math.BigDecimal

fun convertToGeoJsonGeometry(wkt: String): GeoJsonGeometry {
     return Point(Point2D(BigDecimal("1.0"), BigDecimal("2.0")))
}

