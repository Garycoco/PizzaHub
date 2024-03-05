package com.datamateappdev.pizzahub.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.datamateappdev.pizzahub.R

@Composable
fun HomeAppBar(
    modifier: Modifier = Modifier,
    onMenuClicked: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = null,
                Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillHeight
            )
            Column {
                Text(
                    text = "Deliver to",
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.labelSmall
                )
                Text(text = "Your Destination", fontWeight = FontWeight.Bold)
            }
        }
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = null)
            IconButton(onClick = onMenuClicked) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        }

    }
}