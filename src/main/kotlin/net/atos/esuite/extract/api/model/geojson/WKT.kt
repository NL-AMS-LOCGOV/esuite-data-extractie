package net.atos.esuite.extract.api.model.geojson

val SPACE_SEPARATOR = Regex("\\s+")

val COMMA_SEPARATOR = Regex("\\s*,\\s*")

val LEFT_PARENTHESIS_AT_BEGIN = Regex("^\\s*\\(\\s*")

val PARENTHESIS_SURROUNDED_COMMA_SEPARATOR = Regex("\\s*\\)\\s*,\\s*\\(\\s*")

val RIGHT_PARENTHESIS_AT_END = Regex("\\s*\\)\\s*$")

val DOUBLE_LEFT_PARENTHESIS_AT_BEGIN = Regex("^\\s*\\(\\s*\\(\\s*")

val DOUBLE_PARENTHESIS_SURROUNDED_COMMA_SEPARATOR = Regex("\\s*\\)\\s*\\)\\s*,\\s*\\(\\s*\\(\\s*")

val DOUBLE_RIGHT_PARENTHESIS_AT_END = Regex("\\s*\\)\\s*\\)\\s*$")

val GEOMETRY_TYPE_FIRST_LETTER_AT_BEGIN = Regex("^\\s*[A-Z]")

val COMMA_GEOMETRY_TYPE_FIRST_LETTER_SEPARATOR = Regex("\\s*,\\s*[A-Z]")

class WKT(value: String) {

    val geometryType: String

    val coordinates: String

    init {
        val start = value.indexOf('(')
        val end = value.lastIndexOf(')')
        require(start > 0 && end > start && value.substring(end + 1).isBlank()) { "Invalid WKT: $value" }
        geometryType = value.substring(0, start).trim()
        coordinates = value.substring(start + 1, end).trim()
    }
}
