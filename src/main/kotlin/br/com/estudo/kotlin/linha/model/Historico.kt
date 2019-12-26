package br.com.estudo.kotlin.linha.model

import br.com.estudo.kotlin.linha.enums.Sistema
import br.com.estudo.kotlin.linha.enums.TipoHistorico
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Historico (
    val id: String? = null,
    val `data`: java.time.LocalDateTime? = null,
    val tipo: TipoHistorico? = null,
    val sistema: Sistema? = null,
    val descricao: String? = null
) {
}
