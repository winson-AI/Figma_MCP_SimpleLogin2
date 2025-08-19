package com.example.simplelogin2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import simplelogin2.composeapp.generated.resources.Res
import simplelogin2.composeapp.generated.resources.*

@Composable
@Preview
fun App() {
    MaterialTheme {
        LoginScreen()
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    // Colors derived from Figma
    val backgroundPrimary = Color(0xFFF5CB58) // Frame background
    val contentBackground = Color(0xFFF5F5F5) // Inner card background
    val fieldBackground = Color(0xFFF3E9B5)
    val accentColor = Color(0xFFE95322)
    val headlineTextColor = Color(0xFFF8F8F8)
    val primaryTextColor = Color(0xFF391713)
    val secondaryTextColor = Color(0xFF252525)
    val socialContainerColor = Color(0xFFFFDECF)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundPrimary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            // Figma Frame 3 (Status bar)
            TopStatusBar(
                backgroundColor = backgroundPrimary,
                timeTextColor = primaryTextColor
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Top bar/log in title
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(Res.drawable.back_arrow_icon),
                    contentDescription = "Back",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(width = 8.dp, height = 13.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Log In",
                    color = headlineTextColor,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Inner content container
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = contentBackground, shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 16.dp, vertical = 24.dp)
            ) {
                Text(
                    text = "Welcome",
                    color = primaryTextColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    color = secondaryTextColor,
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Normal
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Email or Mobile Number",
                    color = primaryTextColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Email field styled per Figma
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = fieldBackground, shape = RoundedCornerShape(13.dp))
                        .padding(horizontal = 14.dp)
                ) {
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text("example@example.com", color = primaryTextColor, fontSize = 20.sp) },
                        textStyle = TextStyle(color = primaryTextColor, fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 45.dp),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            textColor = primaryTextColor,
                            cursorColor = primaryTextColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Password ",
                    color = primaryTextColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = fieldBackground, shape = RoundedCornerShape(13.dp))
                        .padding(horizontal = 14.dp)
                ) {
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("*************", color = primaryTextColor, fontSize = 20.sp) },
                        textStyle = TextStyle(color = primaryTextColor, fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 45.dp),
                        singleLine = true,
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            Icon(
                                painter = painterResource(Res.drawable.show_off_icon),
                                contentDescription = "Toggle password visibility",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(width = 16.5.dp, height = 13.75.dp)
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            textColor = primaryTextColor,
                            cursorColor = primaryTextColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "forget password",
                    color = accentColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.End)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Centered fixed-size button per Figma
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = { /* Handle login */ },
                        modifier = Modifier
                            .height(45.dp)
                            .width(207.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = accentColor)
                    ) {
                        Text("Log In", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Medium)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "or sign up with",
                        color = secondaryTextColor,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.13.dp)
                            .background(color = socialContainerColor, shape = RoundedCornerShape(13.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.google_icon),
                            contentDescription = "Google",
                            modifier = Modifier.size(18.38.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(34.13.dp)
                            .background(color = socialContainerColor, shape = RoundedCornerShape(13.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.facebook_icon),
                            contentDescription = "Facebook",
                            modifier = Modifier.size(22.39.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(34.13.dp)
                            .background(color = socialContainerColor, shape = RoundedCornerShape(13.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.fingerprint_icon),
                            contentDescription = "Fingerprint",
                            modifier = Modifier.size(23.63.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don’t have an account? Sign Up",
                        color = secondaryTextColor,
                        fontSize = 14.sp
                    )
                }
            }

            // Figma Frame 56 (Bottom bar)
            Spacer(modifier = Modifier.height(16.dp))
            BottomBar(backgroundColor = accentColor)
        }
    }
}

@Composable
private fun TopStatusBar(
    backgroundColor: Color,
    timeTextColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(backgroundColor)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "16:04",
            color = timeTextColor,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(Res.drawable.status_icons),
            contentDescription = "Status icons",
            modifier = Modifier.size(width = 17.dp, height = 9.dp)
        )
    }
}

@Composable
private fun BottomBar(
    backgroundColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Res.drawable.footer_icon_1),
                contentDescription = "Footer 1",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                painter = painterResource(Res.drawable.footer_icon_2),
                contentDescription = "Footer 2",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                painter = painterResource(Res.drawable.footer_icon_3),
                contentDescription = "Footer 3",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                painter = painterResource(Res.drawable.footer_icon_4),
                contentDescription = "Footer 4",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                painter = painterResource(Res.drawable.footer_icon_5),
                contentDescription = "Footer 5",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}