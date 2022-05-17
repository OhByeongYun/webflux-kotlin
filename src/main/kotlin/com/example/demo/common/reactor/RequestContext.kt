package com.example.demo.common.reactor

import ch.qos.logback.classic.util.LogbackMDCAdapter

object RequestContext {

    private val adapter = LogbackMDCAdapter()

    const val TRANSACTION_ID = "requestContext.transactionId"

    val transactionId: String
        get() {
            return adapter.get(TRANSACTION_ID)
        }

    val copyOfContextMap: Map<String, String>
        get() {
            return adapter.copyOfContextMap
        }

    fun setContextMap(contextMap: Map<String, String>) = adapter.setContextMap(contextMap)

    fun clear() {
        adapter.remove(TRANSACTION_ID)
    }
}
