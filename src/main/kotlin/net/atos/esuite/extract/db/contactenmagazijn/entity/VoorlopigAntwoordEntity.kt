package net.atos.esuite.extract.db.contactenmagazijn.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.Instant


@Entity
@Table(name = "con_voorlopigantwoord", schema = "contactenmagazijn")
class VoorlopigAntwoordEntity {

    @Id
    @Column(name = "id_voorlopigantwoord")
    var identifier: Long = 0

    @Column(name = "antwoord")
    @Lob
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    lateinit var antwoord: String

    @Column(name = "datumantwoord")
    lateinit var datumantwoord: Instant

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    lateinit var contact: ContactEntity

    @Column(name = "id_afdeling", length = 128)
    var afdelingId: String? = null

    @Column(name = "id_behandelaar", length = 64)
    var medewerkerId: String? = null

}
