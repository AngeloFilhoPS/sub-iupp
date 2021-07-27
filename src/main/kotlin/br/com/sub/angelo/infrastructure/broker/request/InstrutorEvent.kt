package br.com.sub.angelo.infrastructure.broker.request

data class InstrutorEvent (
    val events: Events,
    val instrutorEvent: InstrutorRequest
        )

enum class Events(val eventName:String) {
    SAVE_INSTRUTOR("SAVE_INSTRUTOR"),
    UPDATE_INSTRUTOR("UPDATE_INSTRUTOR"),
    DELETE_INSTRUTOR("DELETE_INSTRUTOR")
}
