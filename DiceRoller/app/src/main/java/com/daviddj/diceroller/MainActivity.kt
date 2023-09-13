package com.daviddj.diceroller

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daviddj.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                DiceRollerApp()
                }
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRollerTheme {
        Greeting("Android")
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    var result2 by remember { mutableStateOf(1) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = getDiceImageResource(result)), contentDescription = result.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(id = getDiceImageResource(result2)), contentDescription = result2.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                result = getRandomDiceImage()
                result2 = getRandomDiceImage()
            }
        ) {
            Text(stringResource(com.daviddj.diceroller.R.string.roll))
        }
    }
}

@Preview
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

private fun getRandomDiceImage() : Int {
    return (1..6).random()
}

private fun getDiceImageResource(result: Int): Int {
    return when (result) {
        1 -> com.daviddj.diceroller.R.drawable.dice_1
        2 -> com.daviddj.diceroller.R.drawable.dice_2
        3 -> com.daviddj.diceroller.R.drawable.dice_3
        4 -> com.daviddj.diceroller.R.drawable.dice_4
        5 -> com.daviddj.diceroller.R.drawable.dice_5
        else -> com.daviddj.diceroller.R.drawable.dice_6
    }
}