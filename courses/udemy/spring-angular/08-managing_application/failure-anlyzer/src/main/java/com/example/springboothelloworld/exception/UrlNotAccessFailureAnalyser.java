package com.example.springboothelloworld.exception;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

public class UrlNotAccessFailureAnalyser extends AbstractFailureAnalyzer<UrlAccessException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, UrlAccessException cause) {
        return new FailureAnalysis("Unable to acces the URL " + cause.getUrl(), "Ensure the URL it's accessible", cause);
    }
}
