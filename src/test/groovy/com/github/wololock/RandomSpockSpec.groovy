package com.github.wololock

import spock.lang.Specification

@RandomizedOrder
class RandomSpockSpec extends Specification {

    private int i = 10

    def "test 1"() {
        when:
        def number = 1

        then:
        println "[${new Date().format("HH:mm:ss.SSS")}] number ${number}"
    }

    def "test 2"() {
        when:
        def number = 2

        then:
        println "[${new Date().format("HH:mm:ss.SSS")}] number ${number}"
    }

    def "test 3"() {
        when:
        def number = 3

        then:
        println "[${new Date().format("HH:mm:ss.SSS")}] number ${number}"
    }

    def "test 4"() {
        when:
        def number = 4

        then:
        println "[${new Date().format("HH:mm:ss.SSS")}] number ${number}"
    }

    def "test 5"() {
        when:
        def number = 5

        then:
        println "[${new Date().format("HH:mm:ss.SSS")}] number ${number}"
    }
}
