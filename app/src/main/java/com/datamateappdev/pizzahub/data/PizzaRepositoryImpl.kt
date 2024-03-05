package com.datamateappdev.pizzahub.data

import com.datamateappdev.pizzahub.data.local.LocalPizzaDataProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PizzaRepositoryImpl: PizzaRepository {
    override fun getAllPopularPizza(): Flow<List<PizzaItem>> = flow {
        emit(LocalPizzaDataProvider.allPopularPizza)
    }

    override fun getLLNewMenuPizza(): Flow<List<PizzaItem>> = flow {
        emit(LocalPizzaDataProvider.allNewPizza)
    }
}