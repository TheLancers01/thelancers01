package thelancers01.project.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import thelancers01.project.models.Exercise;
import thelancers01.project.models.Workout;
import thelancers01.project.models.data.ExerciseRepository;
import thelancers01.project.models.data.WorkoutRepository;

@Controller
@RequestMapping("workouts")
public class WorkoutController {



        public static List<Exercise> exercises = new ArrayList<>();

        @Autowired
        private ExerciseRepository exerciseRepository;

        @Autowired
        private WorkoutRepository workoutRepository;
        @RequestMapping("index")
         public String viewAllWorkouts(Model model){

        model.addAttribute("workouts", workoutRepository.findAll());
        return "workouts/index";
    }

        @GetMapping("create")
        public String ViewCreateAnExercise(Model model) {

            model.addAttribute(new Workout());
            return "workouts/create";
        }


        @PostMapping("create")
        public String submitForm(@ModelAttribute @Valid Workout newWorkout, Model model) {

            workoutRepository.save(newWorkout);


            return "redirect:/workouts/index";
        }

        @GetMapping("view/{workoutId}")
    public String displayViewWorkout(Model model, @PathVariable int workoutId){

            Optional<Workout> optionalWorkout = workoutRepository.findById(workoutId);
            if (optionalWorkout.isPresent()){
                Workout workout = (Workout) optionalWorkout.get();
                model.addAttribute("workout", workout);
                return "workouts/view";
            }else {
                return "redirect:../";
            }
        }


}
