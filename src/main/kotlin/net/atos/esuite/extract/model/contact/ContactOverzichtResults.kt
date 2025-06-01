package net.atos.esuite.extract.model.contact

import net.atos.esuite.extract.model.shared.Results

class ContactOverzichtResults(results: List<ContactOverzicht>, count: Int, page: Int, pageSize: Int) :
    Results<ContactOverzicht>(results, count, page, pageSize)
