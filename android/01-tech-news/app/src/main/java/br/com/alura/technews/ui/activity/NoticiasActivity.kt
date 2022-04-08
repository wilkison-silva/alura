package br.com.alura.technews.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.alura.technews.R
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.ui.fragment.ListaNoticiasFragment
import br.com.alura.technews.ui.fragment.VisualizaNoticiaFragment

private const val TITULO_APPBAR = "Notícias"
private const val MENSAGEM_FALHA_CARREGAR_NOTICIAS = "Não foi possível carregar as novas notícias"

private const val TAG_FRAGMENT_LISTA_NOTICIAS = "lista-noticias"

class NoticiasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)
        title = TITULO_APPBAR

        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.add(
            R.id.activity_noticias_container,
            ListaNoticiasFragment(),
            TAG_FRAGMENT_LISTA_NOTICIAS
        )
        beginTransaction.commit()
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        if (fragment is ListaNoticiasFragment) {
            fragment.quandoFabSalvaNoticiaClicado = {
                abreFormularioModoCriacao()
            }
            fragment.quandoNoticiaSelecionada = { noticia ->
                abreVisualizadorNoticia(noticia)
            }
        }
        if (fragment is VisualizaNoticiaFragment) {
            fragment.quandoAbreFormularioEdicao = { noticiaSelecionada: Noticia ->
                abreFormularioEdicao(noticiaSelecionada)
            }
            fragment.quandoFinalizaTela = {
                finish()
            }
        }
    }

    private fun abreFormularioModoCriacao() {
        val intent = Intent(this, FormularioNoticiaActivity::class.java)
        startActivity(intent)
    }

    private fun abreVisualizadorNoticia(noticia: Noticia) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        val visualizaNoticiaFragment = VisualizaNoticiaFragment()
        val dados = Bundle()
        dados.putLong(NOTICIA_ID_CHAVE, noticia.id)
        visualizaNoticiaFragment.arguments = dados
        beginTransaction.replace(R.id.activity_noticias_container, visualizaNoticiaFragment)
        beginTransaction.addToBackStack(null)
        beginTransaction.commit()
    }

    private fun abreFormularioEdicao(noticia: Noticia) {
        val intent = Intent(this, FormularioNoticiaActivity::class.java)
        intent.putExtra(NOTICIA_ID_CHAVE, noticia.id)
        startActivity(intent)
    }

}
