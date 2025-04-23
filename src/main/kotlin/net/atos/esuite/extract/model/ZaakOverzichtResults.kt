package net.atos.esuite.extract.model

class ZaakOverzichtResults(results: List<ZaakOverzicht>, count: Int, page: Int, pageSize: Int) :
    Results<ZaakOverzicht>(results, count, page, pageSize)
