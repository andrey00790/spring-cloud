package com.microservices.currencyexchangeservice.jpa.model

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "exchange_value")
data class ExchangeValueDto(
        @field:Id var id: Long?,
        @field:Column(name = "currency_from") var from: String,
        @field:Column(name = "currency_to")var to: String,
        var conversionMultiple: BigDecimal
){
    constructor() : this(null, "","", BigDecimal.ZERO)
}