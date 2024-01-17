package thelancers01.project.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thelancers01.project.models.DataPoint;
import thelancers01.project.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordsRepository extends CrudRepository<DataPoint, Integer> {

    Optional<DataPoint> findFirstByUserOrderByIdDesc(User user);

    List<DataPoint> findByUser(User loggedInUser);
}
