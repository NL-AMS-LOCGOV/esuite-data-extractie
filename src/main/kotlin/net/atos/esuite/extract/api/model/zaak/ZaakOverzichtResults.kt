package net.atos.esuite.extract.api.model.zaak

import net.atos.esuite.extract.api.model.shared.Results

class ZaakOverzichtResults(results: List<ZaakOverzicht>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<ZaakOverzicht>(results, count, previousPage, nextPage)
