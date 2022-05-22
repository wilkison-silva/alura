package br.com.alura.ceep.webclient.service

import br.com.alura.ceep.webclient.model.NotaResposta
import retrofit2.Call
import retrofit2.http.GET

interface NotaService {

    @GET("/notas")
    suspend fun buscaTodas(): List<NotaResposta>
}