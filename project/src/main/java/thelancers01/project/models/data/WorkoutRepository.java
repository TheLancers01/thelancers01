package thelancers01.project.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thelancers01.project.models.Workout;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Integer> {
}
