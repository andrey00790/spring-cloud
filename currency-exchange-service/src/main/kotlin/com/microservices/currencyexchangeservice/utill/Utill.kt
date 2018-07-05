package com.microservices.currencyexchangeservice.utill

import com.microservices.currencyexchangeservice.jpa.model.ExchangeValueDto
import com.microservices.currencyexchangeservice.web.model.out.ExchangeValueResponse

fun ExchangeValueDto.toDto(): ExchangeValueResponse = ExchangeValueResponse(this.from, this.to, this.conversionMultiple)