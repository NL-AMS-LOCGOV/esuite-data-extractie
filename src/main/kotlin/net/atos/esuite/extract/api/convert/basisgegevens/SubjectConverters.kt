package net.atos.esuite.extract.api.convert.basisgegevens

import net.atos.esuite.extract.api.model.basisgegevens.*
import net.atos.esuite.extract.db.entity.basisgegevens.*

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
        geslacht = toGeslacht(geslachtsAanduiding),
        aanhefAanschrijving = aanhefAanschrijving,
        adelijkeTitel = titelAdelijk,
        preAcademischeTitel = titelPreAcademisch,
        postAcademischeTitel = titelPostAcademisch,
        naamgebruik = toNaamgebruik(aanduidingNaamGebruik),
        geslachtsNaamPartner = geslachtsNaamPartner,
        voorvoegselPartner = voorvoegselPartner,
        geboortedatum = geboortedatum,
        geboorteplaats = geboorteplaats,
        overlijdensdatum = overlijdensdatum,
        overlijdensplaats = overlijdensplaats,
        aNummer = aNummer,
        opschortingsReden = toOpschortingsReden(redenOpschorting),
        opschortingsDatum = datumOpschorting,
        geblokkeerd = indicatieGeblokkeerd,
        curateleRegister = indicatieCurateleRegister,
        inOnderzoek = indicatieInOnderzoek,
        geboortedatumVolledig = toOnvolledigeDatumType(indicatieOnvolledigeGeboortedatum),
        overlijdensdatumVolledig = toOnvolledigeDatumType(indicatieOnvolledigeOverlijdensdatum),
        beperkingVerstrekking = indicatieBeperkingVerstrekking,
        nietIngezeteneAanduiding = toNietIngezeteneAanduiding(indicatieNietIngezetene),
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
        vestigingsstatus = toVestigingsstatus(statusVestiging),
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

fun NotitieEntity.toNotitie() =
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

private fun toGeslacht(geslacht: String?) =
    when (geslacht) {
        "O" -> Geslacht.onbekend
        "M" -> Geslacht.man
        "V" -> Geslacht.vrouw
        null -> null
        else -> error("Invalid Geslacht: $geslacht")
    }

private fun toNaamgebruik(aanduidingNaamGebruik: String?) =
    when (aanduidingNaamGebruik) {
        "E" -> Naamgebruik.eigen_geslachtsnaam
        "N" -> Naamgebruik.geslachtsnaam_partner_na_eigen_geslachtsnaam
        "P" -> Naamgebruik.geslachtsnaam_partner
        "V" -> Naamgebruik.geslachtsnaam_partner_voor_eigen_geslachtsnaam
        null -> null
        else -> error("Invalid Naamgebruik: $aanduidingNaamGebruik")
    }

private fun toOpschortingsReden(redenOpschorting: String?) =
    when (redenOpschorting) {
        "." -> OpschortingsReden.standaard_waarde
        "O" -> OpschortingsReden.overlijden
        "E" -> OpschortingsReden.emigratie
        "M" -> OpschortingsReden.ministerieel_besluit
        "R" -> OpschortingsReden.pl_aangelegd_in_rni
        "F" -> OpschortingsReden.fout
        null -> null
        else -> error("Invalid OpschortingsReden: $redenOpschorting")
    }

private fun toOnvolledigeDatumType(indicatieOnvolledigeGeboortedatum: OnvolledigeDatumIndicatieType?) =
    when (indicatieOnvolledigeGeboortedatum) {
        OnvolledigeDatumIndicatieType.J -> OnvolledigeDatumType.jaar_en_maand_en_dag_onbekend
        OnvolledigeDatumIndicatieType.M -> OnvolledigeDatumType.maand_en_dag_onbekend
        OnvolledigeDatumIndicatieType.D -> OnvolledigeDatumType.dag_onbekend
        OnvolledigeDatumIndicatieType.V -> OnvolledigeDatumType.volledig
        null -> null
    }

private fun toNietIngezeteneAanduiding(indicatieNietIngezetene: String?) =
    when (indicatieNietIngezetene) {
        "I" -> NietIngezeteneAanduiding.ingezetene
        "N" -> NietIngezeteneAanduiding.niet_ingezetene
        "A" -> NietIngezeteneAanduiding.ander_natuurlijk_persoon
        null -> null
        else -> error("Invalid NietIngezeteneAanduiding: $indicatieNietIngezetene")
    }

private fun ReferentieLandEntity.toLand() =
    Land(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        gbaCode = gbacode,
    )

private fun ReferentieBurgerlijkeStaatEntity.toBurgerlijkeSTaat() =
    BurgerlijkeStaat(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        gbaCode = gbacode,
    )


