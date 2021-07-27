package br.com.sub.angelo

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.sub.angelo")
		.start()
}

