package com.example.businesscardapp

import android.R.attr.contentDescription
import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        bcName = "M Gibbs, P.Eng",
                        bcTitle = "Embedded Design, Distributed Architecture, Analytics",
                        bcPhoneNumber = "+00 (00) 000 000",
                        bcSocMedia = "https://github.com/mgibbs",
                        bcEmail = "mgibbs@google.com",
                        bcCompanyLogo = painterResource(R.drawable.insights_256dp_8c1af6),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    bcName: String,
    bcTitle: String,
    bcPhoneNumber: String,
    bcSocMedia: String,
    bcEmail: String,
    bcCompanyLogo: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.bcBackground))
    ) {
        BcMainPanel(bcName, bcTitle, bcCompanyLogo, modifier)
        BcContactInfo(
            bcPhoneNumber,
            bcSocMedia,
            bcEmail,
            painterResource(R.drawable.phone_24dp_1f1f1f),
            painterResource(R.drawable.share_24dp_1f1f1f),
            painterResource(R.drawable.email_24dp_1f1f1f)
        )
    }
}

@Composable
fun BcMainPanel(bcmpFullName: String, bcmpJobTitle: String, imagePainter: Painter, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 224.dp, bottom = 128.dp)
    ) {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = "$bcmpFullName",
            modifier = modifier
        )
        Text(
            text = "$bcmpJobTitle",
            fontSize = 10.sp,
            modifier = modifier
        )
    }
}

@Composable
fun BcContactInfoRow(bccirInfo: String, bccirImagePainter: Painter, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = bccirImagePainter, contentDescription = null)
        Text(
            text = "$bccirInfo",
            fontSize = 9.sp,
            modifier = modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun BcContactInfo(
    bcciPhoneNum: String,
    bcciSocialMediaHandler: String,
    bcciEmail: String,
    bcciImage1: Painter,
    bcciImage2: Painter,
    bcciImage3: Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(top = 16.dp, bottom = 32.dp)) {
        BcContactInfoRow("$bcciPhoneNum", bcciImage1, modifier)
        BcContactInfoRow("$bcciSocialMediaHandler", bcciImage2, modifier)
        BcContactInfoRow("$bcciEmail", bcciImage3, modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard(
            "M Gibbs, P.Eng",
            "Embedded Design, Distributed Architecture, Analytics",
            "+00 (00) 000 000",
            "https://github.com/mgibbs",
            "mgibbs@google.com",
            bcCompanyLogo = painterResource(R.drawable.insights_256dp_8c1af6),
        )
    }
}