package thelancers01.project.controllers;

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

@Controller
@RequestMapping("/records")
public class RecordsController {

    @Autowired
    private RecordsRepository recordsRepository;

    @Autowired
    private UserRepository userRepository; // To fetch the logged-in user

    @GetMapping("/view")
    public String displayRecords(Model model) {
        User loggedInUser = getLoggedInUser();
        DataPoint currentRecord = recordsRepository.findFirstByUserOrderByIdDesc(loggedInUser)
                .orElseGet(() -> {
                    DataPoint newDataPoint = new DataPoint();
                    newDataPoint.setUser(loggedInUser);
                    return newDataPoint;
                });
        model.addAttribute("currentRecord", currentRecord);
        return "records/view";
    }

    @PostMapping("/save")
    public String saveRecord(@ModelAttribute("currentRecord") DataPoint currentRecord, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Invalid data");
            return "records/view";
        }

        DataPoint existingRecord = null;
        if (currentRecord.getId() != null) {
            existingRecord = recordsRepository.findById(currentRecord.getId()).orElse(null);
        }
        if (existingRecord != null) {
            existingRecord.updateFields(currentRecord);
            recordsRepository.save(existingRecord);
        } else {
            User loggedInUser = getLoggedInUser();
            currentRecord.setUser(loggedInUser);
            recordsRepository.save(currentRecord);
        }

        return "redirect:/records/view";
    }
    private User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return userRepository.findByUsername(authentication.getName());
    }
}
