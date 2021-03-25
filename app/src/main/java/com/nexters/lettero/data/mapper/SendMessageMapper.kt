package com.nexters.lettero.data.mapper

import com.nexters.lettero.data.model.SendMessage
import com.nexters.lettero.domain.model.Message
import com.nexters.lettero.presentation.util.DateUtils

object SendMessageMapper : Mapper<Message, SendMessage> {
    override fun toDomain(entity: SendMessage): Message {
        return Message(
            entity.messageId,
            entity.receiverPhoneNumber,
            entity.text,
            DateUtils.toDatetime(entity.sendTimestamp)
        )
    }

    override fun fromDomain(domain: Message): SendMessage {
        return SendMessage(
            domain.id,
            domain.text,
            domain.author,
            DateUtils.toServerTimestamp(domain.datetime)
        )
    }
}
