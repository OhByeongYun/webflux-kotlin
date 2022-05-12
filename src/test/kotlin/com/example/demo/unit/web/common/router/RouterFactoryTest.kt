package com.example.demo.unit.web.common.router

import com.example.demo.web.common.router.ApiVersion
import com.example.demo.web.common.router.Router
import com.example.demo.web.common.router.RouterFactory
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk

class RouterFactoryTest : StringSpec() {

    private val v1router = mockk<Router>()

    private val routerFactory = RouterFactory(v1Router = v1router)

    init {
        "라우터 팩토리는 버전에 따라 라우터를 반환한다." {
            routerFactory(ApiVersion.V1) {
                this shouldBe v1router
            }
        }
    }
}
