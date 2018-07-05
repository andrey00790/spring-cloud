package com.microservices.netflixzuulapigatewayserver.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ZuulLoggingFilter: ZuulFilter() {

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 1
    }

    override fun run(): Any {
        val request = RequestContext.getCurrentContext().request
        log.info("request->${request}, requestUri->${request.requestURI}")
        return 0
    }

    companion object {
        val log = LoggerFactory.getLogger(ZuulLoggingFilter::class.java)
    }
}