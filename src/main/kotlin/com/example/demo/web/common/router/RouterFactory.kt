package com.example.demo.web.common.router

import com.example.demo.common.util.exhaustive
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class RouterFactory(
    @Qualifier("V1Router") private val v1Router: Router
) {

    operator fun invoke(apiVersion: ApiVersion, block: Router.() -> Unit) {
        when (apiVersion) {
            ApiVersion.V1 -> block(v1Router)
        }.exhaustive
    }
}
