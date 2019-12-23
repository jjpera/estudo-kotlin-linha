package br.com.estudo.kotlin.linha.repository

import br.com.estudo.kotlin.linha.model.Linha
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.domain.Pageable

interface LinhaRepository:MongoRepository<Linha,String>{

    @Query("{ddd : ?0, numero : ?1}")
	fun findFilter(ddd: String?, numero: String?, pageable: Pageable): List<Linha>

    @Query(value = "{ddd : ?0, numero : ?1}", count = true)
	fun count(ddd: String?, numero: String?): Int
}