package net.atos.esuite.extract.api.validator

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Constraint(validatedBy = [BSNValidator::class])
annotation class ValidBSN(
    val message: String = "Invalide BSN",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
