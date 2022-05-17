package com.example.demo.web.common.filter

import com.example.demo.common.Constants
import com.example.demo.common.reactor.RequestContext
import com.example.demo.common.reactor.RequestContext.TRANSACTION_ID
import java.util.UUID
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono
import reactor.util.context.Context

@Component
class RequestContextWriteFilter : WebFilter {

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {

        val contextMap = createContextMap(exchange.request)

        RequestContext.setContextMap(contextMap)

        return chain.filter(exchange)
            .contextWrite {
                Context.of(RequestContext.copyOfContextMap)
            }
    }

    private fun createContextMap(request: ServerHttpRequest): Map<String, String> {

        val transactionId = request.headers.getFirst(Constants.HEADER_TRANSACTION_ID).takeUnless {
            it.isNullOrEmpty()
        } ?: UUID.randomUUID().toString()

        return mapOf(
            TRANSACTION_ID to transactionId
        )
    }
}
