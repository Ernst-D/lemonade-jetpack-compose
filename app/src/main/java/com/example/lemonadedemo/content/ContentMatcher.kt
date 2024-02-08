package com.example.lemonadedemo.content

import com.example.lemonadedemo.R

internal class LemonadeBoxContent(val image: Int, val contentDesc: Int, val textContent: Int)

internal val getLemonadeContent: (screenNumber: Int) -> LemonadeBoxContent = {
    when (it) {
        0 -> LemonadeBoxContent(
            R.drawable.lemon_tree,
            R.string.lemon_tree_content_desc,
            R.string.lemon_tree_content_desc,
        )

        1 -> LemonadeBoxContent(
            R.drawable.lemon_squeeze,
            R.string.keep_tapping_content_desc,
            R.string.keep_tapping_text
        )

        2 -> LemonadeBoxContent(
            R.drawable.lemon_drink,
            R.string.lemonade_to_drink_content_desc,
            R.string.lemonade_to_drink_text
        )

        3 -> LemonadeBoxContent(
            R.drawable.lemon_restart,
            R.string.empty_glass_to_drink_content_desc,
            R.string.empty_glass_to_drink_text
        )

        else -> LemonadeBoxContent(
            R.drawable.lemon_tree,
            R.string.lemon_tree_content_desc,
            R.string.lemon_tree_content_desc
        )
    }
}
