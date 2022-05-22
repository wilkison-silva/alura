package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.service.NotaService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInicializador {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.38:8080/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val notaService: NotaService by lazy {
        retrofit.create(NotaService::class.java)
    }

}