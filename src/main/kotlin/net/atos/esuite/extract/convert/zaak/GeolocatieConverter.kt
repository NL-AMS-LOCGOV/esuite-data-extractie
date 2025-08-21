package net.atos.esuite.extract.convert.zaak

import net.atos.esuite.extract.api.model.geojson.*

fun convertToGeoJsonGeometry(wkt: WKT) =
    when {
        isPoint(wkt) -> Point.create(wkt)
        isLineString(wkt) -> LineString.create(wkt)
        else -> error("Unsupported geometry type: $wkt")
    }
