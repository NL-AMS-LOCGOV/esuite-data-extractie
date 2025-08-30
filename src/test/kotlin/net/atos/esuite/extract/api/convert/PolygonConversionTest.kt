package net.atos.esuite.extract.api.convert

import net.atos.esuite.extract.api.convert.zaak.convertToGeoJsonGeometry
import net.atos.esuite.extract.api.model.geojson.Polygon
import net.atos.esuite.extract.api.model.geojson.SPACE_SEPARATOR
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class PolygonConversionTest {

    @Test
    fun `test Polygon conversion`() {
        test("POLYGON((1 1, 2 2, 3 3, 4 4))", listOf("1 1", "2 2", "3 3", "4 4"))
        test(" POLYGON( ( 1 1 , 2 2, 3 3, 4 4 ) ) ", listOf("1 1", "2 2", "3 3", "4 4"))
        test(
            "POLYGON((1 1, 2 2, 3 3, 4 4),(5 5, 6 6, 7 7, 8 8))",
            listOf("1 1", "2 2", "3 3", "4 4"), listOf("5 5", "6 6", "7 7", "8 8")
        )
        test(
            "POLYGON(  (  1  1  ,  2  2  ,  3   3  ,  4  4  )  ,  (5 5, 6 6, 7 7, 8 8  )  )  ",
            listOf("1 1", "2 2", "3 3", "4 4"), listOf("5 5", "6 6", "7 7", "8 8")
        )
        test(
            "POLYGON((166245.03 458673.60000000003,165243.75 457262.4,166896.87 457107.84,166245.03 458673.60000000003))",
            listOf("166245.03 458673.60000000003", "165243.75 457262.4", "166896.87 457107.84", "166245.03 458673.60000000003")
        )

        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON((1 1, 2 2, 3 3") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON(1 1, 2 2, 3 3, 4 4)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON((1 1, 2 2, 3 3, 4 4)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON(1 1, 2 2, 3 3, 4 4))") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON((1 1, 2 2, 3 3, 4 4), 5 5, 6 6, 7 7, 8 8)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POLYGON(((1 1, 2 2, 3 3, 4 4)))") }
    }

    private fun test(wkt: String, vararg expectedCoordinates: List<String>) {
        val geoJsonGeometry = convertToGeoJsonGeometry(wkt)
        assert(geoJsonGeometry is Polygon)
        val polygon = geoJsonGeometry as Polygon
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
}
