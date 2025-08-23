package net.atos.esuite.extract.api.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class VestigingsnummerValidator : ConstraintValidator<ValidVestigingsnummer, String> {

    private val VESTIGINGSNUMMER_PATTERN = Regex("^\\d{12}$")

    override fun isValid(vestigingsnummer: String?, context: ConstraintValidatorContext?) =
        vestigingsnummer?.matches(VESTIGINGSNUMMER_PATTERN) ?: true
}
