package de.tschuehly.fullstackdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringFullstackDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringFullstackDemoApplication>(*args)
}
