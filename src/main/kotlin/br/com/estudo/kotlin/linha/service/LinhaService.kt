package br.com.estudo.kotlin.linha.service

import br.com.estudo.kotlin.linha.model.RetornoLinha
import br.com.estudo.kotlin.linha.model.Linha
import br.com.estudo.kotlin.linha.model.RetornoHistorico
import br.com.estudo.kotlin.linha.model.Historico
import br.com.estudo.kotlin.linha.enums.Sistema
import br.com.estudo.kotlin.linha.enums.TipoHistorico
import br.com.estudo.kotlin.linha.repository.LinhaRepository
import br.com.estudo.kotlin.linha.service.HistoricoService
import org.springframework.stereotype.Service
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@Service
class LinhaService(private val linhaRepository: LinhaRepository, private val historicoService: HistoricoService) {

    fun insert(linha: Linha): RetornoLinha {
        var retornoLinha: RetornoLinha

        linhaRepository.save(linha)

        historicoService.insert(Historico(
            tipo = TipoHistorico.post,
            sistema = Sistema.linha,
            descricao = "ddd: " + linha.ddd + " numero: " + linha.numero
        ))

        retornoLinha = defaultRetornoLinha(registros = 1, linhas = listOf(linha))

        return retornoLinha
    }

    fun find(ddd: String?, numero: String?, pagina: Int, qtdePagina: Int): RetornoLinha {
        var retornoLinha: RetornoLinha

        val page = PageRequest.of(pagina, qtdePagina, Sort.Direction.DESC, "ddd")
        val listaLinha = linhaRepository.findFilter(ddd, numero, page)

        historicoService.insert(Historico(
            tipo = TipoHistorico.get,
            sistema = Sistema.linha,
            descricao = "ddd: " + ddd + " numero: " + numero
        ))

        retornoLinha = defaultRetornoLinha(linhaRepository.count(ddd, numero), listaLinha)

        return retornoLinha
    }

    fun update(codigo: String, linha: Linha): RetornoLinha {
        var retornoLinha: RetornoLinha

        if (linhaRepository.existsById(codigo)) {
            linhaRepository.save(linha)

            historicoService.insert(Historico(
                tipo = TipoHistorico.put,
                sistema = Sistema.linha,
                descricao = "ddd: " + linha.ddd + " numero: " + linha.numero
            ))

            retornoLinha = defaultRetornoLinha(1, listOf(linha))

        } else {
            retornoLinha = RetornoLinha(
                codigo = 500,
                descricao = "Id não encontrado"
            )
        }

        return retornoLinha
    }

    fun delete(codigo: String): RetornoLinha {
        var retornoLinha: RetornoLinha

        if (linhaRepository.existsById(codigo)) {
            val linha = linhaRepository.findById(codigo).orElse(null)
            linhaRepository.delete(linha)

            historicoService.insert(Historico(
                tipo = TipoHistorico.delete,
                sistema = Sistema.linha,
                descricao = "ddd: " + linha.ddd + " numero: " + linha.numero
            ))

            retornoLinha = defaultRetornoLinha(1, listOf(linha))
        } else {
            retornoLinha = RetornoLinha(
                codigo = 500,
                descricao = "Id não encontrado"
            )
        }

        return retornoLinha
    }

    fun defaultRetornoLinha(registros: Int, linhas: List<Linha>, pagina: Int? = 0, qtdePagina: Int? = 0): RetornoLinha {
        return RetornoLinha(
            codigo = 0,
            descricao = "success",
            pagina = 0,    
            qtdePagina = 0,
            registros = registros,
            listaLinhas = linhas
        )
    }
}