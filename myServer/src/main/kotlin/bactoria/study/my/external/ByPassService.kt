package bactoria.study.my.external

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient




@Service
class ByPassService(private val externalApi: ExternalApi) {

	@CircuitBreaker(
		name = "bactoriaccc",
		fallbackMethod = "bypassFallback"
	)
	fun bypass(): String {
		return externalApi.externalHealth()
	}
	
	private fun bypassFallback(e: RuntimeException): String {
		return "bypassFallback - error"
	}
}
