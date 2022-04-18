package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.NavGraphDirections
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

abstract class BaseFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()
    private val navController by lazy {
        findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verificaSeEstaLogado()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_lista_produtos, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.menu_lista_produtos_deslogar){
            loginViewModel.fazerLogout()
            vaiParaLoginFragment()

        }
        return super.onOptionsItemSelected(item)
    }

    private fun vaiParaLoginFragment() {
        val actionGlobalLoginFragment = NavGraphDirections.actionGlobalLoginFragment()
        navController.navigate(actionGlobalLoginFragment)
    }

    private fun verificaSeEstaLogado() {
        if (loginViewModel.verificaSeNaoFezLogin()) {
            vaiParaLoginFragment()
        }
    }
}