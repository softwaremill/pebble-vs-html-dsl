package com.example

import com.example.rolodex.Contact
import kotlinx.html.*

object Templates {
    fun HTML.base(content: FlowContent.() -> Unit) {
        lang = "en"
        attributes["data-theme"] = "light"

        head {
            link {
                href = "https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
                rel = "stylesheet"
            }
            link {
                href = "/static/css/main.css"
                rel = "stylesheet"
            }
            meta {
                charset = "UTF-8"
            }
            title { +"Rolodex 2000" }
        }

        body {
            main {
                classes = linkedSetOf("container")
                content()
            }
        }
    }

    fun FlowContent.contactDetail(contact: Contact) {
        article {
            classes = linkedSetOf("contact")
            h2 {

                classes = linkedSetOf("contact__name")
                +contact.name
            }
            table {
                tbody {
                    classes = linkedSetOf("contact__info")
                }
                tr {
                    th {
                        scope = ThScope.row
                        +"Phone number:"
                    }
                    td {
                        +contact.phone
                    }
                }
                tr {
                    th {
                        scope = ThScope.row
                        +"E-mail:"
                    }
                    td {
                        +contact.email
                    }
                }
            }
            section {
                classes = linkedSetOf("contact__note")
                h5 {
                    +"Note:"
                }
                p {
                    +contact.note
                }
            }
            button {
                classes = linkedSetOf("place-on-left")
                +"Edit"
            }
        }
    }
}
