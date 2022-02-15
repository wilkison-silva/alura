package br.com.alura.technews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.repository.NoticiaRepository

class ListaNoticiasViewModel(
    private val repository: NoticiaRepository
) : ViewModel() {



    fun buscaTodos(
        quandoSucesso: (noticiasNovas: List<Noticia>) -> Unit,
        quandoFalha: (erro: String?) -> Unit
    ) {
        repository.buscaTodos(quandoSucesso, quandoFalha)
    }


}