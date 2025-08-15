package net.atos.esuite.extract.converter.zaak

import net.atos.esuite.extract.model.geojson.LineString
import net.atos.esuite.extract.model.geojson.Point
import net.atos.esuite.extract.model.geojson.WKT
import net.atos.esuite.extract.model.geojson.isLineString
import net.atos.esuite.extract.model.geojson.isPoint

fun convertToGeoJsonGeometry(wkt: WKT) =
    when {
        isPoint(wkt) -> Point.create(wkt)
        isLineString(wkt) -> LineString.create(wkt)
        else -> error("Unsupported geometry type: $wkt")
    }
