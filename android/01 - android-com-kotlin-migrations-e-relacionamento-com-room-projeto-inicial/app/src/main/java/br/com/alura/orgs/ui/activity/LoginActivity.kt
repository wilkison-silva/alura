package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.database.preference.CHAVE_USUARIO_ID_LOGADO
import br.com.alura.orgs.database.preference.dataStore
import br.com.alura.orgs.databinding.ActivityLoginBinding
import br.com.alura.orgs.extensions.toHash
import br.com.alura.orgs.extensions.toast
import br.com.alura.orgs.extensions.vaiPara
import br.com.alura.orgs.ui.viewmodel.LoginViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val loginViewModel by lazy {
        LoginViewModel()
    }

    private val usuarioDao by lazy {
        AppDatabase.instancia(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoCadastrar()
        configuraBotaoEntrar()
    }

    private fun configuraBotaoEntrar() {
        binding.activityLoginBotaoEntrar.setOnClickListener {
            val usuario = binding.activityLoginUsuario.text.toString()
            val senha = binding.activityLoginSenha.text.toString().toHash()

            autentica(usuario, senha)
        }
    }

    private fun autentica(usuario: String, senha: String) {
        lifecycleScope.launch {
            usuarioDao.autentica(
                usuarioNome = usuario,
                usuarioSenha = senha
            )?.let { usuario ->
                Log.i("Usuario Base", "Indo para Lista de Produtos")
                vaiPara(ListaProdutosActivity::class.java)
                dataStore.edit { preferences ->
                    preferences[CHAVE_USUARIO_ID_LOGADO] = usuario.id
                }
                finish()
            }
                ?: toast("Usuário não encontrado")
        }
    }

    private fun configuraBotaoCadastrar() {
        binding.activityLoginBotaoCadastrar.setOnClickListener {
            vaiPara(FormularioCadastroUsuarioActivity::class.java)
        }
    }

}