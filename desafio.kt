enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: List<String>, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    fun mostrarFormacao(){
        println("Nome da formação: $nome")

        println("Conteúdo da formação:");
        conteudos.forEach{ conteudo -> conteudo.nome.forEach{ nomeConteudo ->
            println("- $nomeConteudo")
        }
        }
    }

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        for(aluno in usuario) {
            inscritos.add(aluno)
            //println(aluno.nome)
        }
    }


    fun mostrarInscritos(){
        val total = inscritos.size
        val nivel = Nivel.INTERMEDIARIO
        val mensagem = when(nivel){
            Nivel.BASICO -> "avançado"
            Nivel.INTERMEDIARIO -> "intermediário"
            Nivel.AVANCADO -> "avançado"
        }

        println("Número de inscritos: $total")
        println("Nível da formação: $mensagem")
        println("Alunos inscritos: ")
        for(aluno in inscritos) {
            println("- ${aluno.nome}")
        }
    }
}

fun main() {
    val aluno1 = Usuario("Mateus")
    val aluno2 = Usuario("Pedro")
    val aluno3 = Usuario("Paula")

    val conteudo = ConteudoEducacional(listOf("HTTP", "API REST", "Bibliotecas", "Funções"), 120)
    val formacao = Formacao("Backend com Kotlin", listOf(conteudo))
    formacao.matricular(aluno1, aluno2, aluno3)
    formacao.mostrarFormacao()
    formacao.mostrarInscritos()


}