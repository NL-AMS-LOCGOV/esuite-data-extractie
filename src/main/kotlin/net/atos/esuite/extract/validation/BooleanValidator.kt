package net.atos.esuite.extract.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class BooleanValidator : ConstraintValidator<ValidBoolean, String> {

    companion object {
        val FALSE: String = "false"
        val TRUE: String = "true"
        fun equalsTrue(value: String?) = value?.equals(TRUE) ?: false
        private val BOOLEAN_PATTERN = Regex("^(true|false)$")
    }

    override fun isValid(bsn: String?, context: ConstraintValidatorContext?): Boolean {
        return bsn?.matches(BOOLEAN_PATTERN) ?: true
    }
}
