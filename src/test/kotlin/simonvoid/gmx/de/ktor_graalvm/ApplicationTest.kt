package simonvoid.gmx.de.ktor_graalvm

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import simonvoid.gmx.de.ktor_graalvm.plugins.configureRouting
import simonvoid.gmx.de.ktor_graalvm.plugins.configureSerialization
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("GraalVM-Ktor-Serialisation-Demo", bodyAsText())
        }
    }

//    @Test
//    fun testConversion() = testApplication {
//        application {
//            configureSerialization()
//            configureRouting()
//        }
//        client.post("/format") {
//            headers.append("Content-Type", "application/json;charset=UTF-8")
//            setBody(
//                """
//                    {
//                    ...
//                    }
//                    """.trimIndent()
//            )
//        }.apply {
//            assertEquals(HttpStatusCode.OK, status)
//            assertEquals(
//                """
//                    ...
//                    """.trimIndent(),
//                bodyAsText(),
//            )
//        }
//    }
}