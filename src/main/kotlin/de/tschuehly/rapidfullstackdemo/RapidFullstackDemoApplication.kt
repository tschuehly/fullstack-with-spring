package de.tschuehly.rapidfullstackdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RapidFullstackDemoApplication

fun main(args: Array<String>) {
    runApplication<RapidFullstackDemoApplication>(*args)
}
