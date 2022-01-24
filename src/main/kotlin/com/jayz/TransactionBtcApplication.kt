package com.jayz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication
class TransactionBtcApplication

@PostConstruct
fun init() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
}

fun main(args: Array<String>) {
    runApplication<TransactionBtcApplication>(*args)
}

