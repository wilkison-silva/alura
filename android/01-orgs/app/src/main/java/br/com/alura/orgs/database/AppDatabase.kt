package br.com.alura.orgs.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.alura.orgs.database.dao.Converters
import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.model.Produto

@Database(entities = [Produto::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun produtoDao(): ProdutoDao

    companion object {
        @Volatile private var dbInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "orgs.db"
                ).build();
            }
            return dbInstance as AppDatabase
        }
    }

}