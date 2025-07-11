package net.atos.esuite.extract.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Constraint(validatedBy = [BooleanValidator::class])
annotation class ValidBoolean(
    val message: String = "Invalide Boolean. Geldige waardes: 'true' or 'false'",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
