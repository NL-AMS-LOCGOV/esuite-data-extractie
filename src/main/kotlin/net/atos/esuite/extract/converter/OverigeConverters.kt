package net.atos.esuite.extract.converter

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime

private const val ZONE_ID = "Europe/Amsterdam"

fun Instant.toZonedDateTime() =
    ZonedDateTime.ofInstant(this, ZoneId.of(ZONE_ID))

fun Instant.toLocalDate() =
    LocalDate.ofInstant(this, ZoneId.of(ZONE_ID))
