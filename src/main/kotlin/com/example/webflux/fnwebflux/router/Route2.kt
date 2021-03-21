package com.example.webflux.fnwebflux.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration
class Route2 {

    @Bean
    fun predicateRoute(): RouterFunction<ServerResponse> =
        RouterFunctions.route()
            .GET("/hi", {
                val userId = it.headers().firstHeader("x-user-id")
                userId == "tony"
            }) {
                ServerResponse.ok().bodyValue("Hi Tony")
            }
            .GET("/hi") {
                ServerResponse.ok().bodyValue("Hi")
            }
            .build()
}