package com.nexters.lettero.domain.interactor

import com.nexters.lettero.data.model.SendMessage
import com.nexters.lettero.domain.interactor.base.BaseUseCase
import com.nexters.lettero.domain.repository.MessageRepository
import io.reactivex.Single

class GetSendMessagesUseCase(private val messageRepository: MessageRepository) :
    BaseUseCase<Single<List<SendMessage>>, Unit> {

    override fun buildUseCase(params: Unit) = messageRepository.getSendMessages()
}
