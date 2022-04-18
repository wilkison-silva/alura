package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.com.alura.aluraesporte.R

class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        findNavController(R.id.produtos_activity_nav_host)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        navController.addOnDestinationChangedListener { navController,
                                                        navDestination,
                                                        bundle ->
            title = navDestination.label
            when(navDestination.id){
                R.id.listaProdutos -> supportActionBar?.show()
                R.id.loginFragment -> supportActionBar?.hide()
            }

        }
    }

}
