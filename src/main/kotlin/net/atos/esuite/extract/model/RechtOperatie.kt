package net.atos.esuite.extract.model

enum class RechtOperatie {
    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] mag tonen  */
    tonen,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] informatie mag bekijken  */
    raadplegen,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] informatie mag bewerken  */
    bewerken,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] informatie mag toevoegen  */
    toevoegen,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] informatie mag verwijderen  */
    verwijderen,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] mag overdragen  */
    overdragen,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] mag starten  */
    starten,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] mag heropenen  */
    heropenen,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] mag verdelen  */
    verdelen,

    /** RechtOperatie die gebruikt wordt om aan te geven dat een gebruiker [RechtType] mag importeren  */
    importeren,
}
