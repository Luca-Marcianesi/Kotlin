package com.example.applicazionecorso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.applicazionecorso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var dice = Dice(6)

    lateinit var immageDice1 : ImageView


    var valueResult : Int = 1


    lateinit var resultView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        immageDice1 = binding.firstDice
        resultView = binding.textResult
        resultView.text = valueResult.toString()
        }

    fun viewDice1(v: View){
        valueResult = dice.roll()
        resultView.text = valueResult.toString()
        when (valueResult){
            1-> immageDice1.setImageResource(R.drawable.dice_1)
            2-> immageDice1.setImageResource(R.drawable.dice_2)
            3-> immageDice1.setImageResource(R.drawable.dice_3)
            4-> immageDice1.setImageResource(R.drawable.dice_4)
            5-> immageDice1.setImageResource(R.drawable.dice_5)
            6-> immageDice1.setImageResource(R.drawable.dice_6)
        }

    }
    
    }


class Dice (val face: Int){

    fun roll(): Int{
        return (1..this.face).shuffled().first()
    }

}
