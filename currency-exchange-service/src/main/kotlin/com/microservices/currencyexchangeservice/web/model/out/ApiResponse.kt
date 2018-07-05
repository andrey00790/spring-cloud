package com.microservices.currencyexchangeservice.web.model.out

import java.math.BigDecimal

data class ExchangeValueResponse(
    val from: String,
    val to: String,
    val conversionMultiple: BigDecimal
)