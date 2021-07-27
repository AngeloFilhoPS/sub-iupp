package br.com.sub.angelo.infrastructure.database

import br.com.sub.angelo.core.model.Instrutor
import br.com.sub.angelo.core.ports.InstrutorDatabasePort
import br.com.sub.angelo.infrastructure.database.entity.InstrutorEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton
import br.com.sub.angelo.core.mapper.InstrutorMapper.Companion.instrutorEntityToModel

@Singleton
class InstrutorDatabase(private val cqlSession: CqlSession):InstrutorDatabasePort {
    override fun findById(id: UUID): Optional<Instrutor> {
        TODO("Not yet implemented")
    }

    override fun save(instrutorEntity: InstrutorEntity): Instrutor {
        println(instrutorEntity)
        instrutorEntity.id= UUID.randomUUID()
        cqlSession.execute(
            SimpleStatement.newInstance(
                "INSERT INTO instrutores(id, nome, cpf, descricao, numArmas) VALUES (?,?,?,?,?)",
                instrutorEntity.id,
                instrutorEntity.nome,
                instrutorEntity.cpf,
                instrutorEntity.descricao,
                instrutorEntity.numArmas
            )
        )
        return instrutorEntityToModel(instrutorEntity)

    }

    override fun update(instrutorEntity: InstrutorEntity) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "UPDATE instrutores SET nome = ?, cpf =?, descricao = ?, numArmas = ? WHERE ID = ?",
                instrutorEntity.nome,
                instrutorEntity.cpf,
                instrutorEntity.descricao,
                instrutorEntity.numArmas,
                instrutorEntity.id
            )
        )

    }

    override fun deleteById(id: UUID) {
        println(id)
        cqlSession.execute(
            SimpleStatement.newInstance("DELETE from instrutores WHERE id = ?",id)
        )
    }
}