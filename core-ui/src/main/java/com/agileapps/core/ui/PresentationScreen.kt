package com.agileapps.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PresentationScreen(
    title: String,
    titleColor: Color,
    description:String,
    coverImage:Painter = painterResource(id = R.drawable.default_image),
    textButton: String,
    contentColorButton : Color,
    onClickButton: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        item {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 24.dp,
                            bottomStart = 24.dp,
                            topEnd = 24.dp,
                            bottomEnd = 100.dp
                        )
                    )
                    .fillMaxWidth()
                    .height(
                        390.dp
                    )
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) { Image(
                painter = coverImage,
                contentDescription = "cover image", contentScale = ContentScale.Crop) }
        }
        item {
            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = title,
                        style = TextStyle(
                            color = titleColor,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.W900,
                            textAlign = TextAlign.Center,
                            lineHeight = 50.sp
                        ),
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 50.dp),
                    text = description,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp,
                    color = Color(0xff242c33),
                    fontWeight = FontWeight.Black,
                    fontSize = 14.sp
                )
            }
        }
        item {
            ContinueButton(textButton = textButton, contentColorButton = contentColorButton, onClick = onClickButton)
        }
    }
}

@Composable
fun ContinueButton(textButton: String, contentColorButton : Color,onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(bottom = 2.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = contentColorButton)
    ) { Text(text = textButton,
        fontWeight = FontWeight.Black, color = Color.White) }
}