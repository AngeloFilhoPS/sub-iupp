package br.com.sub.angelo.infrastructure.broker.listener

import br.com.sub.angelo.core.ports.InstrutorServicePort
import br.com.sub.angelo.infrastructure.broker.request.InstrutorEvent
import br.com.sub.angelo.infrastructure.broker.request.Events
import io.micronaut.messaging.annotation.MessageBody
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import br.com.sub.angelo.core.mapper.InstrutorMapper.Companion.instrutorEventToModel

@NatsListener
class InstrutorListener (private val servicePort: InstrutorServicePort){


    @Subject("instrutor")
    fun getMessage(@MessageBody instrutorEvent: InstrutorEvent){
        println(instrutorEvent.instrutorEvent)
        with(instrutorEvent){
            when(events){
                Events.SAVE_INSTRUTOR -> servicePort.cadastrarInstrutor(instrutorEventToModel(this.instrutorEvent))
                Events.UPDATE_INSTRUTOR->servicePort.editarInstrutor(instrutorEventToModel(this.instrutorEvent))
                Events.DELETE_INSTRUTOR->servicePort.deletarInstrutor(instrutorEventToModel(this.instrutorEvent))
            }
        }
    }

}