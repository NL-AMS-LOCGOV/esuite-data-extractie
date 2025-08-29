package net.atos.esuite.extract.api.convert

import net.atos.esuite.extract.api.convert.zaak.convertToGeoJsonGeometry
import net.atos.esuite.extract.api.model.geojson.Point
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class PointConversionTest {

    @Test
    fun `test Point conversion`() {
        test("POINT(2,1)", "1", "2")
        test("POINT( 2,1)", "1", "2")
        test("POINT(2 ,1)", "1", "2")
        test("POINT(2, 1)", "1", "2")
        test("POINT(2,1 )", "1", "2")

        test("POINT(1 2)", "1", "2")
        test("POINT( 1 2)", "1", "2")
        test("POINT(1  2)", "1", "2")
        test("POINT(1 2 )", "1", "2")
        test("POINT(  1  2  )", "1", "2")

        test("POINT(48.00692996042, 3.35239326111899)", "3.35239326111899", "48.00692996042")
        test("POINT(3.35239326111899 48.00692996042)", "3.35239326111899", "48.00692996042")
        test("POINT (48.00692996042, 3.35239326111899)", "3.35239326111899", "48.00692996042")
        test("POINT (3.35239326111899 48.00692996042)", "3.35239326111899", "48.00692996042")

        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(23.017725521)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT( , 45.862665328)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(45.862665328)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(A B)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(  1  2  3)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(1,  2,  3)") }
        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("POINT(  1  )") }
    }

    private fun test(wkt: String, expectedLongitude: String, expectedLatitude: String) {
        val geoJsonGeometry = convertToGeoJsonGeometry(wkt)
        assert(geoJsonGeometry is Point)
        val (longitude, lattitude) = (geoJsonGeometry as Point).point2D
        assert(longitude == BigDecimal(expectedLongitude))
        assert(lattitude == BigDecimal(expectedLatitude))
    }
}
