package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadoAppViewModel : ViewModel() {

    val componentesVisuais: LiveData<ComponentesVisuais> get() = _componentesVisuais

    private var _componentesVisuais: MutableLiveData<ComponentesVisuais> = MutableLiveData<ComponentesVisuais>().also {
        it.value = ComponentesVisuais()
    }

    fun mostrarAppBar(componentesVisuais: ComponentesVisuais){
        _componentesVisuais.value = componentesVisuais
    }

    class ComponentesVisuais(
        val appBar: Boolean = false,
        val bottomNavigation: Boolean = false
    ){

    }


}