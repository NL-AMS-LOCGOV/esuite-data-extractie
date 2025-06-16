package net.atos.esuite.extract.converter.basisgegevens

import net.atos.esuite.extract.entity.basisgegevens.BedrijfEntity
import net.atos.esuite.extract.entity.basisgegevens.NotitieEntity
import net.atos.esuite.extract.entity.basisgegevens.OnvolledigeDatumIndicatieType
import net.atos.esuite.extract.entity.basisgegevens.PersoonAdresEntity
import net.atos.esuite.extract.entity.basisgegevens.PersoonEntity
import net.atos.esuite.extract.entity.basisgegevens.PersoonNationaliteitEntity
import net.atos.esuite.extract.entity.basisgegevens.PersoonReisdocumentEntity
import net.atos.esuite.extract.entity.basisgegevens.ReferentieBurgerlijkeStaatEntity
import net.atos.esuite.extract.entity.basisgegevens.ReferentieLandEntity
import net.atos.esuite.extract.entity.basisgegevens.RelatieEntity
import net.atos.esuite.extract.entity.basisgegevens.SubjectEntity
import net.atos.esuite.extract.model.basisgegevens.Adres
import net.atos.esuite.extract.model.basisgegevens.AdresType
import net.atos.esuite.extract.model.basisgegevens.Bedrijf
import net.atos.esuite.extract.model.basisgegevens.BurgerlijkeStaat
import net.atos.esuite.extract.model.basisgegevens.Geslachtsaanduiding
import net.atos.esuite.extract.model.basisgegevens.Land
import net.atos.esuite.extract.model.basisgegevens.Naamgebruik
import net.atos.esuite.extract.model.basisgegevens.Nationaliteit
import net.atos.esuite.extract.model.basisgegevens.NietIngezeteneAanduiding
import net.atos.esuite.extract.model.basisgegevens.OnvolledigeDatumType
import net.atos.esuite.extract.model.basisgegevens.OpschortingsReden
import net.atos.esuite.extract.model.basisgegevens.Persoon
import net.atos.esuite.extract.model.basisgegevens.RedenOntbindingVerbintenis
import net.atos.esuite.extract.model.basisgegevens.Reisdocument
import net.atos.esuite.extract.model.basisgegevens.Relatie
import net.atos.esuite.extract.model.basisgegevens.RelatieType
import net.atos.esuite.extract.model.basisgegevens.SoortVerbintenis
import net.atos.esuite.extract.model.basisgegevens.SubjectNotitie
import net.atos.esuite.extract.model.basisgegevens.VervallenAanduiding
import kotlin.collections.ifEmpty

fun SubjectEntity.toSubject() =
    when (this) {
        is PersoonEntity -> this.toPersoon()
        is BedrijfEntity -> this.toBedrijf()
        else -> error("Invalid SubjectEntity type: ${this.javaClass.simpleName}")
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
        toGeslachtsAanduiding(geslachtsAanduiding),
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
        relaties = relaties.map {it.toRelatie()}.ifEmpty { null },
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

private fun toGeslachtsAanduiding(geslachtsAanduiding: String?) =
    when (geslachtsAanduiding) {
        "O" -> Geslachtsaanduiding.onbekend
        "M" -> Geslachtsaanduiding.man
        "V" -> Geslachtsaanduiding.vrouw
        null -> null
        else -> error("Invalid Geslachtsaanduiding: $geslachtsAanduiding")
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


private fun PersoonAdresEntity.toAdres() =
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
    when(relatieType) {
        "O" -> RelatieType.is_ouder_van
        "K" -> RelatieType.is_kind_van
        "P" -> RelatieType.is_partner_van
        else -> error("Invalid RelatieType: $relatieType")
    }

private fun toSoortVerbintenis(soortVerbintenis: String?) =
    when(soortVerbintenis) {
        "H" -> SoortVerbintenis.huwelijk
        "P" -> SoortVerbintenis.partnerschap
        null -> null
        else -> error("Invalid SoortVerbintenis: $soortVerbintenis")
    }

private fun toRedenOntbindingVerbintenis(redenOntbindingVerbintenis: String?) =
    when(redenOntbindingVerbintenis) {
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
    when(indicatieVervallen) {
        "I" -> VervallenAanduiding.ingetrokken
        "V" -> VervallenAanduiding.van_rechtswege_vervallen
        null -> null
        else -> error("Invalid VervallenAanduiding: $indicatieVervallen")
    }
