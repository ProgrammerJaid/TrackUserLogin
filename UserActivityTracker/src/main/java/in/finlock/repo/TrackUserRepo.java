package in.finlock.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.finlock.entity.UserTrackDetail;

@Repository
public interface TrackUserRepo extends CrudRepository<UserTrackDetail, String> {

	Optional<List<UserTrackDetail>> findByUsername(String username);
	
}
