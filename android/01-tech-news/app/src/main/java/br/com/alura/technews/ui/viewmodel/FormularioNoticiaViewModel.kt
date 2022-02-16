package br.com.alura.technews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.repository.Resource

class FormularioNoticiaViewModel(
    private val repository: NoticiaRepository
) : ViewModel() {

    fun salva(noticia: Noticia): LiveData<Resource<Void?>> {
//        val falha = { _: String? ->
//            mostraErro(MENSAGEM_ERRO_SALVAR)
//        }
//        val sucesso = { _: Noticia ->
//            finish()
//        }

        if (noticia.id > 0) {
            return repository.edita(noticia)
        }
        return repository.salva(noticia)
    }
}