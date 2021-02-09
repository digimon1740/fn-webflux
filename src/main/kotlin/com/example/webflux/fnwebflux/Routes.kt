package com.example.webflux.fnwebflux

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route


@Configuration
class Routes {

    @Bean
    fun userRoute(handler: Handlers): RouterFunction<ServerResponse> =
        route()
            .GET("/users/{id}", handler::getUser)
            .GET("/users", handler::getAll)
            .build()
}