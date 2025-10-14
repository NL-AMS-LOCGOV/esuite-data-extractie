package net.atos.esuite.extract.api.converter

import net.atos.esuite.extract.api.model.subject.*
import net.atos.esuite.extract.db.basisgegevens.entity.*

fun SubjectEntity.toSubject() =
    when (this) {
        is PersoonEntity -> this.toPersoon()
        is BedrijfEntity -> this.toBedrijf()
        else -> error("Unsupported SubjectEntity type: ${this.javaClass.simpleName}")
    }

fun PersoonEntity.toPersoon() =
    Persoon(
        identifier = identifier,
        notities = this.notities.map { it.toNotitie() }.ifEmpty { null },
        telefoonnummer = telefoonnummer,
        telefoonnummerAlternatief = telefoonnummerAlternatief,
        emailadres = emailadres,
        rekeningnummer = rekeningnummer,
        ontvangenZaakNotificaties = ontvangenZaakNotificaties,
        toestemmingZaakNotificatiesAlleenDigitaal = toestemmingZaakNotificatiesAlleenDigitaal,
        burgerServiceNummer = this.burgerServiceNummer,
        voornamen = voornamen,
        voorletters = voorletters,
        geslachtsNaam = geslachtsNaam,
        voorvoegsel = voorvoegsel,
        geslacht = geslachtsAanduiding?.toGeslacht(),
        aanhefAanschrijving = aanhefAanschrijving,
        adelijkeTitel = titelAdelijk,
        preAcademischeTitel = titelPreAcademisch,
        postAcademischeTitel = titelPostAcademisch,
        naamgebruik = aanduidingNaamGebruik?.toNaamgebruik(),
        geslachtsNaamPartner = geslachtsNaamPartner,
        voorvoegselPartner = voorvoegselPartner,
        geboortedatum = geboortedatum,
        geboorteplaats = geboorteplaats,
        overlijdensdatum = overlijdensdatum,
        overlijdensplaats = overlijdensplaats,
        aNummer = aNummer,
        opschortingsReden = redenOpschorting?.toOpschortingsReden(),
        opschortingsDatum = datumOpschorting,
        geblokkeerd = indicatieGeblokkeerd,
        curateleRegister = indicatieCurateleRegister,
        inOnderzoek = indicatieInOnderzoek,
        geboortedatumVolledig = indicatieOnvolledigeGeboortedatum?.toOnvolledigeDatumType(),
        overlijdensdatumVolledig = indicatieOnvolledigeOverlijdensdatum?.toOnvolledigeDatumType(),
        beperkingVerstrekking = indicatieBeperkingVerstrekking,
        nietIngezeteneAanduiding = indicatieNietIngezetene?.toNietIngezeteneAanduiding(),
        handmatigToegevoegd = indicatieHandmatigToegevoegd,
        afnemerIndicatie = indicatieAfnemer,
        anpIdentificatie = anpIdentificatie,
        gemeentecode = gemeentecode,
        geboorteland = geboorteland?.toLand(),
        overlijdensland = overlijdensland?.toLand(),
        burgerlijkeStaat = burgerlijkestaat.toBurgerlijkeSTaat(),
        adressen = adressen.map { it.toAdres() }.ifEmpty { null },
        nationaliteiten = nationaliteiten.map { it.toNationaliteit() }.ifEmpty { null },
        reisdocumenten = reisdocumenten.map { it.toReisdocument() }.ifEmpty { null },
        relaties = relaties.map { it.toRelatie() }.ifEmpty { null },
    )

fun BedrijfEntity.toBedrijf() =
    Bedrijf(
        identifier = identifier,
        notities = notities.map { it.toNotitie() }.ifEmpty { null },
        kvkNummer = kvknummer,
        vestigingsnummer = vestigingsnummer,
        buitenlandsHandelsregisternummer = buitenlandsHandelsregisternummer,
        bedrijfsnaam = bedrijfsnaam,
        telefoonnummer = telefoon,
        telefoonnummerAlternatief = telefoonnummerAlternatief,
        emailadres = emailadres,
        rekeningnummer = bankrekening,
        ontvangenZaakNotificaties = ontvangenZaakNotificaties,
        toestemmingZaakNotificatiesAlleenDigitaal = toestemmingZaakNotificatiesAlleenDigitaal,
        adressen = adressen.map { it.toAdres() }.ifEmpty { null },
        handmatigToegevoegd = indicatieHandmatigToegevoegd,
        vennootschapsnaam = vennootschapsnaam,
        statutaireZetel = statutaireZetel,
        datumVestiging = datumVestiging,
        datumOpheffing = datumVestiging,
        datumVoortzetting = datumVoortzetting,
        faxnummer = telefax,
        aantalWerknemers = aantalWerknemers,
        inSurceance = indSurseance,
        failliet = indFaillisement,
        rsinummer = rsinummer,
        vestigingsstatus = statusVestiging?.toVestigingsstatus(),
        ingangsdatum = ingangsdatum,
        mutatiedatum = mutatiedatum,
        vestigingstype = when (indHoofdVestiging) {
            true -> Vestigingstype.hoofdvestiging
            false, null -> Vestigingstype.nevenvestiging
        },
        hoofdactiviteit = hoofdactiviteit?.toHoofdactiviteit(),
        nevenactiviteiten = nevenactiviteiten.map { it.toNevenactiviteit() }.toSet().ifEmpty { null },
        contactpersonen = contactpersonen.map { it.toContactpersoon() }.ifEmpty { null },
        rechtsvorm = rechtsvorm?.toRechtsvorm(),
    )

