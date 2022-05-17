package com.example.demo.common.reactor

import org.slf4j.helpers.BasicMDCAdapter

object RequestContext {

    private val adapter = BasicMDCAdapter()

    const val TRANSACTION_ID = "transaction.id"

    val transactionId: String
        get() {
            return adapter.get(TRANSACTION_ID)
        }

    val copyOfContextMap: Map<String, String>
        get() {
            return adapter.copyOfContextMap
        }

    fun setContextMap(contextMap: Map<String, String>) = adapter.setContextMap(contextMap)

    fun clear() = adapter.clear()
}
