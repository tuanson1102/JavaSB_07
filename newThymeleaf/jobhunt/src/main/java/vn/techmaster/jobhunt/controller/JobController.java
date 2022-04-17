package vn.techmaster.jobhunt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.jobhunt.model.City;
import vn.techmaster.jobhunt.model.Job;
import vn.techmaster.jobhunt.reponsitory.JobRepo;
import vn.techmaster.jobhunt.request.JobRequest;

@Controller
@RequestMapping(value = "/job")
public class JobController {
    @Autowired JobRepo jobRepo;
    @GetMapping
    public String listAllJobs(Model model){
        model.addAttribute("jobs", jobRepo.getAll());
        return "jobs";
    }
    @GetMapping(value = "/{id}")
    public String JobById(Model model, @PathVariable String id){
        model.addAttribute("job", jobRepo.findById(id));
        return "job";
    }
    @GetMapping(value = "/add")
    public String addJob(Model model) {
        model.addAttribute("job", new Job());
        return "job_add";
    }

    @PostMapping(value = "/add")
    public String addJob(@ModelAttribute Job request, BindingResult bindingResult, Model model) {
        Job newJob = jobRepo.addJob(Job.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .city(request.getCity())
                .build());
        if (!bindingResult.hasErrors()) {

            return "redirect:/job";
        }
        return "job_add";

    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable String id) {
        return "redirect:/job";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployerByID(@PathVariable String id) {
        Job job = jobRepo.deleteById(id);
        return "redirect:/job";
    }
}
