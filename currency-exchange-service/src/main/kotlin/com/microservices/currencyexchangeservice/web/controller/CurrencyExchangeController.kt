package com.microservices.currencyexchangeservice.web.controller

import com.microservices.currencyexchangeservice.jpa.ExchangeValueRepository
import com.microservices.currencyexchangeservice.utill.toDto
import com.microservices.currencyexchangeservice.web.model.out.ExchangeValueResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CurrencyExchangeController @Autowired constructor(val exchangeValueRepository: ExchangeValueRepository){

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    fun retrieveExchangeValue(@PathVariable from: String, @PathVariable to: String) : ExchangeValueResponse {
        val exchangeValueResponse = exchangeValueRepository
                .findByFromAndTo(from, to)
                .toDto()
        log.info("exchangeValueResponse:->$exchangeValueResponse")
        return exchangeValueResponse
    }

    companion object {
        var log = LoggerFactory.getLogger(CurrencyExchangeController::class.java)
    }
}