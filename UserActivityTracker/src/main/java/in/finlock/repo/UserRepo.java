package in.finlock.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.finlock.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, String> {

}
