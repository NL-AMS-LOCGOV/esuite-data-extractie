package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.basisgegevens.BedrijfEntity
import net.atos.esuite.extract.entity.basisgegevens.NotitieEntity
import net.atos.esuite.extract.entity.basisgegevens.PersoonEntity
import net.atos.esuite.extract.entity.basisgegevens.SubjectEntity
import net.atos.esuite.extract.model.Bedrijf
import net.atos.esuite.extract.model.Persoon
import net.atos.esuite.extract.model.SubjectNotitie
import kotlin.collections.ifEmpty

fun SubjectEntity.toSubject() =
    when (this) {
        is PersoonEntity -> this.toPersoon()
        is BedrijfEntity -> this.toBedrijf()
        else -> error("Invalid SubjectEntity type: ${this.javaClass.simpleName}")
    }

private fun PersoonEntity.toPersoon() =
    Persoon(
        burgerServiceNummer = this.burgerServiceNummer,
        voornamen = voornamen,
        voorletters = voorletters,
        geslachtsNaam = geslachtsNaam,
        voorvoegsel = voorvoegsel,
        telefoonnummer = telefoonnummer,
        telefoonnummerAlternatief = telefoonnummerAlternatief,
        emailadres = emailadres,
        rekeningnummer = rekeningnummer,
        notities = this.notities.map { it.toNotitie() }.ifEmpty { null },
    )

private fun BedrijfEntity.toBedrijf() =
    Bedrijf(
        notities = notities.map { it.toNotitie() }.ifEmpty { null },
        kvkNummer = kvknummer,
        vestigingsnummer = vestigingsnummer,
        buitenlandsHandelsregisternummer = buitenlandsHandelsregisternummer,
        bedrijfsnaam = bedrijfsnaam,
        telefoonnummer = telefoon,
        telefoonnummerAlternatief = telefoonnummerAlternatief,
        emailadres = emailadres,
        rekeningnummer = bankrekening,
    )

fun NotitieEntity.toNotitie() =
    SubjectNotitie(
        ingangsdatumGeldigheid = ingangsdatum,
        einddatumGeldigheid =  datumgeldigtot,
        afdeling = idAfdeling,
        groep = idGroep,
        aangemaaktOp = aangemaaktOp,
        aangemaaktDoor = aangemaaktDoor,
        titel = titel,
        inhoud = inhoud,
    )
