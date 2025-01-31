package com.example

import com.example.Templates.base
import com.example.Templates.contactDetail
import com.example.rolodex.Contact
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        staticResources("/static", "static") {
            extensions("css")
            preCompressed(CompressedFileType.GZIP)
        }

        get("/") {
            call.respondHtml(HttpStatusCode.OK) {
                base {
                    div {
                        classes = linkedSetOf("contact-list-container")
                        ul {
                            classes = linkedSetOf("contact-list")
                            li {
                                +"Tom Red"
                            }
                            li {
                                classes = linkedSetOf("contact-list__contact--selected")
                                +"Charles Green"
                            }
                            li {
                                +"Peter Blue"
                            }
                        }
                        button {
                            classes = linkedSetOf("add-contact-button")
                            +"Add"
                        }
                    }
                    contactDetail(Contact("Charles Green", "555-55-55", "charles@example.com", "A very nice person"))
                }
            }
        }
    }
}
