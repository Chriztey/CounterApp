package com.chris.counterapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chris.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CounterViewModel by viewModels()
            CounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp(viewModel)
                }
            }


        }
    }
}


@Composable
fun CounterApp(viewModel: CounterViewModel) {


    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Count : ${viewModel.count.value}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            )
        Spacer(modifier = Modifier.height(24.dp))
        Row (
            //modifier = Modifier.fillMaxSize(),
            //horizontalArrangement = Arrangement.Center,
        ) {
            IconButton(onClick = { viewModel.increment() }) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.KeyboardArrowUp,
                    contentDescription = "Increase"
                )
            }
            IconButton(onClick = { viewModel.decrement() }) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Decrease"
                )
            }
        }
    }
}