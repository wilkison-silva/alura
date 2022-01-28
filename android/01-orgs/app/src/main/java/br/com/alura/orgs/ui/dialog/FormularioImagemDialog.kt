package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem

class FormularioImagemDialog(
    private val context: Context
) {

    fun mostra(urlPadrao: String? = null,
               quandoImagemCarregada: (urlImagem: String) -> Unit) {


        FormularioImagemBinding
            .inflate(LayoutInflater.from(context)).apply {
                if(urlPadrao != null){
                    formularioImagemImageview.tentaCarregarImagem(urlPadrao)
                    formularioImagemUrl.setText(urlPadrao)
                }

                formularioImagemBotaoCarregar.setOnClickListener {
                    val imagemURL: String = formularioImagemUrl.text.toString()
                    formularioImagemImageview.tentaCarregarImagem(imagemURL)
                }

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar") { _, _ ->
                        val urlImagem = formularioImagemUrl.text.toString()
                        quandoImagemCarregada(urlImagem)
                    }
                    .setNegativeButton("Cancelar") { _, _ ->

                    }
                    .show()

            }

    }

}