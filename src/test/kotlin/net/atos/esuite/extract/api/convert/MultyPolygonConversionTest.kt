package net.atos.esuite.extract.api.convert

import net.atos.esuite.extract.api.convert.zaak.convertToGeoJsonGeometry
import net.atos.esuite.extract.api.model.geojson.MultiPolygon
import net.atos.esuite.extract.api.model.geojson.SPACE_SEPARATOR
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class MultyPolygonConversionTest {

    @Test
    fun `test Polygon conversion`() {
        test(
            "MULTIPOLYGON ( ( (177434.705997835 557594.18018044,171190.32 553620.48,170760.24 574156.8,180417.421943131 560605.5930798,176180.569355798 558676.619544103,177434.705997835 557594.18018044), (176180.569355798 558676.619544103,172776.60161435 561614.567892377,173340.72 557383.68,176180.569355798 558676.619544103), (172776.60161435 561614.567892377,172480.56 563834.88,172695.6 561684.48,172776.60161435 561614.567892377) ), ( (180963.277354421 559839.634680086,190758.96 546094.08,177434.705997835 557594.18018044,180963.277354421 559839.634680086) ), ( (180417.421943131 560605.5930798,186565.68 563404.8,180963.277354421 559839.634680086,180417.421943131 560605.5930798) ) )",
            listOf(
                listOf(
                    "177434.705997835 557594.18018044",
                    "171190.32 553620.48",
                    "170760.24 574156.8",
                    "180417.421943131 560605.5930798",
                    "176180.569355798 558676.619544103",
                    "177434.705997835 557594.18018044"
                ),
                listOf("176180.569355798 558676.619544103", "172776.60161435 561614.567892377", "173340.72 557383.68", "176180.569355798 558676.619544103"),
                listOf("172776.60161435 561614.567892377", "172480.56 563834.88", "172695.6 561684.48", "172776.60161435 561614.567892377")
            ),
            listOf(listOf("180963.277354421 559839.634680086", "190758.96 546094.08", "177434.705997835 557594.18018044", "180963.277354421 559839.634680086")),
            listOf(listOf("180417.421943131 560605.5930798", "186565.68 563404.8", "180963.277354421 559839.634680086", "180417.421943131 560605.5930798")),
        )

        assertThrows<IllegalArgumentException> { convertToGeoJsonGeometry("MULTIPOLYGON(1 1, 2 2, 3 3, 4 4)") }
    }

    private fun test(wkt: String, vararg expectedCoordinates: List<List<String>>) {
        val geoJsonGeometry = convertToGeoJsonGeometry(wkt)
        assert(geoJsonGeometry is MultiPolygon)
        val multiPpolygon = geoJsonGeometry as MultiPolygon
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
}
