package br.com.alura.technews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.repository.Resource

class VisualizaNoticiaViewModel(
    private val repository: NoticiaRepository
) : ViewModel() {

    fun buscaPorId(noticiaId: Long): LiveData<Noticia?> = repository.buscaPorId(noticiaId)

    fun remove(noticia: Noticia) : LiveData<Resource<Void?>> {
        return repository.remove(noticia)
    }


}