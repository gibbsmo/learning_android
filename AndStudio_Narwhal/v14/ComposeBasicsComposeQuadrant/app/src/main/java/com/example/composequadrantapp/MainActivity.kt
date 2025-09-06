package com.example.composequadrantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrantapp.ui.theme.ComposeQuadrantAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InfoScreen(
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun InfoScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(Modifier.weight(1f, fill = false)) {
            InfoPanel(
                stringResource(R.string.info_panel_1_heading),
                stringResource(R.string.info_panel_1_txt),
                colorResource(R.color.info_panel_1),
                modifier = Modifier
                    .weight(1f, false)
                    .background(color = colorResource(R.color.info_panel_1))
            )
            InfoPanel(
                stringResource(R.string.info_panel_2_heading),
                stringResource(R.string.info_panel_2_txt),
                colorResource(R.color.info_panel_2),
                modifier = Modifier
                    .weight(1f, false)
                    .background(color = colorResource(R.color.info_panel_2))
            )
        }
        Row(Modifier.weight(1f, fill = false)) {
            InfoPanel(
                stringResource(R.string.info_panel_3_heading),
                stringResource(R.string.info_panel_3_txt),
                colorResource(R.color.info_panel_3),
                modifier = Modifier
                    .weight(1f, false)
                    .background(color = colorResource(R.color.info_panel_3))
            )
            InfoPanel(
                stringResource(R.string.info_panel_4_heading),
                stringResource(R.string.info_panel_4_txt),
                colorResource(R.color.info_panel_4),
                modifier = Modifier
                    .weight(1f, false)
                    .background(color = colorResource(R.color.info_panel_4))
            )
        }
    }
}

@Composable
private fun InfoPanel(txtHeading: String,
              txtInformation: String,
              cbInfoPanelColor: Color,
              modifier: Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = txtHeading,
            fontWeight = Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(bottom = 16.dp)

        )
        Text (
            text = txtInformation,
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true)
@Composable
fun InfoScreenPreview() {
    ComposeQuadrantAppTheme {
        InfoScreen()
    }
}