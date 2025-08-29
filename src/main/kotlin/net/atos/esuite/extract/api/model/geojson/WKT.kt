package net.atos.esuite.extract.api.model.geojson

val SPACE_SEPARATOR_REGEX = Regex("\\s+")

val COMMA_SEPARATOR_REGEX = Regex("\\s*,\\s*")

val NESTED_COMMA_SEPARATOR_REGEX = Regex("\\s*\\)\\s*,\\s*\\(\\s*")

class WKT(value: String) {

    val geometryType: String

    val coordinates: String

    init {
        val start = value.indexOf('(')
        val end = value.lastIndexOf(')')
        require(start > 0 && end > start) { "Invalid WKT: $value" }
        geometryType = value.substring(0, start).trim()
        coordinates = value.substring(start + 1, end).trim()
    }
}
