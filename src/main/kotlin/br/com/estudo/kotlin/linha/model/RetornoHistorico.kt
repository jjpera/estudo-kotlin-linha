package br.com.estudo.kotlin.linha.model

import br.com.estudo.kotlin.linha.model.Historico
import br.com.estudo.kotlin.linha.model.Retorno
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RetornoHistorico (
    val codigo: Long? = null,    
    val descricao: String? = null,    
    val registros: Int? = null,    
    val pagina: Int? = null,    
    val qtdePagina: Int? = null,    
    val listaHistoricos: Array<Historico>? = null
) {
}
