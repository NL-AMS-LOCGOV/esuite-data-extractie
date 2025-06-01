package net.atos.esuite.extract.model.zaak

import net.atos.esuite.extract.model.shared.Results

class ZaakOverzichtResults(results: List<ZaakOverzicht>, count: Int, page: Int, pageSize: Int) :
    Results<ZaakOverzicht>(results, count, page, pageSize)
