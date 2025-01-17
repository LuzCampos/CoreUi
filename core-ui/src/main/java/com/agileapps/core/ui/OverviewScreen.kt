package com.agileapps.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OverviewScreen(
    backgroundColorInside : Int,
    backgroundColorOutside : Int,
    imageCenterContent : Painter = painterResource(id = R.drawable.default_icon),
    title:String,
    description:String,
    leftIcon: Painter = painterResource(id = R.drawable.default_icon),
    rightIcon: Painter = painterResource(id = R.drawable.default_icon),
    onClickNextButton: () -> Unit) {

    val topBottomFade = Brush.verticalGradient(0.6f to Color.Red, 1f to Color.Transparent)

    val largeRadialGradient = object : ShaderBrush() {

        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(Color(backgroundColorInside), Color(backgroundColorOutside)),
                center = size.center,
                radius = biggerDimension / 2f,
                colorStops = listOf(0f, 0.95f)
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
    ){

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 36.dp)
                .padding(bottom = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                modifier = Modifier
                    .size(170.dp),
                alignment = Alignment.Center,
                painter = imageCenterContent,
                contentDescription = "imageScreen" )
            Column(modifier = Modifier.padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = title, color = Color(0xff272822),
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 38.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                if (description.length < 140)
                    TextContent(Modifier.height(120.dp), description)
                else TextContent(
                    Modifier
                        .padding(top = 6.dp)
                        .height(140.dp)
                        .fadingEdge(topBottomFade), description
                )
            }
        }
        //NumberNotification(numberText = numberText, pokeballBackground = )
        CustomButton(
            leftIcon = leftIcon,
            nextIcon = rightIcon,
            onClickNextButton = onClickNextButton
        )
    }
}

@Composable
fun BoxScope.NumberNotification(numberText:String, pokeballBackground : Int){
    Box(modifier = Modifier
        .align(Alignment.TopEnd)
        .size(218.dp)
        .offset(x = 30.dp, y = (-50).dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painterResource(pokeballBackground),
            contentDescription = "numberBackground",
            colorFilter = ColorFilter.tint(color = Color(0xff303943).copy(0.06f))
        )
        Text(
            text ="#$numberText",
            textAlign = TextAlign.Center,
            color = Color(0xff272822).copy(.4f),
            modifier = Modifier
                .align(Alignment.Center),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}

@Composable
fun BoxScope.CustomButton(
    leftIcon:Painter,
    nextIcon : Painter,
    onClickNextButton : () -> Unit
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        .align(Alignment.BottomCenter)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Box() {
                Image(
                    modifier = Modifier
                        .height(80.dp)
                        .padding(start = 6.dp),
                    contentScale = ContentScale.Inside,
                    painter = leftIcon, contentDescription = "" )
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .border(5.dp, Color.White.copy(alpha = 0.18f), CircleShape)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = onClickNextButton,
                    modifier = Modifier
                        .size(80.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = nextIcon,
                        contentDescription = "nextIcon"
                    )
                }
            }
        }
    }
}



@Composable
fun TextContent(modifier: Modifier, content: String) {
    LazyColumn(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start){
        item {
            Box(
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 12.dp),
                    text = content,
                    textAlign = TextAlign.Left,
                    color = Color(0xff242c33),
                    fontSize = 14.sp,
                    lineHeight = 24.sp
                )
            }
        }
    }


}

fun Modifier.fadingEdge(brush: Brush) = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
        drawContent()
        drawRect(brush = brush, blendMode = BlendMode.DstIn)
    }

