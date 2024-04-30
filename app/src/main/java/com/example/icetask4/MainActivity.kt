package com.example.icetask4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.time.times

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterButton : Button = findViewById(R.id.enterButton)
        val discountText : TextView = findViewById(R.id.discountText)
        val inputText : TextView = findViewById(R.id.inputText)

        enterButton.setOnClickListener {
            val input = inputText.text.toString().toIntOrNull()
            val discountRates = arrayOf(0.05, 0.1, 0.15, 0.2) //discount for items bought
            val quantities = arrayOf(input?: 0, 3, 1)
            val items = arrayOf(10, 20, 30, 40)//the amount of items bought


            val total = items.zip(quantities).sumOf { (item, quantity) ->
                if (quantity != null) {
                    item * quantity
                }
            }
            val discount = when {
                input!! >= 10 -> discountRates[3]
                input >= 5 -> discountRates[2]
                input >= 3 -> discountRates[1]
                else -> discountRates[0]
            }
            val discountedTotal = total * (1 - discount)

            discountText.text = "Total amount before discount: $$total\n" +
                    "Discount applied: ${(discount * 100)}%\n" +
                    "Total amount after discount: $$discountedTotal"
        }
    }
}
