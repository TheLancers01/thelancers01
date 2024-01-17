package thelancers01.project.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import thelancers01.project.models.Exercise;
import thelancers01.project.models.User;
import thelancers01.project.models.data.ExerciseRepository;
import thelancers01.project.models.data.UserRepository;


@Controller
@RequestMapping("exercise")
public class CreateExerciseController {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private HttpSession httpSession;

    private User getLoggedInUser() {
        Integer userId = (Integer) httpSession.getAttribute(AuthenticationController.userSessionKey);
        if (userId == null) {
            return null;
        }
        return userRepository.findById(userId).orElse(null);
    }


    @GetMapping("create")
    public String displayCreateExerciseForm(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "/exercise/create";
    }
    @PostMapping("create")
    @Transactional
    public String submitForm(@ModelAttribute @Valid Exercise exercise, Model model) {
        User user = getLoggedInUser();
        if (user != null) {
            exercise.setUser(user);
            exerciseRepository.save(exercise);

        }
        return "redirect:/userExercises";
    }


}