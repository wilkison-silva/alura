package br.com.alura.aluraesporte.repository

import android.content.SharedPreferences
import androidx.core.content.edit

private const val CHAVE_LOGADO = "CHAVE_LOGADO"

class LoginRepository(
    private val preferences: SharedPreferences
) {
    fun fazerLogin() {
        salva(true)
    }

    fun fazerLogout() {
        salva(false)
    }

    fun verificaSeFezLogin(): Boolean = preferences.getBoolean(CHAVE_LOGADO, false)

    private fun salva(estado: Boolean) {
        preferences.edit {
            putBoolean(CHAVE_LOGADO, estado)
        }
    }
}
