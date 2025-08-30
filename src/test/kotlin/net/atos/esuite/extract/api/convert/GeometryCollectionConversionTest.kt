package net.atos.esuite.extract.api.convert

import org.junit.jupiter.api.Test

class GeometryCollectionConversionTest {

    @Test
    fun `test GeometryCollection conversion`() {
        test("GEOMETRYCOLLECTION(POINT(1 2),LINESTRING(1 2,3 4))", "POINT (1 2)", "LINESTRING (1 2, 3 4)")
        test("GEOMETRYCOLLECTION(POINT(258248.054 470084.484),POLYGON((258260.95606673326 470093.9980863866,258259.69606673328 470079.71808638657,258278.59606673327 470082.2380863866,258275.23606673325 470097.7780863866,258260.95606673326 470093.9980863866)))")
    }

    private fun test(wkt: String, vararg expected: String) {
        TODO() // ToDo
    }
}
