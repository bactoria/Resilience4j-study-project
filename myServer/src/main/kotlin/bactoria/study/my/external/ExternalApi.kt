package bactoria.study.my.external

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.time.Duration

@Component
class ExternalApi {

	fun externalHealth(): String {
		return webClientBuilder.build().get()
			.uri("/health")
			.retrieve()
			.bodyToMono(String::class.java)
			.timeout(Duration.ofMillis(1000))
//			.onErrorReturn("error")
			.block()!!
	}

	companion object {
		private const val externalHost = "http://localhost:9090"
		val webClientBuilder = WebClient.builder().baseUrl(externalHost)
	}
}
