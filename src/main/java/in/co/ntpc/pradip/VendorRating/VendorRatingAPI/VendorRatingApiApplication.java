package in.co.ntpc.pradip.VendorRating.VendorRatingAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class VendorRatingApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(VendorRatingApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		return builder
				.setConnectTimeout(Duration.ofMillis(30000))
				.setReadTimeout(Duration.ofMillis(30000))
				.build();
	}

}
