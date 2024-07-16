package org.example.examplefinalProject.service;

import org.example.examplefinalProject.entity.Parent;
import org.example.examplefinalProject.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<Parent> findAll(){
        return parentRepository.findAll();
    }

    public Parent findById(int parentId){
        return parentRepository.findById(parentId).orElse(null);
    }
}
