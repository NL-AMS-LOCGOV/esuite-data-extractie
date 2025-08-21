package net.atos.esuite.extract.api.model.contact

import net.atos.esuite.extract.api.model.shared.Results

class ContactOverzichtResults(results: List<ContactOverzicht>, count: Int, page: Int, pageSize: Int) :
    Results<ContactOverzicht>(results, count, page, pageSize)
