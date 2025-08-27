package net.atos.esuite.extract.api.model.dsr.domein

import net.atos.esuite.extract.api.model.shared.Results

class DomeinResults(results: List<Domein>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<Domein>(results, count, previousPage, nextPage)
