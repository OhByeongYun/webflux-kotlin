package com.example.demo.common.log

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LoggerDelegator : ReadOnlyProperty<Any?, Logger> {

    companion object {
        private fun <T> createLogger(clazz: Class<T>): Logger {
            return LoggerFactory.getLogger(clazz.name)
        }
    }

    private lateinit var logger: Logger

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): Logger {
        if (!::logger.isInitialized) {
            logger = createLogger(thisRef!!.javaClass)
        }
        return logger
    }
}
