package br.com.sub.angelo.infrastructure.broker.request

data class InstrutorRequest(
    val id:String? = null,
    val nome: String?= null,
    val cpf:String?=null,
    val descricao:String?=null,
    val  numArmas:Int?=null
)