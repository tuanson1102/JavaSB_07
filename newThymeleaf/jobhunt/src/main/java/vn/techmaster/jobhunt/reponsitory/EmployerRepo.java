package vn.techmaster.jobhunt.reponsitory;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;
import org.springframework.stereotype.Repository;

import vn.techmaster.jobhunt.model.Employer;

@Repository
public class EmployerRepo {
    private ConcurrentHashMap<String, Employer> employers = new ConcurrentHashMap<>();
    public EmployerRepo(){

    }

    //Cần sinh UUID ở đây
    public Employer add(Employer employer){
        String id = UUID.randomUUID().toString();
        employer.setId(id);
        employers.put(id, employer);
        return employer;
    }
    public Collection<Employer>getAll(){
        return employers.values();
    }
    public Employer findById(String id){
        return employers.get(id);
    }
    @PostConstruct
	public void addSomeData() {
		this.add(Employer.builder()
        .name("FPT")
        .website("http://fpt.com.vn")
        .logo_path("fpt.png")
        .email("@fpt.com")
        .build());
		
        
        this.add(Employer.builder()
        .name("CMC")
        .website("http://cmc.com.vn")
        .logo_path("cmc.png")
        .email("@cmc.com")
        .build());

        this.add(Employer.builder()
        .name("Amazon")
        .website("https://amazon.com")
        .logo_path("amazon.png")
        .email("@amazon.com")
        .build());

        this.add(Employer.builder()
        .name("Google")
        .website("https://google.com")
        .logo_path("google.png")
        .email("@google.com")
        .build());
	}
}
