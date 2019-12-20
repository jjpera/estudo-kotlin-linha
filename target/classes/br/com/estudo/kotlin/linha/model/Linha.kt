package br.com.estudo.kotlin.linha.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "linha")
data class Linha (
    @Id val id: String? = null,
    val ddd: String = "",
    val numero: String = ""
)
