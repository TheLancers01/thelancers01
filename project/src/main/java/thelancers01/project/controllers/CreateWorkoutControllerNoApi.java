package thelancers01.project.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


import thelancers01.project.models.Exercise;
import thelancers01.project.models.Workout;
import thelancers01.project.models.data.ExerciseRepository;
import thelancers01.project.models.data.WorkoutRepository;

@Controller
public class CreateWorkoutControllerNoApi {



        public static List<Exercise> exercises = new ArrayList<>();

        @Autowired
        private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutRepository workoutRepository;
    @RequestMapping("workouts")
    public String viewAllWorkouts(Model model){

        model.addAttribute("workouts", workoutRepository.findAll());
        return "workouts";
    }

        @GetMapping("create/workout")
        public String ViewCreateAnExercise(Model model) {

            model.addAttribute(new Workout());
            return "create/workout";
        }


        @PostMapping("create/workout")
        public String submitForm(@ModelAttribute @Valid Workout newWorkout, Model model) {

            workoutRepository.save(newWorkout);


            return "redirect:/workouts";
        }


}
