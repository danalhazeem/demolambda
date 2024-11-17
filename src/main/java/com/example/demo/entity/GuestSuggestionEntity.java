package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "guest_suggestions")
public class GuestSuggestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rate;

    @Column(nullable = false, length = 500)
    private String suggestionText;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SuggestionStatus status;

    // Default constructor (needed for JPA)
    public GuestSuggestionEntity() {}

    // Constructor with parameters
    public GuestSuggestionEntity(int rate, String suggestionText, SuggestionStatus status) {
        this.rate = rate;
        this.suggestionText = suggestionText;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }
}
