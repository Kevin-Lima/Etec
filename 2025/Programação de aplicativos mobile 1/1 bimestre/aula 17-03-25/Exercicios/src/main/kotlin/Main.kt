fun main(args: Array<String>) {
    var valor = 0
    print("Digite um valor: ")  // Exibe a mensagem de prompt
    val input = readLine()       // Lê a entrada do usuário

    if (input != null) {
        valor = input.toInt()
    }

    caso1(valor)
}

// Caso 1: IF ELSE
fun caso1(valor: Int) {
    if (valor > 10) {
        println("Valor maior que 10")
    } else {
        println("Valor menor ou igual a 10")
    }
}

// Caso 2: WHEN
fun caso2When(valor: Int) {
    when (valor) {
        1 -> println("O valor é 1")
        2 -> println("O valor é 2")
        else -> println("Outro valor")
    }
}