package br.com.alura.technews.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.alura.technews.R
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.ui.activity.extensions.mostraErro
import br.com.alura.technews.ui.fragment.extesions.mostraErro
import br.com.alura.technews.ui.recyclerview.adapter.ListaNoticiasAdapter
import br.com.alura.technews.ui.viewmodel.ListaNoticiasViewModel
import kotlinx.android.synthetic.main.lista_noticias.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.IllegalArgumentException

private const val MENSAGEM_FALHA_CARREGAR_NOTICIAS = "Não foi possível carregar as novas notícias"

class ListaNoticiasFragment : Fragment() {

    var quandoFabSalvaNoticiaClicado: () -> Unit = {}
    var quandoNoticiaSelecionada: (noticia: Noticia) -> Unit = {}

    private val adapter by lazy {
        context?.let { context ->
            ListaNoticiasAdapter(context = context)
        } ?: throw IllegalArgumentException("Contexto inválido")
    }

    private val viewModel by viewModel<ListaNoticiasViewModel>()

    //step 1 - OnCreate is used only for initializations that don't need any view ready to be used
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buscaNoticias()
    }

    //step 2 - OnCreateView is used only for inflation of layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_noticias, container, false)
    }

    //step 3 - onViewCreated is called when the layout inflation is done, then you can
    //do the binding process
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecyclerView()
        configuraFabAdicionaNoticia()
    }

    private fun configuraFabAdicionaNoticia() {
        lista_noticias_fab_salva_noticia.setOnClickListener {
            quandoFabSalvaNoticiaClicado()
        }
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        lista_noticias_recyclerview.addItemDecoration(divisor)
        lista_noticias_recyclerview.adapter = adapter
        configuraAdapter()
    }

    private fun configuraAdapter() {
        adapter.quandoItemClicado = quandoNoticiaSelecionada
    }

    private fun buscaNoticias() {
        viewModel.buscaTodos().observe(this, Observer { resource ->
            resource.dado?.let {
                adapter.atualiza(it)
            }
            resource.erro?.let {
                mostraErro(it)
            }
        })
    }
}