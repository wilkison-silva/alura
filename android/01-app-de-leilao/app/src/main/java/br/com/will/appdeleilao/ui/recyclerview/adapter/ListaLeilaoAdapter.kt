package br.com.will.appdeleilao.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.will.covidcasescharts.appdeleilao.R
import br.com.will.appdeleilao.model.Leilao

class ListaLeilaoAdapter(
    private val context: Context,
    private val listaLeiloes: MutableList<Leilao> = mutableListOf(),
    var quandoItemClicado: (leilao: Leilao) -> Unit = {}
) : RecyclerView.Adapter<ListaLeilaoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val viewCriada = LayoutInflater.from(context)
            .inflate(
                R.layout.item_leilao,
                parent,
                false
            )
        return ViewHolder(viewCriada)
    }

    override fun getItemCount(): Int {
        return listaLeiloes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val leilao = listaLeiloes[position]
        holder.vincula(leilao)
    }

    fun atualiza(listaLeiloes: MutableList<Leilao>) {
        notifyItemRangeRemoved(0, this.listaLeiloes.size)
        this.listaLeiloes.clear()
        this.listaLeiloes.addAll(listaLeiloes)
        notifyItemRangeInserted(0, this.listaLeiloes.size)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var leilao: Leilao
        private lateinit var descricaoLeilaoTextView: TextView
        init {
            descricaoLeilaoTextView = itemView.findViewById(R.id.item_leilao_descricao)
            itemView.setOnClickListener {
                if (::leilao.isInitialized) {
                    quandoItemClicado(leilao)
                }
            }
        }

        fun vincula(leilao: Leilao) {
            this.leilao = leilao
            descricaoLeilaoTextView.text = leilao.descricao
        }
    }

}