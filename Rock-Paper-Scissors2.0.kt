package com.example.applicazionecorso

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.applicazionecorso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var userPoint : Int = 0
    var computerPoint : Int = 0

    lateinit var  totUser : TextView
    lateinit var  totComputer : TextView

    lateinit var  userPlay : TextView
    lateinit var  computerPlay : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        totUser = binding.textPointUser
        totComputer = binding.textPointComputer

        totUser.text = userPoint.toString()
        totComputer.text = computerPoint.toString()

        userPlay = binding.textChoiceUser
        computerPlay = binding.textChoiceComputer

        userPlay.text = "Hai Giocato :"
        computerPlay.text = "Il computer gioca :"

    }

    fun playRock(v : View){
        val gameChoice : Option = Gioco.getGameChoice()
        updateView(Gioco.result(Option.Sasso,gameChoice),Option.Sasso,gameChoice)

    }

    fun playPaper(v : View){
        val gameChoice : Option = Gioco.getGameChoice()
        updateView(Gioco.result(Option.Carta,gameChoice),Option.Carta,gameChoice)

    }

    fun playScissors(v : View){
        val gameChoice : Option = Gioco.getGameChoice()
        updateView(Gioco.result(Option.Forbice,gameChoice),Option.Forbice,gameChoice)

    }

    fun updateView(gameResult : Int, userPlay : Option , computerPlay : Option){
        when(gameResult){
            -1 -> computerPoint += 1
            1 -> userPoint += 1
            0-> {}
        }
        updateScore()
        updatePlay(userPlay,computerPlay)
        updateColor()
    }

    fun updatePlay(userChoice : Option , computerChoice : Option){
        userPlay.text = "Hai Giocato $userChoice"
        computerPlay.text = "Il computer gioca $computerChoice"

    }

    fun updateScore(){
        totUser.text = userPoint.toString()
        totComputer.text = computerPoint.toString()

    }

    fun updateColor(){
        if(computerPoint > userPoint){
            totComputer.setTextColor(Color.GREEN)
            totUser.setTextColor(Color.RED)

        }
        else if(computerPoint < userPoint){
            totComputer.setTextColor(Color.RED)
            totUser.setTextColor(Color.GREEN)

        }
        else {
            totComputer.setTextColor(Color.YELLOW)
            totUser.setTextColor(Color.YELLOW)

        }
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
