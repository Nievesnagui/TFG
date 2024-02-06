package net.ausiasmarch.weekeat.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    // Initialize the storage service
    void init();

    // Stores the provided file and return the stored file's name 
    String store(MultipartFile file);

    // Loads the resource (file) with the provided filename
    Resource loadAsResource(String filename);
}
