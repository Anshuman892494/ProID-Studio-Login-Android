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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.proid_studio.ui.theme.ProID_StudioTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProID_StudioTheme {
                SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {

    val context = LocalContext.current

    // Form State
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var acceptTerms by remember { mutableStateOf(false) }

    val Primary = Color(0xFF04675B)

    val SegoeUI = FontFamily(
        Font(R.font.segoeui, FontWeight.Normal),
        Font(R.font.segoeuib, FontWeight.Bold)
    )

    fun validateInput(): Boolean {
        return when {
            name.isBlank() -> {
                Toast.makeText(context, "Name is required", Toast.LENGTH_SHORT).show()
                false
            }
            email.isBlank() -> {
                Toast.makeText(context, "Email is required", Toast.LENGTH_SHORT).show()
                false
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                Toast.makeText(context, "Enter valid email", Toast.LENGTH_SHORT).show()
                false
            }
            phone.isBlank() -> {
                Toast.makeText(context, "Phone number is required", Toast.LENGTH_SHORT).show()
                false
            }
            phone.length != 10 -> {
                Toast.makeText(context, "Enter valid 10-digit phone number", Toast.LENGTH_SHORT).show()
                false
            }
            password.isBlank() -> {
                Toast.makeText(context, "Password is required", Toast.LENGTH_SHORT).show()
                false
            }
            password.length < 6 -> {
                Toast.makeText(context, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                false
            }
            confirmPassword != password -> {
                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                false
            }
            gender.isBlank() -> {
                Toast.makeText(context, "Please select your gender", Toast.LENGTH_SHORT).show()
                false
            }
            !acceptTerms -> {
                Toast.makeText(context, "You must accept the terms & conditions", Toast.LENGTH_SHORT).show()
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

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "Sign Up",
                fontFamily = SegoeUI,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Create your account",
                fontFamily = SegoeUI,
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {

                // Full Name
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Full Name") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email Address") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Phone
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone Number") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Password
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Confirm Password
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirm Password") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Gender Radio Buttons
                Text(text = "Gender", fontFamily = SegoeUI, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    listOf("Male", "Female", "Other").forEach { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.selectable(
                                selected = gender == option,
                                onClick = { gender = option },
                                role = Role.RadioButton
                            )
                        ) {
                            RadioButton(
                                selected = gender == option,
                                onClick = { gender = option },
                                colors = RadioButtonDefaults.colors(selectedColor = Primary)
                            )
                            Text(text = option, fontFamily = SegoeUI)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                // Terms & Conditions Checkbox
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { acceptTerms = !acceptTerms }
                ) {
                    Checkbox(
                        checked = acceptTerms,
                        onCheckedChange = { acceptTerms = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary)
                    )
                    Text(text = "I accept Terms & Conditions", fontFamily = SegoeUI)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Sign Up Button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
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
                        text = "Sign Up",
                        fontFamily = SegoeUI,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                // Login Link
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Already have an account?", fontFamily = SegoeUI, color = Color.Gray)
                    Text(
                        text = " Login",
                        fontFamily = SegoeUI,
                        fontWeight = FontWeight.Bold,
                        color = Primary,
                        modifier = Modifier.clickable {
                            context.startActivity(Intent(context, LoginActivity::class.java))
                        }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
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
