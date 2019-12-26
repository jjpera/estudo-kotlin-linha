package br.com.estudo.kotlin.linha.service

import br.com.estudo.kotlin.linha.model.RetornoHistorico
import br.com.estudo.kotlin.linha.model.Historico
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class HistoricoService {

    fun insert(historico: Historico): RetornoHistorico {
        val retornoHistorico = RetornoHistorico(
            codigo = 500,
            descricao = "Em construção"
        )

        return retornoHistorico
    }
}