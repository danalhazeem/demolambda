package com.example.demo.Controller;

import com.example.demo.Service.GuestSuggestionServiceImpl;
import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.entity.GuestSuggestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuggestionController {
    private final GuestSuggestionServiceImpl guestSuggestionService;


    @Autowired
    public SuggestionController(GuestSuggestionServiceImpl guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }

    @PostMapping("/addSuggestion")
    public ResponseEntity<String> addSuggestion(@RequestBody CreateSuggestionRequest suggestionText){
        guestSuggestionService.printAndProcessSuggestion(suggestionText);
        return ResponseEntity.ok("Suggestion processed successfully.");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<GuestSuggestionEntity>> getAllSuggestions() {
        List<GuestSuggestionEntity> suggestions = guestSuggestionService.getAllSuggestions();
        return ResponseEntity.ok(suggestions);
    }

    @GetMapping("/create")
    public ResponseEntity<List<GuestSuggestionEntity>> getCreatedSuggestions(){
        List<GuestSuggestionEntity> suggestions= guestSuggestionService.findAllCreatedSuggestions();
        return ResponseEntity.ok(suggestions);
    }

    @GetMapping("/remove")
    public ResponseEntity<List<GuestSuggestionEntity>> getRemoveSuggestions(){
        List<GuestSuggestionEntity> suggestions= guestSuggestionService.findAllRemovedSuggestions();
        return ResponseEntity.ok(suggestions);
    }


    @GetMapping("/duplicate")
    public ResponseEntity<List<GuestSuggestionEntity>> getUniqueSuggestions(){
        List<GuestSuggestionEntity> suggestions= guestSuggestionService.findAllSuggestions();
        return ResponseEntity.ok(suggestions);
    }

}
