fun main() {

    //Funcionários
    //Considerando os registros de 20 funcionários, contendo os campos: matrícula, nome e salário,
    //desenvolver um programa que, por meio de um menu, execute as seguintes etapas:
    //
    //a) Cadastrar os 20 empregados e classificar os registros por número de matrícula.
    //b) Pesquisar um determinado empregado pelo número de matrícula.
    //c) Apresentar de forma ordenada (por matrícula) os registros dos empregados que recebem salários
    //acima de R$1.000,00.
    //d) Apresentar de forma ordenada (por matrícula) os registros dos empregados que recebem salários
    //abaixo de R$1.000,00.
    //e) Apresentar de forma ordenada (por matrícula) os registros dos empregados que recebem salários
    //iguais a R$1.000,00.
    //f) Sair do programa.

    val matriculas = Array(20) { 0 } // Array para armazenar as matrículas
    val nomes = Array(20) { "" } // Array para armazenar os nomes
    val salarios = Array(20) { 0.0 } // Array para armazenar os salários
    var opcao: Int

    do {
        // Menu de opções
        println("\n--- MENU ---")
        println("1. Cadastrar 20 funcionários")
        println("2. Pesquisar funcionário por matrícula")
        println("3. Mostrar funcionários com salário acima de R$1000,00")
        println("4. Mostrar funcionários com salário abaixo de R$1000,00")
        println("5. Mostrar funcionários com salário igual a R$1000,00")
        println("6. Sair")
        print("Escolha uma opção: ")
        opcao = readLine()!!.toInt()

        when (opcao) {
            1 -> cadastrarFuncionarios(matriculas, nomes, salarios)
            2 -> pesquisarPorMatricula(matriculas, nomes, salarios)
            3 -> mostrarSalariosAcima1000(matriculas, nomes, salarios)
            4 -> mostrarSalariosAbaixo1000(matriculas, nomes, salarios)
            5 -> mostrarSalariosIgual1000(matriculas, nomes, salarios)
            6 -> println("Saindo...")
            else -> println("Opção inválida!")
        }
    } while (opcao != 6)
}

// Função para cadastrar 20 funcionários
fun cadastrarFuncionarios(matriculas: Array<Int>, nomes: Array<String>, salarios: Array<Double>) {
    println("\nCadastro de 20 funcionários:")
    for (i in 0 until 20) {
        println("\nFuncionário ${i + 1}:")
        print("Matrícula: ")
        matriculas[i] = readLine()!!.toInt()
        print("Nome: ")
        nomes[i] = readLine()!!
        print("Salário: R$")
        salarios[i] = readLine()!!.toDouble()
    }
    // Ordenar os registros por matrícula
    ordenarPorMatricula(matriculas, nomes, salarios)
    println("Cadastro concluído e registros ordenados por matrícula!")
}

// Função para ordenar os registros por matrícula
fun ordenarPorMatricula(matriculas: Array<Int>, nomes: Array<String>, salarios: Array<Double>) {
    for (i in 0 until 19) {
        for (j in i + 1 until 20) {
            if (matriculas[i] > matriculas[j]) {
                // Troca matrículas
                val tempMatricula = matriculas[i]
                matriculas[i] = matriculas[j]
                matriculas[j] = tempMatricula

                // Troca nomes
                val tempNome = nomes[i]
                nomes[i] = nomes[j]
                nomes[j] = tempNome

                // Troca salários
                val tempSalario = salarios[i]
                salarios[i] = salarios[j]
                salarios[j] = tempSalario
            }
        }
    }
}

// Função para pesquisar um funcionário por matrícula
fun pesquisarPorMatricula(matriculas: Array<Int>, nomes: Array<String>, salarios: Array<Double>) {
    print("\nDigite a matrícula do funcionário: ")
    val matricula = readLine()!!.toInt()
    var encontrado = false

    for (i in 0 until 20) {
        if (matriculas[i] == matricula) {
            encontrado = true
            println("\nFuncionário encontrado:")
            println("Matrícula: ${matriculas[i]}")
            println("Nome: ${nomes[i]}")
            println("Salário: R$${salarios[i]}")
            break
        }
    }

    if (!encontrado) {
        println("Funcionário não encontrado!")
    }
}

// Função para mostrar funcionários com salário acima de R$1000,00
fun mostrarSalariosAcima1000(matriculas: Array<Int>, nomes: Array<String>, salarios: Array<Double>) {
    println("\nFuncionários com salário acima de R$1000,00:")
    for (i in 0 until 20) {
        if (salarios[i] > 1000) {
            println("Matrícula: ${matriculas[i]} - Nome: ${nomes[i]} - Salário: R$${salarios[i]}")
        }
    }
}

// Função para mostrar funcionários com salário abaixo de R$1000,00
fun mostrarSalariosAbaixo1000(matriculas: Array<Int>, nomes: Array<String>, salarios: Array<Double>) {
    println("\nFuncionários com salário abaixo de R$1000,00:")
    for (i in 0 until 20) {
        if (salarios[i] < 1000) {
            println("Matrícula: ${matriculas[i]} - Nome: ${nomes[i]} - Salário: R$${salarios[i]}")
        }
    }
}

// Função para mostrar funcionários com salário igual a R$1000,00
fun mostrarSalariosIgual1000(matriculas: Array<Int>, nomes: Array<String>, salarios: Array<Double>) {
    println("\nFuncionários com salário igual a R$1000,00:")
    for (i in 0 until 20) {
        if (salarios[i] == 1000.0) {
            println("Matrícula: ${matriculas[i]} - Nome: ${nomes[i]} - Salário: R$${salarios[i]}")
        }
    }
}