package com.example.demo.web.v1

import com.example.demo.web.common.router.Router
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.CoRouterFunctionDsl
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
@Qualifier("V1Router")
class V1Router : Router {

    override fun route(dsl: CoRouterFunctionDsl) = dsl.apply {
        GET("") {
            // TODO implement.
            ServerResponse.ok().bodyValueAndAwait("ok")
        }
    }
}
