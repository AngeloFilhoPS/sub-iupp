package br.com.sub.angelo.core.ports

import br.com.sub.angelo.core.model.Instrutor
import br.com.sub.angelo.infrastructure.database.entity.InstrutorEntity
import java.util.*

interface InstrutorDatabasePort {

    fun findById(id:UUID):Optional<Instrutor>
    fun save(instrutorEntity: InstrutorEntity):Instrutor
    fun update(instrutorEntity: InstrutorEntity)
    fun deleteById(id:UUID)

}