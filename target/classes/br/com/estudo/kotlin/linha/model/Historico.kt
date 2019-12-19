package br.com.estudo.kotlin.linha.model

import br.com.estudo.kotlin.linha.model.Sistema
import br.com.estudo.kotlin.linha.model.TipoHistorico

/**
 *  * @param id  * @param &#x60;data&#x60;  * @param tipo  * @param sistema  * @param descricao */
data class Historico (    val id: kotlin.Long? = null,    val `data`: java.time.LocalDateTime? = null,    val tipo: TipoHistorico? = null,    val sistema: Sistema? = null,    val descricao: kotlin.String? = null
) {
}
