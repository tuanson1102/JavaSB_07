package vn.techmaster.jobhunt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String showEmployerById(Model model, @PathVariable String id){
        model.addAttribute("job", jobRepo.findById(id));
        return "job";
    }
    @GetMapping(value = "/add")
    public String addJobForm(Model model){
        model.addAttribute("job", new Job());
        model.addAttribute(("city"), City.values());
        return "job_add";
    }
    
    @PostMapping(value = "/add") 
    public String save(@ModelAttribute("job") Job job, BindingResult result, Model model) {
      if (result.hasErrors()) {
        model.addAttribute("job", job);
        return "job_add";
      }
  
     if (job.getId()!="") {
         jobRepo.update(job);
     } else {
         jobRepo.addJob(job);
     }
      return "redirect:/jobs";
    }
    @GetMapping(value = "/edit/{id}")
    public String editEmployerById(@PathVariable("id") String id, Model model) {
      Optional<Job> job = jobRepo.get(id);
      if (job.isPresent()) {
        model.addAttribute("job", job.get());
        model.addAttribute("city", City.values());
      }
      return "jobs";
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteByID(@PathVariable("id") String id) {
      jobRepo.deleteByID(id);
      return "redirect:/jobs";
    }
}
