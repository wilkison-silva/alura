package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val navController by lazy {
        findNavController()
    }

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
            val actionLoginFragmentToListaProdutos =
                LoginFragmentDirections.actionLoginFragmentToListaProdutos()
            navController.navigate(actionLoginFragmentToListaProdutos)
        }

    }
}