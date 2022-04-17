package vn.techmaster.jobhunt.request;

import org.springframework.web.multipart.MultipartFile;

public record EmployerRequest(String id, String name, String website ,String email,MultipartFile logo) {
    
}
