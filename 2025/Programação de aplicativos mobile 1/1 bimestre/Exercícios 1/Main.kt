fun main() {
    println("Exercício 1:")
    ex1()
    println()

    println("Exercício 2:")
    ex2()
    println()

    println("Exercício 3:")
    ex3()
    println()

    println("Exercício 4:")
    ex4()
    println()

    println("Exercício 5:")
    ex5()
    println()

    println("Exercício 6:")
    ex6()
    println()

    println("Exercício 7:")
    ex7()
    println()

    println("Exercício 8:")
    ex8()
    println()

    println("Exercício 9:")
    ex9()
    println()

    println("Exercício 10:")
    ex10()
    println()

}

fun ex1() {
    val nome = "nome"
    println("Oi $nome")
}

fun ex2() {
    // Criando a variável nome e atribuindo "nome" a ela
    val nome = "nome"

    // Imprimindo uma mensagem "Oi" e o valor da variável nome
    println("Oi $nome")
}

fun ex3() {
    val soma = 2 + 2
    val subtracao = 2 - 2
    val divisao = 2 / 2
    val multiplicacao = 2 * 2

    println("Soma: $soma")
    println("Subtração: $subtracao")
    println("Divisão: $divisao")
    println("Multiplicação: $multiplicacao")
}

fun ex4() {
    val base = 3
    val altura = 7
    val resultado = base * altura

    println("Área do retângulo: $resultado")
}

fun ex5() {
    val string = "string"
    println(string)
}

fun ex6() {
    val arrayInt = arrayOf(1, 2, 3, 4)// Criando um array de números inteiros usando arrayOf() - é usado para criar um array com valores específicos

    // Percorrendo o array com o loop for
    for (elemento in arrayInt) {
        println(elemento)
    }
}

fun ex7() {
    val lista = mutableListOf(1, 2, 3, 4) // Criando uma lista mutável
    println("Lista antes: $lista")

    lista.add(5) // Adicionando um item na lista
    lista.add(6)

    println("Lista depois: $lista")

}

fun ex8() {
    val senhaCorreta = "123"
    val tentativas = arrayOf("111", "222", "123", "000") // Lista de senhas para testar

    for (senha in tentativas) { // Percorre todas as senhas na lista
        if (senha == senhaCorreta) {
            println("Acesso autorizado para a senha: $senha")
        } else {
            println("Senha incorreta: $senha")
        }
    }
}

fun ex9(){
    val a = 10
    val b = 50

    if(a > b){
        println("$a é maior que $b")
    }else{
        println("$a é menor que $b")
    }
}

fun ex10() {
    for (i in 1..10) { // Loop de 1 até 10. o in vai incrementando 1 altomaticamente
        println("Número: $i")
    }
}
