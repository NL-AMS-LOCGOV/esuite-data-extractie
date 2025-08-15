package net.atos.esuite.extract.converter.zaak

import net.atos.esuite.extract.model.geojson.LineString
import net.atos.esuite.extract.model.geojson.Point
import net.atos.esuite.extract.model.geojson.isLineString
import net.atos.esuite.extract.model.geojson.isPoint

fun convertToGeoJsonGeometry(wkt: String) =
    when {
        isPoint(wkt) -> Point.createFromWKT(wkt)
        isLineString(wkt) -> LineString.createFromWKT(wkt)
        else -> error("Unsupported geometry type: $wkt")
    }
