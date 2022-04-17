package vn.techmaster.jobhunt.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.techmaster.jobhunt.exception.StorageException;

@Service

public class StorageService {
    @Value("${upload.path")
    private String path;
    public String saveFile(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            throw new StorageException("Failed to store empty file");
        }
        return file.getOriginalFilename();
    }
}
