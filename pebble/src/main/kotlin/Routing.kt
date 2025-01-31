package com.example

import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

import io.ktor.server.http.content.*

fun Application.configureRouting() {
    routing {
        staticResources("/static", "static"){
            extensions("css")
            preCompressed(CompressedFileType.GZIP)
        }

        get("/") {
            call.respond(PebbleContent("index.peb", mapOf()))
        }
    }
}
