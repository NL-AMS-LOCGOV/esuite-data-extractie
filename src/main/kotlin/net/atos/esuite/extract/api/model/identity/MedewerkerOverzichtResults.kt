package net.atos.esuite.extract.api.model.identity

import net.atos.esuite.extract.api.model.shared.Results

class MedewerkerOverzichtResults(results: List<MedewerkerOverzicht>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<MedewerkerOverzicht>(results, count, previousPage, nextPage)
