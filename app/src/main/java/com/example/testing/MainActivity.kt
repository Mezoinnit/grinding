@file:OptIn(ExperimentalAnimationApi::class)

package com.example.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testing.ui.theme.TestingTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    ImagePrev()
                    Practice()
                }
            }
        }
    }
}

//@Composable
//fun Imageprev(){
//    val brightness = -12f
//    val colorMatrix = floatArrayOf(
//        1f, 0f, 0f, 0f, brightness,
//        0f, 1f, 0f, 0f, brightness,
//        0f, 0f, 1f, 0f, brightness,
//        0f, 0f, 0f, 1f, 0f
//    )
//    Image(painter = painterResource(id = R.drawable.bae), contentDescription =null,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier
//            .padding(8.dp)
//            .size(375.dp)
//            .clip(shape = RoundedCornerShape(32.dp))
//            .border(
//                width = 2.dp,
//                color = MaterialTheme.colorScheme.background,
//                shape = RoundedCornerShape(32.dp)
//            ),
//        colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
//
//    )
//}


@Composable
fun Practice(){
    var i by remember {
        mutableStateOf(1)
    }
    var blurred by remember {
        mutableStateOf(1)
    }

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(12.dp)) {
        Text(text = "Rizzler", fontWeight = FontWeight.Bold, fontSize = 36.sp, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 75.dp))
        LazyRow{
            items(i){
                AnimatedContent(targetState = blurred, modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),transitionSpec = {
                    fadeIn() + scaleIn() + slideInVertically { -it } + expandIn { it } with fadeOut() + scaleOut() + slideOutHorizontally { -it } + shrinkOut { it }
                },content = {
                    if (blurred == 1)
                        Image(painter = painterResource(id = R.drawable.rizzler), contentDescription =null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(375.dp)
                                .clip(shape = RoundedCornerShape(32.dp))
                                .border(
                                    width = 2.dp,
                                    color = MaterialTheme.colorScheme.background,
                                    shape = RoundedCornerShape(32.dp)
                                )
                                .blur(
                                    radiusX = 15.dp,
                                    radiusY = 15.dp,
                                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                                ),
                            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0.55f) })
                        )
                    else
                        Image(painter = painterResource(id = R.drawable.rizzler), contentDescription =null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(375.dp)
                                .clip(shape = RoundedCornerShape(32.dp))
                                .border(
                                    width = 2.dp,
                                    color = MaterialTheme.colorScheme.background,
                                    shape = RoundedCornerShape(32.dp)
                                ),
                            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(1.2f) })
                        )
                },
                    label = ""
                )


            }
        }
        Button(onClick = { i++ },
            modifier = Modifier
                .padding(16.dp)
                .width(165.dp)
                .height(65.dp)) {
            Text(text = "Rizz: $i")
        }
        Button(onClick = { blurred = -blurred },
            modifier = Modifier
                .padding(8.dp)
                .width(85.dp)
                .height(40.dp)) {
            Text(text = "blur")
        }

    }
}


data class Message(val to: String, val from: String)

@Composable
fun BirthCard(msg: Message) {
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF8700FF),
                Color(0xFFFF9800),
                Color(0xFFFFE600),
                Color(0xFFE700FF),
                Color(0xFF8700FF)
            )
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(48.dp),
    ) {
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier
            .align(
                Alignment.TopStart
            )
            .padding(0.dp, 48.dp, 0.dp, 0.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(200.dp)
                    .border(width = 5.dp, rainbowColorsBrush, shape = CircleShape),
                contentScale = ContentScale.Crop)
            Text(
                text = "Jvnv",
                textAlign = TextAlign.Start,
                fontSize = 32.sp,
                lineHeight = 116.sp,
                modifier = Modifier.padding(16.dp, 48.dp, 0.dp, 0.dp)

            )
        }
//        Text(
//            text = "From: ${msg.from}",
//            modifier = Modifier.align(Alignment.TopStart),
//            textAlign = TextAlign.Start,
//            fontSize = 32.sp
//        )
//        Text(
//            text = "To: ${msg.to}",
//            modifier = Modifier.align(Alignment.BottomEnd),
//            textAlign = TextAlign.End,
//            fontSize = 32.sp
//        )
    }
}

@Composable
fun ImagePrev(){
    val brightness = -40f
    val colorMatrix = floatArrayOf(
        1f, 0f, 0f, 0f, brightness,
        0f, 1f, 0f, 0f, brightness,
        0f, 0f, 1f, 0f, brightness,
        0f, 0f, 0f, 1f, 0f
    )
    Box {
        val image = painterResource(id = R.drawable.ic_launcher_background)
        Image(painter = image, contentDescription = null,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
        modifier = Modifier
            .blur(
                radiusX = 32.dp,
                radiusY = 1.dp,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            )
            .fillMaxSize(), contentScale = ContentScale.Crop)
    }
}

// line added