private fun AbstractSubjectAdresEntity.toAdres() =
    Adres(
        type = toAdresType(adresType),
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

private fun toAdresType(adresType: String) =
    when (adresType) {
        "C" -> AdresType.correspondentie_adres
        "I" -> AdresType.inschrijf_adres_persoon
        "V" -> AdresType.verblijf_adres_persoon
        "P" -> AdresType.post_adres_bedrijf
        "S" -> AdresType.vestigings_adres_bedrijf
        else -> error("Invalid AdresType: $adresType")
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
        indicatieVervallen = toVervallenAanduiding(indicatieVervallen),
        autoriteitVervallen = autoriteitVervallen,
        einddatumGeldigheid = einddatumGeldigheid,
        reisdocumentnummer = reisdocumentnummer,
        uitgiftedatum = uitgiftedatum,
        autoriteitUitgifte = autoriteitUitgifte,
    )

private fun RelatieEntity.toRelatie() =
    Relatie(
        type = toRelatieType(relatieType),
        soortVerbintenis = toSoortVerbintenis(soortVerbintenis),
        datumSluitingVerbintenis = datumSluitingVerbintenis,
        plaatsSluitingVerbintenis = plaatsSluitingVerbintenis,
        landSluitingVerbintenis = landSluitingVerbintenis?.toLand(),
        datumOntbindingVerbintenis = datumOntbindingVerbintenis,
        redenOntbindingVerbintenis = toRedenOntbindingVerbintenis(redenOntbindingVerbintenis),
        plaatsOntbindingVerbintenis = plaatsOntbindingVerbintenis,
        landOntbindingVerbintenis = landOntbindingVerbintenis?.toLand(),
        identifierPersoon = persoon.identifier,
    )


private fun toRelatieType(relatieType: String) =
    when (relatieType) {
        "O" -> RelatieType.is_ouder_van
        "K" -> RelatieType.is_kind_van
        "P" -> RelatieType.is_partner_van
        else -> error("Invalid RelatieType: $relatieType")
    }

private fun toSoortVerbintenis(soortVerbintenis: String?) =
    when (soortVerbintenis) {
        "H" -> SoortVerbintenis.huwelijk
        "P" -> SoortVerbintenis.partnerschap
        null -> null
        else -> error("Invalid SoortVerbintenis: $soortVerbintenis")
    }

private fun toRedenOntbindingVerbintenis(redenOntbindingVerbintenis: String?) =
    when (redenOntbindingVerbintenis) {
        "." -> RedenOntbindingVerbintenis.onbekend
        "A" -> RedenOntbindingVerbintenis.vermissing_en_ander_huwelijk
        "N" -> RedenOntbindingVerbintenis.nietig_verklaring
        "O" -> RedenOntbindingVerbintenis.overleden
        "R" -> RedenOntbindingVerbintenis.rechtsvermoeden_van_overlijden
        "S" -> RedenOntbindingVerbintenis.scheiding
        "V" -> RedenOntbindingVerbintenis.naar_vreemd_recht_anders_beeindigd
        null -> null
        else -> error("Invalid RedenOntbindingVerbintenis: $redenOntbindingVerbintenis")
    }

private fun toVervallenAanduiding(indicatieVervallen: String?) =
    when (indicatieVervallen) {
        "I" -> VervallenAanduiding.ingetrokken
        "V" -> VervallenAanduiding.van_rechtswege_vervallen
        null -> null
        else -> error("Invalid VervallenAanduiding: $indicatieVervallen")
    }

private fun toVestigingsstatus(status: String?) =
    when (status) {
        "A" -> Vestigingsstatus.nieuw_in_handelsregister
        "B" -> Vestigingsstatus.nieuw_voor_profielhouder
        "C" -> Vestigingsstatus.vestiging_is_gewijzigd
        "D" -> Vestigingsstatus.vervalt_voor_profielhouder_blijft_in_handelsregister
        "E" -> Vestigingsstatus.opgeheven
        "F" -> Vestigingsstatus.opgeheven_ongedaan_gemaakt
        "H" -> Vestigingsstatus.opgeheven_ergens_anders_opnieuw
        null -> null
        else -> error("Invalid vestigingsstatus: $status")
    }

private fun ReferentieHoofdactiviteitEntity.toHoofdactiviteit() =
    Hoofdactiviteit(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        code = code,
    )

private fun ReferentieNevenactiviteitEntity.toNevenactiviteit() =
    Nevenactiviteit(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        code = code,
    )

private fun ContactpersoonEntity.toContactpersoon() =
    Contactpersoon(
        naam = naam,
        geslacht = toGeslacht(geslacht),
        emailadres = emailadres,
        telefoonnummer = telefoon,
        faxnummer = telefax,
        functie = functie,
    )

private fun ReferentieRechtsvormEntity.toRechtsvorm() =
    Rechtsvorm(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        code = code,
        naamNhr = naamNhr,
    )
