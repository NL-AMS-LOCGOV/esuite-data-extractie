package net.atos.esuite.extract.api.converter

import io.quarkus.panache.common.Page
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.DEFAULT_PAGE_SIZE
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime

private val ZONE_ID = "Europe/Amsterdam"

fun Instant.toZonedDateTime() =
    ZonedDateTime.ofInstant(this, ZoneId.of(ZONE_ID))

fun Instant.toLocalDate() =
    LocalDate.ofInstant(this, ZoneId.of(ZONE_ID))

fun BladerParameters.toPage() = Page(page?.toIntOrNull() ?: 0, pageSize?.toIntOrNull() ?: DEFAULT_PAGE_SIZE)
