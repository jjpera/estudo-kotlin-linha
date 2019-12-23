package br.com.estudo.kotlin.linha.api

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import br.com.estudo.kotlin.linha.service.LinhaService
import br.com.estudo.kotlin.linha.model.*

@Controller
//@RequestMapping("/linhas")
class LinhaController(private val linhaService: LinhaService) {

	@PostMapping("/linha")
	fun cadastrarLinha(@RequestBody body: Linha): ResponseEntity<RetornoLinha> {
        return ResponseEntity.ok(linhaService.insert(body))
    }

	@GetMapping("/linha")
	fun buscarLinha(
			@RequestParam(value = "ddd") ddd: String?,
			@RequestParam(value = "numero") numero: String?,
			@RequestParam(value = "pagina") pagina: Int,
			@RequestParam(value = "qtdePagina") qtdePagina: Int): ResponseEntity<RetornoLinha> {
        return return ResponseEntity.ok(linhaService.find(ddd, numero, pagina, qtdePagina))
    }

    @PutMapping("/linha/{codigo}")
    fun alterarLinha(
            @PathVariable codigo: String, 
            @RequestBody body: Linha): RetornoLinha {
        return linhaService.update(codigo, body)
    }

	@DeleteMapping("/linha/{codigo}")
	fun excluirLinha(@PathVariable codigo: String): RetornoLinha {
        return linhaService.delete(codigo)
    }
}