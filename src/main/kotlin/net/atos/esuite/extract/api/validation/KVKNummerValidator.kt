package net.atos.esuite.extract.api.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class KVKNummerValidator : ConstraintValidator<ValidKVKNummer, String> {

    private val KVK_NUMMER_PATTERN = Regex("^\\d{8}$")

    override fun isValid(bsn: String?, context: ConstraintValidatorContext?): Boolean {
        return bsn?.matches(KVK_NUMMER_PATTERN) ?: true
    }
}
