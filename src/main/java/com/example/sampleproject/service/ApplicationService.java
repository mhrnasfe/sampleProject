package com.example.sampleproject.service;

import com.example.sampleproject.model.Application;

public interface ApplicationService {
    Application createApp(Application application);

    void create(Application newEntity);
}
