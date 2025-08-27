package net.atos.esuite.extract.api.model.zaak

import net.atos.esuite.extract.api.model.shared.Results

class ZaaktypeResults(results: List<Zaaktype>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<Zaaktype>(results, count, previousPage, nextPage)
