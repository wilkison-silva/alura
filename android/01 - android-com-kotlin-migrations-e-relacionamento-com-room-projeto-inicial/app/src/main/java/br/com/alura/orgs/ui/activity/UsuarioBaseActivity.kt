package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.database.preference.CHAVE_USUARIO_ID_LOGADO
import br.com.alura.orgs.database.preference.dataStore
import br.com.alura.orgs.extensions.vaiPara
import br.com.alura.orgs.model.Usuario
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class UsuarioBaseActivity : AppCompatActivity() {

    private val usuarioDao by lazy {
        AppDatabase.instancia(this).usuarioDao()
    }

    private val _usuario: MutableStateFlow<Usuario?> = MutableStateFlow(null)
    protected val usuario: StateFlow<Usuario?> = _usuario

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            Log.i("Usuario Base", "verificando usuario logado")
            verificaUsuarioLogado()
        }
    }

    private suspend fun verificaUsuarioLogado() {
        dataStore.data.collect { preferences ->
            preferences[CHAVE_USUARIO_ID_LOGADO]?.let { usuarioId ->
                Log.i("Usuario Base", "usuario ID = $usuarioId")
                buscaUsuario(usuarioId)
            } ?: vaiParaLogin()
        }
    }

    private suspend fun buscaUsuario(usuarioId: String) {
        _usuario.value = usuarioDao
            .buscaPorId(usuarioId)
            .firstOrNull()
        Log.i("Usuario Base", "usuario encontrado = ${_usuario.value}")
    }

    protected suspend fun deslogaUsuario() {
        dataStore.edit { preferences ->
            preferences.remove(CHAVE_USUARIO_ID_LOGADO)
        }
    }

    private fun vaiParaLogin() {
        Log.i("Usuario Base", "indo para login")
        vaiPara(LoginActivity::class.java) {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
        finish()
    }
}