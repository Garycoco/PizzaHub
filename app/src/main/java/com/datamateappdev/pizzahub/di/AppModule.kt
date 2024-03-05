package com.datamateappdev.pizzahub.di

import com.datamateappdev.pizzahub.data.PizzaRepository
import com.datamateappdev.pizzahub.data.PizzaRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRepository(): PizzaRepository = PizzaRepositoryImpl()
}