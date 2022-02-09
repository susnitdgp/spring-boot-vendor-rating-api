package in.co.ntpc.pradip.VendorRating.VendorRatingAPI;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

    @GetMapping("/v1/GetEmployee")
	public String GetEmployee() {
		return "Get Employee List Oauth2";
	}


}