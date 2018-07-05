package com.microservices.currencyexchangeservice.jpa

import com.microservices.currencyexchangeservice.jpa.model.ExchangeValueDto
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeValueRepository: JpaRepository<ExchangeValueDto, Long>{
    //todo EmptyResultDataAccessException
    fun findByFromAndTo(from: String, to: String): ExchangeValueDto
}