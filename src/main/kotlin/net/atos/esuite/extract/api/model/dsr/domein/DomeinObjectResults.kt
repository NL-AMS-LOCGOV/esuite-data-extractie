package net.atos.esuite.extract.api.model.dsr.domein

import net.atos.esuite.extract.api.model.shared.Results

class DomeinObjectResults(results: List<DomeinObject>, count: Int, page: Int, pageSize: Int) :
    Results<DomeinObject>(results, count, page, pageSize)
