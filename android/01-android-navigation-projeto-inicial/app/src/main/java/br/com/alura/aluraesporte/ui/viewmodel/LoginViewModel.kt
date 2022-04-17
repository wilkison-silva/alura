package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.repository.LoginRepository

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {

    fun fazerLogin() = repository.fazerLogin()

    fun verificaSeFezLogin() : Boolean {
        return repository.verificaSeFezLogin()
    }

    fun fazerLogout() {
        repository.fazerLogout()
    }
}