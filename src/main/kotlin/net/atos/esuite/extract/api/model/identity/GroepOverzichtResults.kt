package net.atos.esuite.extract.api.model.identity

import net.atos.esuite.extract.api.model.shared.Results

class GroepOverzichtResults(results: List<GroepOverzicht>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<GroepOverzicht>(results, count, previousPage, nextPage)
