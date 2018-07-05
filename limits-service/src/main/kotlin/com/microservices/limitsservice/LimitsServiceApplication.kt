package com.microservices.limitsservice

import brave.sampler.Sampler
import com.microservices.limitsservice.configuration.LimitsConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableConfigurationProperties(LimitsConfiguration::class)
@EnableDiscoveryClient
@EnableHystrix
class LimitsServiceApplication {
    @Bean
    fun defaultSampler(): Sampler {
        return Sampler.ALWAYS_SAMPLE
    }
}

fun main(args: Array<String>) {
    runApplication<LimitsServiceApplication>(*args)
}
