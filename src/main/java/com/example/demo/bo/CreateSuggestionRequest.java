package com.example.demo.bo;

import com.example.demo.entity.SuggestionStatus;

public class CreateSuggestionRequest {
    private String rate;
    private String suggestionText;
    private SuggestionStatus status;

    public CreateSuggestionRequest () {
        // Default constructor
    }
    public CreateSuggestionRequest (String rate,String suggestionText,SuggestionStatus status) {
        this.rate = rate;
        this.suggestionText=suggestionText;
        this.status=status;

    }

    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }
}
