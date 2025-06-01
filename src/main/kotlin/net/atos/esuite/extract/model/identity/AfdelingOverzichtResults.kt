package net.atos.esuite.extract.model.identity

import net.atos.esuite.extract.model.shared.Results

class AfdelingOverzichtResults(results: List<AfdelingOverzicht>, count: Int, page: Int, pageSize: Int) :
    Results<AfdelingOverzicht>(results, count, page, pageSize)
