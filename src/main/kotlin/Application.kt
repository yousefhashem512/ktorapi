package com.yousefh

import com.yousefh.database.MongoConnection
import io.ktor.server.application.*

fun main(args: Array<String>) {
    val database = MongoConnection.getDatabase()
    println("Database connected: ${database.name}")

    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
