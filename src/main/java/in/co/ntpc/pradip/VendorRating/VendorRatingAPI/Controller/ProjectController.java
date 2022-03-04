package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Controller;


import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain.Jsonpo;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.DatatypeConverter;

@RestController
public class ProjectController {

    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectService projectService;

    @GetMapping("/v1/sendSms")
    public String smsSender(){

        log.info("JSON Service called");
       // return projectService.smsSender();
        Jsonpo temp= projectService .getJonData(105);

       // String base64Encoded = DatatypeConverter.printBase64Binary(temp.getData());
        //byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64Encoded);
        //System.out.println(new String(base64Decoded));


        //log.info(temp.getData().toString());

        return "JSON Data Success";

    }

}
