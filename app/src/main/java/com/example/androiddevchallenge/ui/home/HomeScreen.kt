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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top,
            ) {
                Box(
                    modifier = Modifier.height(64.dp),
                    contentAlignment = Alignment.BottomCenter,
                ) {
                    Text(
                        text = "ACCOUNT",
                        style = MaterialTheme.typography.button
                    )
                }
                Box(
                    modifier = Modifier.height(64.dp),
                    contentAlignment = Alignment.BottomCenter,
                ) {
                    Text(
                        text = "WATCHLIST",
                        style = MaterialTheme.typography.button.copy(
                            color = LocalContentColor.current.copy(alpha = .4f)
                        ),
                    )
                }
                Box(
                    modifier = Modifier.height(64.dp),
                    contentAlignment = Alignment.BottomCenter,
                ) {
                    Text(
                        text = "PROFILE",
                        style = MaterialTheme.typography.button.copy(
                            color = LocalContentColor.current.copy(alpha = .4f)
                        ),
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .height(32.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "Balance",
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Box(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .height(48.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "$73,589.01",
                    style = MaterialTheme.typography.h1
                )
            }
            Box(
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .height(16.dp)
            ) {
                Text(
                    text = "+412.35 today",
                    style = MaterialTheme.typography.subtitle1.copy(color = green)
                )
            }
            Button(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .padding(horizontal = 16.dp)
                    .height(48.dp)
                    .fillMaxWidth(),
                onClick = { },
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                ),
                shape = MaterialTheme.shapes.large,
            ) {
                Text(text = "TRANSACT")
            }
            val names = listOf(
                Pair("Week", true),
                Pair("ETFs", false),
                Pair("Stocks", false),
                Pair("Funds", false),
                Pair("", false)
            )
            LazyRow(
                modifier = Modifier.padding(start = 4.dp)
            ) {
                items(items = names) { item ->
                    ListItem(text = item.first, dropDown = item.second)
                }
            }
        }
    }
}

@Composable
fun ListItem(text: String, dropDown: Boolean = false) {
    Button(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .height(48.dp),
        onClick = { },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground.copy(alpha = 1f)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.background
        ),
        shape = MaterialTheme.shapes.large,
        enabled = false
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground.copy(alpha = 1f)
        )
        if (dropDown) {
            Icon(
                imageVector = Icons.Default.ExpandMore,
                contentDescription = "Dropdown",
                tint = MaterialTheme.colors.onBackground.copy(alpha = 1f)
            )
        }
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 640)
fun Preview() {
    MyTheme {
        HomeScreen()
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 640)
fun PreviewDark() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}
