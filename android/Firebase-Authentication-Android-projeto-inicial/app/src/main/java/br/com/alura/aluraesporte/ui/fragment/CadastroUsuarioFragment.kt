package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.CadastroUsuarioViewModel
import br.com.alura.aluraesporte.ui.viewmodel.ComponentesVisuais
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.cadastro_usuario.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CadastroUsuarioFragment : Fragment() {

    private val controlador by lazy {
        findNavController()
    }
    private val estadoAppViewModel: EstadoAppViewModel by sharedViewModel()
    private val cadastroUsuarioViewModel: CadastroUsuarioViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.cadastro_usuario,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        estadoAppViewModel.temComponentes = ComponentesVisuais()
        cadastro_usuario_botao_cadastrar.setOnClickListener {
            val email = cadastro_usuario_email.editText?.text.toString()
            val password = cadastro_usuario_senha.editText?.text.toString()
            cadastroUsuarioViewModel
                .createUser(email, password)
                .observe(viewLifecycleOwner) { result ->
                    if (result) {
                        controlador.popBackStack()
                    } else {
                        Snackbar.make(view, "Algo deu errado", Snackbar.LENGTH_LONG).show()
                    }
                }
        }
    }

}