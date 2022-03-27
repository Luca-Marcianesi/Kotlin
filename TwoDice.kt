package com.example.applicazionecorso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.applicazionecorso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var dice = Dice(6)

    lateinit var imageDice1 : ImageView
    lateinit var imageDice2 : ImageView


    var valueResult : Int = 2


    lateinit var resultView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        imageDice1 = binding.firstDice
        imageDice2 = binding.secondDice
        resultView = binding.textResult
        resultView.text = valueResult.toString()


        }

    fun viewDices(v: View){
        val resultDice1 : Int = dice.roll()
        val resultDice2  : Int = dice.roll()
        resultView.text = (resultDice1 + resultDice2).toString()
        setImage(resultDice1,imageDice1)
        setImage(resultDice2,imageDice2)

        }

    }

    fun setImage(result : Int , imageSpace : ImageView){
        when (result){
            1-> changeImmage(R.drawable.dice_1 , imageSpace)
            2-> changeImmage(R.drawable.dice_2 , imageSpace)
            3-> changeImmage(R.drawable.dice_3 , imageSpace)
            4-> changeImmage(R.drawable.dice_4 , imageSpace)
            5-> changeImmage(R.drawable.dice_5 , imageSpace)
            6-> changeImmage(R.drawable.dice_6 , imageSpace)

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


