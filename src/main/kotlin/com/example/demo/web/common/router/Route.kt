package com.example.demo.web.common.router

import org.springframework.web.reactive.function.server.CoRouterFunctionDsl

var routerFactory: RouterFactory? = null

/**
 * Route to the given api version by injected [RouterFactory].
 * /v1/V1Router, /v2/V2Router, ...
 */
inline fun <reified T : ApiVersion> T.route(dsl: CoRouterFunctionDsl): CoRouterFunctionDsl {
    return dsl.apply {
        this@route.path.nest {
            routerFactory?.invoke(this@route) {
                route(this@nest)
            } ?: throw IllegalStateException("inject RouterFactory before route.")
        }
    }
}

inline fun <reified T : CoRouterFunctionDsl> T.inject(factory: RouterFactory) {
    routerFactory = factory
}
