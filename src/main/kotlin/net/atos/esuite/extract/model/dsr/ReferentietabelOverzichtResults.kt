package net.atos.esuite.extract.model.dsr

import net.atos.esuite.extract.model.shared.Results
import net.atos.esuite.extract.model.zaak.ZaakOverzicht

class ReferentietabelOverzichtResults(results: List<ReferentietabelOverzicht>, count: Int, page: Int, pageSize: Int) :
    Results<ReferentietabelOverzicht>(results, count, page, pageSize)
