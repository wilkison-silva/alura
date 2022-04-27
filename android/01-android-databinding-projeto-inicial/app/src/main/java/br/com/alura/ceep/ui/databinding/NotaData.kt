package br.com.alura.ceep.ui.databinding

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.alura.ceep.model.Nota
import java.util.*

data class NotaData(
    private var nota: Nota = Nota(),
    val titulo: MutableLiveData<String> = MutableLiveData<String>().also { it.value = nota.titulo },
    val descricao: MutableLiveData<String> = MutableLiveData<String>().also { it.value = nota.descricao },
    val favorita: MutableLiveData<Boolean> = MutableLiveData<Boolean>().also { it.value = nota.favorita },
    val imagemUrl: MutableLiveData<String> = MutableLiveData<String>().also { it.value = nota.imagemUrl }
) {
    fun atualiza(notaEncontrada: Nota) {
        nota = notaEncontrada
        titulo.postValue(notaEncontrada.titulo)
        descricao.postValue(notaEncontrada.descricao)
        favorita.postValue(notaEncontrada.favorita)
        imagemUrl.postValue(notaEncontrada.imagemUrl)
    }

    fun converteParaNota(): Nota? {
        return this.nota.copy(
            titulo = titulo.value ?: return null,
            descricao = descricao.value ?: return null,
            favorita = favorita.value ?: return null,
            imagemUrl = imagemUrl.value ?: return null
        )
    }
}