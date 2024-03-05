package com.datamateappdev.pizzahub.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datamateappdev.pizzahub.data.PizzaItem
import com.datamateappdev.pizzahub.data.PizzaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PizzaRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState(loading = true))
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getAllPopularItems()
        getAllNewItems()
    }

    private fun getAllPopularItems() {
        viewModelScope.launch {
            repository.getAllPopularPizza()
                .catch { ex ->
                    _uiState.value = HomeUiState(error = ex.message, loading = false)
                }
                .collect { popularItem ->
                    _uiState.value = HomeUiState(popularItems = popularItem, loading = false)
                }
        }
    }

    private fun getAllNewItems() {
        viewModelScope.launch {
            repository.getLLNewMenuPizza()
                .catch { ex ->
                    _uiState.value = HomeUiState(error = ex.message)
                }
                .collect { newItem ->
                    _uiState.value = HomeUiState(newItems = newItem)
                }
        }
    }
}

data class HomeUiState(
    val popularItems: List<PizzaItem> = emptyList(),
    val newItems: List<PizzaItem> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)