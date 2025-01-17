package com.agileapps.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OverviewAltScreen(
    title: String,
    description: String,
    backgroundColor : Int,
    titleAffinityLevel : String,
    affinityLevel : String,
    textButton : String,
    contentColorButton : Color,
    imageCenterScreen : Painter = painterResource(id = R.drawable.default_image),
    onClickButton : () -> Unit
) {

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color(backgroundColor))
        .padding(vertical = 30.dp, horizontal = 34.dp)
        .padding(bottom = 24.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        item {
            Column(modifier = Modifier, verticalArrangement = Arrangement.Top) {
                TextsScreen(title, description)
                ImgBox(modifier = Modifier.fillMaxWidth(),
                    backgroundResourceId = imageCenterScreen)
                AffinityRateTexts(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    titleAffinityLevel,
                    affinityLevel)
            }
        }
        item {
            ContinueButton(
                textButton = textButton,
                contentColorButton = contentColorButton,
                onClick = onClickButton)
        }
    }
}

@Composable
fun ImgBox(modifier: Modifier, backgroundResourceId : Painter) {
    Box(modifier = modifier.height(IntrinsicSize.Min)) {
        Box(modifier = Modifier
            .size(300.dp, 300.dp)
            .align(Alignment.BottomCenter),) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 30.dp),
                painter = backgroundResourceId,
                alignment = Alignment.BottomCenter,
                contentDescription = "backgroundResourceId"
            )
        }

    }
}

@Composable
fun AffinityRateTexts(modifier: Modifier, titleAffinityLevel:String,affinityLevel : String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = titleAffinityLevel, fontSize = 16.sp,color = Color.Black)
        Text(text = "$affinityLevel%", fontSize = 46.sp,color = Color.Black)
    }
}

@Composable
fun TextsScreen(title : String, description : String) {
    Column(modifier = Modifier
        .height(IntrinsicSize.Min)
        .padding(vertical = 30.dp),
        verticalArrangement = Arrangement.Top)
    {
        Text(text = title, fontSize = 32.sp,color = Color.Black, lineHeight = 36.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(modifier = Modifier, text = description, textAlign = TextAlign.Start, color = Color.Black, fontSize = 16.sp)
    }
}