package br.com.sub.angelo.core.model

import java.util.*


data class Instrutor(
    val id:UUID? =null,
    val nome:String?=null,
    val cpf:String?=null,
    val descricao:String?=null,
    val numArmas:Int?=null,
)
