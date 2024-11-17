package com.example.demo.bo;

public class CreateSuggestionRequest {
    private String rate;
    private String suggestionText;

    public CreateSuggestionRequest () {
        // Default constructor
    }
    public CreateSuggestionRequest (String rate,String suggestionText) {
        this.rate = rate;
        this.suggestionText=suggestionText;
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
