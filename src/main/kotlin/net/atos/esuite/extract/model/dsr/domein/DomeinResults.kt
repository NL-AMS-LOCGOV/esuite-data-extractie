package net.atos.esuite.extract.model.dsr.domein

import net.atos.esuite.extract.model.dsr.tabel.Referentietabel
import net.atos.esuite.extract.model.shared.Results

class DomeinResults(results: List<Domein>, count: Int, page: Int, pageSize: Int) :
    Results<Domein>(results, count, page, pageSize)
