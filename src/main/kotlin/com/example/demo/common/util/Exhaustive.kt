package com.example.demo.common.util

/**
 * **For jacoco coverage reporter.**
 *
 * Jacoco is not covers default branches of if/switch/when/....
 * Next classes are can not reach 100% coverage normally.
 *
 * ```
 * enum class Foo(val value: String) {
 *     ONE("one")
 * }
 *
 * class Test {
 *     fun get(foo: Foo): String {
 *         return when(foo) {
 *             Foo.ONE -> "one"
 *         }
 *     }
 * }
 * ```
 *
 * below is workaround.
 * ```
 * class Test {
 *      fun get(foo: Foo): String {
 *          return when(foo) {
 *              Foo.ONE -> "one"
 *          }.exhaustive
 *      }
 * }
 * ```
 */
val <T> T.exhaustive: T
    get() = this
