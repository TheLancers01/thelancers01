package thelancers01.project.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thelancers01.project.models.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {

}
