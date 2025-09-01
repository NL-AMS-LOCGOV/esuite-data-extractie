package net.atos.esuite.extract.api.convert

import net.atos.esuite.extract.api.convert.zaak.convertToGeoJsonGeometry
import net.atos.esuite.extract.api.model.geojson.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class GeometryConversionTest {

    @Test
    fun `test Point conversion`() {
        testPoint(convertToGeoJsonGeometry("POINT(2,1)"), "1 2")
        testPoint(convertToGeoJsonGeometry("POINT( 2,1)"), "1 2")
        testPoint(convertToGeoJsonGeometry("POINT(2 ,1)"), "1 2")
        testPoint(convertToGeoJsonGeometry("POINT(2, 1)"), "1 2")
        testPoint(convertToGeoJsonGeometry("POINT(2,1 )"), "1 2")

        testPoint(convertToGeoJsonGeometry("POINT(1 2)"), "1 2")
        testPoint(convertToGeoJsonGeometry("POINT( 1 2)"), "1 2")
        testPoint(convertToGeoJsonGeometry("POINT(1  2)"), "1 2")
        testPoint(convertToGeoJsonGeometry("POINT(1 2 )"), "1 2")
        testPoint(convertToGeoJsonGeometry("POINT(  1  2  )"), "1 2")

        testPoint(
            convertToGeoJsonGeometry("POINT(48.00692996042, 3.35239326111899)"),
            "3.35239326111899 48.00692996042"
        )

        testPoint(
            convertToGeoJsonGeometry("POINT(3.35239326111899 48.00692996042)"),
            "3.35239326111899 48.00692996042"
        )

        testPoint(
            convertToGeoJsonGeometry("POINT (48.00692996042, 3.35239326111899)"),
            "3.35239326111899 48.00692996042"
        )

        testPoint(
            convertToGeoJsonGeometry("POINT (3.35239326111899 48.00692996042)"),
            "3.35239326111899 48.00692996042"
        )

        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(23.017725521)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT( , 45.862665328)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(45.862665328)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(A B)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(  1  2  3)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(1,  2,  3)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(  1  )") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT  1 3 )") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT  1, 3 )") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(  1 3 ") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(  1, 3 ") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT  1 1, 3 ") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(  1 1 ,  2 2 ) 3 3 ") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(  1 1 ),  2 2 )") }
    }

    @Test
    fun `test LineString conversion`() {
        testLineString(convertToGeoJsonGeometry("LINESTRING(2 1,1 2)"), "2 1", "1 2")
        testLineString(convertToGeoJsonGeometry("LINESTRING( 2 1,1 2)"), "2 1", "1 2")
        testLineString(convertToGeoJsonGeometry("LINESTRING(2  1,1 2)"), "2 1", "1 2")
        testLineString(convertToGeoJsonGeometry("LINESTRING(2 1 ,1 2)"), "2 1", "1 2")
        testLineString(convertToGeoJsonGeometry("LINESTRING(2 1, 1 2)"), "2 1", "1 2")
        testLineString(convertToGeoJsonGeometry("LINESTRING(2 1,1  2)"), "2 1", "1 2")
        testLineString(convertToGeoJsonGeometry("LINESTRING(2 1,1 2 )"), "2 1", "1 2")
        testLineString(convertToGeoJsonGeometry("LINESTRING ( 2 1,1 2 ) "), "2 1", "1 2")
        testLineString(convertToGeoJsonGeometry("LINESTRING(1 2, 3 4, 5 6)"), "1 2", "3 4", "5 6")
        testLineString(
            convertToGeoJsonGeometry("LINESTRING(233655.94875 581537.0399999999,233643.34875 581464.7999999999,233755.90875 581456.4,233755.90875 581543.76,233658.46875 581584.9199999999,233618.98875000002 581584.9199999999,233618.98875000002 581535.36,233579.50875 581494.2,233523.22875 581429.52,233692.06875 581416.08,233613.10875 581502.6,233655.10875 581537.88)"),
            "233655.94875 581537.0399999999",
            "233643.34875 581464.7999999999",
            "233755.90875 581456.4",
            "233755.90875 581543.76",
            "233658.46875 581584.9199999999",
            "233618.98875000002 581584.9199999999",
            "233618.98875000002 581535.36",
            "233579.50875 581494.2",
            "233523.22875 581429.52",
            "233692.06875 581416.08",
            "233613.10875 581502.6",
            "233655.10875 581537.88"
        )

        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1 1 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 ,1 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1, 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1, 1 2 3)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(A B, C D)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1 1 2") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING2 1 1 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1, , 1 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1,,1 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING 2 1,1 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING( 2 1,1 2") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING 2 1,1 2") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(( 2 1,1 2))") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING( ( ( 2 1,1 2 ) ) )") }
    }

    @Test
    fun `test Polygon conversion`() {
        testPolygon(convertToGeoJsonGeometry("POLYGON((1 1, 2 2, 3 3, 4 4))"), arrayOf("1 1", "2 2", "3 3", "4 4"))
        testPolygon(convertToGeoJsonGeometry(" POLYGON( ( 1 1 , 2 2, 3 3, 4 4 ) ) "), arrayOf("1 1", "2 2", "3 3", "4 4"))
        testPolygon(
            convertToGeoJsonGeometry("POLYGON((1 1, 2 2, 3 3, 4 4),(5 5, 6 6, 7 7, 8 8))"),
            arrayOf("1 1", "2 2", "3 3", "4 4"), arrayOf("5 5", "6 6", "7 7", "8 8")
        )
        testPolygon(
            convertToGeoJsonGeometry("POLYGON(  (  1  1  ,  2  2  ,  3   3  ,  4  4  )  ,  (5 5, 6 6, 7 7, 8 8  )  )  "),
            arrayOf("1 1", "2 2", "3 3", "4 4"), arrayOf("5 5", "6 6", "7 7", "8 8")
        )
        testPolygon(
            convertToGeoJsonGeometry("POLYGON((166245.03 458673.60000000003,165243.75 457262.4,166896.87 457107.84,166245.03 458673.60000000003))"),
            arrayOf("166245.03 458673.60000000003", "165243.75 457262.4", "166896.87 457107.84", "166245.03 458673.60000000003")
        )

        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON((1 1, 2 2, 3 3") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON(1 1, 2 2, 3 3, 4 4)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON((1 1, 2 2, 3 3, 4 4)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON(1 1, 2 2, 3 3, 4 4))") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON((1 1, 2 2, 3 3, 4 4), 5 5, 6 6, 7 7, 8 8)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON(((1 1, 2 2, 3 3, 4 4)))") }
    }

    @Test
    fun `test MultiPolygon conversion`() {
        testMultiPolygon(
            convertToGeoJsonGeometry("MULTIPOLYGON(((1 1, 2 2, 3 3, 4 4),(5 5, 6 6, 7 7, 8 8)), ((11 11, 12 12, 13 13, 14 14),(15 15, 16 16, 17 17, 18 18)) )"),
            arrayOf(
                arrayOf("1 1", "2 2", "3 3", "4 4"), arrayOf("5 5", "6 6", "7 7", "8 8")
            ),
            arrayOf(
                arrayOf("11 11", "12 12", "13 13", "14 14"), arrayOf("15 15", "16 16", "17 17", "18 18")
            )
        )
        testMultiPolygon(
            convertToGeoJsonGeometry(
                "MULTIPOLYGON ( ( (177434.705997835 557594.18018044,171190.32 553620.48,170760.24 574156.8,180417.421943131 560605.5930798,176180.569355798 558676.619544103,177434.705997835 557594.18018044), (176180.569355798 558676.619544103,172776.60161435 561614.567892377,173340.72 557383.68,176180.569355798 558676.619544103), (172776.60161435 561614.567892377,172480.56 563834.88,172695.6 561684.48,172776.60161435 561614.567892377) ), ( (180963.277354421 559839.634680086,190758.96 546094.08,177434.705997835 557594.18018044,180963.277354421 559839.634680086) ), ( (180417.421943131 560605.5930798,186565.68 563404.8,180963.277354421 559839.634680086,180417.421943131 560605.5930798) ) )"
            ),
            arrayOf(
                arrayOf(
                    "177434.705997835 557594.18018044",
                    "171190.32 553620.48",
                    "170760.24 574156.8",
                    "180417.421943131 560605.5930798",
                    "176180.569355798 558676.619544103",
                    "177434.705997835 557594.18018044"
                ),
                arrayOf("176180.569355798 558676.619544103", "172776.60161435 561614.567892377", "173340.72 557383.68", "176180.569355798 558676.619544103"),
                arrayOf("172776.60161435 561614.567892377", "172480.56 563834.88", "172695.6 561684.48", "172776.60161435 561614.567892377")
            ),
            arrayOf(
                arrayOf(
                    "180963.277354421 559839.634680086",
                    "190758.96 546094.08",
                    "177434.705997835 557594.18018044",
                    "180963.277354421 559839.634680086"
                )
            ),
            arrayOf(arrayOf("180417.421943131 560605.5930798", "186565.68 563404.8", "180963.277354421 559839.634680086", "180417.421943131 560605.5930798")),
        )

        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("MULTIPOLYGON(1 1, 2 2, 3 3, 4 4)") }
    }

    @Test
    fun `test GeometryCollection conversion`() {
        testGeometryCollection(
            convertToGeoJsonGeometry("GEOMETRYCOLLECTION( POINT(1 2), LINESTRING(1 2, 3 4, 5 6), POLYGON((1 1, 2 2, 3 3, 4 4), (5 5, 6 6, 7 7, 8 8)), MULTIPOLYGON(((1 1, 2 2, 3 3, 4 4),(5 5, 6 6, 7 7, 8 8)), ((11 11, 12 12, 13 13, 14 14),(15 15, 16 16, 17 17, 18 18))))"),
            "1 2",
            arrayOf("1 2", "3 4", "5 6"),
            arrayOf(arrayOf("1 1", "2 2", "3 3", "4 4"), arrayOf("5 5", "6 6", "7 7", "8 8")),
            arrayOf(
                arrayOf(
                    arrayOf("1 1", "2 2", "3 3", "4 4"), arrayOf("5 5", "6 6", "7 7", "8 8")
                ),
                arrayOf(
                    arrayOf("11 11", "12 12", "13 13", "14 14"), arrayOf("15 15", "16 16", "17 17", "18 18")
                )
            )
        )
        testGeometryCollection(
            convertToGeoJsonGeometry("GEOMETRYCOLLECTION(POINT(258248.054 470084.484),POLYGON((258260.95606673326 470093.9980863866,258259.69606673328 470079.71808638657,258278.59606673327 470082.2380863866,258275.23606673325 470097.7780863866,258260.95606673326 470093.9980863866)))"),
            "258248.054 470084.484",
            arrayOf(
                arrayOf(
                    "258260.95606673326 470093.9980863866",
                    "258259.69606673328 470079.71808638657",
                    "258278.59606673327 470082.2380863866",
                    "258275.23606673325 470097.7780863866",
                    "258260.95606673326 470093.9980863866"
                )
            )
        )
    }
}

