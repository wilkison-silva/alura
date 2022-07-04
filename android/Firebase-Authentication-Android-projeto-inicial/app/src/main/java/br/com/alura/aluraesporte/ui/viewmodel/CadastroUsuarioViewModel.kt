package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.repository.FirebaseAuthRepository

class CadastroUsuarioViewModel(
    private val firebaseAuthRepository: FirebaseAuthRepository
) : ViewModel(){

    fun createUser(email: String, password: String): LiveData<Boolean> {
        return firebaseAuthRepository.createUser(email, password)
    }
}