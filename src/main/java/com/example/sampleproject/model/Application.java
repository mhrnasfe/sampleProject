package com.example.sampleproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String applicationName;
    private String companyName;
    private String description;
//    private String ipDefinition;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
