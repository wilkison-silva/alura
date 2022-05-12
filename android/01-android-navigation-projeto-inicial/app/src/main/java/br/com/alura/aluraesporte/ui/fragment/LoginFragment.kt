package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel.ComponentesVisuais
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val navController by lazy {
        findNavController()
    }

    private val viewModel: LoginViewModel by viewModel()
    private val viewModelEstadoApp: EstadoAppViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_botao_logar.setOnClickListener {
            viewModel.fazerLogin()
            vaiParaListaProdutosFragment()
        }
        login_botao_cadastrar.setOnClickListener {
            val actionLoginFragmentToCadastroUsuarioFragment =
                LoginFragmentDirections.actionLoginFragmentToCadastroUsuarioFragment()
            navController.navigate(actionLoginFragmentToCadastroUsuarioFragment)
        }
        viewModelEstadoApp.mostrarAppBar(ComponentesVisuais(
            appBar = false,
            bottomNavigation = false
        ))
    }

    private fun vaiParaListaProdutosFragment() {
        val actionLoginFragmentToListaProdutos =
            LoginFragmentDirections.actionLoginFragmentToListaProdutos()
        navController.navigate(actionLoginFragmentToListaProdutos)
    }
}