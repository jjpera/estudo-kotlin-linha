package br.com.estudo.kotlin.linha.model

import br.com.estudo.kotlin.linha.model.Historico
import br.com.estudo.kotlin.linha.model.Retorno
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RetornoHistorico (
    val codigo: kotlin.Long? = null,    
    val descricao: kotlin.String? = null,    
    val registros: kotlin.Int? = null,    
    val pagina: kotlin.Int? = null,    
    val qtdePagina: kotlin.Int? = null,    
    val listaHistoricos: kotlin.Array<Historico>? = null
) {
}
