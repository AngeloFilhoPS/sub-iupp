package br.com.sub.angelo.infrastructure.database.entity

import java.util.*

data class InstrutorEntity(
    var id: UUID?=null,
    var nome:String,
    var cpf:String,
    var descricao:String,
    var numArmas:Int
        )