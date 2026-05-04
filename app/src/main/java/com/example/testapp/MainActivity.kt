package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceRollerApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DiceRollerApp(modifier: Modifier = Modifier) {
    var dice1 by remember { mutableIntStateOf(1) }
    var dice2 by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            DieFace(value = dice1)
            Spacer(modifier = Modifier.width(16.dp))
            DieFace(value = dice2)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            dice1 = (1..6).random()
            dice2 = (1..6).random()
        }) {
            Text(text = "Roll Dice", fontSize = 24.sp)
        }
    }
}

@Composable
fun DieFace(value: Int) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .border(2.dp, Color.Black, shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            val dotRadius = size.width / 10f
            val spacing = size.width / 4f

            // Dot positions relative to center
            val positions = when (value) {
                1 -> listOf(Offset(center.x, center.y))
                2 -> listOf(
                    Offset(center.x - spacing, center.y - spacing),
                    Offset(center.x + spacing, center.y + spacing)
                )
                3 -> listOf(
                    Offset(center.x - spacing, center.y - spacing),
                    Offset(center.x, center.y),
                    Offset(center.x + spacing, center.y + spacing)
                )
                4 -> listOf(
                    Offset(center.x - spacing, center.y - spacing),
                    Offset(center.x + spacing, center.y - spacing),
                    Offset(center.x - spacing, center.y + spacing),
                    Offset(center.x + spacing, center.y + spacing)
                )
                5 -> listOf(
                    Offset(center.x - spacing, center.y - spacing),
                    Offset(center.x + spacing, center.y - spacing),
                    Offset(center.x, center.y),
                    Offset(center.x - spacing, center.y + spacing),
                    Offset(center.x + spacing, center.y + spacing)
                )
                6 -> listOf(
                    Offset(center.x - spacing, center.y - spacing),
                    Offset(center.x + spacing, center.y - spacing),
                    Offset(center.x - spacing, center.y),
                    Offset(center.x + spacing, center.y),
                    Offset(center.x - spacing, center.y + spacing),
                    Offset(center.x + spacing, center.y + spacing)
                )
                else -> emptyList()
            }

            positions.forEach { offset ->
                drawCircle(color = Color.Black, radius = dotRadius, center = offset)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview() {
    TestAppTheme {
        DiceRollerApp()
    }
}