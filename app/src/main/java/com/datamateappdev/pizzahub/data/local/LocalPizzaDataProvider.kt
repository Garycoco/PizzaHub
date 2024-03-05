package com.datamateappdev.pizzahub.data.local

import com.datamateappdev.pizzahub.R
import com.datamateappdev.pizzahub.data.PizzaItem

object LocalPizzaDataProvider {
    val allPopularPizza = listOf(
        PizzaItem(
            id = 1,
            name = "Bacon, Avo & Feta",
            desc = "Tomato base, bacon, avocado & feta cheese",
            prize = 52.00,
            image = R.drawable.popular1
        ),
        PizzaItem(
            id = 2,
            name = "Bacon Supreme",
            desc = "Tomato base, bacon, mushroom, green pepper & onion",
            prize = 120.00,
            image = R.drawable.popular2
        ),
        PizzaItem(
            id = 3,
            name = "Greek",
            desc = "Tomato base, feta cheese & olives",
            prize = 75.25,
            image = R.drawable.popular3
        ),
        PizzaItem(
            id = 4,
            name = "Beef (Sava Flava)",
            desc = "Beef - Tomato base with pressed beef and mozzarella cheese",
            prize = 28.50,
            image = R.drawable.popular4
        )
    )

    val allNewPizza = listOf(
        PizzaItem(
            id = 1,
            name = "Macon, Avo & Feta",
            desc = "Tomato base, macon, avocado & feta cheese",
            prize = 52.00,
            image = R.drawable.new_menu1
        ),
        PizzaItem(
            id = 2,
            name = "Margherita",
            desc = "Tomato base, olive oil, origanum & garlic",
            prize = 28.90,
            image = R.drawable.margherita
        ),
        PizzaItem(
            id = 3,
            name = "Hawaiian",
            desc = "Tomato base, russians & pineapple",
            prize = 37.90,
            image = R.drawable.hawaiian
        ),
        PizzaItem(
            id = 4,
            name = "BBQ CHICKEN & PINEAPPLE",
            desc = "Barbeque base, chicken & pineapple",
            prize = 28.50,
            image = R.drawable.bbq_chickpine_pine
        ),
        PizzaItem(
            id = 5,
            name = "Tropical",
            desc = "Tomato base, salami & pineapple",
            prize = 39.90,
            image = R.drawable.tropical
        ),
        PizzaItem(
            id = 6,
            name = "FOUR IN ONE (NOTHING BUT NYAMA)",
            desc = "Tomato base, pepperoni, russians, cubed pressed beef & salami",
            prize = 39.90,
            image = R.drawable.four_in_one
        )
    )
}