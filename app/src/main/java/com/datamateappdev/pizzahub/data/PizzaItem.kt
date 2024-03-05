package com.datamateappdev.pizzahub.data

import androidx.annotation.DrawableRes

data class PizzaItem(
    val id: Long,
    val name: String,
    val desc: String,
    val prize: Double,
    @DrawableRes val image: Int
)
