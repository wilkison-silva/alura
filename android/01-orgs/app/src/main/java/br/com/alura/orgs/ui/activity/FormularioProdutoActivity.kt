package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.model.Produto
import coil.load
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity() {

    private var urlImagem: String? = null

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
        setContentView(binding.root)

        val formularioImagemBinding = FormularioImagemBinding.inflate(layoutInflater)

        formularioImagemBinding.formularioImagemBotaoCarregar.setOnClickListener {
            val imagemURL: String = formularioImagemBinding.formularioImagemUrl.text.toString()
            formularioImagemBinding.formularioImagemImageview.load(imagemURL)
        }

        binding.activityFormularioProdutoImagem.setOnClickListener {
            AlertDialog.Builder(this)
                .setView(formularioImagemBinding.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    urlImagem = formularioImagemBinding.formularioImagemUrl.text.toString()
                    binding.activityFormularioProdutoImagem.load(urlImagem)
                }
                .setNegativeButton("Cancelar") { _, _ ->

                }
                .show()
        }


    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvar
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = binding.activityFormularioProdutoNome
        val nome = campoNome.text.toString()
        val campoDescricao = binding.activityFormularioProdutoDescricao
        val descricao = campoDescricao.text.toString()
        val campoValor = binding.activityFormularioProdutoValor
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor,
            urlImagem = urlImagem
        )
    }

}