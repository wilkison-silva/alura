package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        findNavController(R.id.produtos_activity_nav_host)
    }

    private val viewModel: EstadoAppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        navController.addOnDestinationChangedListener { navController,
                                                        navDestination,
                                                        bundle ->
            title = navDestination.label
//            when(navDestination.id){
//                R.id.listaProdutos -> supportActionBar?.show()
//                R.id.loginFragment -> supportActionBar?.hide()
//            }
            viewModel.appBar.observe(this, Observer { appBar: Boolean ->
                if(appBar){
                    supportActionBar?.show()
                }
                else{
                    supportActionBar?.hide()
                }
            })
            main_activity_bottom_navigation.setupWithNavController(navController)
        }
    }

}
