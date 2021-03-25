package com.nexters.lettero.data.mapper

interface Mapper<D, E> {
    fun toDomain(entity: E): D
    fun fromDomain(domain: D): E
}
