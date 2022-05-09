package vn.techmaster.job_hunt.respository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import vn.techmaster.job_hunt.model.Employer;
import vn.techmaster.job_hunt.model.Job;
import vn.techmaster.job_hunt.request.SearchRequest;

@Repository
public class JobRepo {
  private ConcurrentHashMap<String, Job> jobs = new ConcurrentHashMap<>();

  public Collection<Job> getAll(){
    return jobs
          .values()
          .stream()
          .sorted(Comparator.comparing(Job::getUpdate_at).reversed())
          .collect(Collectors.toList());
  }

  public Job addJob(Job job) {
    String id = UUID.randomUUID().toString();
    job.setId(id);
    job.setCreate_at(LocalDateTime.now());
    job.setUpdate_at(job.getCreate_at());
    jobs.put(id, job);
    return job;
  }

  public Job addJobForEmployer(Employer employer, Job job) {
    String id = UUID.randomUUID().toString();
    job.setId(id);
    job.setEmp_id(employer.getId());
    job.setCreate_at(LocalDateTime.now());
    job.setUpdate_at(job.getCreate_at());
    jobs.put(id, job);
    return job;
  }

  public Job findById(String id) {
    return jobs.get(id);
  }

  public Collection<Job> findByEmpId(String empId) {
    return jobs.entrySet().stream()
		.filter(x -> empId.equals(x.getValue().getEmp_id()))
		.map(x->x.getValue()).collect(Collectors.toList());
  }

  public Collection<Job> findByTitle(String title) {
    return jobs.entrySet().stream()
        .filter(x -> title.equals(x.getValue().getTitle()))
        .map(x -> x.getValue()).collect(Collectors.toList());
  }

  public Job deleteById(String id) {
    return jobs.remove(id);
  }

  public void update(Job job){
    job.setUpdate_at(LocalDateTime.now());
    jobs.put(job.getId(), job);
  }

public Collection<Job> findByKeyword(SearchRequest searchRequest) {
    return jobs
          .values()
          .stream()
          .filter(job -> job.getTitle().toLowerCase().contains(searchRequest.keywords().toLowerCase()) && job.getCity().toString().equals(searchRequest.city().toString()))
          .collect(Collectors.toList());
    
}


}
