package com.example.demo.Service;

import com.example.demo.Processor.SuggestionProcessor;
import com.example.demo.Repository.GuestSuggestionRepository;
import com.example.demo.entity.SuggestionStatus;
import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.entity.GuestSuggestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionServiceImpl implements GuestSuggestionService{
    public GuestSuggestionRepository guestSuggestionRepository ;

    @Autowired
    public GuestSuggestionServiceImpl(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    public SuggestionProcessor processSuggestion = (suggestionText, status) -> {
        GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
        suggestionEntity.setRate(5);
        suggestionEntity.setStatus(status);
        suggestionEntity.setSuggestionText(suggestionText);
        guestSuggestionRepository.save(suggestionEntity);
    };
    public void printAndProcessSuggestion(CreateSuggestionRequest request) {
        System.out.println("Received suggestion: " + request.getSuggestionText());
        processSuggestion.process(request.getSuggestionText(),request.getStatus());
    }
    public List<GuestSuggestionEntity> getAllSuggestions() {
        return guestSuggestionRepository.findAll();
    }

    public List<GuestSuggestionEntity> findAllCreatedSuggestions(){
        return guestSuggestionRepository.findAll().stream().filter(suggestion->suggestion.getStatus()== SuggestionStatus.CREATE).collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> findAllRemovedSuggestions(){
        return guestSuggestionRepository.findAll().stream().filter(suggestion->suggestion.getStatus()== SuggestionStatus.REMOVE).collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> findAllSuggestions(){
        return guestSuggestionRepository.findAll().stream().distinct()
                .collect(Collectors.toList());
    }
}
