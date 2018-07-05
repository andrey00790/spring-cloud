package com.microservices.currencyconvertionservice.model.out

import java.math.BigDecimal

data class CurrencyConversionResponse(
        val from: String,
        val to: String,
        val conversionMultiple: BigDecimal,
        val quantity: BigDecimal,
        val totalCalculatedAmount: BigDecimal
)

data class ExchangeValueResponse(
        val from: String,
        val to: String,
        val conversionMultiple: BigDecimal
)