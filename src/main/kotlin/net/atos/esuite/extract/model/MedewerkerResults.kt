package net.atos.esuite.extract.model

class MedewerkerResults(results: List<Medewerker>, count: Int, page: Int, pageSize: Int) :
    Results<Medewerker>(results, count, page, pageSize)
