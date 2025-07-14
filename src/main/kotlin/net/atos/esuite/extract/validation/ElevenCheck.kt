package net.atos.esuite.extract.validation

/**
 * Checks if the input string is a number that conforms to the eleven-check.
 *
 * @param value Input string to check
 * @return true if input commits to eleven-check
 */
fun commitsToElevenCheck(value: String): Boolean {
    val length = value.length
    var check = 0

    for (i in length downTo 2) {
        check += i * value[length - i].digitToInt()
    }

    check += -1 * value[length - 1].digitToInt()

    return check % 11 == 0
}
