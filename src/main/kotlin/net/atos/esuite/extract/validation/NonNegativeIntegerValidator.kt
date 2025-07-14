package net.atos.esuite.extract.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NonNegativeIntegerValidator : ConstraintValidator<ValidNonNegativeInteger, String> {

    override fun isValid(integer: String?, context: ConstraintValidatorContext): Boolean {
        return integer?.let {
            it.toIntOrNull()?.let { i -> i >= 0 } ?: false
        } ?: true
    }
}
