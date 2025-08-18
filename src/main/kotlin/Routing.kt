package com.yousefh

import com.yousefh.routes.PropertyRoute
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        PropertyRoute()
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
