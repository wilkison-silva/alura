package br.com.alura.technews.di.module

import androidx.room.Room
import br.com.alura.technews.database.AppDatabase
import br.com.alura.technews.database.dao.NoticiaDAO
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.retrofit.webclient.NoticiaWebClient
import br.com.alura.technews.ui.viewmodel.FormularioNoticiaViewModel
import br.com.alura.technews.ui.viewmodel.ListaNoticiasViewModel
import br.com.alura.technews.ui.viewmodel.VisualizaNoticiaViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BANCO_DE_DADOS = "news.db"

val appModules = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DE_DADOS
        ).build()
    }
    single<NoticiaDAO> {
        get<AppDatabase>().noticiaDAO
    }
    single<NoticiaWebClient> {
        NoticiaWebClient()
    }
    single<NoticiaRepository> {
        NoticiaRepository(
            get<NoticiaDAO>(),
            get<NoticiaWebClient>()
        )
    }
    viewModel<ListaNoticiasViewModel> {
        ListaNoticiasViewModel(
            get<NoticiaRepository>()
        )
    }
    viewModel<VisualizaNoticiaViewModel> {
        VisualizaNoticiaViewModel(
            get<NoticiaRepository>()
        )
    }
    viewModel<FormularioNoticiaViewModel> {
        FormularioNoticiaViewModel(
            get<NoticiaRepository>()
        )
    }
}
