package com.example.lemondeapp

import android.R.attr.x
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemondeapp.ui.theme.LemondeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemondeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Lemonade(
                        appName = "Lemonade",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemondeAppTheme {
        Lemonade("Lemonade")
    }
}


@Composable
fun Lemonade(appName: String, modifier: Modifier = Modifier) {
    var juiceStep by remember { mutableIntStateOf(0) }
    var juiceLimit by remember { mutableIntStateOf(1) }
    var screenView by remember { mutableIntStateOf(0) }
    var imageDescription : String
    var imageInstruction : String
    var imageResource = R.drawable.lemon_tree

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        when (screenView) {
            0 -> {
                imageResource = R.drawable.lemon_tree
                imageDescription = stringResource(R.string.image_description_1)
                imageInstruction = stringResource(R.string.image_instruction_1)
            }
            1 -> {
                imageResource = R.drawable.lemon_squeeze
                imageDescription = stringResource(R.string.image_description_2)
                imageInstruction = stringResource(R.string.image_instruction_2)
            }
            2 -> {
                imageResource = R.drawable.lemon_drink
                imageDescription = stringResource(R.string.image_description_3)
                imageInstruction = stringResource(R.string.image_instruction_3)
            }
            else -> {
                imageResource = R.drawable.lemon_restart
                imageDescription = stringResource(R.string.image_description_4)
                imageInstruction = stringResource(R.string.image_instruction_4)
            }
        }

        Row (
            modifier = modifier
                .fillMaxWidth()
        ){
            Text(
                text = appName,
                textAlign = TextAlign.Center,
                fontSize = 8.sp,
                modifier = modifier
                    .background(color = colorResource(R.color.brightYellow))
                    .fillMaxWidth()
            )
        }
        Row (
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
                .height(192.dp)
                .fillMaxHeight()
        ){
            Box (
                modifier = modifier
                    .width(192.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(color = colorResource(R.color.imageBackgroundGreen)),
                contentAlignment = Alignment.Center
            ){

                Image(
                    painter = painterResource(imageResource),
                    contentDescription = imageDescription,
                    modifier = modifier
                        .clickable(enabled = true, onClick = {
                            if (screenView != 1) {
                                //++screenView
                                screenView = (++screenView) % 4
                                juiceLimit = (0..4).random()
                            } else {
                                juiceStep = juiceStep + 1
                                if (juiceStep > juiceLimit) {
                                    screenView = (++screenView) % 4
                                    juiceLimit = (0..4).random()
                                    juiceStep = 0
                                }
                            }

                        })
                )
            }
        }
        Spacer(modifier = modifier.height(32.dp))
        Row (
            modifier = modifier
                .fillMaxHeight()
        ){
            Text(
                text = imageInstruction,
                fontSize = 16.sp,
                modifier = modifier
            )
        }
    }
}
