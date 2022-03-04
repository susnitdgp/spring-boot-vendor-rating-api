package in.co.ntpc.pradip.VendorRating.VendorRatingAPI;

import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Controller.ProjectController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VendorRatingApiApplicationTests {

	@Autowired
	private ProjectController projectController;

	@Test
	void contextLoads() {

		assertThat(projectController).isNotNull();

    }

}
