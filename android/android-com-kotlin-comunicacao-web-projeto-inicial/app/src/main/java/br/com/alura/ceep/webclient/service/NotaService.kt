package br.com.alura.ceep.webclient.service

import br.com.alura.ceep.webclient.model.NotaRequisicao
import br.com.alura.ceep.webclient.model.NotaResposta
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface NotaService {

    @GET("/notas")
    suspend fun buscaTodas(): List<NotaResposta>

    @PUT("/notas/{id}")
    suspend fun salva(@Path("id") notaId: String,
                      @Body notaRequisicao: NotaRequisicao): Response<NotaResposta>

    @DELETE("/notas/{id}")
    suspend fun remove(@Path("id") notaId: String): Response<Void>
}