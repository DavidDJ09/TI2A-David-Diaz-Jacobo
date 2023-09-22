package com.daviddj.superheroes.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes;

data class Hero(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)