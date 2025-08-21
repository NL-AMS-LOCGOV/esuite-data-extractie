package net.atos.esuite.extract.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository

interface BaseRepository<Entity : Any> : PanacheRepository<Entity> {

    fun findByNaam(naam: String) =
        find("naam", naam).firstResult()

    fun listAll(pageIndex: Int, pageSize: Int): ListResult<Entity> = ListResult(
        findAll().page(pageIndex, pageSize).list(),
        count().toInt()
    )
}
