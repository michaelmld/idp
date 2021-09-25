package com.michael.idp

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import java.util.*


@SpringBootApplication
class IdpApplication {

	@Bean
	fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner? {
		return CommandLineRunner {
			println("Let's inspect the beans provided by Spring Boot:")
			val beanNames: Array<String> = ctx.getBeanDefinitionNames()
			Arrays.sort(beanNames)
			for (beanName in beanNames) {
//				println(beanName)
			}
		}
	}
}

//An entry point to a Kotlin application is the main function.
fun main(args: Array<String>) {
	runApplication<IdpApplication>(*args)
}