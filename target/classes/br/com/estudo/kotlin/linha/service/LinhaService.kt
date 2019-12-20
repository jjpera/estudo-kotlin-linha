package br.com.estudo.kotlin.linha.service

import br.com.estudo.kotlin.linha.model.RetornoLinha
import br.com.estudo.kotlin.linha.model.Linha
import br.com.estudo.kotlin.linha.model.RetornoHistorico
import br.com.estudo.kotlin.linha.model.Historico
import br.com.estudo.kotlin.linha.repository.LinhaRepository
import org.springframework.stereotype.Service

@Service
class LinhaService(private val linhaRepository: LinhaRepository) {

    fun insert(linha: Linha): RetornoLinha {
        var retornoLinha: RetornoLinha

        linhaRepository.save(linha)

        retornoLinha = defaultRetornoLinha(1, listOf(linha))

        return retornoLinha
    }

    fun find(ddd: String, numero: String, pagina: Integer, qtdePagina: Integer): RetornoLinha {
        var retornoLinha: RetornoLinha

        val listaLinha = linhaRepository.findAll()

        retornoLinha = defaultRetornoLinha(listaLinha.size, listaLinha)

        return retornoLinha
    }

    fun update(codigo: String, linha: Linha): RetornoLinha {
        var retornoLinha: RetornoLinha

        if (linhaRepository.existsById(codigo)) {
            linhaRepository.save(linha)
            
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

            retornoLinha = defaultRetornoLinha(1, listOf(linha))
        } else {
            retornoLinha = RetornoLinha(
                codigo = 500,
                descricao = "Id não encontrado"
            )
        }

        return retornoLinha
    }

    fun defaultRetornoLinha(registros: Int, linhas: List<Linha>): RetornoLinha {
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