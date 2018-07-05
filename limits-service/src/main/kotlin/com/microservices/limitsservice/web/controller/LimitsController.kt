package com.microservices.limitsservice.web.controller

import com.microservices.limitsservice.configuration.LimitsConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.microservices.limitsservice.web.model.LimitsResponse
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.ribbon.proxy.annotation.Hystrix
import org.springframework.beans.factory.annotation.Autowired

@RestController
class LimitsController @Autowired constructor(val limitsConfiguration: LimitsConfiguration) {

    @GetMapping("/limits")
    @HystrixCommand(fallbackMethod = "fallbackRetieveLimits")
    fun retrieveLimitsFromConfigurations() : LimitsResponse{
        return LimitsResponse(limitsConfiguration.minimum, limitsConfiguration.maximum)
    }

    fun fallbackRetieveLimits(): LimitsResponse {
        throw IllegalStateException("Service not available")
    }

}