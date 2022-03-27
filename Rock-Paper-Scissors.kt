package com.example.applicazionecorso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.applicazionecorso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var imageUser : ImageView
    lateinit var imageComputer : ImageView
    lateinit var result : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        imageUser = binding.imageUser
        imageComputer = binding.imageComputer
        result = binding.textResult
        result.text = "GIOCA"




    }
    fun playRock(v : View){
        val gameChoice : Option = Gioco.getGameChoice()
        changeImmage(R.drawable.sasso,imageUser)
        changeImmage(getComputerImage(gameChoice),imageComputer)
        printResult(Gioco.result(Option.Sasso,gameChoice))


    }

    fun playPaper(v : View){
        val gameChoice : Option = Gioco.getGameChoice()
        changeImmage(R.drawable.carta,imageUser)
        changeImmage(getComputerImage(gameChoice),imageComputer)
        printResult(Gioco.result(Option.Carta,gameChoice))


    }

    fun playScissors(v : View){
        val gameChoice : Option = Gioco.getGameChoice()
        changeImmage(R.drawable.forbice,imageUser)
        changeImmage(getComputerImage(gameChoice),imageComputer)
        printResult(Gioco.result(Option.Forbice,gameChoice))

    }

    fun printResult(gameResult : Int){
        when(gameResult){
            -1-> result.text = "YOU LOSE"
            0-> result.text = "DRAW"
            1-> result.text = "YOU WIN"
        }
    }


        fun getComputerImage(computerChoice : Option): Int{
        when(computerChoice){
            Option.Carta -> return R.drawable.carta
            Option.Forbice -> return  R.drawable.forbice
            Option.Sasso -> return  R.drawable.sasso
        }

    }
    fun changeImmage(image: Int, imageSpace: ImageView){
        imageSpace.setImageResource(image)
    }




    enum class Option{Sasso , Carta , Forbice }

    object Gioco{
        val a = Triple(Option.Sasso, Option.Carta,  -1)
        val b = Triple(Option.Sasso, Option.Forbice,    1)
        val c = Triple(Option.Sasso, Option.Sasso,  0)
        val d = Triple(Option.Carta, Option.Carta, 0)
        val e = Triple(Option.Carta, Option.Forbice, -1)
        val f = Triple(Option.Carta, Option.Sasso, 1)
        val g = Triple(Option.Forbice, Option.Carta, 1)
        val h = Triple(Option.Forbice, Option.Forbice, 0)
        val i = Triple(Option.Forbice, Option.Sasso, -1)

        val  regole = mutableListOf(a,b,c,d,e,f,g,h,i)

        fun getGameChoice(): Option{
            return Option.values().toList().shuffled().first()
        }

        fun result(a : Option , b: Option): Int{
            for(element in regole){
                if(element.first.equals(a)  and element.second.equals(b) ) return element.third
            }
            return 100
        }

    }


}


