package simonvoid.gmx.de.ktor_graalvm.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("GraalVM-Ktor-Serialisation-Demo")
        }
//        post("/format") {
//            val incomingOpeningTimes = call.receive<Map<String, List<IncomingOpeningTime>>>()
//            ...
//            // return a string representation of the final representation
//            call.respondText(openPeriodsByDay.prettyPrint(), status = HttpStatusCode.OK)
//        }
    }
}