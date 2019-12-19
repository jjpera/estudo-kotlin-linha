package br.com.estudo.kotlin.linha.model

/**
 *  * @param codigo  * @param descricao  * @param registros  * @param pagina  * @param qtdePagina */
data class Retorno (    val codigo: kotlin.Long? = null,    val descricao: kotlin.String? = null,    val registros: kotlin.Int? = null,    val pagina: kotlin.Int? = null,    val qtdePagina: kotlin.Int? = null
) {
}
