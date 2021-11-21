package bactoria.study.my.external

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ByPassController(private val byPassService: ByPassService) {
	
	@GetMapping("/bypass")
	fun bypass(): String {
		return byPassService.bypass()
	}
}
