package br.com.alura.ceep.webclient.model

data class NotaRequisicao(
    private val titulo: String,
    private val descricao: String,
    private val imagem: String? = null
) {

}
