package simonvoid.gmx.de.ktor_graalvm

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import simonvoid.gmx.de.ktor_graalvm.plugins.configureRouting
import simonvoid.gmx.de.ktor_graalvm.plugins.configureSerialization


fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}