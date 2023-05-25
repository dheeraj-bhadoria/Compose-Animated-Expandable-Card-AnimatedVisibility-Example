package com.dheeraj.expandablecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dheeraj.expandablecard.ui.theme.ExpandableCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Column() {
        CreditCardInfoCard()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExpandableCardTheme {
        App()
    }
}


data class CreditCardInfo(
    val cardNumber: String,
    val customerName: String,
    val cvv: String,
    val expiry: String,
    val cardType: String
)

@Composable
fun CreditCardInfoCard() {
    val expanded = remember { mutableStateOf(false) }
    val cardInfo = CreditCardInfo(
        cardNumber = "**** **** **** 1234",
        customerName = "John Doe",
        cvv = "123",
        expiry = "12/24",
        cardType = "Visa"
    )

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.Gray), // Set the desired background color here
    ) {
        Column(
            modifier = Modifier
                .clickable { expanded.value = !expanded.value }
                .padding(16.dp)
        ) {
            Text(text = "Card Number: ${cardInfo.cardNumber}")
            AnimatedVisibility(
                visible = expanded.value,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 8.dp)
                ) {
                    Text(text = "Customer Name: ${cardInfo.customerName}")
                    Text(text = "CVV: ${cardInfo.cvv}")
                    Text(text = "Expiry: ${cardInfo.expiry}")
                    Text(text = "Type of Card: ${cardInfo.cardType}")
                }
            }
        }
    }
}