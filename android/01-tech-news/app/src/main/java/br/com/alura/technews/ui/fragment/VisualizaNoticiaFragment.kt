package br.com.alura.technews.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.alura.technews.R
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.ui.activity.NOTICIA_ID_CHAVE
import br.com.alura.technews.ui.fragment.extesions.mostraErro
import br.com.alura.technews.ui.viewmodel.VisualizaNoticiaViewModel
import kotlinx.android.synthetic.main.visualiza_noticia.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.IllegalArgumentException


private const val NOTICIA_NAO_ENCONTRADA = "Notícia não encontrada"
private const val MENSAGEM_FALHA_REMOCAO = "Não foi possível remover notícia"

class VisualizaNoticiaFragment : Fragment() {

    private val noticiaId: Long by lazy {
        arguments?.getLong(NOTICIA_ID_CHAVE)
            ?: throw IllegalArgumentException("NOTICIA_ID_CHAVE inválido")
    }

    private val viewModel by viewModel<VisualizaNoticiaViewModel>()

    private lateinit var noticia: Noticia

    var quandoAbreFormularioEdicao: (noticiaSelecionada: Noticia) -> Unit = {}
    var quandoFinalizaTela: () -> Unit = {}

    //step 1 - OnCreate is used only for initializations that don't need any view ready to be used
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) //habilita os menus para fragments
        verificaIdDaNoticia()
        buscaNoticiaSelecionada()
    }

    //step 2 - OnCreateView is used only for inflation of layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.visualiza_noticia, container, false)
    }

    //step 3 - onViewCreated is called when the layout inflation is done, then you can
    //do the binding process
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.visualiza_noticia_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.visualiza_noticia_menu_edita -> {
                quandoAbreFormularioEdicao(noticia)
            }
            R.id.visualiza_noticia_menu_remove -> remove()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun buscaNoticiaSelecionada() {
        viewModel.buscaPorId(noticiaId).observe(this, Observer { noticiaEncontrada ->
            noticiaEncontrada?.let {
                this.noticia = it
                preencheCampos(it)
            }
        })
    }

    private fun verificaIdDaNoticia() {
        if (noticiaId == 0L) {
            mostraErro(NOTICIA_NAO_ENCONTRADA)
            quandoFinalizaTela()
        }
    }

    private fun preencheCampos(noticia: Noticia) {
        visualiza_noticia_titulo.text = noticia.titulo
        visualiza_noticia_texto.text = noticia.texto
    }

    private fun remove() {
        if (::noticia.isInitialized) {
            viewModel.remove(noticia).observe(this, Observer { resource ->
                resource.erro?.let { _ ->
                    mostraErro(MENSAGEM_FALHA_REMOCAO)
                } ?: quandoFinalizaTela()
            })
        }
    }
}