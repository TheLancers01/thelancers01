//package thelancers01.project.controllers;
//
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import thelancers01.project.models.Exercise;
//import thelancers01.project.models.User;
//import thelancers01.project.models.data.ExerciseRepository;
//import thelancers01.project.models.data.UserRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("userExercises")
//public class UserExercisesController {
//
//        public static List<Exercise> exercises = new ArrayList<>();
//
//        @Autowired
//        private UserRepository userRepository;
//
//        @Autowired
//        private ExerciseRepository exerciseRepository;
//        @Autowired
//        private HttpSession httpSession;
//
//    private User getLoggedInUser() {
//        Integer userId = (Integer) httpSession.getAttribute(AuthenticationController.userSessionKey);
//        if (userId == null) {
//            return null;
//        }
//        return userRepository.findById(userId).orElse(null);
//    }
//
//
//    @GetMapping
//        public String viewUserExercises(Model model) {
//            User user = getLoggedInUser();
//            List<Exercise> userExercises = exerciseRepository.findByUser(user);
//            model.addAttribute("exercises", userExercises);
//            return "userExercises";
//        }
//
//}
//
//
//