private fun testPoint(geometry: Geometry, expectedCoordinates: String) {
    assert(geometry is Point)
    val (longitude, lattitude) = (geometry as Point).point2D
    val (expectedLongitude, expectedLatitude) = expectedCoordinates.split(SPACE_SEPARATOR)
    assert(longitude == BigDecimal(expectedLongitude))
    assert(lattitude == BigDecimal(expectedLatitude))
}

private fun testLineString(geometry: Geometry, vararg expectedCoordinates: String) {
    assert(geometry is LineString)
    val lineString = geometry as LineString
    assert(lineString.line2D.points.size == expectedCoordinates.size)
    for ((index, point2D) in lineString.line2D.points.withIndex()) {
        val (expectedLongitude, expectedLatitude) = expectedCoordinates[index].split(SPACE_SEPARATOR)
        assert(point2D.longitude == BigDecimal(expectedLongitude))
        assert(point2D.latitude == BigDecimal(expectedLatitude))
    }
}

private fun testPolygon(geometry: Geometry, vararg expectedCoordinates: Array<String>) {
    assert(geometry is Polygon)
    val polygon = geometry as Polygon
    assert(polygon.polygon2D.rings.size == expectedCoordinates.size)
    for ((ringIndex, ring2d) in polygon.polygon2D.rings.withIndex()) {
        assert(ring2d.points.size == expectedCoordinates[ringIndex].size)
        for ((pointIndex, point2D) in ring2d.points.withIndex()) {
            val (expectedLongitude, expectedLatitude) = expectedCoordinates[ringIndex][pointIndex].split(SPACE_SEPARATOR)
            assert(point2D.longitude == BigDecimal(expectedLongitude))
            assert(point2D.latitude == BigDecimal(expectedLatitude))
        }
    }
}

