package com.example.swipetoreveal_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swipetoreveal_jetpackcompose.ui.theme.Purple200
import com.example.swipetoreveal_jetpackcompose.ui.theme.Purple500
import com.example.swipetoreveal_jetpackcompose.ui.theme.SwipeToRevealjetPackComposeTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeToRevealjetPackComposeTheme {
                SwipeCompose()
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun SwipeCompose() {
    var bgColor by remember {
        mutableStateOf(Purple200)
    }


    val color = animateColorAsState(
        targetValue = bgColor,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    val squareSize = 150.dp
    val swipAbleState = rememberSwipeableState(initialValue = 0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)


    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple500)
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Compose Swipe",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(Color.LightGray)
                .swipeable(
                    state = swipAbleState,
                    anchors = anchors,
                    thresholds = { _, _ ->
                        FractionalThreshold(0.3f)
                    },
                    orientation = Orientation.Horizontal
                )
            ) {
                Column() {
                    
                }
            }
        }
    }


}
















