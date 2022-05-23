package br.com.alura.ceep.repository

import br.com.alura.ceep.database.dao.NotaDao
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.NotaWebClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class NotaRepository(
    private val notaDao: NotaDao,
    private val notaWebClient: NotaWebClient
) {

    fun buscaTodas(): Flow<List<Nota>>{
        return notaDao.buscaTodas()
    }

    private suspend fun atualizaTodas(){
        notaWebClient.buscaTodas()?.let { notas: List<Nota> ->
            val notasSincronizadas = notas.map{ nota: Nota ->
                nota.copy(sincronizada = true)
            }
            notaDao.salva(notasSincronizadas)
        }
    }

    suspend fun salva(nota: Nota){
        notaDao.salva(nota)
        if(notaWebClient.salva(nota)){
            val notaSincronizada = nota.copy(sincronizada = true)
            notaDao.salva(notaSincronizada)
        }
    }

    suspend fun remove(notaId: String) {
        notaDao.remove(notaId)
    }

    fun buscaPorId(notaId: String): Flow<Nota> {
        return notaDao.buscaPorId(notaId)
    }

    suspend fun sincroniza(){
        //tenta atualizar as notas não sincronizadas do banco para dentro da webAPI
        val notasNaoSincronizadas: List<Nota> = notaDao.buscaNotasNaoSincronizadas().first()
        notasNaoSincronizadas.forEach{ notaNaoSincronizada: Nota ->
            salva(notaNaoSincronizada)
        }
        //Quando terminar o código acima, tenta atualizar as notas sincronizadas na webAPI
        //para dentro do banco
        atualizaTodas()
    }

}