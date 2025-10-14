package net.atos.esuite.extract.api.convert

import net.atos.esuite.extract.api.model.geojson.*

fun String.convertToGeoJsonGeometry(): Geometry {
    return with(WKT(this)) {
        when {
            isPoint() -> createPoint()
            isLineString() -> createLineString()
            isPolygon() -> createPolygon()
            isMultiPolygon() -> createMultiPolygon()
            isGeometryCollection() -> createGeometryCollection()
            else -> error("Unsupported geometry type: $this")
        }
    }
}
