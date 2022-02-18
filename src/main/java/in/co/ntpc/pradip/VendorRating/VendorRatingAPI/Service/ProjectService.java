package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Service;


import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception.InsertException;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Exception.ProjectNotFoundException;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Repository.ProjectRepository;
import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain.ProjectDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Transactional
    public List<ProjectDetails> getAll(){

        //projectRepository.existsById();

        return projectRepository.findAll();

    }

    @Transactional
    public ProjectDetails getProject(Integer id){
        return projectRepository.findById(id).
                orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
    }

    @Transactional
    public ProjectDetails saveProject(ProjectDetails details){
        try{

            return projectRepository.save(details);

        }catch(RuntimeException ex){

            throw new InsertException(ex.getMessage());
        }

    }

    @Transactional
    public ProjectDetails saveProjectWithoutExceptionHandling(ProjectDetails details){

            return projectRepository.save(details);

    }

}
