package thelancers01.project.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import thelancers01.project.models.DataPoint;
import thelancers01.project.models.User;
import thelancers01.project.models.data.RecordsRepository;
import thelancers01.project.models.data.UserRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/records")
public class RecordsController {

    @Autowired
    private RecordsRepository recordsRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/view")
    public String displayRecords(Model model) {
        User loggedInUser = getLoggedInUser();
        List<DataPoint> records = recordsRepository.findByUser(loggedInUser);
        DataPoint currentRecord = records.isEmpty() ? new DataPoint() : records.get(0);
        model.addAttribute("currentRecord", currentRecord);
        return "records/view";
    }


            @PostMapping("/save")
    public String saveRecord(@ModelAttribute("currentRecord") DataPoint currentRecord, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Invalid data");
            return "records/view";
        }

        User loggedInUser = getLoggedInUser();
        if (loggedInUser != null) {
            currentRecord.setUser(loggedInUser);
        }

        recordsRepository.save(currentRecord);

        return "redirect:/records/view";
    }

    private User getLoggedInUser() {
        Integer userId = (Integer) httpSession.getAttribute(AuthenticationController.userSessionKey);
        if (userId == null) {
            return null;
        }
        return userRepository.findById(userId).orElse(null);
    }

}
