package com.example.webflux.fnwebflux

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

class User(val id: String)

@Component
class Handlers {

    val users = listOf(
        User(id = "user1@gmail.com"),
        User(id = "user2@gmail.com")
    )

    fun getUser(request: ServerRequest): Mono<ServerResponse> =
        users.find { request.pathVariable("id") == it.id }
            ?.let {
                val body = BodyInserters.fromValue(Mono.just(it))
                ServerResponse.ok().body(body)
            }
            ?: ServerResponse.notFound().build()

    fun getAll(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().body(BodyInserters.fromValue(Mono.just(users)))
}