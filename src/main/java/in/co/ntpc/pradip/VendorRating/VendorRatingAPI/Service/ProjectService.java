package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Service;


import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain.Jsonpo;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception.CustomException;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Repository.JsonRepository;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Repository.ProjectRepository;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain.ProjectDetails;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProjectService {

    private static final Logger log = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    JsonRepository jsonRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    public List<ProjectDetails> getAll(){

        //projectRepository.existsById();

        return projectRepository.findAll();

    }

    @Transactional
    public ProjectDetails getProject(Integer id){
        return projectRepository.findById(id).
                orElseThrow(() -> new CustomException("Project Not Found"));
    }

    @Transactional
    public ProjectDetails saveProject(ProjectDetails details){
        try{

            return projectRepository.save(details);

        }catch(RuntimeException ex){

            throw new CustomException(ex.getMessage());
        }

    }

    @Transactional
    public ProjectDetails saveProjectWithoutExceptionHandling(ProjectDetails details){

            return projectRepository.save(details);

    }

    @Transactional
    public Jsonpo getJonData(int id){

        try{

            Jsonpo temp=jsonRepository.findById(id).
                    orElseThrow(() -> new CustomException("ID Not Found"));

            return temp;

        }catch(RuntimeException ex){

            throw new CustomException(ex.getMessage());
        }

    }

    @Retry(name = "smsSender",fallbackMethod = "localSmsSender")
    public String smsSender(){
        log.info("Making Request: " );
        restTemplate.getForEntity("http://10.3.0.110",String.class);
        return "SUCCESS-ORIGINAL";
    }
    //Fallback
    public String localSmsSender(Exception ex) {
        return "SUCCESS-FALLBACK:" + ex.getMessage();
    }

    @RateLimiter(name = "basic_rate_limiter",fallbackMethod = "localRateCheck")
    public String rateCheck(){

                return "SUCCESS-RATE-CHECK";
    }
    //Fallback
    public String localRateCheck(Exception ex){
        return "FALLBACK-RATE-CHECK:" + ex.getMessage();
    }

}
