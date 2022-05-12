package com.example.demo.web

import com.example.demo.web.common.router.ApiVersion
import com.example.demo.web.common.router.RouterFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfig {

    @Bean
    fun entryPoint(
        routerFactory: RouterFactory
    ) = coRouter {

        ApiVersion.V1.path.nest {
            routerFactory(ApiVersion.V1) {
                route(this@nest)
            }
        }
    }
}
