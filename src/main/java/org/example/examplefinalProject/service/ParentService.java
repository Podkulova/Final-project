package org.example.examplefinalProject.service;

import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.Parent;
import org.example.examplefinalProject.exception.InvalidStatusException;
import org.example.examplefinalProject.exception.ParentNotFoundExeption;
import org.example.examplefinalProject.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ParentService {
    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<Parent> findAll(){
        return parentRepository.findAll();
    }

    public Parent findById(int id){
        return parentRepository.findById(id).orElse(null);
    }

    public void delete(Integer parentId){
        Parent parentName = parentRepository.findById(parentId)
                .orElseThrow(() -> new ParentNotFoundExeption(String.format("Parent with id: %d was not fount", parentId)));
        if (parentName.isDone()) {
            parentRepository.deleteById(parentId);
            log.warn(String.format("Parent with id %d has been deleted", parentId));
        } else {
            throw new InvalidStatusException(String.format("This parent with name '%s' has invalid state: '%s'", parentName.getParentName(), parentName.isDone()));
        }
    }
/*    Parent parent = new Parent();
public void deleteParent(){
    if (!parent.isDone()){
        parent.remove(0);
        }
    }*/
}
