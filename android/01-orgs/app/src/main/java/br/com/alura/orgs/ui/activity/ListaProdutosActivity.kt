package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.alura.orgs.R
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.databinding.ActivityListaProdutosActivityBinding
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import kotlinx.coroutines.launch


private const val TAG = "ListaProdutosActivity"


class ListaProdutosActivity : AppCompatActivity() {

    private val adapter: ListaProdutosAdapter = ListaProdutosAdapter(this)

    private val binding by lazy {
        ActivityListaProdutosActivityBinding.inflate(layoutInflater)
    }

    private val dao by lazy {
        val db = AppDatabase.getInstance(this)
        db.produtoDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()
    }

    private fun configuraFab() {
        val fab = binding.activityListaProdutosFab
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView.adapter = adapter
        configuraAdapter()
    }

    private fun configuraAdapter() {
        adapter.quandoClicarNoItem = { produto: Produto, view: View ->
            val intent = Intent(this, EditarActivity::class.java).apply {
                putExtra("produto", produto)
            }
            startActivity(intent)
        }
        lifecycleScope.launch {
            val produtosEncontrados = dao.buscaTodos()
            produtosEncontrados.collect{
                adapter.atualiza(it)
            }
        }
    }

    fun showPopup(view: View) {
        val popup = PopupMenu(this, view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.activity_editar_menu, popup.menu)
        popup.show()
    }


}