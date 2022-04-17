package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.jobhunt.reponsitory.EmployerRepo;
import vn.techmaster.jobhunt.request.EmployerRequest;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {
    @Autowired private EmployerRepo employerRepo;
    @GetMapping
    public String listAllEmployers(Model model){
        model.addAttribute("employers", employerRepo.getAll());
        return "employers";
    }
    @GetMapping(value = "/{id}")
    public String showEmployerById(Model model, @PathVariable String id){
        model.addAttribute("employer", employerRepo.findById(id));
        return "employer";
    }
    @GetMapping(value = "/add")
    public String addEmployerForm(Model model){
        model.addAttribute("employer", new EmployerRequest("","","","", null));
        return "employer_add";
    }
    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public String addEmployer(@ModelAttribute EmployerRequest employerRequest, BindingResult result){
        if(result.hasErrors()){
            return "employer_add";
        }
        return "redirect:/employers";
    }
}
