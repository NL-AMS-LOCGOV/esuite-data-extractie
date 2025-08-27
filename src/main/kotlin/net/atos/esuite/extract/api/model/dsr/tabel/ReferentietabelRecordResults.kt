package net.atos.esuite.extract.api.model.dsr.tabel

import net.atos.esuite.extract.api.model.shared.Results

class ReferentietabelRecordResults(results: List<ReferentietabelRecord>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<ReferentietabelRecord>(results, count, previousPage, nextPage)
