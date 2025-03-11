fun main() {
    val nomes = Array(10) { "" }
    val enderecos = Array(10) { "" }
    val telefones = Array(10) { "" }
    var continuar = true
    var qtdRegistros = 0

    while (continuar) {
        println("\nMenu de Opções:")
        println("1. Cadastrar os 10 registros")
        println("2. Pesquisar registro pelo nome")
        println("3. Classificar registros por nome")
        println("4. Apresentar todos os registros")
        println("5. Sair do programa")
        print("Digite a opção desejada: ")

        when (readLine()!!.toInt()) {
            1 -> qtdRegistros = cadastrarRegistros(nomes, enderecos, telefones, qtdRegistros)
            2 -> pesquisarRegistro(nomes, enderecos, telefones, qtdRegistros)
            3 -> classificarRegistros(nomes, enderecos, telefones, qtdRegistros)
            4 -> apresentarRegistros(nomes, enderecos, telefones, qtdRegistros)
            5 -> {
                println("Saindo do programa de cadastro...")
                continuar = false
            }
            else -> println("Opção inválida! Tente novamente.")
        }
    }
}

fun cadastrarRegistros(nomes: Array<String>, enderecos: Array<String>, telefones: Array<String>, qtdRegistros: Int): Int {
    var count = qtdRegistros
    if (count >= 10) {
        println("Agenda já possui 10 registros.")
        return count
    }
    for (i in count until 10) {
        print("\nDigite o nome do contato ${i + 1}: ")
        nomes[i] = readLine()!!
        print("Digite o endereço do contato ${i + 1}: ")
        enderecos[i] = readLine()!!
        print("Digite o telefone do contato ${i + 1}: ")
        telefones[i] = readLine()!!
        count++
    }
    println("Registros cadastrados com sucesso!")
    return count
}

fun pesquisarRegistro(nomes: Array<String>, enderecos: Array<String>, telefones: Array<String>, qtdRegistros: Int) {
    print("Digite o nome do contato a ser pesquisado: ")
    val nomePesquisa = readLine()!!
    val index = nomes.indexOfFirst { it.equals(nomePesquisa, ignoreCase = true) }
    if (index != -1) {
        println("Contato encontrado: Nome: ${nomes[index]}, Endereço: ${enderecos[index]}, Telefone: ${telefones[index]}")
    } else {
        println("Contato não encontrado.")
    }
}

fun classificarRegistros(nomes: Array<String>, enderecos: Array<String>, telefones: Array<String>, qtdRegistros: Int) {
    for (i in 0 until qtdRegistros - 1) {
        for (j in i + 1 until qtdRegistros) {
            if (nomes[i].compareTo(nomes[j], ignoreCase = true) > 0) {
                val tempNome = nomes[i]
                val tempEndereco = enderecos[i]
                val tempTelefone = telefones[i]
                nomes[i] = nomes[j]
                enderecos[i] = enderecos[j]
                telefones[i] = telefones[j]
                nomes[j] = tempNome
                enderecos[j] = tempEndereco
                telefones[j] = tempTelefone
            }
        }
    }
    println("Registros classificados por nome.")
}

fun apresentarRegistros(nomes: Array<String>, enderecos: Array<String>, telefones: Array<String>, qtdRegistros: Int) {
    if (qtdRegistros == 0) {
        println("Agenda vazia.")
    } else {
        println("Registros da agenda:")
        for (i in 0 until qtdRegistros) {
            println("Nome: ${nomes[i]}, Endereço: ${enderecos[i]}, Telefone: ${telefones[i]}")
        }
    }
}
