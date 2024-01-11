package thelancers01.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thelancers01.project.models.DataPoint;
import thelancers01.project.models.data.RecordsRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/records")
public class RecordsController {

    @Autowired
    private RecordsRepository recordsRepository;

    @GetMapping("view")
    public String displayRecords(Model model) {
        DataPoint currentRecord = recordsRepository.findById(1).orElse(new DataPoint());
        model.addAttribute("currentRecord", currentRecord);
        return "records/view";
    }

    @PostMapping("/update-mile-time")
    public String updateMileTime(@RequestParam String newMileTime, Model model) {
        return "redirect:/records/view";
    }

    @PostMapping("/update-bench-press")
    public String updateBenchPress(@RequestParam int newBenchPress, Model model) {
        return "redirect:/records/view";
    }

    @PostMapping("/update-squat")
    public String updateSquat(@RequestParam int newSquat, Model model) {
        return "redirect:/records/view";
    }

    @PostMapping("/update-max-push-ups")
    public String updateMaxPushUps(@RequestParam int newMaxPushUps, Model model) {
        return "redirect:/records/view";
    }

    @PostMapping("/update-max-sit-ups")
    public String updateMaxSitUps(@RequestParam int newMaxSitUps, Model model) {
        return "redirect:/records/view";
    }

    @PostMapping("/update-calories-burned")
    public String updateCaloriesBurned(@RequestParam int newCaloriesBurned, Model model) {
        return "redirect:/records/view";
    }
}

