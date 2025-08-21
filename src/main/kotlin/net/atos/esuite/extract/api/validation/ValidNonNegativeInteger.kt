package net.atos.esuite.extract.api.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Constraint(validatedBy = [NonNegativeIntegerValidator::class])
annotation class ValidNonNegativeInteger(
    val message: String = "Invalide niet negatieve integer",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
