package com.example.demo.common.util

/**
 * **For jacoco coverage reporter.**
 *
 * jacoco is not covers default branches of if/switch/when.
 * normally, next classes are can not reach 100% coverage.
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
 * blow is workaround.
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
