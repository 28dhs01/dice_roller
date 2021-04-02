package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // this is our main activity class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // gives a particular reference point(rollButton) for our button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }// this will take us to our rollDice function

        //do a dice Roll when our app starts
        rollDice()
    }

    // this is our rollDice function
    private fun rollDice() {
        val dice = Dice(6) // object for our Dice class is created with assigning numSides to 6
        val diceRoll = dice.roll() // calls roll method of our Dice class
        val diceImage: ImageView = findViewById(R.id.imageView) // creates reference point for our ImageView

        //showing the desired output of diceImage according to our randomNumber which is returned from roll method of our Dice class
        val drawableResource = when(diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->{
                R.drawable.dice_6
            }
        }

        //update the ImageView with correct drawable resource id
        diceImage.setImageResource(drawableResource)
       // diceImage.contentDescription = diceRoll.toString()

    }
}


// Dice class
class Dice(private val numSides: Int) {

    //roll function with Int as a return type
    fun roll(): Int {
        return (1..numSides).random() // returning a random number from 1-numSides
    }
}