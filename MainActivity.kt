package com.example.proid_studio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proid_studio.ui.theme.ProID_StudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProID_StudioTheme {
                EntryPage()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun EntryPage() {

    val context = LocalContext.current

    //Colors
    val Primary = Color(0xFF04675B)
    val Secondary = Color(0xFF09758A)

    //Default Font
    val SegoeUI = FontFamily(
        Font(R.font.segoeui, FontWeight.Normal),
        Font(R.font.segoeuib, FontWeight.Bold),
    )

    /* -------- Main Section -------- */
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(300.dp))

            /* -------- Top Section -------- */
            /* -------- Company Logo -------- */
            Image(
                    painter = painterResource(id = R.drawable.colorlogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                )
            /* -------- Company Name -------- */
            Text(
                    text = "ProID Studio",
                    color = Primary,
                    fontFamily = SegoeUI,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Professional ID Card Generation App",
                color = Primary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Business | Education | Event",
                color = Color.Gray,
                fontFamily = SegoeUI,
                fontSize = 16.sp
            )

            /* -------- Bottom Section -------- */
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {

                Button(
                    onClick = {
                        val intent = Intent(context, LoginActivity::class.java)
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 80.dp, vertical = 20.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Get Started",
                        fontFamily = SegoeUI,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
                /* -------- Bottom Description -------- */
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "ProID Studio is a modern application for designing professional ID cards",
                    color = Color.Gray,
                    fontFamily = SegoeUI,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 15.dp)
                )
            }
        }
    }
    /* -------- Top Gradient -------- */
    Image(
        painter = painterResource(id = R.drawable.bottom_img),
        contentDescription = "Top Gradient",
        modifier = Modifier
            .fillMaxSize(),
        alignment = Alignment.TopCenter
    )
}