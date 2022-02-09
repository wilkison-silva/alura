package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.dialog.FormularioImagemDialog
import coil.load
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity() {

    private var urlImagem: String? = null
    private var idProduto = 0L

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
        setContentView(binding.root)

        title = "Cadastrar produto"

        binding.activityFormularioProdutoImagem.setOnClickListener {
            FormularioImagemDialog(this)
                .mostra(this.urlImagem) { urlImagem ->
                    this.urlImagem = urlImagem
                    binding.activityFormularioProdutoImagem.tentaCarregarImagem(this.urlImagem)
                }
        }

        intent.getParcelableExtra<Produto>("produto")?.let { produtoRecebido ->
            title = "Alterar produto"
            with(binding) {
                activityFormularioProdutoImagem.tentaCarregarImagem(produtoRecebido.urlImagem)
                activityFormularioProdutoNome.setText(produtoRecebido.nome)
                activityFormularioProdutoDescricao.setText(produtoRecebido.descricao)
                activityFormularioProdutoValor.setText(produtoRecebido.valor.toPlainString())
                idProduto = produtoRecebido.id
                urlImagem = produtoRecebido.urlImagem
            }
        }
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvar
        val db = AppDatabase.getInstance(this)
        val produtoDao = db.produtoDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            if(idProduto == 0L){
                produtoDao.salva(produtoNovo)
            }
            else {
                produtoDao.altera(produtoNovo)
            }
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
            urlImagem = urlImagem,
            id =  idProduto
        )
    }

}