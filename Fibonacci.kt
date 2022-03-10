fun fib(limite : Int): Int = if (limite <= 2) 1 else  fib(limite - 1) + fib(limite - 2)

fun main() {
    println(fib(6))
}
