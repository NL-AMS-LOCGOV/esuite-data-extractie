package net.atos.esuite.extract.api.model.identity

import net.atos.esuite.extract.api.model.shared.Results

class GroepOverzichtResults(results: List<GroepOverzicht>, count: Int, page: Int, pageSize: Int) :
    Results<GroepOverzicht>(results, count, page, pageSize)
