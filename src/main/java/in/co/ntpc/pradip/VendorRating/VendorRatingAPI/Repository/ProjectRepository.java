package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Repository;

import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectDetails, Integer> {


}
