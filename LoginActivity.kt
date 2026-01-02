package com.example.proid_studio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proid_studio.ui.theme.ProID_StudioTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProID_StudioTheme {
                LoginScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreen() {

    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val Primary = Color(0xFF04675B)

    val SegoeUI = FontFamily(
        Font(R.font.segoeui, FontWeight.Normal),
        Font(R.font.segoeuib, FontWeight.Bold)
    )

    // Validation with email format & strong password rules
    fun validateInput(): Boolean {

        // Email must contain @ and .
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        // Password min 6 chars, 1 uppercase, 1 lowercase, 1 number, 1 special char
        val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{6,}$")

        return when {
            email.isBlank() -> {
                Toast.makeText(context, "Email is required", Toast.LENGTH_SHORT).show()
                false
            }
            !email.matches(emailPattern.toRegex()) -> {
                Toast.makeText(context, "Enter valid email (must contain @ and .)", Toast.LENGTH_SHORT).show()
                false
            }
            password.isBlank() -> {
                Toast.makeText(context, "Password is required", Toast.LENGTH_SHORT).show()
                false
            }
            !password.matches(passwordPattern) -> {
                Toast.makeText(
                    context,
                    "Password must be at least 6 characters with uppercase, lowercase, number & special char",
                    Toast.LENGTH_LONG
                ).show()
                false
            }
            else -> true
        }
    }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(180.dp))

            // Company Logo
            Image(
                painter = painterResource(id = R.drawable.colorlogo),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )

            Text(
                text = "ProID Studio",
                fontFamily = SegoeUI,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Primary
            )

            Text(
                text = "Welcome Back!",
                fontFamily = SegoeUI,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Primary
            )

            Spacer(modifier = Modifier.height(80.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {

                // Email Field with Envelope Icon
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Email Address") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Icon") }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Password Field with Lock Icon
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Password") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon") }
                )

                Spacer(modifier = Modifier.height(40.dp))

                // Login Button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Primary),
                    onClick = {
                        if (validateInput()) {
                            val intent = Intent(context, DashActivity::class.java)
                            intent.putExtra("EMAIL", email)
                            intent.putExtra("PASSWORD", password)
                            context.startActivity(intent)
                        }
                    }
                ) {
                    Text(
                        text = "Login",
                        fontFamily = SegoeUI,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Sign Up Link
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don't have an account?",
                    fontFamily = SegoeUI,
                    color = Color.Gray
                )
                Text(
                    text = " Sign Up",
                    fontFamily = SegoeUI,
                    fontWeight = FontWeight.Bold,
                    color = Primary,
                    modifier = Modifier.clickable {
                        context.startActivity(
                            Intent(context, SignUpActivity::class.java)
                        )
                    }
                )
            }
        }
    }

    // Optional: Background image at top/bottom
    Image(
        painter = painterResource(id = R.drawable.bottom_img),
        contentDescription = "Top Gradient",
        modifier = Modifier.fillMaxSize(),
        alignment = Alignment.TopCenter
    )
}
