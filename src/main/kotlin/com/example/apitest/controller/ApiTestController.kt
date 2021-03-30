package com.example.apitest.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class ApiTestController {

	@GetMapping("/timeout")
	fun timeoutTest(): String {
		println("Timout Test Start")
		Thread.sleep(300 * 1000) // 300초(5분) sleep
		return "End"
	}

	@GetMapping("/get")
	fun getTest(
		@RequestHeader header1: String,
		@RequestHeader header2: String,
		@RequestParam id: String,
		@RequestParam pw: Int): ResponseEntity<Map<String, Any>> {

		println("GET")
		println("$header1, $header2")
		println("$id, $pw")

		return ResponseEntity.ok()
			.body(mapOf(
				"status" to true,
				"msg" to "hello"
			))
	}

	@PostMapping("/post")
	fun postTest(
		@RequestHeader header1: String,
		@RequestHeader header2: String,
		@RequestParam id: String,
		@RequestParam pw: Int,
		@RequestBody body: Map<String, Any>): ResponseEntity<Map<String, Any>> {

		println("POST")
		println("Headers: $header1, $header2")
		println("Params: $id, $pw")

		for ((key, value) in body.entries) {
			println("    $key, $value")
		}

		return ResponseEntity.ok()
			.body(mapOf(
				"status" to true,
				"msg" to "hello"
			))
	}

	@PutMapping("/put")
	fun putTest(
		@RequestHeader header1: String,
		@RequestHeader header2: String,
		@RequestParam id: String,
		@RequestParam pw: Int,
		@RequestParam key1: String,
		@RequestParam key2: Int
	): ResponseEntity<Map<String, Any>> {

		println("PUT")
		println("$header1, $header2")
		println("$id, $pw")
		println("$key1, $key2")

		return ResponseEntity.ok()
			.body(mapOf(
				"status" to true,
				"msg" to "hello"
			))
	}

	@DeleteMapping("/delete")
	fun deleteTest(
		@RequestHeader header1: String,
		@RequestHeader header2: String,
		@RequestParam id: String,
		@RequestParam pw: Int): ResponseEntity<Map<String, Any>> {

		println("DELETE")
		println("$header1, $header2")
		println("$id, $pw")

		return ResponseEntity.ok()
			.body(mapOf(
				"status" to true,
				"msg" to "hello"
			))
	}

	@GetMapping("/forgit")
	fun forGit(): String {
		return "H1asdfasdffdo"
	}
}