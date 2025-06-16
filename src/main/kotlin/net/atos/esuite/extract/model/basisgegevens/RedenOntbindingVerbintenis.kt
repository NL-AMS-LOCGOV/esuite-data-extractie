package net.atos.esuite.extract.model.basisgegevens

enum class RedenOntbindingVerbintenis {

    // (.)
    onbekend,

    // Ander huwelijk gesloten na vermissing partner. (A)
    vermissing_en_ander_huwelijk,

    // Ontbinding door rechtbank. (N)
    nietig_verklaring,

    //  Partner overleden. (O)
    overleden,

    //  Partner waarschijnlijk overleden (vastgesteld door rechtbank). (R)
    rechtsvermoeden_van_overlijden,

    //  Scheiding. (S)
    scheiding,

    //  Beëindigd in het buitenland. (V)
    naar_vreemd_recht_anders_beeindigd,
}
