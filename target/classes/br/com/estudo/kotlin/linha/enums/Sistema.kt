package br.com.estudo.kotlin.linha.enums

/**
* 
* Values: linha,banda,tv,historico
*/
enum class Sistema(val value: kotlin.String){
    linha("linha"),
    banda("banda"),
    tv("tv"),
    historico("historico");
}

