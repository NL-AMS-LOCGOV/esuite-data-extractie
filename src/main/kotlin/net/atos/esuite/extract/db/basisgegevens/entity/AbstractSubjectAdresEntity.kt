package net.atos.esuite.extract.db.basisgegevens.entity

import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractSubjectAdresEntity {

    @Column(name = "adrestype", length = 1)
    lateinit var adresType: String

    @ManyToOne
    @JoinColumn(name = "id_adres", referencedColumnName = "id_adres")
    lateinit var adres: AdresEntity
}
