package com.microservices.currencyconvertionservice.controller

import com.microservices.currencyconvertionservice.model.out.CurrencyConversionResponse
import com.microservices.currencyconvertionservice.service.CurrencyExchangeServiceProxy
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import javax.validation.Valid

@Validated
@RestController
class CurrencyConverterController @Autowired constructor(val currencyExchangeServiceProxy: CurrencyExchangeServiceProxy) {


    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    fun convertCurrency(@PathVariable("from") from: String,
                        @PathVariable("to") to: String,
                        @PathVariable("quantity") quantity: BigDecimal): CurrencyConversionResponse {

        val exchangeValue = currencyExchangeServiceProxy.retrieveExchangeValue(from, to)
        log.info("exchangeValue->$exchangeValue")
        return CurrencyConversionResponse(from, to, exchangeValue.conversionMultiple, quantity, quantity.multiply(exchangeValue.conversionMultiple))
    }

    companion object {
        var log = LoggerFactory.getLogger(CurrencyConverterController::class.java)
    }

}