private fun NotitieEntity.toNotitie() =
    SubjectNotitie(
        ingangsdatumGeldigheid = ingangsdatum,
        einddatumGeldigheid = datumgeldigtot,
        afdeling = idAfdeling,
        groep = idGroep,
        aangemaaktOp = aangemaaktOp,
        aangemaaktDoor = aangemaaktDoor,
        titel = titel,
        inhoud = inhoud,
    )

private fun String.toGeslacht() =
    when (this) {
        "O" -> Geslacht.onbekend
        "M" -> Geslacht.man
        "V" -> Geslacht.vrouw
        else -> error("Invalid Geslacht: $this")
    }

private fun String.toNaamgebruik() =
    when (this) {
        "E" -> Naamgebruik.eigen_geslachtsnaam
        "N" -> Naamgebruik.geslachtsnaam_partner_na_eigen_geslachtsnaam
        "P" -> Naamgebruik.geslachtsnaam_partner
        "V" -> Naamgebruik.geslachtsnaam_partner_voor_eigen_geslachtsnaam
        else -> error("Invalid Naamgebruik: $this")
    }

private fun String.toOpschortingsReden() =
    when (this) {
        "." -> OpschortingsReden.standaard_waarde
        "O" -> OpschortingsReden.overlijden
        "E" -> OpschortingsReden.emigratie
        "M" -> OpschortingsReden.ministerieel_besluit
        "R" -> OpschortingsReden.pl_aangelegd_in_rni
        "F" -> OpschortingsReden.fout
        else -> error("Invalid OpschortingsReden: $this")
    }

private fun OnvolledigeDatumIndicatieTypeEnum.toOnvolledigeDatumType() =
    when (this) {
        OnvolledigeDatumIndicatieTypeEnum.J -> OnvolledigeDatumType.jaar_en_maand_en_dag_onbekend
        OnvolledigeDatumIndicatieTypeEnum.M -> OnvolledigeDatumType.maand_en_dag_onbekend
        OnvolledigeDatumIndicatieTypeEnum.D -> OnvolledigeDatumType.dag_onbekend
        OnvolledigeDatumIndicatieTypeEnum.V -> OnvolledigeDatumType.volledig
    }

private fun String.toNietIngezeteneAanduiding() =
    when (this) {
        "I" -> NietIngezeteneAanduiding.ingezetene
        "N" -> NietIngezeteneAanduiding.niet_ingezetene
        "A" -> NietIngezeteneAanduiding.ander_natuurlijk_persoon
        else -> error("Invalid NietIngezeteneAanduiding: $this")
    }

private fun LandEntity.toLand() =
    Land(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        gbaCode = gbacode,
    )

private fun BurgerlijkeStaatEntity.toBurgerlijkeSTaat() =
    BurgerlijkeStaat(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        gbaCode = gbacode,
    )


private fun AbstractSubjectAdresEntity.toAdres() =
    Adres(
        type = adresType.toAdresType(),
        straatnaam = adres.straatnaam,
        postcode = adres.postcode,
        plaatsnaam = adres.plaatsnaam,
        huisletter = adres.huisletter,
        huisnummer = adres.huisnummer,
        huisnummertoevoeging = adres.huisnummertoevoeging,
        huisnummeraanduiding = adres.huisnummeraanduiding,
        adresbuitenland1 = adres.adresbuitenland1,
        adresbuitenland2 = adres.adresbuitenland2,
        adresbuitenland3 = adres.adresbuitenland3,
        buitenlandsAdres = adres.indicatieBuitenlandsadres,
        land = adres.land.toLand(),
    )

private fun String.toAdresType() =
    when (this) {
        "C" -> AdresType.correspondentie_adres
        "I" -> AdresType.inschrijf_adres_persoon
        "V" -> AdresType.verblijf_adres_persoon
        "P" -> AdresType.post_adres_bedrijf
        "S" -> AdresType.vestigings_adres_bedrijf
        else -> error("Invalid AdresType: $this")
    }

