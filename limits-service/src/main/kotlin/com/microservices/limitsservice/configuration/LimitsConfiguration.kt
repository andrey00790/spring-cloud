package com.microservices.limitsservice.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@Validated
@ConfigurationProperties(prefix = "limits-service", ignoreInvalidFields = true)
class LimitsConfiguration {
    var minimum: Int = 1
    var maximum: Int = 10000
}
