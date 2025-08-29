package net.atos.esuite.extract.api.convert.zaak

import net.atos.esuite.extract.api.model.geojson.*

fun convertToGeoJsonGeometry(wkt: String): Geometry? {
    if (wkt.isBlank()) return null

    return with(WKT(wkt)) {
        when {
            isPoint() -> createPoint()
            isLineString() -> createLineString()
            isPolygon() -> createPolygon()
            else -> error("Unsupported geometry type: $geometryType")
        }
    }
}
