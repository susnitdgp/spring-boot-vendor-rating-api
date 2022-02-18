package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Controller;

import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception.ProjectNotFoundException;

import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Model.Employee;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Service.ProjectService;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain.ProjectDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ProjectService projectService;

	@GetMapping("/")
	@CrossOrigin(origins = "https://react-7cuyla.stackblitz.io/")
	public List<Employee> listProject() {

		log.info("URL / Called");
		ProjectDetails project = projectService.getProject(1);

		List<ProjectDetails> lsk=projectService.getAll();

	
		log.info("Project:" + project.getAmount() + project.getStartdate().toString());


		List<Employee> lsm=new ArrayList<Employee>();

		Employee emp=new Employee();
		emp.setKey("1");
		emp.setName(project.getName());
		emp.setRole(project.getDescription());
		emp.setDept("IT-ECM");
		emp.setPlant("EOC-Noida");


		lsm.add(emp);

		return lsm;
	}

    @GetMapping("/v1/GetEmployee")
	@CrossOrigin(origins = "https://react-7cuyla.stackblitz.io/")
	public ResponseEntity<String> GetEmployee() {

		return new ResponseEntity<String>("Get Employee List Oauth2", HttpStatus.OK);
	}

	@GetMapping("/v1/ExceptionTest")
	@CrossOrigin(origins = "https://react-7cuyla.stackblitz.io/")
	public String createException(){
		throw new ProjectNotFoundException();
	}

	@PostMapping("/v1/saveProject")
	@CrossOrigin
	public ResponseEntity<ProjectDetails> saveProject(@RequestBody ProjectDetails details){
		log.info("URL /v1/saveProject Called");
		log.trace("TRace Check");
		//return projectService.saveProjectWithoutExceptionHandling(details);

		ProjectDetails project=projectService.saveProject(details);
		return new ResponseEntity<ProjectDetails>(project,HttpStatus.OK);

	}


}