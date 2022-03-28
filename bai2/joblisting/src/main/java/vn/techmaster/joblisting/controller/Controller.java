package vn.techmaster.joblisting.controller;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.apache.el.util.ConcurrentCache;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.joblisting.dto.JobRequest;
import vn.techmaster.joblisting.model.Job;

@RestController
@RequestMapping("/job")
public class Controller {
    private ConcurrentHashMap<String, Job> jobs;
    public Controller(){
       jobs = new ConcurrentHashMap<>();
       jobs.put("1", new Job("1", "CODE JAVA", "ASCSACA", "hà nội", 3000000,  15000000 , "acb@gmail.com")); 
       jobs.put("2", new Job("2", "CODE PHP", "AasdwsCA", "hà nội", 2000000,  10000000 , "abc@gmail.com")); 
       jobs.put("3", new Job("3", "Thiết kế", "thiết kể thời trang", "đà nẵng", 7000000,  12000000 , "abc@gmail.com")); 
       jobs.put("4", new Job("4", "Thiết kế", "thiết kê đồ họa", "HCM", 9000000,  20000000 , "abc@gmail.com")); 
       jobs.put("5", new Job("5", "Văn phòng", "kế toán", "HCM", 5000000,  8000000 , "abc@gmail.com")); 
    }
    @GetMapping
    public List<Job> getJobs(){
        return jobs.values().stream().toList();
    }
    @PostMapping
    public Job createJob(@RequestBody JobRequest jobRequest){
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid, jobRequest.title(), jobRequest.description(), jobRequest.location(), jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email_to());
        jobs.put(uuid, newJob);
        return newJob;
    }
    @GetMapping(value="/id")
    public Job getJobByID(@PathParam("id") String id){
        return jobs.get(id);
    }
    @PutMapping(value="/id")
    public Job updateJobByID(@PathParam("id") String id,@RequestBody JobRequest jobRequest){
        Job updateJob = new Job(id, jobRequest.title(), jobRequest.description(), jobRequest.location(), jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email_to());
        return updateJob;
    }
    @DeleteMapping(value="/id")
    public Job deleteBookById(@PathVariable("id") String id){
        Job removeJob = jobs.remove(id);
        return removeJob;
    }
    
    @GetMapping(value="/sortbysalary")
    public List<Job> getJobsByTitle(){
        return jobs.values().stream()
    .sorted(Comparator.comparing(Job::getTitle))
    .collect(Collectors.toList());
    }
    // .filter(p -> ((List<Job>) p).contains("hà nội"))

}
