package com.microservices.limitsservice.web.model


data class LimitsResponse(
    val minimum : Int,
    val maximum : Int
)