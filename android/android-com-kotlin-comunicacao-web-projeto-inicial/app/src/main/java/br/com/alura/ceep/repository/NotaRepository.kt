package br.com.alura.ceep.repository

import br.com.alura.ceep.database.dao.NotaDao
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.service.NotaWebClient
import kotlinx.coroutines.flow.Flow

class NotaRepository(
    private val notaDao: NotaDao,
    private val notaWebClient: NotaWebClient
) {

    fun buscaTodas(): Flow<List<Nota>>{
        return notaDao.buscaTodas()
    }

    suspend fun atualizaTodas(){
        notaWebClient.buscaTodas()?.let { notas: List<Nota> ->
            notaDao.salva(notas)
            //busca primeiro na API e em seguida atualiza o banco
        }
    }

}