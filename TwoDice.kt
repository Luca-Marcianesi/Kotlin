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
    lateinit var immageDice2 : ImageView


    var valueResult : Int = 2


    lateinit var resultView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        immageDice1 = binding.firstDice
        immageDice2 = binding.secondDice
        resultView = binding.textResult
        resultView.text = valueResult.toString()


        }

    fun viewDices(v: View){
        val resultDice1 : Int = dice.roll()
        val resultDice2  : Int = dice.roll()
        resultView.text = (resultDice1 + resultDice2).toString()
        setImmage(resultDice1,immageDice1)
        setImmage(resultDice2,immageDice2)
        
        }

    }

    fun setImmage(result : Int , immageSpace : ImageView){
        when (result){
            1-> changeImmage(R.drawable.dice_1 , immageSpace)
            2-> changeImmage(R.drawable.dice_2 , immageSpace)
            3-> changeImmage(R.drawable.dice_3 , immageSpace)
            4-> changeImmage(R.drawable.dice_4 , immageSpace)
            5-> changeImmage(R.drawable.dice_5 , immageSpace)
            6-> changeImmage(R.drawable.dice_6 , immageSpace)

    }

    }
    fun changeImmage(image: Int, imageSpace: ImageView){
        imageSpace.setImageResource(image)
    }

class Dice (val face: Int){

    fun roll(): Int{
        return (1..this.face).shuffled().first()
    }

}


