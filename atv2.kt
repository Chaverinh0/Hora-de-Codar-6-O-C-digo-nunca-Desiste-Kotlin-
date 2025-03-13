
fun main() {

    //Qual a nota?
    //Considerando a necessidade de um programa que armazene o nome e as notas bimestrais de 20 alunos do curso de Técnicas de Programação, defina a estrutura de registro apropriada, o diagrama de blocos e a codificação de um programa que, por meio do uso de um menu de opções, execute as seguintes etapas:
    //
    //a) Cadastrar os 20 registros (após o cadastro efetuar a classificação por nome).
    //b) Pesquisar os 20 registros, de cada vez, pelo campo nome. Nesta pesquisa o programa deverá
    //também apresentar a média do aluno e as mensagens: “Aprovado” caso sua média seja maior ou
    //igual a 5, ou “Reprovado” para média abaixo de 5.
    //c) Apresentar todos os registros, médias e a mensagem de aprovação ou reprovação.
    //d) Sair do programa de cadastro.

    val nomes = Array(20) { "" } // Array para armazenar os nomes dos alunos
    val notas1 = Array(20) { 0.0 } // Array para armazenar a primeira nota de cada aluno
    val notas2 = Array(20) { 0.0 } // Array para armazenar a segunda nota de cada aluno
    val notas3 = Array(20) { 0.0 } // Array para armazenar a terceira nota de cada aluno
    val notas4 = Array(20) { 0.0 } // Array para armazenar a quarta nota de cada aluno
    var opcao: Int

    do {
        // Menu de opções
        println("\n--- MENU ---")
        println("1. Cadastrar 20 alunos")
        println("2. Pesquisar aluno por nome")
        println("3. Listar todos os alunos")
        println("4. Sair")
        print("Escolha uma opção: ")
        opcao = readLine()!!.toInt()

        when (opcao) {
            1 -> cadastrarAlunos(nomes, notas1, notas2, notas3, notas4)
            2 -> pesquisarAluno(nomes, notas1, notas2, notas3, notas4)
            3 -> listarAlunos(nomes, notas1, notas2, notas3, notas4)
            4 -> println("Saindo...")
            else -> println("Opção inválida!")
        }
    } while (opcao != 4)
}

// Função para cadastrar 20 alunos
fun cadastrarAlunos(
    nomes: Array<String>,
    notas1: Array<Double>,
    notas2: Array<Double>,
    notas3: Array<Double>,
    notas4: Array<Double>
) {
    println("\nCadastro de 20 alunos:")
    for (i in 0 until 20) {
        println("\nAluno ${i + 1}:")
        print("Nome: ")
        nomes[i] = readLine()!!
        print("Nota 1: ")
        notas1[i] = readLine()!!.toDouble()
        print("Nota 2: ")
        notas2[i] = readLine()!!.toDouble()
        print("Nota 3: ")
        notas3[i] = readLine()!!.toDouble()
        print("Nota 4: ")
        notas4[i] = readLine()!!.toDouble()
    }
    println("Cadastro concluído!")
}

// Função para pesquisar um aluno pelo nome
fun pesquisarAluno(
    nomes: Array<String>,
    notas1: Array<Double>,
    notas2: Array<Double>,
    notas3: Array<Double>,
    notas4: Array<Double>
) {
    print("\nDigite o nome do aluno: ")
    val nome = readLine()!!
    var encontrado = false

    for (i in 0 until 20) {
        if (nomes[i].equals(nome, ignoreCase = true)) {
            encontrado = true
            val media = (notas1[i] + notas2[i] + notas3[i] + notas4[i]) / 4
            println("\nAluno encontrado:")
            println("Nome: ${nomes[i]}")
            println("Média: $media")
            println("Situação: ${if (media >= 5) "Aprovado" else "Reprovado"}")
            break
        }
    }

    if (!encontrado) {
        println("Aluno não encontrado!")
    }
}

// Função para listar todos os alunos
fun listarAlunos(
    nomes: Array<String>,
    notas1: Array<Double>,
    notas2: Array<Double>,
    notas3: Array<Double>,
    notas4: Array<Double>
) {
    println("\nLista de todos os alunos:")
    for (i in 0 until 20) {
        val media = (notas1[i] + notas2[i] + notas3[i] + notas4[i]) / 4
        println("\nNome: ${nomes[i]}")
        println("Média: $media")
        println("Situação: ${if (media >= 5) "Aprovado" else "Reprovado"}")
    }
}