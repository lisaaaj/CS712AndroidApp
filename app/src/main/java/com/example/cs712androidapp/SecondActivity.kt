package com.example.cs712androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen()
        }
    }
}

@Composable
fun SecondScreen() {
    val context = LocalContext.current

    Column {
        Text("Mobile Software Engineering Challenges:")

        Text("• Device fragmentation")
        Text("• Battery optimization")
        Text("• Security vulnerabilities")
        Text("• Performance optimization")
        Text("• Backward compatibility")

        Button(onClick = {
            (context as? ComponentActivity)?.finish()
        }) {
            Text("Main Activity")
        }
    }
}
