package br.com.alura.technews.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.ui.viewmodel.VisualizaNoticiaViewModel

class VisualizaNoticiaViewModelFactory(
    private val repository: NoticiaRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(p0: Class<T>): T {
        return VisualizaNoticiaViewModel(repository) as T
    }
}


