package net.atos.esuite.extract.api.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

const val TRUE: String = "true"
const val FALSE: String = "false"

class BooleanValidator : ConstraintValidator<ValidBoolean, String> {

    private val BOOLEAN_PATTERN = Regex("^(${TRUE}|${FALSE})$")

    override fun isValid(boolean: String?, context: ConstraintValidatorContext?) =
        boolean?.matches(BOOLEAN_PATTERN) ?: true
}
