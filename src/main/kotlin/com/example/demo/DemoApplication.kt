package com.example.demo

import mycompany.application.SayHi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class DemoApplication {

	@PostConstruct
	fun example(){
		SayHi().SayNameUser()
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
