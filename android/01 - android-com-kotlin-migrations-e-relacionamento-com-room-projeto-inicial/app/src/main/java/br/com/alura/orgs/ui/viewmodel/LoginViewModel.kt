package br.com.alura.orgs.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    companion object{
        private var _isLoading: MutableLiveData<Boolean> = MutableLiveData()
        val isLoading: LiveData<Boolean> = _isLoading

        fun loadingStatus(status: Boolean){
            _isLoading.value = status
        }
    }

}