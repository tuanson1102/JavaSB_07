package vn.techmaster.jobhunt.reponsitory;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import vn.techmaster.jobhunt.model.City;
import vn.techmaster.jobhunt.model.Job;



@Repository
public class JobRepo {
  private ConcurrentHashMap<String, Job> jobs = new ConcurrentHashMap<>();

  public Collection<Job> getAll(){
    return jobs.values().stream().toList();
  }
  public Optional<Job> get(String id) {
    return jobs.values().stream().filter(u -> u.getId().contains(id)).findFirst();
  }
  
  public Job addJob(Job job) {
    String id = UUID.randomUUID().toString();
    job.setId(id);
    jobs.put(id, job);
    return job;
  }
  

  public Job findById(String id) {
    return jobs.get(id);
  }

  // public Job deleteById(String id) {
  //   return jobs.remove(id);
  // }

  // public void update(Job job){
  //   jobs.put(job.getId(), job);
  // }

  public void update(Job job) {
    get(job.getId()).ifPresent(existjob -> {
      existjob.setName(job.getName());
      existjob.setCity(job.getCity());
      existjob.setTitle(job.getTitle());
      existjob.setDescription(job.getDescription());
      existjob.setCompany(job.getCompany());
    });
  }

  public void deleteByID(String id) {
    get(id).ifPresent(existemployer -> jobs.remove(id));
  }

  public void delete(Job job) {
    deleteByID(job.getId());
  }
}