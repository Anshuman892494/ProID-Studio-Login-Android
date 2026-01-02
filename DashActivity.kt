package com.example.proid_studio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proid_studio.ui.theme.ProID_StudioTheme

class DashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val email = intent.getStringExtra("EMAIL") ?: ""
        val password = intent.getStringExtra("PASSWORD") ?: ""

        setContent {
            ProID_StudioTheme {
                DashboardScreen(email)
            }
        }
    }
}
@Composable
fun DashboardScreen(email: String) {

    val Primary = Color(0xFF04675B)

    val SegoeUI = FontFamily(
        Font(R.font.segoeui, FontWeight.Normal),
        Font(R.font.segoeuib, FontWeight.Bold)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
                .background(Color.White)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "Dashboard",
                fontFamily = SegoeUI,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Welcome to ProID Studio",
                fontFamily = SegoeUI,
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(60.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F7F7)),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    Text(
                        text = "Logged in as",
                        fontFamily = SegoeUI,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = email,
                        fontFamily = SegoeUI,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                onClick = {
                    /* Future action */
                }
            ) {
                Text(
                    text = "Continue",
                    fontFamily = SegoeUI,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
