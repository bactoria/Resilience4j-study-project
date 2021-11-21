package bactoria.study.external

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController(var count:Int = 0) {
	
	
	@GetMapping("/health")
	fun health(): ResponseEntity<String> {
		log.info("log - ${++count}")
		Thread.sleep(3000)
		return ResponseEntity.ok("ok")
	}
	
	companion object {
		private val log = LoggerFactory.getLogger(this.javaClass)
	}
}
