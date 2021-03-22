package com.example.testing_comps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testing_comps.ui.theme.TestingcompsTheme

// Box within box to have color sliver on left
@Composable
fun FAQ(answer: Answer) {
    val offset = 5
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color(0xFFFAC705))
    ) {
        Box(
            modifier = Modifier
                .offset(x = offset.dp)
                .background(Color(0xFF12395B))
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .padding(24.dp)
                .offset((-offset).dp)) {
                PopulateFAQ(answer)
            }
        }
    }
}

// Populate text items. Present either title or description combinations based on other passed items
@Composable
fun PopulateFAQ(answer: Answer) {
    val titlePresent = !answer.title.isNullOrEmpty()

    if (titlePresent) {
        AnswerTitle(answer.title!!)
    }
    if (!answer.description.isNullOrEmpty()) {
        if (titlePresent) {
            Spacer(modifier = Modifier.height(16.dp))
        }
        AnswerDescription(answer.description)
    }
    if (!answer.footnote.isNullOrEmpty()) {
        Spacer(modifier = Modifier.height(16.dp))
        AnswerFootnote(footnote = answer.footnote)
    }
}

@Composable
fun AnswerTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.Cyan
        )
    )
}

@Composable
fun AnswerDescription(description: String) {
    Text(
        text = description,
        style = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = Color.White
        )
    )
}

@Composable
fun AnswerFootnote(footnote: String) {
    Text(
        text = footnote,
        style = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 14.sp,
            color = Color.LightGray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TitleOnlyPreview() {
    TestingcompsTheme {
        FAQ(
            Answer("The Best Sugar Cookie Recipe with Sugar Cookie Icing", null, "")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DescriptionOnlyPreview() {
    TestingcompsTheme {
        FAQ(
            Answer(
                "",
                "These soft sugar cookies are the best sugar cookies for your holiday cookie plate! Make a tray with these cookies, Peanut Butter Blossoms, Meringue Cookies, Hot Cocoa Cookies and Chocolate Crinkle Cookies. Throw on some individually wrapped Homemade Caramel Candy and you’ve got the perfect edible gift!",
                ""
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TitleDescriptionFootnotePreview() {
    TestingcompsTheme {
        FAQ(
            Answer(
                "The Best Sugar Cookie Recipe with Sugar Cookie Icing",
                "These soft sugar cookies are the best sugar cookies for your holiday cookie plate! Make a tray with these cookies, Peanut Butter Blossoms, Meringue Cookies, Hot Cocoa Cookies and Chocolate Crinkle Cookies. Throw on some individually wrapped Homemade Caramel Candy and you’ve got the perfect edible gift!",
                "Literally - THE BEST"
            )
        )
    }
}