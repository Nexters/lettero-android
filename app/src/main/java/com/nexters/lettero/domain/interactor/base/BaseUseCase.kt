package com.nexters.lettero.domain.interactor.base

interface BaseUseCase<T, Params> {
    fun buildUseCase(params: Params): T
}