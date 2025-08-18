package com.yousefh

import com.yousefh.database.MongoConnection
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val database = MongoConnection.getDatabase()
    println("Database connected: ${database.name}")

    configureSerialization()
    configureRouting()
}
