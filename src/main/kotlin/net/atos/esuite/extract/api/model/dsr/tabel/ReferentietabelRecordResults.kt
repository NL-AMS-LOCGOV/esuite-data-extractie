package net.atos.esuite.extract.api.model.dsr.tabel

import net.atos.esuite.extract.api.model.shared.Results

class ReferentietabelRecordResults(results: List<ReferentietabelRecord>, count: Int, page: Int, pageSize: Int) :
    Results<ReferentietabelRecord>(results, count, page, pageSize)
