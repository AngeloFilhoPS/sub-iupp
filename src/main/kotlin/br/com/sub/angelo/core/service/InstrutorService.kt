package br.com.sub.angelo.core.service

import br.com.sub.angelo.core.mapper.InstrutorMapper.Companion.instrutorToEntity
import br.com.sub.angelo.core.model.Instrutor
import br.com.sub.angelo.core.ports.InstrutorDatabasePort
import br.com.sub.angelo.core.ports.InstrutorServicePort
import javax.inject.Singleton

@Singleton
open class InstrutorService(private val instrutorDatabase: InstrutorDatabasePort):InstrutorServicePort {
    override fun cadastrarInstrutor(instrutor: Instrutor) {
        instrutorDatabase.save(instrutorToEntity(instrutor))
    }

    override fun deletarInstrutor(instrutor: Instrutor) {
        println(instrutor)
        var id = instrutor.id
        println(id)
        if (id != null) {
            instrutorDatabase.deleteById(id)
        }

    }

    override fun editarInstrutor(instrutor: Instrutor) {
        instrutorDatabase.update(instrutorToEntity(instrutor))
    }
}