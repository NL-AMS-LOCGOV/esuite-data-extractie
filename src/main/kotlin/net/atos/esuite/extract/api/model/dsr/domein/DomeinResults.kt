package net.atos.esuite.extract.api.model.dsr.domein

import net.atos.esuite.extract.api.model.shared.Results

class DomeinResults(results: List<Domein>, count: Int, page: Int, pageSize: Int) :
    Results<Domein>(results, count, page, pageSize)
