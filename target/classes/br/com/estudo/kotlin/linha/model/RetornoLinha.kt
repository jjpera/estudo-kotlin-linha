package br.com.estudo.kotlin.linha.model

import br.com.estudo.kotlin.linha.model.Linha
import br.com.estudo.kotlin.linha.model.Retorno

/**
 *  * @param listaLinhas */
data class RetornoLinha (  
    val codigo: kotlin.Long? = null,    
    val descricao: kotlin.String? = null,    
    val registros: kotlin.Int? = null,    
    val pagina: kotlin.Int? = null,    
    val qtdePagina: kotlin.Int? = null,    
    val listaLinhas: List<Linha>? = null
) {
}