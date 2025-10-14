package net.atos.esuite.extract.db.shared

import jakarta.persistence.Column
import jakarta.persistence.Lob
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes


@MappedSuperclass
abstract class AbstractReferentieEntity {

    @Column(name = "naam", length = 255)
    lateinit var naam: String

    @Column(name = "omschrijving")
    @Lob
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    var omschrijving: String? = null

    @Column(name = "actief")
    var actief = false
}
