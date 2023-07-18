package de.tschuehly.fullstackdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RapidFullstackDemoApplication

fun main(args: Array<String>) {
    runApplication<RapidFullstackDemoApplication>(*args)
}
