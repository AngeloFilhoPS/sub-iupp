package br.com.sub.angelo.core.mapper

import br.com.sub.angelo.core.model.Instrutor
import br.com.sub.angelo.infrastructure.broker.request.InstrutorRequest
import br.com.sub.angelo.infrastructure.database.entity.InstrutorEntity
import java.util.*

class InstrutorMapper {
    companion object {
        fun instrutorToEntity(instrutor: Instrutor): InstrutorEntity = with(instrutor) {
            InstrutorEntity(
                id = id!!,
                nome = nome!!,
                cpf = cpf!!,
                descricao = descricao!!,
                numArmas = numArmas!!
            )
        }

        fun instrutorEntityToModel(instrutorEntity: InstrutorEntity):Instrutor= with(instrutorEntity){
            Instrutor(
                id=id,
                nome=nome,
                cpf=cpf,
                descricao=descricao,
                numArmas=numArmas

            )
        }

        fun instrutorEventToModel(instrutorRequest: InstrutorRequest): Instrutor = with(instrutorRequest) {
            Instrutor(
                id = id?.let(UUID::fromString),
                nome = nome,
                descricao=descricao,
                cpf = cpf,
                numArmas = numArmas
            )
        }
    }
}