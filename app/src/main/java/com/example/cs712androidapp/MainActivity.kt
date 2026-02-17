package com.example.cs712androidapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.cs712androidapp.ui.theme.CS712AndroidAppTheme
import androidx.core.content.ContextCompat
class MainActivity : ComponentActivity() {
    private var myReceiver: MyBroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        myReceiver = MyBroadcastReceiver()
        val filter = IntentFilter("com.example.MY_ACTION")

        ContextCompat.registerReceiver(
            this,
            myReceiver,
            filter,
            ContextCompat.RECEIVER_NOT_EXPORTED
        )

        setContent {
            CS712AndroidAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()

        myReceiver?.let {
            unregisterReceiver(it)
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier) {

        Text(
            text = "Lisa Johnson\nStudent ID: 8010492"
        )

        // Explicit Intent
        Button(onClick = {
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("Start Activity Explicitly")
        }

        // Implicit Intent
        Button(onClick = {
            val intent = Intent("com.example.cs712androidapp.OPEN_SECOND")
            context.startActivity(intent)
        }) {
            Text("Start Activity Implicitly")
        }

        // Start Foreground Service
        Button(onClick = {
            val intent = Intent(context, MyForegroundService::class.java)
            context.startService(intent)
        }) {
            Text("Start Service")
        }

        // Send Custom Broadcast
        Button(onClick = {
            val intent = Intent("com.example.MY_ACTION")
            intent.setPackage(context.packageName)
            context.sendBroadcast(intent)
            context.sendBroadcast(intent)
        }) {
            Text("Send Broadcast")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CS712AndroidAppTheme {
        Greeting()
    }
}
