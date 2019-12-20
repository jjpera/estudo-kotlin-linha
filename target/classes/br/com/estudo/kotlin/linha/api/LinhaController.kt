package br.com.estudo.kotlin.linha.api

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import br.com.estudo.kotlin.linha.service.LinhaService
import br.com.estudo.kotlin.linha.model.*

@Controller
class LinhaController {

	@PostMapping("/linha")
	fun cadastrarLinha(@RequestBody body: Linha): RetornoLinha {
        var retornoLinha: RetornoLinha = RetornoLinha()
        return retornoLinha
    }

	@GetMapping("/linha")
	fun buscarLinha(
			@RequestParam(value = "ddd") ddd: String,
			@RequestParam(value = "numero") numero: String,
			@RequestParam(value = "pagina") pagina: Integer,
			@RequestParam(value = "qtdePagina") qtdePagina: Integer): RetornoLinha {
        var retornoLinha: RetornoLinha = RetornoLinha()
        return retornoLinha
    }

    @PutMapping("/linha/{codigo}")
    fun alterarLinha(
            @PathVariable codigo: String, 
            @RequestBody body: Linha): RetornoLinha {
        var retornoLinha: RetornoLinha = RetornoLinha()
        return retornoLinha
    }

	@DeleteMapping("/linha/{codigo}")
	fun excluirLinha(@PathVariable codigo: String): RetornoLinha {
        var retornoLinha: RetornoLinha = RetornoLinha()
        return retornoLinha
    }
}