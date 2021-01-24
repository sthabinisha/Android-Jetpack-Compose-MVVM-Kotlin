package com.example.restaurant.domain.util

interface DomainMapper <T, DomainModel>{

    fun mapToDomainModel(model: T): DomainModel
    fun maptoEntity(domainModel: DomainModel): T


}
