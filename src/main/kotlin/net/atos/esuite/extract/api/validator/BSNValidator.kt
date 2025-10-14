package net.atos.esuite.extract.api.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class BSNValidator : ConstraintValidator<ValidBSN, String> {

    private val BSN_PATTERN = Regex("^\\d{9}$")

    override fun isValid(bsn: String?, context: ConstraintValidatorContext?) =
        bsn?.let { it.matches(BSN_PATTERN) && commitsToElevenCheck(it) } ?: true
}
