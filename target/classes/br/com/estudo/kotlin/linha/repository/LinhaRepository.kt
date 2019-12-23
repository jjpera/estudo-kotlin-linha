package br.com.estudo.kotlin.linha.repository

import br.com.estudo.kotlin.linha.model.Linha
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.domain.Pageable

interface LinhaRepository:MongoRepository<Linha,String>{
	//fun find(ddd: String?, numero: String?, pageable: Pageable): List<Linha>
}