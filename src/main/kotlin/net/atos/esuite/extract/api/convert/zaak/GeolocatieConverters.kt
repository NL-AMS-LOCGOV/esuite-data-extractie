package net.atos.esuite.extract.api.convert.zaak

import net.atos.esuite.extract.api.model.geojson.*

fun convertToGeoJsonGeometry(wkt: String): Geometry {
    return with(WKT(wkt)) {
        when {
            isPoint() -> createPoint()
            isLineString() -> createLineString()
            isPolygon() -> createPolygon()
            isMultiPolygon() -> createMultiPolygon()
            isGeometryCollection() -> createGeometryCollection()
            else -> error("Unsupported geometry type: $geometryType")
        }
    }
}
