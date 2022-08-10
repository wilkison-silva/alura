package br.com.alura.alurasquare.ui.viewmodel

import androidx.lifecycle.*
import br.com.alura.alurasquare.model.Post
import br.com.alura.alurasquare.repository.PostRepository
import br.com.alura.alurasquare.repository.Resultado

class FormularioPostViewModel(
    private val repository: PostRepository
) : ViewModel() {

    fun buscaPost(id: String) = repository.buscaPorId(id).asLiveData()

    fun salva(post: Post, imagemByteArray: ByteArray) =
        liveData<Resultado<Unit>>(viewModelScope.coroutineContext) {
            try {
                val id = repository.salva(post)
                emit(Resultado.Sucesso())
                _imagemCarregada.value?.let {
                    repository.enviaImagem(id, imagemByteArray)
                }
            } catch (e: Exception) {
                emit(Resultado.Erro(e))
            }
        }

    fun remove(postId: String) =
        liveData<Resultado<Unit>>(viewModelScope.coroutineContext) {
            try {
                repository.remove(postId)
                emit(Resultado.Sucesso())
                repository.removeImagem(postId)
            } catch (e: Exception) {
                emit(Resultado.Erro(e))
            }
        }

    fun edita(post: Post, imagemByteArray: ByteArray) =
        liveData<Resultado<Unit>>(viewModelScope.coroutineContext) {
            try {
                repository.edita(post)
                emit(Resultado.Sucesso())
                post.id?.let { postId ->
                    _imagemCarregada.value?.let {
                        repository.enviaImagem(postId, imagemByteArray)
                    }
                }
            } catch (e: Exception) {
                emit(Resultado.Erro(e))
            }
        }

    private val _imagemCarregada = MutableLiveData<String?>()
    val imagemCarregada: LiveData<String?>
        get() = _imagemCarregada


    fun atualizaImagemCarregada(imagemUrl: String){
        _imagemCarregada.postValue(imagemUrl)
    }

    fun removerImagem(){
        _imagemCarregada.postValue(null)
    }


}