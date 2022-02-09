package br.com.alura.orgs.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import br.com.alura.orgs.R
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.databinding.ActivityEditarBinding
import br.com.alura.orgs.databinding.ActivityListaProdutosActivityBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem
import br.com.alura.orgs.model.Produto
import org.w3c.dom.Text
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class EditarActivity : AppCompatActivity() {

    private lateinit var produto: Produto

    private val binding by lazy {
        ActivityEditarBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        tentaCarregarProduto()
    }

    private fun tentaCarregarProduto(){
        val intent: Intent = intent
        if (intent.hasExtra("produto")) {
            produto = intent.getParcelableExtra<Produto>("produto") as Produto
            if (produto != null) configuraCampos(produto)
        } else {
            finish()
        }
    }

    private fun configuraCampos(produto: Produto) {
        val imagem: ImageView = binding.activityEditarImagem
        val valor: TextView = binding.activityEditarValor
        val nome: TextView = binding.activityEditarNome
        val descricao: TextView = binding.activityEditarDescricao

        imagem.tentaCarregarImagem(produto.urlImagem)
        valor.text = formatarEmMoedaBrasileira(produto.valor)
        nome.text = produto.nome
        descricao.text = produto.descricao

    }

    private fun formatarEmMoedaBrasileira(valor: BigDecimal): String {
        val formatador: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        return formatador.format(valor)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_editar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(::produto.isInitialized){
            val db = AppDatabase.getInstance(this)
            val produtoDao = db.produtoDao()
            when (item.itemId) {
                R.id.activity_editar_menu_alterar -> {
                    Intent(this, FormularioProdutoActivity::class.java).apply {
                        putExtra("produto", produto)
                        startActivity(this)
                    }
                }
                R.id.activity_editar_menu_deletar -> {
                    produtoDao.remove(produto)
                    finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}