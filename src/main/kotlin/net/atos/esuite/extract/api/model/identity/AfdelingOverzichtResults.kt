package net.atos.esuite.extract.api.model.identity

import net.atos.esuite.extract.api.model.shared.Results

class AfdelingOverzichtResults(results: List<AfdelingOverzicht>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<AfdelingOverzicht>(results, count, previousPage, nextPage)
