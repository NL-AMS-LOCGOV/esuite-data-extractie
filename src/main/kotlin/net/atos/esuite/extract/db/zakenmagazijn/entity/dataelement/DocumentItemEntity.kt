package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class DocumentItemEntity {

    @Column(name = "id_documenttype", length = 255)
    lateinit var documentTypeID: String

    @Column(name = "id_documentstatus", length = 255)
    lateinit var documentStatusID: String

    @Column(name = "mimetype", length = 255)
    lateinit var mimeType: String

    @Column(name = "bestandsnaam", length = 255)
    lateinit var bestandsNaam: String

    @Column(name = "documentrichting")
    var documentRichting: String? = null

    @Column(name = "publicatieniveau", length = 16)
    var publicatieniveau: String? = null

    @Column(name = "inhoud")
    var inhoud: ByteArray? = null

    @Column(name = "titel", length = 256)
    var titel: String? = null

}
