package com.nexters.lettero.domain.interactor

import com.nexters.lettero.data.model.ReceiveMessage
import com.nexters.lettero.domain.interactor.base.BaseUseCase
import com.nexters.lettero.domain.repository.MessageRepository
import io.reactivex.Single

class GetReceiveMessagesUseCase(private val messageRepository: MessageRepository) :
    BaseUseCase<Single<List<ReceiveMessage>>, Unit> {

    override fun buildUseCase(params: Unit) = messageRepository.getReceiveMessages()
}
