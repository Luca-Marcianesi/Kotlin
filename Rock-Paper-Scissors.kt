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
    
    fun Result(a : Option , b: Option): Int{ 
        for(element in regole){
            if(element.first.equals(a)  and element.second.equals(b) ) return element.third
        }
        return 100
    }
    
    fun printResult(a : Option , b: Option): String{
        val risultato = this.Result(a,b)
        when(risultato){
            -1-> return ("Vince il secondo giocatore con $b")
            0-> return ("Pareggio")
            1-> return ("Vince il secondo giocatore con $a")
            
        }
        return "errore"
    }  
}

fun main() {
    val userChoice = Option.Carta
    val gameChoice : Option = Gioco.getGameChoice()
    println("L'utente gioca $userChoice")
    println("Il computer gioca $gameChoice")
    println(Gioco.printResult(userChoice,gameChoice))
   
}
