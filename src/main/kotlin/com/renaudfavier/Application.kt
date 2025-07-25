package com.renaudfavier

import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.Micronaut.run

fun main(args: Array<String>) {
	run(*args)
}

//fun main(args: Array<String>) {
//	Micronaut.build()
//		.packages("com.renaudfavier")
//		.mainClass(Application::class.java)
//		.start()
//}
//
//class Application
