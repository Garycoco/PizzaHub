package com.datamateappdev.pizzahub.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.datamateappdev.pizzahub.R

@Composable
fun TopBanner(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp), modifier = modifier.padding(horizontal = 10.dp)) {
        Text(
            text = "Let's find your best\nfavorite pizza!",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Row(
                modifier = modifier.padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = modifier.weight(1f),
                    painter = painterResource(id = R.drawable.banner_pizza),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
                Column(
                    modifier = modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MyText(text = "Special For You", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.ExtraBold)
                    MyText(
                        text = "Tomato base, pepperoni, pressed cubed beef, mushroom, green pepper & onion",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.onError.copy(alpha = .8f)
                    )
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Order Now")
                    }
                }
            }
        }
    }
}

@Composable
fun MyText(
    text: String,
    style: TextStyle,
    color: Color = MaterialTheme.colorScheme.onError,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        style = style,
        color = color,
        fontWeight = fontWeight
    )
}