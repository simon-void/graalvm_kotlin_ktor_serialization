package simonvoid.gmx.de.ktor_graalvm.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(listOf("GraalVM-Ktor-Serialisation-Demo", "1", "2", "3"))
        }
    }
}