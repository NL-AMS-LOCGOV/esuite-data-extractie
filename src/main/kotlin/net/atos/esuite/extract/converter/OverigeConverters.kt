package net.atos.esuite.extract.converter

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

fun Instant.toZonedDateTime() =
    ZonedDateTime.ofInstant(this, ZoneId.of("Europe/Amsterdam"))
