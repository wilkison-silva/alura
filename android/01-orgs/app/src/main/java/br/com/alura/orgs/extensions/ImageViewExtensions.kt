package br.com.alura.orgs.extensions

import android.widget.ImageView

import coil.load

fun ImageView.tentaCarregarImagem(url: String? = null) {
    load(url) {
        fallback(br.com.alura.orgs.R.drawable.erro)//in case of image is null
        error(br.com.alura.orgs.R.drawable.erro)//in case of uri error
        placeholder(br.com.alura.orgs.R.drawable.placeholder) // show placeholder while loading url target
    }
}