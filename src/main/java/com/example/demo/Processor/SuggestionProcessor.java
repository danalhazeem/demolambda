package com.example.demo.Processor;

import com.example.demo.entity.SuggestionStatus;

@FunctionalInterface
public interface SuggestionProcessor {
    void process(String text, SuggestionStatus status);
}
