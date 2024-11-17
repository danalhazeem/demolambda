package com.example.demo.Service;

import com.example.demo.Processor.SuggestionProcessor;
import com.example.demo.Repository.GuestSuggestionRepository;
import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.entity.GuestSuggestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestSuggestionServiceImpl implements GuestSuggestionService{
    public GuestSuggestionRepository guestSuggestionRepository ;

    @Autowired
    public GuestSuggestionServiceImpl(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    public SuggestionProcessor processSuggestion = (suggestionText) -> {
        GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
        suggestionEntity.setRate("5");
        suggestionEntity.setSuggestionText(suggestionText);
        guestSuggestionRepository.save(suggestionEntity);
    };
    public void printAndProcessSuggestion(CreateSuggestionRequest request) {
        System.out.println("Received suggestion: " + request.getSuggestionText());
        processSuggestion.process(request.getSuggestionText());
    }
    public List<GuestSuggestionEntity> getAllSuggestions() {
        return guestSuggestionRepository.findAll();
    }

}
