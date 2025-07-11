package net.atos.esuite.extract.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class VestigingsnummerValidator : ConstraintValidator<ValidVestigingsnummer, String> {

    private val VESTIGINGSNUMMER_PATTERN = Regex("^\\d{12}$")

    override fun isValid(bsn: String?, context: ConstraintValidatorContext?): Boolean {
        return bsn?.matches(VESTIGINGSNUMMER_PATTERN) ?: true
    }
}
