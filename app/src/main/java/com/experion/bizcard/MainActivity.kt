package com.experion.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.layout.ModifierLocalPinnableParent
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experion.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember { mutableStateOf((false)) }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally


            ) {
                CreateImageProfile()
                Divider(
                    thickness = 2.dp,

                    )
                CreateInfo()
                Button(
                    onClick = {
                        Log.d("Clicked", "Portfolio button clicked")
                        buttonClickedState.value = !buttonClickedState.value
                    }
                ) {
                    Text(
                        text = "Portfolio",

                        )
                }
                if (buttonClickedState.value) {
                    Content()
                } else {
                    Box() {

                    }
                }

            }


        }
    }
}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "Miles P.",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 24.sp,
        )
        Text(text = "Android Compose Programmer")
        Text(text = "themilesCompose")
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(12.dp)),
            border = BorderStroke(2.dp, color = Color.LightGray)

        ) {
            Portfolio(data = listOf("Project1", "Project2", "Project4", "Project5", "project6"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,


                ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)

                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(Alignment.CenterVertically)


                    )
                    {
                        Text(
                            text = "$item",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "A great project",
                   )
                    }


                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}