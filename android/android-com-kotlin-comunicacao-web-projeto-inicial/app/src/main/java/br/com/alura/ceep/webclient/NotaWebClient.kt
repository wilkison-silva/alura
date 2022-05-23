package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.model.NotaRequisicao
import br.com.alura.ceep.webclient.model.NotaResposta
import retrofit2.Response
import java.lang.Exception
import javax.security.auth.login.LoginException

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

    suspend fun salva(nota: Nota): Boolean {
        try {
            val resposta: Response<NotaResposta> = notaService.salva(
                nota.id,
                NotaRequisicao(
                    nota.titulo,
                    nota.descricao,
                    nota.imagem
                )
            )
            if (resposta.isSuccessful) {
                Log.i("NotaWebCliente", "Nota salva na webApi")
                return true
            } else {
                Log.i("NotaWebCliente", "Não conseguiu salvar a API: ${resposta.code()} - code")
                return false
            }
        } catch (e: Exception) {
            Log.e("NotaWebCliente", "Falha ao salvar", e)
        }
        return false
    }

}