private fun testMultiPolygon(geometry: Geometry, vararg expectedCoordinates: Array<Array<String>>) {
    assert(geometry is MultiPolygon)
    val multiPpolygon = geometry as MultiPolygon
    assert(multiPpolygon.polygons.size == expectedCoordinates.size)
    for ((polygonIndex, polygon2D) in multiPpolygon.polygons.withIndex()) {
        assert(polygon2D.rings.size == expectedCoordinates[polygonIndex].size)
        for ((ringIndex, ring2d) in polygon2D.rings.withIndex()) {
            assert(ring2d.points.size == expectedCoordinates[polygonIndex][ringIndex].size)
            for ((pointIndex, point2D) in ring2d.points.withIndex()) {
                val (expectedLongitude, expectedLatitude) = expectedCoordinates[polygonIndex][ringIndex][pointIndex].split(SPACE_SEPARATOR)
                assert(point2D.longitude == BigDecimal(expectedLongitude))
                assert(point2D.latitude == BigDecimal(expectedLatitude))
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
private fun testGeometryCollection(geometry: Geometry, vararg expectedCoordinates: Any) {
    assert(geometry is GeometryCollection)
    val geometryCollection = geometry as GeometryCollection
    assert(geometryCollection.geometries.size == expectedCoordinates.size)
    geometryCollection.geometries.forEachIndexed { index, geometry ->
        when (geometry.type) {
            GeometryType.Point -> testPoint(geometry, expectedCoordinates[index] as String)
            GeometryType.LineString -> testLineString(geometry, *(expectedCoordinates[index] as Array<String>))
            GeometryType.Polygon -> testPolygon(geometry, *(expectedCoordinates[index] as Array<Array<String>>))
            GeometryType.MultiPolygon -> testMultiPolygon(geometry, *(expectedCoordinates[index] as Array<Array<Array<String>>>))
            else -> assert(false)
        }
    }
}
