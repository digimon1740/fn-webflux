package com.example.webflux.fnwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class FnWebfluxApplication

fun main(args: Array<String>) {
	runApplication<FnWebfluxApplication>(*args)
}
