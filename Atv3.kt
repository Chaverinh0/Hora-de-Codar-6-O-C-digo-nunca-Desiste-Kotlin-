fun main() {

    //Nome e Altura
    //Elaborar um programa que armazene o nome e a altura de 15 pessoas, por meio do uso de
    //registros. O programa deverá ser manipulado por um menu que execute as seguintes etapas:
    //
    //a) Cadastrar os 15 registros.
    //b) Apresentar os registros (nome e altura) das pessoas menores ou iguais a 1.5m.
    //c) Apresentar os registros (nome e altura) das pessoas que sejam maiores que 1.5m.
    //d) Apresentar os registros (nome e altura) das pessoas que sejam maiores que 1.5m e menores que
    //2.0m.
    //e) Apresentar a média extraída de todas as alturas armazenadas.
    //f) Sair do programa.

    val nomes = Array(15) { "" } // Array para armazenar os nomes das pessoas
    val alturas = Array(15) { 0.0 } // Array para armazenar as alturas das pessoas
    var opcao: Int

    do {
        // Menu de opções
        println("\n--- MENU ---")
        println("1. Cadastrar 15 pessoas")
        println("2. Mostrar pessoas com altura ≤ 1.5m")
        println("3. Mostrar pessoas com altura > 1.5m")
        println("4. Mostrar pessoas com altura > 1.5m e < 2.0m")
        println("5. Mostrar média das alturas")
        println("6. Sair")
        print("Escolha uma opção: ")
        opcao = readLine()!!.toInt()

        when (opcao) {
            1 -> cadastrarPessoas(nomes, alturas)
            2 -> mostrarAte150(nomes, alturas)
            3 -> mostrarAcima150(nomes, alturas)
            4 -> mostrarEntre150e200(nomes, alturas)
            5 -> mostrarMediaAlturas(alturas)
            6 -> println("Saindo...")
            else -> println("Opção inválida!")
        }
    } while (opcao != 6)
}

// Função para cadastrar 15 pessoas
fun cadastrarPessoas(nomes: Array<String>, alturas: Array<Double>) {
    println("\nCadastro de 15 pessoas:")
    for (i in 0 until 15) {
        println("\nPessoa ${i + 1}:")
        print("Nome: ")
        nomes[i] = readLine()!!
        print("Altura (em metros): ")
        alturas[i] = readLine()!!.toDouble()
    }
    println("Cadastro concluído!")
}

// Função para mostrar pessoas com altura ≤ 1.5m
fun mostrarAte150(nomes: Array<String>, alturas: Array<Double>) {
    println("\nPessoas com altura ≤ 1.5m:")
    for (i in 0 until 15) {
        if (alturas[i] <= 1.5) {
            println("Nome: ${nomes[i]} - Altura: ${alturas[i]}m")
        }
    }
}

// Função para mostrar pessoas com altura > 1.5m
fun mostrarAcima150(nomes: Array<String>, alturas: Array<Double>) {
    println("\nPessoas com altura > 1.5m:")
    for (i in 0 until 15) {
        if (alturas[i] > 1.5) {
            println("Nome: ${nomes[i]} - Altura: ${alturas[i]}m")
        }
    }
}

// Função para mostrar pessoas com altura > 1.5m e < 2.0m
fun mostrarEntre150e200(nomes: Array<String>, alturas: Array<Double>) {
    println("\nPessoas com altura > 1.5m e < 2.0m:")
    for (i in 0 until 15) {
        if (alturas[i] > 1.5 && alturas[i] < 2.0) {
            println("Nome: ${nomes[i]} - Altura: ${alturas[i]}m")
        }
    }
}

// Função para mostrar a média das alturas
fun mostrarMediaAlturas(alturas: Array<Double>) {
    val somaAlturas = alturas.sum()
    val mediaAlturas = somaAlturas / 15
    println("\nMédia das alturas: ${"%.2f".format(mediaAlturas)}m")
    /* %.2f formatação para duas casas decimais */
}