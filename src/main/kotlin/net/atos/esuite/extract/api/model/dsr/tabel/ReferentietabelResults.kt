package net.atos.esuite.extract.api.model.dsr.tabel

import net.atos.esuite.extract.api.model.shared.Results

class ReferentietabelResults(results: List<Referentietabel>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<Referentietabel>(results, count, previousPage, nextPage)
