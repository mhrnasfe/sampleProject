package com.example.sampleproject.service.Imp;

import com.example.sampleproject.model.Application;
import com.example.sampleproject.model.User;
import com.example.sampleproject.repository.ApplicationRepository;
import com.example.sampleproject.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationServiceImp implements ApplicationService {

    private final ApplicationRepository applicationRepository;


    @Override
    public Application createApp(Application application) {
        Application application1 = new Application();
        application1.setApplicationName(application.getApplicationName());
        application1.setCompanyName(application.getCompanyName());
//        application1.setIpDefinition(application.getIpDefinition());
        application1.setDescription(application.getDescription());
        return applicationRepository.save(application);
    }

    @Override
    public void create(Application application) {
        applicationRepository.save(application);
    }
}
