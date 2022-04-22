package br.com.will.appdeleilao.model

import java.io.Serializable

data class Lance(
    val usuario: Usuario,
    val valor: Double
) : Serializable {


}
