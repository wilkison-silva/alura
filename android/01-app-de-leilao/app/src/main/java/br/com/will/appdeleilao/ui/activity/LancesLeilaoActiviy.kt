package br.com.will.appdeleilao.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.will.appdeleilao.model.Leilao
import br.com.will.covidcasescharts.appdeleilao.R

class LancesLeilaoActiviy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lances_leilao)
        val dadosRecebidos = getIntent ()
        if (dadosRecebidos.hasExtra("leilao")) {
            val leilao: Leilao = dadosRecebidos.getSerializableExtra("leilao") as Leilao
            val descricao: TextView = findViewById(R.id.lances_leilao_descricao)
            descricao.setText(leilao.descricao)
        }

    }

}