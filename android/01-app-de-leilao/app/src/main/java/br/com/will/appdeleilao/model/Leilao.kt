package br.com.will.appdeleilao.model

import br.com.will.appdeleilao.model.Lance
import java.io.Serializable

class Leilao(
    val descricao: String
) : Serializable {

    private val lances: MutableList<Lance> = mutableListOf()

}