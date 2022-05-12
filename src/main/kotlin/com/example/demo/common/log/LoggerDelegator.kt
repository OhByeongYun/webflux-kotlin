package com.example.demo.common.log

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LoggerDelegator(
    private val name: String? = null
) : ReadOnlyProperty<Any?, Logger> {

    companion object {
        private fun createLogger(clazz: String): Logger {
            return LoggerFactory.getLogger(clazz)
        }
    }

    private lateinit var logger: Logger

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): Logger {
        LoggerFactory.getLogger("loggerDelete").info("$property")

        if (::logger.isInitialized) {
            return logger
        }

        if (thisRef != null) {
            logger = createLogger(thisRef.javaClass.name)
        } else {
            name?.let {
                logger = createLogger(name)
            } ?: throw IllegalArgumentException("Logger name must not be null.")
        }

        return logger
    }
}
