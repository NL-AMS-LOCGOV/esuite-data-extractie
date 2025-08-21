package net.atos.esuite.extract.api.model.identity

import net.atos.esuite.extract.api.model.shared.Results

class MedewerkerOverzichtResults(results: List<MedewerkerOverzicht>, count: Int, page: Int, pageSize: Int) :
    Results<MedewerkerOverzicht>(results, count, page, pageSize)
