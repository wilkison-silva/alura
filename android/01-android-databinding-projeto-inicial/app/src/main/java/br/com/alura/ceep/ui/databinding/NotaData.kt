package br.com.alura.ceep.ui.databinding

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import br.com.alura.ceep.model.Nota
import java.util.*

data class NotaData(
    private var nota: Nota = Nota(),
    val titulo: ObservableField<String> = ObservableField(nota.titulo),
    val descricao: ObservableField<String> = ObservableField(nota.descricao),
    val favorita: ObservableBoolean = ObservableBoolean(nota.favorita),
    val imagemUrl: ObservableField<String> = ObservableField(nota.imagemUrl)
) {
    fun atualiza(notaEncontrada: Nota) {
        nota = notaEncontrada
        titulo.set(notaEncontrada.titulo)
        descricao.set(notaEncontrada.descricao)
        favorita.set(notaEncontrada.favorita)
        imagemUrl.set(notaEncontrada.imagemUrl)
    }

    fun converteParaNota(): Nota? {
        return this.nota.copy(
            titulo = titulo.get() ?: return null,
            descricao = descricao.get() ?: return null,
            favorita = favorita.get(),
            imagemUrl = imagemUrl.get() ?: return null
        )
    }
}