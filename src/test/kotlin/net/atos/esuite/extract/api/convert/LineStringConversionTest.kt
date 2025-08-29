package net.atos.esuite.extract.api.convert

import net.atos.esuite.extract.api.convert.zaak.convertToGeoJsonGeometry
import net.atos.esuite.extract.api.model.geojson.LineString
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class LineStringConversionTest {

    @Test
    fun `test LineString conversion`() {
        test("LINESTRING(2 1,1 2)", "2 1", "1 2")
        test("LINESTRING( 2 1,1 2)", "2 1", "1 2")
        test("LINESTRING(2  1,1 2)", "2 1", "1 2")
        test("LINESTRING(2 1 ,1 2)", "2 1", "1 2")
        test("LINESTRING(2 1, 1 2)", "2 1", "1 2")
        test("LINESTRING(2 1,1  2)", "2 1", "1 2")
        test("LINESTRING(2 1,1 2 )", "2 1", "1 2")
        test(
            "LINESTRING(233655.94875 581537.0399999999,233643.34875 581464.7999999999,233755.90875 581456.4,233755.90875 581543.76,233658.46875 581584.9199999999,233618.98875000002 581584.9199999999,233618.98875000002 581535.36,233579.50875 581494.2,233523.22875 581429.52,233692.06875 581416.08,233613.10875 581502.6,233655.10875 581537.88)",
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

        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1 1 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 ,1 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1, 2)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1, 1 2 3)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(A B, C D)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING(2 1 1 2") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("LINESTRING2 1 1 2)") }
    }

    private fun test(wkt: String, vararg expectedCoordinates: String) {
        val geoJsonGeometry = convertToGeoJsonGeometry(wkt)
        assert(geoJsonGeometry is LineString)
        val lineString = geoJsonGeometry as LineString
        assert(lineString.line2D.points.size == expectedCoordinates.size)
        for ((index, point2d) in lineString.line2D.points.withIndex()) {
            val (expectedLongitude, expectedLatitude) = expectedCoordinates[index].split(" ")
            assert(point2d.longitude == BigDecimal(expectedLongitude))
            assert(point2d.latitude == BigDecimal(expectedLatitude))
        }
    }
}
