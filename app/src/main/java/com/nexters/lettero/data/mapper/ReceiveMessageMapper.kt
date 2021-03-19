package com.nexters.lettero.data.mapper

import com.nexters.lettero.data.model.ReceiveMessage
import com.nexters.lettero.domain.model.Message
import com.nexters.lettero.presentation.util.DateUtils

object ReceiveMessageMapper : Mapper<Message, ReceiveMessage> {
    override fun toDomain(entity: ReceiveMessage): Message {
        return Message(
            entity.messageId,
            entity.senderPhoneNumber,
            entity.text,
            DateUtils.toDatetime(entity.receiveTimestamp)
        )
    }

    override fun fromDomain(domain: Message): ReceiveMessage {
        return ReceiveMessage(
            domain.id,
            domain.text,
            false,
            domain.author,
            DateUtils.toServerTimestamp(domain.datetime)
        )
    }
}
