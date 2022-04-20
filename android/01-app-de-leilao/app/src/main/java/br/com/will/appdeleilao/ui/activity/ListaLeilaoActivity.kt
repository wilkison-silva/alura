package br.com.will.appdeleilao.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.will.covidcasescharts.appdeleilao.R
import br.com.will.appdeleilao.model.Leilao
import br.com.will.appdeleilao.ui.recyclerview.adapter.ListaLeilaoAdapter

class ListaLeilaoActivity : AppCompatActivity() {

    private val listaNoticiasRecyclerView: RecyclerView by lazy{
        findViewById(R.id.lista_leilao_recyclerview)
    }

    private val adapter by lazy {
            ListaLeilaoAdapter(context = this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_leilao)
        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        listaNoticiasRecyclerView.addItemDecoration(divisor)
        listaNoticiasRecyclerView.adapter = adapter
        configuraAdapter()
    }

    private fun configuraAdapter() {
        adapter.atualiza(leiloesDeExemplo())
        adapter.quandoItemClicado = {leilao ->
            val vaiParaLancesLeilao = Intent(
                this,
                LancesLeilaoActiviy::class.java
            )
            vaiParaLancesLeilao.putExtra("leilao", leilao)
            startActivity(vaiParaLancesLeilao)
        }
    }

    private fun leiloesDeExemplo(): MutableList<Leilao> {
        val console = Leilao("Console")
        return mutableListOf(console)
    }
}