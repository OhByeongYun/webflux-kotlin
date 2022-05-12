package com.example.demo.web.common.config

import java.util.UUID
import org.slf4j.MDC
import org.springframework.context.annotation.Configuration
import org.springframework.http.server.reactive.HttpHandler
import org.springframework.http.server.reactive.HttpHandlerDecoratorFactory
import reactor.util.context.Context

@Configuration
class InjectMDCHttpHandlerDecorator : HttpHandlerDecoratorFactory {
    companion object {
        private const val TransactionId = "transaction.id"
    }

    override fun apply(handler: HttpHandler): HttpHandler {
        val id = UUID.randomUUID().toString()
        return HttpHandler { request, response ->
            handler.handle(request, response).contextWrite {
                MDC.put(TransactionId, id)
                Context.of(TransactionId, id)
            }
        }
    }
}
