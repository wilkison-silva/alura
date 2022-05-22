package br.com.alura.ceep.webclient.service

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.RetrofitInicializador
import br.com.alura.ceep.webclient.model.NotaResposta
import java.lang.Exception

class NotaWebClient {

    private val notaService = RetrofitInicializador().notaService

    suspend fun buscaTodas(): List<Nota>? {
        return try {
            val notas: List<Nota> = notaService
                .buscaTodas()
                .map { notaResposta: NotaResposta ->
                    notaResposta.nota
                }
            notas
        } catch (e: Exception) {
            Log.e("NotaWebCliente", "Exception: ", e)
            null
        }
    }

}