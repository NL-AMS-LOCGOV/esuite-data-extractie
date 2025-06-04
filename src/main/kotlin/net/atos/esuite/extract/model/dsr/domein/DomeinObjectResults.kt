package net.atos.esuite.extract.model.dsr.domein

import net.atos.esuite.extract.model.dsr.tabel.Referentietabel
import net.atos.esuite.extract.model.shared.Results

class DomeinObjectResults(results: List<DomeinObject>, count: Int, page: Int, pageSize: Int) :
    Results<DomeinObject>(results, count, page, pageSize)
