package in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Repository;

import in.co.ntpc.pradip.VendorRating.VendorRatingAPI.Domain.Jsonpo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonRepository extends JpaRepository<Jsonpo, Integer> {

}