private fun PersoonNationaliteitEntity.toNationaliteit() =
    Nationaliteit(
        naam = nationaliteit.naam,
        omschrijving = nationaliteit.omschrijving,
        actief = nationaliteit.actief,
        gbaCode = nationaliteit.gbacode,
        redenVerkrijging = redenVerkrijging,
        datumVerkrijging = datumVerkrijging,
    )

private fun PersoonReisdocumentEntity.toReisdocument() =
    Reisdocument(
        naam = reisdocument.naam,
        omschrijving = reisdocument.omschrijving,
        actief = reisdocument.actief,
        gbaCode = reisdocument.gbacode,
        indicatieOnttrekking = indicatieOnttrekking,
        autoriteitOntrekking = autoriteitOntrekking,
        indicatieVervallen = indicatieVervallen?.toVervallenAanduiding(),
        autoriteitVervallen = autoriteitVervallen,
        einddatumGeldigheid = einddatumGeldigheid,
        reisdocumentnummer = reisdocumentnummer,
        uitgiftedatum = uitgiftedatum,
        autoriteitUitgifte = autoriteitUitgifte,
    )

private fun RelatieEntity.toRelatie() =
    Relatie(
        type = relatieType.toRelatieType(),
        soortVerbintenis = soortVerbintenis?.toSoortVerbintenis(),
        datumSluitingVerbintenis = datumSluitingVerbintenis,
        plaatsSluitingVerbintenis = plaatsSluitingVerbintenis,
        landSluitingVerbintenis = landSluitingVerbintenis?.toLand(),
        datumOntbindingVerbintenis = datumOntbindingVerbintenis,
        redenOntbindingVerbintenis = redenOntbindingVerbintenis?.toRedenOntbindingVerbintenis(),
        plaatsOntbindingVerbintenis = plaatsOntbindingVerbintenis,
        landOntbindingVerbintenis = landOntbindingVerbintenis?.toLand(),
        identifierPersoon = persoon.identifier,
    )


private fun String.toRelatieType() =
    when (this) {
        "O" -> RelatieType.is_ouder_van
        "K" -> RelatieType.is_kind_van
        "P" -> RelatieType.is_partner_van
        else -> error("Invalid RelatieType: $this")
    }

private fun String.toSoortVerbintenis() =
    when (this) {
        "H" -> SoortVerbintenis.huwelijk
        "P" -> SoortVerbintenis.partnerschap
        else -> error("Invalid SoortVerbintenis: $this")
    }

private fun String.toRedenOntbindingVerbintenis() =
    when (this) {
        "." -> RedenOntbindingVerbintenis.onbekend
        "A" -> RedenOntbindingVerbintenis.vermissing_en_ander_huwelijk
        "N" -> RedenOntbindingVerbintenis.nietig_verklaring
        "O" -> RedenOntbindingVerbintenis.overleden
        "R" -> RedenOntbindingVerbintenis.rechtsvermoeden_van_overlijden
        "S" -> RedenOntbindingVerbintenis.scheiding
        "V" -> RedenOntbindingVerbintenis.naar_vreemd_recht_anders_beeindigd
        else -> error("Invalid RedenOntbindingVerbintenis: $this")
    }

private fun String.toVervallenAanduiding() =
    when (this) {
        "I" -> VervallenAanduiding.ingetrokken
        "V" -> VervallenAanduiding.van_rechtswege_vervallen
        else -> error("Invalid VervallenAanduiding: $this")
    }

private fun String.toVestigingsstatus() =
    when (this) {
        "A" -> Vestigingsstatus.nieuw_in_handelsregister
        "B" -> Vestigingsstatus.nieuw_voor_profielhouder
        "C" -> Vestigingsstatus.vestiging_is_gewijzigd
        "D" -> Vestigingsstatus.vervalt_voor_profielhouder_blijft_in_handelsregister
        "E" -> Vestigingsstatus.opgeheven
        "F" -> Vestigingsstatus.opgeheven_ongedaan_gemaakt
        "H" -> Vestigingsstatus.opgeheven_ergens_anders_opnieuw
        else -> error("Invalid vestigingsstatus: $this")
    }

private fun HoofdactiviteitEntity.toHoofdactiviteit() =
    Hoofdactiviteit(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        code = code,
    )

private fun NevenactiviteitEntity.toNevenactiviteit() =
    Nevenactiviteit(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        code = code,
    )

private fun ContactpersoonEntity.toContactpersoon() =
    Contactpersoon(
        naam = naam,
        geslacht = geslacht?.toGeslacht(),
        emailadres = emailadres,
        telefoonnummer = telefoon,
        faxnummer = telefax,
        functie = functie,
    )

private fun RechtsvormEntity.toRechtsvorm() =
    Rechtsvorm(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        code = code,
        naamNhr = naamNhr,
    )
