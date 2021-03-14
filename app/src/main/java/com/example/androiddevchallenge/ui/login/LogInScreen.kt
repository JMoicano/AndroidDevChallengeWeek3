/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(logInAction: () -> Unit = {}) {
    var email = remember { "" }
    var pass = remember { "" }
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.ic_login_bg),
                    contentDescription = null
                )
                Surface(
                    color = MaterialTheme.colors.background.copy(alpha = 0f),
                    contentColor = MaterialTheme.colors.onBackground
                ) {
                    Text(
                        text = "Welcome\nback",
                        style = MaterialTheme.typography.h2,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 40.dp, bottom = 16.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 4.dp),
                        value = email,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = { email = it },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        label = {
                            Text(
                                text = "Email",
                                style = MaterialTheme.typography.body1,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Mail,
                                contentDescription = "Email"
                            )
                        },
                        singleLine = true,
                        colors = textFieldColors(
                            backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0f)
                        ),
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        value = pass,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = { pass = it },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        label = {
                            Text(
                                text = "Password",
                                style = MaterialTheme.typography.body1,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Password,
                                contentDescription = "Password"
                            )
                        },
                        singleLine = true,
                        colors = textFieldColors(
                            backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0f)
                        ),
                    )
                    Button(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .height(48.dp)
                            .fillMaxWidth(),
                        onClick = { logInAction() },
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp
                        ),
                        shape = MaterialTheme.shapes.large,
                    ) {
                        Text(text = "LOG IN")
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewDark() {
    MyTheme(darkTheme = true) {
        LoginScreen() {}
    }
}
@Composable
@Preview(showBackground = true)
fun Preview() {
    MyTheme {
        LoginScreen() {}
    }
}
