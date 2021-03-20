package com.example.webflux.fnwebflux.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration
class Route1 {

    @Bean
    fun route(): RouterFunction<ServerResponse> =
        RouterFunctions.route()
            .GET("/hello") {
                ServerResponse.ok().bodyValue("Hello World")
            }
            .GET("/hello/{name}") {
                val message = "Hello ${it.pathVariable("name")}"
                ServerResponse.ok().bodyValue(message)
            }
            .build()
}