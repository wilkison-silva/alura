package br.com.alura.aluraesporte.repository

import android.content.SharedPreferences
import androidx.core.content.edit

private const val CHAVE_LOGADO = "CHAVE_LOGADO"

class LoginRepository(
    private val preferences: SharedPreferences
) {

    fun fazerLogin() {
        preferences.edit {
            putBoolean(CHAVE_LOGADO, true)
        }
    }

    fun verificaSeFezLogin(): Boolean = preferences.getBoolean(CHAVE_LOGADO, false)

    fun fazerLogout() {
        preferences.edit {
            putBoolean(CHAVE_LOGADO, false)
        }
    }

}
