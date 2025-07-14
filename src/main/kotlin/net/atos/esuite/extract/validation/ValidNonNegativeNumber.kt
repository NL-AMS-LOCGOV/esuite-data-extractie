package net.atos.esuite.extract.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Constraint(validatedBy = [NonNegativeNumberValidator::class])
annotation class ValidNonNegativeNumber(
    val message: String = "Invalide niet negatief getal",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
