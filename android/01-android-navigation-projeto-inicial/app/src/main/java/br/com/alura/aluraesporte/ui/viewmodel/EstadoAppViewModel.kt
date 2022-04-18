package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadoAppViewModel : ViewModel() {

    val appBar: LiveData<Boolean> get() = _appBar

    private var _appBar: MutableLiveData<Boolean> = MutableLiveData<Boolean>().also {
        it.value = false
    }

    fun mostrarAppBar(estado: Boolean){
        _appBar.value = estado
    }

}