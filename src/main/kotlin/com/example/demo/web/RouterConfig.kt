package com.example.demo.web

import com.example.demo.web.common.router.ApiVersion
import com.example.demo.web.common.router.RouterFactory
import com.example.demo.web.common.router.inject
import com.example.demo.web.common.router.route
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfig(
    private val routerFactory: RouterFactory
) {

    @Bean
    fun entryPoint() = coRouter {
        inject(routerFactory)
        ApiVersion.V1.route(this)
    }
}
