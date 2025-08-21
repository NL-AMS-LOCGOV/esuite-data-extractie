package net.atos.esuite.extract.api.model.dsr.tabel

import net.atos.esuite.extract.api.model.shared.Results

class ReferentietabelResults(results: List<Referentietabel>, count: Int, page: Int, pageSize: Int) :
    Results<Referentietabel>(results, count, page, pageSize)
