package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_metadataelement", schema = "zakenmagazijn")
class ReferentieMetadataelementEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_metadataelement")
    var identifier: Long = 0

    // Label van metadataelement
    @Column(name = "label", length = 255)
    lateinit var label: String

    // Type metadataelement (TEKST / NUMERIEK / DATUM)
    @Column(name = "type", length = 20)
    lateinit var type: String

    // Indicatie is verplicht element
    @Column(name = "ind_verplicht")
    var indicatieVerplicht = false

    // Indicatie of het metadataelement gebruikt wordt bij alle documenttypes
    @Column(name = "ind_voor_alle_documenttypes")
    var indicatieVoorAlleDocumenttypes = false
}
