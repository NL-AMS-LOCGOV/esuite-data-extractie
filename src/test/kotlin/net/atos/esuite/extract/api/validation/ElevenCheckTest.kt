package net.atos.esuite.extract.api.validation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Test class for the `commitsToElevenCheck` function in the `ElevenCheckKt` class.
 *
 * The function validates whether a string of digits satisfies a numeric condition
 * related to modulus operation by 11.
 */
class ElevenCheckTest {

    @Test
    fun `test commitsToElevenCheck with valid input that meets the condition`() {
        val validInput = "357997530" // Example input where the function should return true
        val result = commitsToElevenCheck(validInput)
        assertTrue(result, "Expected input '$validInput' to satisfy the eleven check condition")
    }

    @Test
    fun `test commitsToElevenCheck with valid input that does not meet the condition`() {
        val invalidInput = "357997531" // Example input where the function should return false
        val result = commitsToElevenCheck(invalidInput)
        assertFalse(result, "Expected input '$invalidInput' to not satisfy the eleven check condition")
    }

    @Test
    fun `test commitsToElevenCheck with single digit input`() {
        val singleDigitInput = "6" // Single-digit input, should always return false
        val result = commitsToElevenCheck(singleDigitInput)
        assertFalse(result, "Expected single-digit input '$singleDigitInput' to not satisfy the eleven check condition")
    }

    @Test
    fun `test commitsToElevenCheck with all zeroes input`() {
        val allZeroesInput = "00000" // Input with all zeroes, should return true
        val result = commitsToElevenCheck(allZeroesInput)
        assertTrue(result, "Expected input '$allZeroesInput' to satisfy the eleven check condition")
    }

    @Test
    fun `test commitsToElevenCheck with empty string input`() {
        val emptyInput = "" // Empty input, should throw an exception or handle gracefully
        val exception = runCatching { commitsToElevenCheck(emptyInput) }.exceptionOrNull()
        assertTrue(exception is StringIndexOutOfBoundsException, "Expected empty input to throw a StringIndexOutOfBoundsException")
    }

    @Test
    fun `test commitsToElevenCheck with large valid input`() {
        val largeValidInput = "9876543210" // Large example input where the function should return true
        val result = commitsToElevenCheck(largeValidInput)
        assertTrue(result, "Expected input '$largeValidInput' to satisfy the eleven check condition")
    }

    @Test
    fun `test commitsToElevenCheck with large invalid input`() {
        val largeInvalidInput = "9876543211" // Large example input where the function should return false
        val result = commitsToElevenCheck(largeInvalidInput)
        assertFalse(result, "Expected input '$largeInvalidInput' to not satisfy the eleven check condition")
    }
}
