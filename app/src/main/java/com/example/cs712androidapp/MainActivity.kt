package com.example.cs712androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cs712androidapp.ui.theme.CS712AndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS712AndroidAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = androidx.compose.ui.platform.LocalContext.current
    androidx.compose.foundation.layout.Column(modifier = modifier) {

        Text(
            text = "Lisa Johnson\nStudent ID: 8010492"
        )

        androidx.compose.material3.Button(onClick = {
            val intent = android.content.Intent(context, SecondActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("Start Activity Explicitly")
        }

        androidx.compose.material3.Button(onClick = {
            val intent = android.content.Intent("com.example.cs712androidapp.OPEN_SECOND")
            context.startActivity(intent)
        }) {
            Text("Start Activity Implicitly")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CS712AndroidAppTheme {
        Greeting("Android")
    }
}