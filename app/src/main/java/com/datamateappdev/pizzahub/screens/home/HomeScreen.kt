package com.datamateappdev.pizzahub.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.datamateappdev.pizzahub.components.HomeAppBar
import com.datamateappdev.pizzahub.components.home.NewMenuSection
import com.datamateappdev.pizzahub.components.home.PopularSection
import com.datamateappdev.pizzahub.components.home.TopBanner
import com.datamateappdev.pizzahub.data.PizzaItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    items: List<PizzaItem>,
    onMenuClicked: () -> Unit
) {
    Scaffold(modifier = modifier.windowInsetsPadding(WindowInsets.statusBars), topBar = {
        HomeAppBar(onMenuClicked = onMenuClicked)
    }) {
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = modifier.height(20.dp))
            TopBanner(modifier = modifier)
            PopularSection(items = items)
            NewMenuSection()
        }
    }
}