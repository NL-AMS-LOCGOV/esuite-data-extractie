package net.atos.esuite.extract.api.model.contact

import net.atos.esuite.extract.api.model.shared.Results

class ContactOverzichtResults(results: List<ContactOverzicht>, count: Long, previousPage: Boolean, nextPage: Boolean) :
    Results<ContactOverzicht>(results, count, previousPage, nextPage)
