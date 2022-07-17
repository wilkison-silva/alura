package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.model.Produto
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import org.koin.android.viewmodel.ext.android.viewModel
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private val controlador by lazy {
        findNavController(R.id.main_activity_nav_host)
    }
    private val viewModel: EstadoAppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        lifecycleScope.launch {
            getProdutosFirebase()
            addProdutoFirebase()
            getProdutosFirebase()
        }

        controlador.addOnDestinationChangedListener { _,
                                                      destination,
                                                      _ ->
            title = destination.label
            viewModel.componentes.observe(this) {
                it?.let { temComponentes ->
                    if (temComponentes.appBar) {
                        supportActionBar?.show()
                    } else {
                        supportActionBar?.hide()
                    }
                    if (temComponentes.bottomNavigation) {
                        main_activity_bottom_navigation.visibility = VISIBLE
                    } else {
                        main_activity_bottom_navigation.visibility = GONE
                    }
                }
            }
        }
        main_activity_bottom_navigation
            .setupWithNavController(controlador)
    }

    private suspend fun getProdutosFirebase() {
        val firestore: FirebaseFirestore = Firebase.firestore
        try {
            val querySnapshot: QuerySnapshot? =
                firestore.collection("produtos").get().await()
            querySnapshot?.documents?.forEach { documentSnapshot ->
                Log.i("MainActivity", "produto encontrado: ${documentSnapshot.data}")
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    private suspend fun addProdutoFirebase() {
        val firestore: FirebaseFirestore = Firebase.firestore
        try {
            val produto = Produto(
                nome = "camisa flamengo",
                preco = BigDecimal(200)
            )
            firestore.collection("produtos").add(
                mapOf<String, Any>(
                    "nome" to produto.nome,
                    "preco" to produto.preco.toDouble()
                )
            ).await()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

}
