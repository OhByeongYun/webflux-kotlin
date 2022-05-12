package com.example.demo.web.common.router

import org.springframework.web.reactive.function.server.CoRouterFunctionDsl

interface Router {

    fun route(dsl: CoRouterFunctionDsl): CoRouterFunctionDsl
}
