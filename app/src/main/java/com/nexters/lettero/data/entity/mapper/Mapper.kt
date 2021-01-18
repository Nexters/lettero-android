package com.nexters.lettero.data.entity.mapper

interface Mapper<D, T> {
    fun to(data: D): T
}
