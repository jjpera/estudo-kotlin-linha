package br.com.estudo.kotlin.linha.enums

/**
* 
* Values: post,put,delete,get
*/
enum class TipoHistorico(val value: kotlin.String){
    post("post"),
    put("put"),
    delete("delete"),
    get("get");
}

