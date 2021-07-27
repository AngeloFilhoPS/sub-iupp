package br.com.sub.angelo.core.ports

import br.com.sub.angelo.core.model.Instrutor

interface InstrutorServicePort {

    fun cadastrarInstrutor(instrutor: Instrutor)
    fun deletarInstrutor(instrutor:Instrutor)
    fun editarInstrutor(instrutor:Instrutor)

}