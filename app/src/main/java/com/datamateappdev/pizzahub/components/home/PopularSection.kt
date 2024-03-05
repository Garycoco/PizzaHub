package com.datamateappdev.pizzahub.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.datamateappdev.pizzahub.components.SectionRow
import com.datamateappdev.pizzahub.data.PizzaItem

@Composable
fun PopularSection(modifier: Modifier = Modifier, items: List<PizzaItem>) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        SectionRow(title = "Popular", option = "See All")
        Text(
            modifier = modifier.padding(horizontal = 10.dp),
            text = "See the most popular food on order",
            fontWeight = FontWeight.ExtraLight,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = .5f)
        )
        LazyRow(contentPadding = PaddingValues(10.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(items) { item ->
                CardItem(item = item)
            }
        }
    }
}

@Composable
fun CardItem(modifier: Modifier = Modifier, item: PizzaItem) {
    Card(modifier = modifier
        .width(150.dp)
        .wrapContentWidth()
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .size(150.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.outline)
        )
        Column(
            modifier = modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text = item.name, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(
                text = item.desc,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = .5f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = modifier.height(5.dp))
            Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "R${item.prize}", fontWeight = FontWeight.ExtraBold)
                FilledIconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                }
            }
        }
    }
}