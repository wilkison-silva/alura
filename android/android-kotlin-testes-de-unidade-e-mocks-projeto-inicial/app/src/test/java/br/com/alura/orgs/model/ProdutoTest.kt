package br.com.alura.orgs.model

import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeTrue
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

class ProdutoTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `deve retornar verdadeiro quando o valor do produto for valido`(){
        val produto = Produto(
            nome = "abacaxi",
            descricao = "frutas",
            valor = BigDecimal("10.99")
        )

        produto.valorValido.shouldBeTrue()
    }
}