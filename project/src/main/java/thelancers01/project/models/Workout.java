package thelancers01.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Workout {


    @Id
    @GeneratedValue
    private int id;
    public static String name;
    private static int nextId = 1;
    private String workoutName;
    private String workoutType;
    private String targetMuscles;
    private String workoutDescription;
    //private List<Exercise> exerciseList = new ArrayList<>();


    public Workout(int id, String workoutName, String workoutType, String targetMuscles, String workoutDescription, List exerciseList) {
        this.id = id;
        this.workoutName = workoutName;
        this.workoutType = workoutType;
        this.targetMuscles = targetMuscles;
        this.workoutDescription = workoutDescription;
       // this.exerciseList = exerciseList;
    }

    public Workout (){};
    public int getId() {
        return id;
    }

    public String getName() {
        return workoutName;
    }

    public void setName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public String getTargetMuscles() {
        return targetMuscles;
    }

    public void setTargetMuscles(String targetMuscles) {
        this.targetMuscles = targetMuscles;
    }

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public void setWorkoutDescription(String workoutDescription) {
        this.workoutDescription = workoutDescription;
    }

//    public List<Exercise> getExerciseList() {
//        return exerciseList;
//    }

//    public void setExerciseList(List<Exercise> exerciseList) {
//        this.exerciseList = exerciseList;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return id == workout.id;
    }
}