package br.com.alura.orgs.database.dao

import androidx.room.*
import br.com.alura.orgs.model.Produto
import kotlinx.coroutines.flow.Flow

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produto")
    fun buscaTodos() : Flow<List<Produto>>

    @Insert
    suspend fun salva(vararg produto: Produto)

    @Delete
    suspend fun remove(vararg produto: Produto)

    @Update
    suspend fun altera(produto: Produto)

    @Query("SELECT * FROM Produto WHERE id = :id")
    suspend fun buscaPorId(id: Long) : Produto?
}