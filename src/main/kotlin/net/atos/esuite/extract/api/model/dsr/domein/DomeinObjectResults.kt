package net.atos.esuite.extract.api.model.dsr.domein

import net.atos.esuite.extract.api.model.shared.Results

class DomeinObjectResults(results: List<DomeinObject>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<DomeinObject>(results, count, previousPage, nextPage)
