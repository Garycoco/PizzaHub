package com.datamateappdev.pizzahub.data

import kotlinx.coroutines.flow.Flow

interface PizzaRepository {
    fun getAllPopularPizza(): Flow<List<PizzaItem>>
    fun getLLNewMenuPizza(): Flow<List<PizzaItem>>
}