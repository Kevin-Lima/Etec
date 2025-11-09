package com.example.affirmations.model

// Essas anotações servem para avisar ao Android Studio que essas variáveis
// devem receber IDs específicos dos recursos do app (strings e drawables).
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// "data class" é usada quando a classe serve apenas para guardar dados.
// Aqui estamos guardando o texto da afirmação e a imagem dela.
data class Affirmation(
    // @StringRes indica que este Int é um ID de recurso de string (R.string...)
    @StringRes val stringResourceId: Int,

    // @DrawableRes indica que este Int é um ID de recurso de imagem (R.drawable...)
    @DrawableRes val imageResourceId: Int
)

