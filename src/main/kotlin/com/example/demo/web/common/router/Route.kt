package com.example.demo.web.common.router

import org.springframework.web.reactive.function.server.CoRouterFunctionDsl

var routerFactory: RouterFactory? = null

/**
 * Route to the given api version by injected [RouterFactory].
 * Concrete router placed on subdirectory of each version.
 *
 * Example:
 * ```
 * /v1/V1Router,
 * /v2/V2Router,
 * ...
 * ```
 *
 * @author ohbyeongyun
 * @since 0.0.1
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

/**
 * Inject [RouterFactory] to the Route.
 *
 * Example:
 * ```
 * corouter {
 *   inject(routerFactory)
 *   ApiVersion.V1.route(this)
 * }
 * ```
 *
 * @author ohbyeongyun
 * @since 0.0.1
 */
fun inject(factory: RouterFactory) {
    routerFactory = factory
}
